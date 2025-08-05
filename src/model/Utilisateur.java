/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author yahya
 */
public class Utilisateur {
     private int id;
    private String nomUtilisateur;
    private String motDePasseHash; // hash stocké
    private String role;

    // getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
    public String getMotDePasseHash() { return motDePasseHash; }
    public void setMotDePasseHash(String motDePasseHash) { this.motDePasseHash = motDePasseHash; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
