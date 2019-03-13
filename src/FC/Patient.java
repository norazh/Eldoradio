/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.Random;

/**
 *
 * @author menar
 */
public class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private int codePostal;
//        private String idSIR;
//        private String idSIH;
    private int IPP;
    private int idDMR;
    private Date dateNaissance;
    private Sexe sexe;

//    public Patient(String nom, String prenom, String adresse, String ville, String codePostal, String idSIR, String idSIH, Date date, Sexe sexe) {
//        this.nom = nom;
//        this.prenom = prenom;
//        this.adresse = adresse;
//        this.ville = ville;
//        this.codePostal = codePostal;
//        this.idSIR = idSIR;
//        this.idSIH = idSIH;
//        this.dateNaissance = date;
//        this.sexe = sexe;
//
//    }
//    public Patient(String nom, String prenom, String adresse, String ville, String codePostal, String idSIR, String idSIH, String idDMR, Date date, Sexe sexe) {
//        this.nom = nom;
//        this.prenom = prenom;
//        this.adresse = adresse;
//        this.ville = ville;
//        this.codePostal = codePostal;
//        this.idSIR = idSIR;
//        this.idSIH = idSIH;
//        this.idDMR = idDMR;
//        this.dateNaissance = date;
//        this.sexe = sexe;
//
//    }
    public Patient(String nom, String prenom, String adresse, String ville, int codePostal, Date date, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.idDMR = idDMR;
        this.dateNaissance = date;
        this.sexe = sexe;
        
        Random r1 = new Random();
        int valeur_ipp = 0 + r1.nextInt(10000000 - 0);
        this.IPP = valeur_ipp;
        
        Random r2 = new Random();
        int valeur_idDMR = 0 + r2.nextInt(1000000 - 0);
        this.idDMR = valeur_idDMR;
    }

    public String toString() {
        return "FICHE PATIENT" + "\n" + "Prénom: " + getPrenom() + "\n " + "Nom : " + getNom() + " \n " + "Adresse: " + getAdresse() + "\n" + "Ville : " + getVille() + "\n" + "Code Postal: " + getCodePostal() + "\n" + "idSIR: " + getidSIR() + "\n" + "idSIH: " + getidSIH() + "\n" + "idDMR: " + getidDMR() + "\n" + "Date de naissance: " + getDateDeNaissance().toString() + " \n " + "Sexe : " + getSexe() + " \n ";
    }

    public String toStringNom() {
        return getNom();
    }

    public String toStringNomPrenom() {
        return getNom() + " " + getPrenom();
    }

    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient) o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
        } else {
            return false;
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public int getIPP() {
        return IPP;
    }

//    public String getidSIH() {
//        return idSIH;
//    }

    public int getidDMR() {
        return idDMR;
    }

    public Date getDateDeNaissance() {
        return dateNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public void setPrenom(String p) {
        this.prenom = p;
    }

    public void setAdresse(String a) {
        this.adresse = a;
    }

    public void setVille(String v) {
        this.ville = v;
    }

    public void setCodePostal(int cp) {
        this.codePostal = cp;
    }

//    public void setidSIR(int id) {
//        this.idSIR = id;
//    }
//
//    public void setidSIH(int id) {
//        this.idSIH = id;
//    }

    public void setidDMR(int id) {
        this.idDMR = id;
    }

    public void setDateNaissance(Date d) {
        this.dateNaissance = d;
    }

    public void setSexe(Sexe s) {
        this.sexe = s;
    }

    /*public int compareTo(Object o) {
        String n= (String)o;
        n=n.toLowerCase();
        if (!nom.equals(n)){// si c'est pas la même année
            int nom1= (int)
            if ((char)nom>(char)n){
            return annee - d.annee;
            }
        }
        if (mois != d.mois) //si passe a ce deuxieme if annee égale
            return mois  - d.mois;// renvoie la différence des mois
        // ici on a forcement annee == d.annee et mois == d.mois :
		if (getJour() != d.getJour()){// si passe à ce if, mois égal
			return jour - d.jour;// renvoie la différence des jours
		}
		if ( heure != d.heure){// si passe à ce if, jour égal
			return heure - d.heure ; // renvoie la différence d'heures 
		}
        return minute - d.minute;// différence des minutes
        }*/
}
