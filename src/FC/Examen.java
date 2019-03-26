/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.Date;

/**
 *
 * @author menar
 */
public class Examen {

    private String idExamen;
    private Date date;
    private Medecin medecin;
    private TypeExamen type;
    private String CR;
    private boolean DMRpapier;
    private Salle salle;

    public Examen(String idExamen, Date date, Medecin medecin, TypeExamen type, String CR, boolean dmrpapier, Salle salle) {
        this.idExamen = idExamen;
        this.date = date;
        this.medecin = medecin;
        this.type = type;
        this.CR = CR;
        this.DMRpapier = dmrpapier;
        this.salle = salle;
    }

    public Examen(String idExamen, Date date, Medecin medecin, TypeExamen type, boolean dmrpapier, Salle salle) {
        this.idExamen = idExamen;
        this.medecin = medecin;
        this.date = date;
        this.type = type;
        this.DMRpapier = dmrpapier;
        this.salle = salle;
    }
    
    public Examen(Medecin medecin, TypeExamen type, Salle salle) {
        this.medecin = medecin;
        this.type = type;
        this.salle = salle;
    }

    public Examen(String idExam) {
        this.idExamen = idExam;
    }
    
    public Examen(){}

    public String getidExamen() {
        return idExamen;
    }

    public Date getDate() {
        return date;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public TypeExamen getTypeExamen() {
        return type;
    }

    public String getCR() {
        return CR;
    }
    
    public boolean getDMRPapier() {
        return DMRpapier;
    }
    
    public Salle getSalle() {
        return salle;
    }

    public void setidExamen(String idExamen) {
        this.idExamen = idExamen;
    }
    
    public void setCR(String cr) {
        this.CR = cr;
    }

    public void setTypeExamen(TypeExamen type) {
        this.type = type;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setDMRpapier(boolean dmr) {
        this.DMRpapier = dmr;
    }


    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
