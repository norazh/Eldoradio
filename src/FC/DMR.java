/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.ArrayList;

/**
 *
 * @author menar
 */
public class DMR {
    private String idDMR;
    private Patient patient;
    private ArrayList<Examen> listeExamen= new ArrayList<Examen>();
    
    public DMR(String idDMR, Patient patient, ArrayList<Examen> liste){
        this.idDMR=idDMR;
        this.patient=patient;
        this.listeExamen=liste;
    }
    public String getidDMR(){
        return idDMR;
    }
    public Patient getPatient(){
        return patient;
    }
    public ArrayList<Examen> getListeExamen(){
     return listeExamen;   
    }
    public void setidDMR(String id){
        // faire une recherche du patient patient dans le SIR, aller dans ce patient et appeler le setidDMR du patient
        this.idDMR=id;// faire cette affectation ssi ce nouvel id n'existe pas déjà dans la liste DMR de SIR
        
    }
    public void setPatient (Patient p){
        //vérifier que le atient mis en paramètre n'a pas déjà de DMR
        //vérifier que le patient existe 
        this.patient=p;
    }
    public void ajouterExamen (Examen exam){
        
    }
           
}