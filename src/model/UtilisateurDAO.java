/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import cabinet.Mysqlcon;
import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author yahya
 */
public class UtilisateurDAO {
    public Utilisateur authentifier(String nomUtilisateur, String motDePasse) throws SQLException {
        String sql = "SELECT id_utilisateur, nom_utilisateur, mot_de_passe, role FROM Utilisateur WHERE nom_utilisateur = ?";
        try (Connection conn = Mysqlcon.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nomUtilisateur);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hash = rs.getString("mot_de_passe");
                    if (BCrypt.checkpw(motDePasse, hash)) {
                        Utilisateur user = new Utilisateur();
                        user.setId(rs.getInt("id_utilisateur"));
                        user.setNomUtilisateur(rs.getString("nom_utilisateur"));
                        user.setMotDePasseHash(hash);
                        user.setRole(rs.getString("role"));
                        return user;
                    }
                }
            }
        }
        return null; // échec d’authentification
    }

    // Pour créer un utilisateur (ex : admin) avec hash :
    public void creerUtilisateur(String nomUtilisateur, String motDePassePlain, String role) throws SQLException {
        String hash = BCrypt.hashpw(motDePassePlain, BCrypt.gensalt(12));
        String sql = "INSERT INTO Utilisateur (nom_utilisateur, mot_de_passe, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nomUtilisateur);
            ps.setString(2, hash);
            ps.setString(3, role);
            ps.executeUpdate();
        }
    }
}
