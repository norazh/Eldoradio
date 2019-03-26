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
public class Personnel {
    public String  idpers;
    private String nom;
    private String prenom;
    private String identifiant;
    private MDP mdp;
    private Statut statut;
    private Metier metier;
    
     public Personnel(String idpers, String nom, String prenom, String identifiant, MDP mdp, Statut statut, Metier metier) { 
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.statut = statut;
        this.metier = metier;
    }

    public Personnel(String idpers, String nom, String prenom, String identifiant, MDP mdp, Statut statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.statut = statut;
    }

    public Personnel(String idpers, String nom, String prenom, String identifiant, MDP mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mdp = mdp;
    }

    public Personnel(String idpers, String nom, String prenom, Statut statut, Metier metier) {
        this.nom = nom;
        this.prenom = prenom;
        this.metier = metier;
        this.statut = statut;

    }

    public Personnel(String idpers, String nom, String prenom) {
        this.idpers = idpers;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public Personnel(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    
    // Constructeur vide pour l' UI Connexion
    public Personnel() {}
    
    public String toStringNomPrenom(){
        return getNom()+" "+ getPrenom();
    }
	
	
	public String getIdpers(){
    return idpers;
    }
    
    public String getId() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public MDP getMDP() {
        return mdp;
    }

    public Statut getStatut() {
        return statut;
    }
    
    public Metier getMetier() {
        return metier;
    }
    
    public void setIdpers(String idpers){
    this.idpers = idpers;
    }
    
    public void setMDP(String mdp) {
        MDP m = new MDP(mdp);
        if (m.MdpValide(mdp)) {
            this.mdp = m;
        }

    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setId(String identifiant) {
        this.identifiant = identifiant;
    }
    
    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    
    public void setMetier(Metier metier){
        this.metier = metier;
    }
        
}
