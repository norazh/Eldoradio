/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import static UI.Medecin_RechercherPatient.stringToSexe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Raphael
 */
public class Fonctions {

    //cette fonction permet de récupérer un patient à partie d'un resultSet
    public Patient recupPatient(ResultSet resultat) throws SQLException {
        //tous les résultats des requêtes contiennent les infos sur le patient

        Patient p = null;
        while (resultat.next()) {
            //on initialise un patient
            int ipp = resultat.getInt("IPP");
            int iddmr = resultat.getInt("IDDMR");
            String nomP = resultat.getString("Nom");
            String prenomP = resultat.getString("Prenom");
            Sexe sexe = stringToSexe(resultat.getString("Sexe"));
            String adresse = resultat.getString("Adresse");
            String ville = resultat.getString("Ville");
            int codepostal = resultat.getInt("CodePostal");

            java.util.Date date = resultat.getDate("DateNaissance");
            FC.Date dateN = new FC.Date(date.getDay(), date.getMonth(), date.getYear());
            p = new Patient(ipp, iddmr, nomP, prenomP, adresse, ville, codepostal, dateN, sexe);
        }
        return p;
    }

    //retourne le plus grand numD'archivage de la base de données
    public int getMax() throws SQLException {
        int number = 0;
        ConnexionBD c = new ConnexionBD();
        c.connexion();
        ResultSet r = c.exec("SELECT MAX(NumArchivage) AS 'MAX' FROM `hostis_dmr`.`Examen`");
        while (r.next()) {
            number = r.getInt("MAX");
        }
        return number;

    }

    //s doit être de la forme AAAA-MM-JJ
    //retourne une date à partir d'une string
    public Date stringtodate(String s) {
        Date d = null;
        int year = Integer.valueOf(s.charAt(0) + s.charAt(1) + s.charAt(2) + s.charAt(3));
        int mounth = Integer.valueOf(s.charAt(5) + s.charAt(6));
        int day = Integer.valueOf(s.charAt(8) + s.charAt(9));
        d = new Date(year, mounth, day);
        return d;

    }

    //retourne la date au format YYYY-MM-DD
    public String datecourante() {
        String format = "yyyy-MM-dd hh:mm";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        String s = "";
        for (int i = 0; i < 10; i++) {
            s = s + formater.format(date).charAt(i);
        }
        return s;
    }

    //retourne l'heure actuelle (sans les minutes)
    public String heurecourante() {
        String format = "HH";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        String s = "";
        s = s + formater.format(date).charAt(0) + formater.format(date).charAt(1);
        return formater.format(date);
    }

    //retourne les minutes de l'heure actuelle
    public String minutescourantes() {
        String format = "mm";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
        java.util.Date date = new java.util.Date();
        String s = "";
        for (int i = 13; i < 15; i++) {
            //s=s+formater.format(date).charAt(i);
        }
        return formater.format(date);
    }

    //transforme un variable de type typeExamen en string
    public String typeexamtostring(TypeExamen tp) {
        if (tp.equals(TypeExamen.ANGIOGRAPHIE)) {
            return "ANGIOGRAPHIE";
        } else if (tp.equals(TypeExamen.ECHOENDOGRAPHIE)) {
            return "ECHOENDOGRAPHIE";
        } else if (tp.equals(TypeExamen.ECHOGRAPHIE)) {
            return "ECHOGRAPHIE";
        } else if (tp.equals(TypeExamen.IRM)) {
            return "IRM";
        } else if (tp.equals(TypeExamen.MAMMOGRAPHIE)) {
            return "MAMMOGRAPHIE";
        } else if (tp.equals(TypeExamen.PET)) {
            return "PET";
        } else if (tp.equals(TypeExamen.RADIOLOGIE)) {
            return "RADIOLOGIE";
        } else if (tp.equals(TypeExamen.RADIOTHERAPIE)) {
            return "RADIOTHERAPIE";
        } else {
            return "SCANNER";
        }
    }

    //transforme une variable de type Sexe en String
    public String sexetostring(Sexe s) {
        if (s.equals(Sexe.Femme)) {
            return "Femme";
        } else {
            return "Homme";
        }
    }

    //cette fonction permet de récupérer un examen à partir d'un ResultSet
//    public Examen recupExamen(ResultSet resultat) throws SQLException {
//        //tous les résultats des requêtes contiennent les infos sur le patient
//        Examen e = null;
//        while (resultat.next()) {
//            int idexamen = resultat.getInt("idExamen");
//            int NumArchivage = resultat.getInt("NumArchivage");
//            Date date = resultat.getDate("dateExamen");
//            int heure = resultat.getInt("Heure");
//            int minutes = resultat.getInt("Minutes");
//
//            //on initialise un patient
//            int ipp = resultat.getInt("IPP");
//            String nomP = resultat.getString("Nom");
//            String prenomP = resultat.getString("Prenom");
//            Sexe sexe = StringToSexe(resultat.getString("Sexe"));
//            Date dateN = (resultat.getDate("DateNaissance"));
//            String adresse = resultat.getString("Adresse");
//            Patient p = new Patient(nomP, prenomP, adresse, dateN, ipp, sexe);
//
//            //on initialise un PH
//            int idph = resultat.getInt("IDPH");
//            String NomProMed = resultat.getString("NomPH");
//            String PrenomProMed = resultat.getString("PrenomPH");
//            PersonnelHospitalier ph = new PersonnelHospitalier(NomProMed, PrenomProMed, idph);
//
//            String TypeExam = resultat.getString("TypeExam");
//            String com = resultat.getString("Commentaire");
//            String contenu = resultat.getString("Compte Rendu");
//            Examen e1 = new Examen(p, ph, com, NumArchivage, stringToTypeExamen(TypeExam), date, heure, minutes, new CompteRendu(contenu, date));
//            e = e1;
//        }
//        return e;
//    }

    //retourne une liste d'examen à partir d'un ResultSet
//    public ArrayList<Examen> recupListeExamens(ResultSet resultat) throws SQLException {
//        //tous les résultats des requêtes contiennent les infos sur le patient
//        ArrayList<Examen> l = new ArrayList<Examen>();
//
//        while (resultat.next()) {
//            int NumArchivage = resultat.getInt("NumArchivage");
//            Date date = resultat.getDate("dateExamen");
//            int heure = resultat.getInt("Heure");
//            int minutes = resultat.getInt("Minutes");
//
//            //on initialise un patient
//            int ipp = resultat.getInt("IPP");
//            String NomP = resultat.getString("Nom");
//            String PrenomP = resultat.getString("Prenom");
//            Sexe sexe = stringToSexe(resultat.getString("Sexe"));
//            Date dateN = resultat.getDate("DateNaissance");
//            String Adresse = resultat.getString("Adresse");
//            Patient p = new Patient(NomP, PrenomP, Adresse, dateN, ipp, sexe);
//
//            //on initialise un PH
//            int idph = resultat.getInt("IDPH");
//            String NomProMed = resultat.getString("NomPH");
//            String PrenomProMed = resultat.getString("PrenomPH");
//            PersonnelHospitalier ph = new PersonnelHospitalier(NomProMed, PrenomProMed, idph);
//
//            //on intialise un examen
//            String TypeExam = resultat.getString("TypeExam");
//            String com = resultat.getString("Commentaire");
//            Examen e = new Examen(p, ph, com, NumArchivage, stringToTypeExamen(TypeExam), date, heure, minutes);
//            //Examen e = new Examen(NomProMed, PrenomProMed, ipp, idph, "", NumArchivage, stringToTypeExamen(TypeExam), date, heure, minutes, cr);
//            l.add(e);
//        }
//        return l;
//    }

    //retourne une liste de patient à partir d'un ResultSet
    public ArrayList<Patient> recupListeP(ResultSet resultat) throws SQLException, ParseException {
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

    //retourne une enum Sexe à partir d'un string 
    public static Sexe StringToSexe(String s) {
        Sexe sexe = null;
        switch (s) {
            case "Homme":
                sexe = Sexe.Homme;
                break;
            case "Femme":
                sexe = Sexe.Femme;
                break;
            default:
                break;

        }
        return sexe;
    }

}
