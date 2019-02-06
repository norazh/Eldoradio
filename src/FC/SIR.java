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
    // if (ExistencePatientListe(P,list)){
    public ArrayList<Patient> getListePatientSansDMR(){   // crée une liste de tous les patients qui n'ont pas de DMR
		ArrayList<Patient> liste= new ArrayList<> ();
                for (int i=0; i<listePatient.size();i++){//on recopie la liste de tous les patients dans liste
                 liste.add(listePatient.get(i));
                }
                ArrayList<Patient> listePatientAEnlever= this.getListePatientAvecDMR();
                for(int i =0;i<listePatientAEnlever.size();i++){
                    liste.remove(listePatientAEnlever.get(i));
                }
                return liste;
	}
    
       public ArrayList<Patient> getListePatientAvecDMR(){   // crée une liste de tous les patients qui ont un DMR
		ArrayList<Patient> liste= new ArrayList<> ();
		for (int i=0; i<listeDMR.size(); i++){
			if (!liste.contains(listeDMR.get(i).getPatient())){
				liste.add(listeDMR.get(i).getPatient());
			}
		}
		return liste;
	}
    
    public void ajouterDMR (DMR dmr){ //ajoute un nouveau DMR 
        int i=0;
        int j=0;
        while(i<listeDMR.size() && dmr.getidDMR()!=listeDMR.get(i).getidDMR() ){
            i++;
        }
        if (i<listeDMR.size()){
            while (j<listeDMR.size() && !listeDMR.get(j).equals(dmr)){
                j++;
            }
            if(j<listeDMR.size()){
            listeDMR.add(dmr);
            }
            else{
                System.out.println("Ce DMR existe déjà");
            }
        }
        else{
            System.out.println("Ce DMR a un identifiant idDMR déjà existant");
        }
        
    }
    public boolean ExistencePatient (Patient patient){ // permet de savoir si un patient patient existe
        int i=0;
        boolean b=false;
   
        while(patient!=listePatient.get(i) && i<listePatient.size()){ //recherche du patient dans la liste des patients qui ont un DMR
            i++;
        }
        if (i<listePatient.size()){
            b=true;
        }
        return b;
    }
    
      public boolean ExistencePatientListe (Patient patient,ArrayList<Patient>list){ // permet de savoir si un patient patient est présent dans une liste donnée de patients
        int i=0;
        boolean b=false;
   
        while(patient!=list.get(i) && i<list.size()){ //recherche du patient dans la liste de patients donnés
            i++;
        }
        if (i<list.size()){
            b=true;
        }
        return b;
    }
      
    public int RechercheIndicePatientDansListe (ArrayList<Patient> list, Patient P){
        int i=0;
        while (i<list.size() && !list.get(i).equals(P)){
            i++;
        }
        return i;
      
    }
    public Patient RecherchePatientParNom (Patient P){
        int i=0;
        while(i<listePatient.size() && !listePatient.get(i).equals(P)){
                    i++;
        }
        
        return listePatient.get(i);
        
            
        
    }        
      
        
 }