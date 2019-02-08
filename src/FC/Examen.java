/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

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
    private PACS pacs;
    
    public Examen (String idExamen,Date date, Medecin medecin, TypeExamen type, String CR, PACS pacs){
        this.idExamen=idExamen;
        this.date=date;
        this.medecin=medecin;
        this.type= type;
        this.CR=CR;
        this.pacs=pacs;
    }
     public Examen (String idExamen, Date date, Medecin medecin, TypeExamen type, PACS pacs){
       this.idExamen=idExamen;
       this.medecin=medecin;
       this.date=date;
       this.type= type;
       this.pacs=pacs;
    }
    public String getidExamen(){
        return idExamen;
    }
    
    public Date getDate(){
        return date;
    }
    public Medecin getMedecin(){
        return medecin;
    }
    public TypeExamen getTypeExamen(){
        return type;
    }
    public String getCR(){
        return CR;
    }
    public PACS getPACS(){
        return pacs;
    }
    public void setCR (String cr){
        this.CR=cr;
    }
    public void setMedecin (Medecin medecin){
        this.medecin=medecin;
    }
}
