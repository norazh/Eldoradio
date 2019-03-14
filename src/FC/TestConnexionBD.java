/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import static FC.TestBD.afficher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imane
 */
public class TestConnexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnexionBD c = new ConnexionBD();
        c.connexion();
        
        try {
            ArrayList<Patient> lp = c.recupListeP();
            System.out.println(lp.get(0).getNom());
        } catch (SQLException ex) {
            Logger.getLogger(TestConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(TestConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
//        ArrayList<ArrayList<String>> listePatients = c.listeExam("1");
//        afficher(listeExam);
//        String  query = "SELECT * FROM personnel";
//        ResultSet res = c.select(query);
//        c.info(res);
        
    }
    
}
