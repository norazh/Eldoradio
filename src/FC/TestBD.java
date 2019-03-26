package FC;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loicdancelme
 */
public class TestBD {

    private static String requeteSQL;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    
    public static void main(String[] args) throws IOException, SQLException {
        
        /*  ---------------------------------- Test requêtes SQL ---------------------------------- */
        
        DbConnection c = new DbConnection(); // Instance de la classe permettant la connexion à la BD
        c.connexionB();                     // Ouverture de la connexion au serveur ldancelme_eldoradio
                
        //  SELECT_Extraire des informations de la BD
        requeteSQL = "SELECT * FROM personnel WHERE (prenom = 'Jean')";
        System.out.println("Requête SQL: SELECT * FROM personnel WHERE (prenom = 'Jean')\nRésultat:");
        rs = c.select(requeteSQL);
        while (rs.next()) {
            System.out.println("ID|Prénom| Nom  | Spécialité | Identifiant |\t\t   Token (MDP Crypté)");
            System.out.print(rs.getString(1));                  // Affichage des informations extraites 
            System.out.print(" | " + rs.getString(2));          // du tableau ResultSet rs à partir de
            System.out.print(" | " + rs.getString(3));          // la requête SQL requeteSQL
            System.out.print(" |  " + rs.getString(4));
            System.out.print("   |    " + rs.getString(5));
            System.out.println("    | " + rs.getString(6) + " |");
        }
        
        String pr = "Pat";
        String n = "Bole";
        System.out.println("SELECT IDPERS FROM personnel WHERE (Prenom = '" + pr + "') AND (Nom = '" + n + "')");
        ResultSet rs = c.select("SELECT IDPERS FROM personnel WHERE Prenom = '" + pr + "' AND Nom = '" + n + "'");
        
        // INSERT
        
        // Test de la fonction insert(String table, String field)
        String table ="examen";
        String field = "TypeExamen,DMRPapier,Salle,CompteRendu,IDPERS,IDDMR";
        ArrayList<String> sepField = c.separate(field);
        int nbValues = sepField.size();
        String query = "INSERT INTO " + table + " (" + field + ") VALUES (";
        // Ajoute autant de ? que de champs à la requête
        for (int i = 0; i < nbValues - 1; i++) {
            query += "?, ";
        } query += "?)";
        System.out.println(query);
               
        
        PreparedStatement pstmt = c.insert("examen", "TypeExamen,DMRPapier,Salle,CompteRendu,IDPERS,IDDMR");
        pstmt.setString(1, "SCANNER");
        pstmt.setString(2, "Non");
        pstmt.setString(3, "S4");
        pstmt.setString(4, "Scanner de la jambe droite");
        pstmt.setInt(5, 3);
        pstmt.setInt(6, 4);
        pstmt.execute();

        
        
//        /*  INSERT_Insérer des informations dans la BD
//        //    String fields est de la forme "colonne_1,colonne_2,..."
//        ArrayList<String> col = c.arrColNames("SELECT * FROM patients");
//        String fields = c.joint(col);
//        
//        /*  CHoix des valeurs à insérer */
//        pstmt = c.insert("patients","INSERT INTO " + fields);
//        pstmt.setString(1, "4");
//        pstmt.setString(2, "4");
//        pstmt.setString(3, "Tiphaine");
//        pstmt.setString(4, "MENARD");
//        pstmt.setString(5, "2000-12-24");
//        pstmt.setString(6, "Femme");
//        pstmt.setString(7, "6 avenue Général Leclerc");
//        pstmt.setString(8, "38400");
//        pstmt.setString(9, "St-Martin-d'Hères");
//        pstmt.execute();
//        
//        requeteSQL = "SELECT * FROM patients WHERE (IPP = '4')";
        
         
         
        
        
       
    }
    
}
