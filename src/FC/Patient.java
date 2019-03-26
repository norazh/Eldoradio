/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Date;

/**
 *
 * @author menar
 */
public class Patient {

    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String codePostal;
    private int IPP;
    private int idDMR;
    private Date dateNaissance;
    private Sexe sexe;

    public Patient(int ipp, int iddmr, String nom, String prenom, String adresse, String ville, String codePostal, Date date, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.idDMR = idDMR;
        this.dateNaissance = date;
        this.sexe = sexe;
        this.IPP = ipp;
        this.idDMR = iddmr;
    }

    public Patient(int ipp, String nom, String prenom, String adresse, String ville, String codePostal, Date date, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.idDMR = idDMR;
        this.dateNaissance = date;
        this.sexe = sexe;
        this.IPP = ipp;

    }

    public Patient() {
    }

    public Patient(int ipp) {
        this.IPP = ipp;
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

    public String getCodePostal() {
        return codePostal;
    }

    public int getIPP() {
        return IPP;
    }

    public int getidDMR() {
        return idDMR;
    }

    public Date getDateDeNaissance() {
        return dateNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setIPP(int IPP) {
        this.IPP = IPP;
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

    public void setCodePostal(String cp) {
        this.codePostal = cp;
    }

    public void setidDMR(int id) {
        this.idDMR = id;
    }

    public void setDateNaissance(Date d) {
        this.dateNaissance = d;
    }

    public void setSexe(Sexe s) {
        this.sexe = s;
    }

}
