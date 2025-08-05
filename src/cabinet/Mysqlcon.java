
package cabinet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Mysqlcon {
        private static Connection conn;
        String url = "jdbc:mysql://localhost:3306/cabinet"; 
        String user = "root"; // Remplacez par votre nom d'utilisateur MySQL
        String password = ""; // Remplacez par votre mot de passe MySQL
        private Mysqlcon() {// Informations de connexion
        // Connexion à la base de données
        try  {  
               conn = DriverManager.getConnection(url, user, password) ;
            } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "\"Échec de la connexion à la base de données !\"");
        } 
        } 
        
    public static  synchronized Connection getConnection() 
     {  
            try {
                if (conn==null || conn.isClosed())  {new Mysqlcon();}
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "\"Échec  la connexion à la base de données !\"");
            }
         return conn;
     }
        
      public static void closeConnection() {
    try {
        if (conn != null && !conn.isClosed()) {
            conn.close();
     
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "\"Échec  fermeture de la connexion à la base de données !\"");
    }
}   
        
}

