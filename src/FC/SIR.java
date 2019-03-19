/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author menar
 */
public class SIR {
    private ArrayList<DMR> listeDMR = new ArrayList<>();
    private Statut statutConnexion;
    private ArrayList<Personnel> listePersonnel = new ArrayList<>();
    private ArrayList<Patient> listePatient = new ArrayList<>();
    private String idSIR;

    public SIR(ArrayList<DMR> listeDMR, Statut statut, ArrayList<Personnel> listePersonnel, ArrayList<Patient> listePatient, String idSIR) {
        this.idSIR = idSIR;
        this.listeDMR = listeDMR;
        this.listePersonnel = listePersonnel;
        this.listePatient = listePatient;
        this.statutConnexion = statut;
    }

    public ArrayList<DMR> getListeDMR() {
        return listeDMR;
    }

    public Statut getStatut() {
        return statutConnexion;
    }

    public ArrayList<Personnel> getListePersonnel() {
        return listePersonnel;
    }
    
    public ArrayList<Medecin> getListeMedecin (){
        ArrayList<Medecin> liste=new ArrayList<>();
        for(int i=0;i<this.getListePersonnel().size(); i++){
            if(this.getListePersonnel().get(i) instanceof Medecin){
                Medecin med= (Medecin)this.getListePersonnel().get(i);
                liste.add(med);
            }
        }
        return liste;
    }
    
    public String getIdSIR(){
        return idSIR;
    }

    // if (ExistencePatientListe(P,list)){
    public ArrayList<Patient> getListePatientSansDMR() {   // crée une liste de tous les patients qui n'ont pas de DMR
        ArrayList<Patient> liste = new ArrayList<>();
        for (int i = 0; i < listePatient.size(); i++) {//on recopie la liste de tous les patients dans liste
            liste.add(listePatient.get(i));
        }
        ArrayList<Patient> listePatientAEnlever = this.getListePatientAvecDMR();
        for (int i = 0; i < listePatientAEnlever.size(); i++) {
            liste.remove(listePatientAEnlever.get(i));
        }
        return liste;
    }

    public ArrayList<Patient> getListePatientAvecDMR() {   // crée une liste de tous les patients qui ont un DMR
        ArrayList<Patient> liste = new ArrayList<>();
        for (int i = 0; i < listeDMR.size(); i++) {
            if (!liste.contains(listeDMR.get(i).getPatient())) {
                liste.add(listeDMR.get(i).getPatient());
            }
        }
        return liste;
    }

    public void ajouterDMR(DMR dmr) { //ajoute un nouveau DMR
        int i = 0;
        int j = 0;
        while (i < listeDMR.size() && dmr.getidDMR() != listeDMR.get(i).getidDMR()) {
            i++;
        }
        if (i < listeDMR.size()) {
            while (j < listeDMR.size() && !listeDMR.get(j).equals(dmr)) {
                j++;
            }
            if (j < listeDMR.size()) {
                listeDMR.add(dmr);
            } else {
                System.out.println("Ce DMR existe déjà");
            }
        } else {
            System.out.println("Ce DMR a un identifiant idDMR déjà existant");
        }

    }

    public boolean ExistencePatient(Patient patient) { // permet de savoir si un patient patient existe
        int i = 0;
        boolean b = false;

        while (patient != listePatient.get(i) && i < listePatient.size()) { //recherche du patient dans la liste des patients qui ont un DMR
            i++;
        }
        if (i < listePatient.size()) {
            b = true;
        }
        return b;
    }

    public boolean ExistencePatientListe(Patient patient, ArrayList<Patient> list) { // permet de savoir si un patient patient est présent dans une liste donnée de patients
        int i = 0;
        boolean b = false;

        while (patient != list.get(i) && i < list.size()) { //recherche du patient dans la liste de patients donnés
            i++;
        }
        if (i < list.size()) {
            b = true;
        }
        return b;
    }
    
    public boolean ExistenceExamenDansDMR (DMR dmr, Examen exam){
        boolean bool = false;
        int i=0;
        ArrayList<Examen> list= dmr.getListeExamen();
        while(i<list.size() && !list.get(i).equals(exam)){
            i++;
        }
        if(i<list.size()){
            bool=true;
        }
        return bool;
    }

    public int RechercheIndicePatientDansListe(ArrayList<Patient> list, Patient P) {
        int i = 0;
        while (i < list.size() && !list.get(i).equals(P)) {
            i++;
        }
        return i;

    }

    public Patient RecherchePatientParNom(String nom) {
        String p1 = nom.toLowerCase();
        int i = 0;
        while (i < listePatient.size() && !listePatient.get(i).getNom().toLowerCase().equals(p1)) {
            i++;
        }
        return listePatient.get(i);
    }

    public Patient RecherchePatientParPrenom(String prenom) {
        String p1 = prenom.toLowerCase();
        int i = 0;
        while (i < listePatient.size() && !listePatient.get(i).getPrenom().toLowerCase().equals(p1)) {
            i++;
        }
        return listePatient.get(i);
    }

    public DMR RechercheDMRParNomPatient(String nom) {
        String p1 = nom.toLowerCase();
        int i = 0;
        while (i < listeDMR.size() && !listeDMR.get(i).getPatient().getNom().toLowerCase().equals(p1)) {
            i++;
        }
        return listeDMR.get(i);
    }
<<<<<<< Updated upstream
//    public DMR RechercheDMRParIdSIR(int id) {
//        int p1 = id;
//        int i = 0;
//        while (i < listeDMR.size() && !listeDMR.get(i).getPatient().getIPP() == p1) {
=======
//    public DMR RechercheDMRParIPP(String id) {
//        String p1 = id.toLowerCase();
//        int i = 0;
//        while (i < listeDMR.size() && !listeDMR.get(i).getPatient().getIPP().equals(p1)) {
>>>>>>> Stashed changes
//            i++;
//        }
//        return listeDMR.get(i);
//    }

    public DMR RechercheDMRParPrenomPatient(String prenom) {
        String p1 = prenom.toLowerCase();
        int i = 0;
        while (i < listeDMR.size() && !listeDMR.get(i).getPatient().getPrenom().toLowerCase().equals(p1)) {
            i++;
        }
        return listeDMR.get(i);
    }
    
    public ArrayList<Examen> RechercherExamenSansCR (){
        ArrayList<Examen> liste= new ArrayList<>();
        for (int i=0; i<this.listeDMR.size();i++ ){
            for (int j=0; j<this.listeDMR.get(i).getListeExamen().size();j++){
                if (this.listeDMR.get(i).getListeExamen().get(j).getCR().isEmpty()){
                    liste.add(this.listeDMR.get(i).getListeExamen().get(j));
                }
            }
        }
        return liste;
    }
    public ArrayList<Examen> RechercherExamenAvecCR (){
        ArrayList<Examen> liste= new ArrayList<>();
        for (int i=0; i<this.listeDMR.size();i++ ){
            for (int j=0; j<this.listeDMR.get(i).getListeExamen().size();j++){
                if (!this.listeDMR.get(i).getListeExamen().get(j).getCR().isEmpty()){
                    liste.add(this.listeDMR.get(i).getListeExamen().get(j));
                }
            }
        }
        return liste;
    }
    
    

    public DMR RechercheDMRParidDMR(String id) {
        String p1 = id.toLowerCase();
        int i = 0;
        while (i < listeDMR.size() && !listeDMR.get(i).getidDMR().toLowerCase().equals(p1)) {
            i++;
        }
        return listeDMR.get(i);
    }

    public void triDMRDateDernierExamen() {
        ArrayList<DMR> copieListeDMR = new ArrayList<>();//création d'un nouveau vecteur égale à fiche de soins
        for (int i = 0; i < listeDMR.size(); i++) { //recopie tous les éléments de listeDMR dans copieListeDMR
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

    public void trierDMRParNomPatient() {
        ArrayList<DMR> copieListeDMR = new ArrayList<>();//création d'un nouveau vecteur égale à fiche de soins
        for (int i = 0; i < listeDMR.size(); i++) { //recopie tous les éléments de listeDMR dans copieListeDMR
            copieListeDMR.add(listeDMR.get(i));
        }
        int i=0;
       // Collections.sort(copieListeDMR.get(i).getPatient().getNom());
      }
      
      
      public void ajouterCR (String idDMR, int idExam, String cr ){
          if(getStatut()==Statut.valueOf("MEDECIN")){
            DMR d= this.RechercheDMRParidDMR(idDMR);
            int i=0;
            while (i<d.getListeExamen().size() && !d.getListeExamen().get(i).getidExamen().equals(idExam)){
                i++;
            }
            if (i < d.getListeExamen().size()) {//il existe l'examen dans lequel on veut rajouter le compte rendu
                d.getListeExamen().get(i).setCR(cr);
            } else {
                System.out.println("Cet examen n'existe pas dans le DMR à l'identifiant " + idExam);
            }
        }
    }

    public void ajouterPatient(Patient patient) {
        if (!listePatient.contains(patient) && statutConnexion == Statut.valueOf("SECRET")) {
            listePatient.add(patient);
        } else {
            System.out.println("Ce patient existe déjà");
        }
    }

    public void ajouterPersonnel(Personnel personnel) {
        if (!listePersonnel.contains(personnel) && statutConnexion == Statut.valueOf("SECRET")) {
            listePersonnel.add(personnel);
        } else {
            System.out.println("Ce personnel existe déjà");
        }
    }

    public void ajouterExamen(Examen examen, String idDMR) {
        if (!this.RechercheDMRParidDMR(idDMR).equals(null)) {// si le DMR dans lequel on veut rajouter l'examen existe
            int i = 0;
            DMR dm = this.RechercheDMRParidDMR(idDMR);
            while (i < dm.getListeExamen().size() && !dm.getListeExamen().get(i).equals(examen)) {
                i++;
            }
            if (i < dm.getListeExamen().size()) {
                System.out.println("Cet examen existe déjà par le DMR d'id : " + dm.getidDMR());
            } else {
                dm.ajouterExamen(examen);
            }
        } else {
            System.out.println("Le DMR dans lequel vous voulez rajouter l'examen n'existe pas");
        }
    }


    public ArrayList<Examen> RechercheExamenParTypeExamen(TypeExamen type) {
        ArrayList<Examen> list = new ArrayList<>();
        for (int i = 0; i < listeDMR.size(); i++) {//parcour des DMR
            for (int j = 0; j < listeDMR.get(i).getListeExamen().size(); j++) {//parcour des listes d'examen pour chaque DMR
                if (listeDMR.get(i).getListeExamen().get(j).getTypeExamen().equals(type)) {
                    list.add(listeDMR.get(i).getListeExamen().get(j));
                }
            }
        }
        return list;
    }

    public ArrayList<Examen> RechercheExamenParNomMedecin(String nom) {
        String n = nom.toLowerCase();
        ArrayList<Examen> list = new ArrayList<>();
        for (int i = 0; i < listeDMR.size(); i++) {//parcour des DMR
            for (int j = 0; j < listeDMR.get(i).getListeExamen().size(); j++) {//parcour des listes d'examen pour chaque DMR
                if (listeDMR.get(i).getListeExamen().get(j).getMedecin().getNom().toLowerCase().equals(n)) {
                    list.add(listeDMR.get(i).getListeExamen().get(j));
                }
            }
        }
        return list;
    }

    public ArrayList<Examen> RechercheExamenParPrenomMedecin(String nom) {
        String n = nom.toLowerCase();
        ArrayList<Examen> list = new ArrayList<>();
        for (int i = 0; i < listeDMR.size(); i++) {//parcour des DMR
            for (int j = 0; j < listeDMR.get(i).getListeExamen().size(); j++) {//parcour des listes d'examen pour chaque DMR
                if (listeDMR.get(i).getListeExamen().get(j).getMedecin().getPrenom().toLowerCase().equals(n)) {
                    list.add(listeDMR.get(i).getListeExamen().get(j));
                }
            }
        }
        return list;
    }
     public ArrayList<Examen> RechercheExamenParDate(Date date) {
        ArrayList<Examen> list = new ArrayList<>();
        for (int i = 0; i < listeDMR.size(); i++) {//parcour des DMR
            for (int j = 0; j < listeDMR.get(i).getListeExamen().size(); j++) {//parcour des listes d'examen pour chaque DMR
                if (listeDMR.get(i).getListeExamen().get(j).getDate().equals(date)) {
                    list.add(listeDMR.get(i).getListeExamen().get(j));
                }
            }
        }
        return list;
    }

}