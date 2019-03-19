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
    private String nom;
    private String prenom;
    private String id;
    private MDP mdp;
    private Statut statut;
    private Metier metier;
    
    public Personnel(String nom, String prenom, String id, MDP mdp, Statut statut,Metier metier) { //constructeur
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.mdp = mdp;
        this.statut=statut;
        this.metier=metier;
    }
    public Personnel(String nom, String prenom, String identifiant, MDP mdp, Metier metier) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = identifiant;
        this.mdp = mdp;
        this.metier=metier;
    }

     public Personnel(String nom, String prenom, String identifiant, MDP mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = identifiant;
        this.mdp = mdp;
    }


    public Personnel(String nom, String prenom, Statut statut, Metier metier) {
        this.nom = nom;
        this.prenom = prenom;
        this.metier=metier;
        this.statut=statut;
        
    }

    public Personnel(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    public String toStringNomPrenom(){
        return getNom()+" "+ getPrenom();
    }
	
	
	public String getId(){
		return id;
	}
	public String getNom(){
		return nom;
	}
	public String getPrenom(){
		return prenom;
	}
	public MDP getMDP(){
		return mdp;
	}
	public Statut getStatut(){
		return statut;
	}
	
	public void setMDP(String mdp){
            MDP m= new MDP(mdp);
            if (m.MdpValide(mdp)){
		this.mdp=m;
            }
            
	}
	public void setNom(String nom){
		this.nom=nom;
	}
	public void setPrenom (String prenom){
		this.prenom=prenom;
	}
        public void setStatut( Statut statut){
            this.statut=statut;
        }
        
        
}
