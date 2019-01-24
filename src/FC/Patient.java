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

public class Patient {
    private String nom;
    private String prenom;
	private String adresse;
	private String ville;
	private String codePostal;
        private String idSIR;
        private String idSIH;
        private String idDMR;
	private Date dateNaissance;
	private Sexe sexe;
	
    
    public Patient(String nom, String prenom, String adresse, String ville, String codePostal, String idSIR, String idSIH, Date date, String idDMR,  Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
		this.adresse= adresse;
		this.ville=ville;
		this.codePostal= codePostal;
		this.idSIR=idSIR;
                this.idSIH= idSIH;
                this.idDMR=idDMR;
		this.dateNaissance= date;
		this.sexe=sexe;
		
        }
    
    public String toString() {
        return getPrenom() + " " + getNom() + " - " + getDateDeNaissance().toString() + " / " + getSexe()+ " / " ;
        }
    
    public String toStringNom(){
        return getNom();
    }
    public String toStringNomPrenom(){
        return getNom() +" "+ getPrenom();
    }
    
    public boolean equals(Object o) {
        if (o instanceof Patient) {
            Patient p = (Patient)o;
            return nom.equals(p.nom) && prenom.equals(p.prenom);
            }
        else
            return false;
        }    
		
		
	public String getNom (){
		return nom;
	}
	public String getPrenom (){
		return prenom;
	}
	public String getAdresse (){
		return adresse;
	}
	public String getVille (){
		return ville;
	}
	public String	getCodePostal(){
		return codePostal;
	}
	public String getidSIR(){
            return idSIR;
        }
        public String getidSIH (){
            return idSIH;
        }
        public String getidDMR(){
            return idDMR;
        }
	public Date getDateDeNaissance(){
		return dateNaissance;
	}
	public Sexe getSexe(){
		return sexe;
	}
	public void setNom ( String n){
		this.nom = n;
	}
	public void setPrenom (String p){
		this.prenom= p;
	}
	
	public void setAdresse (String a){
		this.adresse=a;
	}
	public void setVille (String v){
		this.ville= v;
	}
	
	public void setCodePostal ( String cp){
		this.codePostal= cp;
	}
	public void setidSIR (String id){
            this.idSIR=id;
        }
        public void setidSIH(String id){
            this.idSIH=id;
        }
        public void setidDMR(String id){
            this.idDMR=id;
        }
	public void setDateNaissance( Date d){
		this.dateNaissance=d;
	}
	public void setSexe (Sexe s){
		this.sexe=s;
	}
        
	
    }


