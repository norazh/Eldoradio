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
public class SIR {
    private ArrayList<DMR> listeDMR = new ArrayList<>();
    private Statut statut;
    private ArrayList<Personnel> listePersonnel= new ArrayList<>();
    private ArrayList<Patient> listePatient= new ArrayList<>();
    private String idSIR;
    
    public SIR(ArrayList<DMR> listeDMR,Statut statut,ArrayList<Personnel> listePersonnel,ArrayList<Patient> listePatient,String idSIR){
        this.idSIR=idSIR;
        this.listeDMR=listeDMR;
        this.listePersonnel=listePersonnel;
        this.listePatient=listePatient;
        this.statut=statut;
    }
    
    public ArrayList<DMR> getListeDMR (){
        return listeDMR;
    }
    
    public Statut getStatut(){
        return statut;
    }
    
    public ArrayList<Personnel> getListePersonnel(){
        return listePersonnel;
    }
    
    public String getIdSIR(){
        return idSIR;
    }
    
   /* public ArrayList<Patient> getListePatient(){   // crée une liste de tous les patients présents dans la liste DMR
		ArrayList<Patient> listePatient= new ArrayList<> ();
		for (int i=0; i<listeDMR.size(); i++){
			if (!listePatient.contains(listeDMR.get(i).getPatient())){
				listePatient.add(listeDMR.get(i).getPatient());
			}
		}
		return listePatient;
	}*/
    
    public void ajouterDMR (DMR dmr){ //ajoute un nouveau DMR 
        
    }
    public boolean PresencePatient (Patient patient){ // permet de savoir si un patient a déjà un DMR
        int i=0;
        boolean b=false;
        ArrayList<Patient> listePatientExistant= this.getListePatient();
        while(patient!=listePatientExistant.get(i) && i<listePatientExistant.size()){ //recherche du patient dans la liste des patients qui ont un DMR
            i++;
        }
        if (i<listePatientExistant.size()){
            b=true;
        }
        return b;
    }
}
