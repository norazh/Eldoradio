/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import static UI.Medecin_RechercherPatient.stringToSexe;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOFFREY
 */
public class ConnexionBD {

    public String url;
    private String user;
    private String pwd;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultat = null;

    public ConnexionBD(String url, String utilisateur, String motDePasse) {
        this.url = url;
        this.user = utilisateur;
        this.pwd = motDePasse;
    }

    // Par défaut on se connecte au serveur suivant : jdbc:mysql://mysql-hostis.alwaysdata.net
    public ConnexionBD() {
        this.url = "jdbc:mysql://mysql-ldancelme.alwaysdata.net/ldancelme_eldoradio";
        this.url += "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "ldancelme";
        this.pwd = "datingoskra";
    }

    //fonction pour se connecter au serveur
    public boolean connexion() {
        /* Chargement du drier JDBC par MySQL */
        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            statement = connection.createStatement();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    /*méthode permettant d'exécuter une requête SQL lors de la connexion sur l'interface 
    Ici, la requête correspond au String requete */
    public ResultSet exec(String requete) {
        try {
            resultat = statement.executeQuery(requete);
            return resultat;
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    /**
     * Insérer des données avec requête SQL.
     *
     * @param s requête SQL
     * @return 0 si échec sinon nombre de lignes affectées
     */
    public int insererBD(String s) {
        int i = 0;
        try {
            i = statement.executeUpdate(s);
        } catch (SQLException ex) {
            return i;
        }
        return i;
    }


    /**
     * Fermer la connexion au serveur de DB
     */
    public void close() {
        if (resultat != null) {
            try {
                resultat.close();
            } catch (SQLException ignore) {
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ignore) {
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignore) {
            }
        }
    }
    
     public ArrayList<Patient> recupListeP() throws SQLException, ParseException {
        String query = "select * from patients ";
        //where ipp=?";
        PreparedStatement statement = connection.prepareStatement(query);
    //    statement.setInt(1, 1); //le premier 1 correspond au numéro de la colonne de la table, et le deuxième 1 correspond à la valeur pour le where
        ResultSet resultat = statement.executeQuery();
        ArrayList<Patient> l = new ArrayList<Patient>();
        while (resultat.next()) {

            int ipp = resultat.getInt("IPP");
            int iddmr = resultat.getInt("IDDMR");
            String nomP = resultat.getString("Nom");
            String prenomP = resultat.getString("Prenom");
            String sexe = resultat.getString("Sexe");
            String adresse = resultat.getString("Adresse");
            String ville = resultat.getString("Ville");
            int codepostal = resultat.getInt("CodePostal");
            //Sexe.valueOf("Homme");

            java.util.Date date = resultat.getDate("DateNaissance");
            FC.Date dateN = new FC.Date(date.getDay(), date.getMonth(), date.getYear());
            Patient p = new Patient(ipp, iddmr, nomP, prenomP, adresse, ville, codepostal, dateN, stringToSexe(sexe));

            l.add(p);
        }
        return l;
    }
     
//     public ArrayList<Examen> recupListeE() throws SQLException, ParseException {
//        String query = "select * from examen NATURAL JOIN patients ";
//        //where ipp=?";
//        PreparedStatement statement = connection.prepareStatement(query);
//    //    statement.setInt(1, 1); //le premier 1 correspond au numéro de la colonne de la table, et le deuxième 1 correspond à la valeur pour le where
//        ResultSet resultat = statement.executeQuery();
//        ArrayList<Examen> e = new ArrayList<Examen>();
//        while (resultat.next()) {
//
//            int idexam = resultat.getInt("IPP");
//            int iddmr = resultat.getInt("IDDMR");
//            String nomP = resultat.getString("Nom");
//            String prenomP = resultat.getString("Prenom");
//            String sexe = resultat.getString("Sexe");
//            String adresse = resultat.getString("Adresse");
//            String ville = resultat.getString("Ville");
//            int codepostal = resultat.getInt("CodePostal");
//            //Sexe.valueOf("Homme");
//
//            java.util.Date date = resultat.getDate("DateNaissance");
//            FC.Date dateN = new FC.Date(date.getDay(), date.getMonth(), date.getYear());
//            Examen e = new Patient(ipp, iddmr, nomP, prenomP, adresse, ville, codepostal, dateN, stringToSexe(sexe));
//
//            e.add(p);
//        }
//        return l;
//    }
}
