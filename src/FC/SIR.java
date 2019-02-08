/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.ArrayList;
import java.util.Collections;

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
    public Patient RecherchePatientParNom (String nom){
        String p1= nom.toLowerCase();
        int i=0;
        while(i<listePatient.size() && !listePatient.get(i).getNom().toLowerCase().equals(p1)){
                    i++;
        }
        return listePatient.get(i);
    }        
      
    public Patient RecherchePatientParPrenom (String prenom){
        String p1= prenom.toLowerCase();
        int i=0;
        while(i<listePatient.size() && !listePatient.get(i).getPrenom().toLowerCase().equals(p1)){
                    i++;
        }
        return listePatient.get(i);
    }    
        
    public DMR RechercheDMRParNomPatient (String nom){
        String p1=nom.toLowerCase();
        int i=0;
        while (i<listeDMR.size() && !listeDMR.get(i).getPatient().getNom().toLowerCase().equals(p1)){
            i++;
        }
        return listeDMR.get(i);
    }
    
     public DMR RechercheDMRParPrenomPatient (String prenom){
        String p1=prenom.toLowerCase();
        int i=0;
        while (i<listeDMR.size() && !listeDMR.get(i).getPatient().getPrenom().toLowerCase().equals(p1)){
            i++;
        }
        return listeDMR.get(i);
    }
     
     public DMR RechercheDMRParidDMR (String id){
        String p1=id.toLowerCase();
        int i=0;
        while (i<listeDMR.size() && !listeDMR.get(i).getidDMR().toLowerCase().equals(p1)){
            i++;
        }
        return listeDMR.get(i);
    }
     
      public void triDMRDateDernierExamen() {
        ArrayList <DMR> copieListeDMR = new ArrayList<>();//création d'un nouveau vecteur égale à fiche de soins
        for (int i=0; i<listeDMR.size(); i++){ //recopie tous les éléments de listeDMR dans copieListeDMR
            copieListeDMR.add(listeDMR.get(i));
        }
        while (!copieListeDMR.isEmpty()) {// tant que copieFiches n'est pas vide, faire:
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            DMR d1 = copieListeDMR.get(imin);
            for (int i = 1; i < copieListeDMR.size(); i++) {
                DMR d2 = copieListeDMR.get(i);
                for (int j = 0; j < d2.getListeExamen().size(); j++) {
                    if (d2.getListeExamen().get(j).getDate().compareTo(d1.getListeExamen().get(j).getDate()) < 0) {
                        imin = i;
                        d1 = d2;
                    }
                }
            }
            // on affiche la fiche de soins trouvee :
            d1.toString();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieListeDMR.remove(imin);
        }
    }
      
      public void trierDMRParNomPatient(){
           ArrayList <DMR> copieListeDMR = new ArrayList<>();//création d'un nouveau vecteur égale à fiche de soins
        for (int i=0; i<listeDMR.size(); i++){ //recopie tous les éléments de listeDMR dans copieListeDMR
            copieListeDMR.add(listeDMR.get(i));
        }
        int i=0;
       // Collections.sort(copieListeDMR.get(i).getPatient().getNom());
      }
      
      
      public void ajouterCR (String idDMR, String idExam, String cr){
          DMR d= this.RechercheDMRParidDMR(idDMR);
          int i=0;
          while (i<d.getListeExamen().size() && !d.getListeExamen().get(i).getidExamen().toLowerCase().equals(idExam.toLowerCase())){
              i++;
          }
          if(i<d.getListeExamen().size()){//il existe l'examen dans lequel on veut rajouter le compte rendu
              d.getListeExamen().get(i).setCR(cr);
          }
          else {
              System.out.println ("Cet examen n'existe pas dans le DMR à l'identifiant "+idExam);
          }
          
      }
              
 }