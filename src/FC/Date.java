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


public class Date implements Comparable {
    private int jour;
    private int mois;
    private int annee;
    private int heure;//ajout d'un attribut heure qui va permettre de distinguer les actes et fichePatient en fonction de l'heure 
    private int minute;//ajout d'un attribut minute qui va permettre de distinguer les actes et fichePatient en fonction des minutes
    

     public Date(int jour, int mois, int annee) {
        boolean dateValide = false;
        if ((mois >= 1 && mois <= 12) && (jour >= 1 && jour <= 31)) {
            //Mois avec 30 jours
            if ((mois == 4 || mois == 6 || mois == 9 || mois == 11) && (jour <= 30)) {
                dateValide = true;
            }

            //Mois avec 31 jours
            if ((mois == 1 || mois == 2 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) && (jour <= 31)) {
                dateValide = true;
            }

            //Février
            if ((mois == 2) && (jour < 30)) {
                //vérif année bisextile
                boolean anneeBisextileValide = false;

                //vérification  année bisextile 
				//une annee bisextile est divisible par 4 mais pas par 100 sauf si divisible par 400
                if ((annee % 400 == 0) || ((annee % 4 == 0) && (annee % 100 != 0))) {
                    anneeBisextileValide = true;
                }

                if (anneeBisextileValide == true && jour <= 29) {
                    dateValide = true;
                } else if (anneeBisextileValide == false && jour <= 28) {
                    dateValide = true;
                }
            }
        }

        if (dateValide == true) {
            this.annee = annee;
            this.mois = mois;
            this.jour = jour;
        } else {
            throw new IllegalArgumentException("La date saisie n'est pas valide. Veuillez recommencer");
        }
	 }
	 

     public Date(int jour, int mois, int annee, int heure, int minute) {
        boolean dateValide = false;
        if ((mois >= 1 && mois <= 12) && (jour >= 1 && jour <= 31)) {
            //Mois avec 30 jours
            if ((mois == 4 || mois == 6 || mois == 9 || mois == 11) && (jour <= 30)) {
                dateValide = true;
            }

            //Mois avec 31 jours
            if ((mois == 1 || mois == 2 || mois == 3 || mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) && (jour <= 31)) {
                dateValide = true;
            }

            //Février
            if ((mois == 2) && (jour < 30)) {
                //vérif année bisextile
                boolean anneeBisextileValide = false;

                //vérification  année bisextile 
				//une annee bisextile est divisible par 4 mais pas par 100 sauf si divisible par 400
                if ((annee % 400 == 0) || ((annee % 4 == 0) && (annee % 100 != 0))) {
                    anneeBisextileValide = true;
                }

                if (anneeBisextileValide == true && jour <= 29) {
                    dateValide = true;
                } else if (anneeBisextileValide == false && jour <= 28) {
                    dateValide = true;
                }
            }
        }

        if (dateValide == true) {
            this.annee = annee;
            this.mois = mois;
            this.jour = jour;
        } else {
            throw new IllegalArgumentException("La date saisie n'est pas valide. Veuillez recommencer");
        }
		 if (heure <= 23 || heure >= 0) {
            this.heure = heure;
        } else {
            throw new IllegalArgumentException("La date saisie n'est pas valide. Veuillez recommencer");
        }
        if (minute <= 59 || minute >= 0) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("La date saisie n'est pas valide. Veuillez recommencer");
        }
    }
    public String toString() {
        String s = "";
        if (getJour() < 10) {
            s += "0" + getJour() + "/";
        } else {
            s += getJour() + "/";
        }
        if (getMois() < 10) {
            s += "0" + getMois() + "/";
        } else {
            s += getMois() + "/";
        }
        s += getAnnee() + "-";
        
        if (heure < 10) {
            s += "0" + heure + ":";
        } else {
            s += heure + ":";
        }
        if (minute < 10) {
            s += "0" + minute;
        } else {
            s += minute;
        }
        return s;
    }

		
    public String toStringBasique() {
        String s = "";
        if (getJour() < 10) {
            s += "0" + getJour() + "/";
        } else {
            s += getJour() + "/";
        }
        if (getMois() < 10) {
            s += "0" + getMois() + "/";
        } else {
            s += getMois() + "/";
        }
        s += getAnnee() ;
        return s;
    }
    
    public boolean equals(Object o) {// méthode qui permet de vérifier si deux dates sont identiques , retourne true si les 2 dates correspondent, false sinon   
        if (o instanceof Date) { // si l'objet o est une instance de Date
            Date d = (Date)o;// crée une variable d égale à l'objet
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour) && (heure == d.heure) && (minute == d.minute);// retourne true si c'est la même date, false si c'est pas la même date
            }
        else
            return false;// si l'objet n'est pas une date, on retourne false
        }
    
    public boolean sup(Object o) {
        if (o instanceof Date) {
            Date d = (Date) o;
            return (getAnnee() >= d.getAnnee()) && (getMois() >= d.getMois()) && (getJour() >= d.getJour());
        } else {
            return false;
        }
    }
    
    // precondition : 'o' est une instance de 'Date' : 
    public int compareTo(Object o) {
        Date d = (Date)o;// variable d prend les valeurs de l'objet
        if (annee != d.annee)// si c'est pas la même année
            return annee - d.annee;// renvoie la différence des années
        // ici on a forcement annee == d.annee :
        if (mois != d.mois) //si passe a ce deuxieme if annee égale
            return mois  - d.mois;// renvoie la différence des mois
        // ici on a forcement annee == d.annee et mois == d.mois :
		if (getJour() != d.getJour()){// si passe à ce if, mois égal
			return jour - d.jour;// renvoie la différence des jours
		}
		if ( heure != d.heure){// si passe à ce if, jour égal
			return heure - d.heure ; // renvoie la différence d'heures 
		}
        return minute - d.minute;// différence des minutes
        }
		
        public int getJour(){
            return jour;
        }
	public String getJourComplet (){//retourne le jour
            String s="";
		if (getJour() < 10) {
                    s += "0" + getJour();
                } 
                else {
                    s += getJour();
                }
                return s;
	}
	
	public int getMois (){//retourne le mois
		return mois;
	}
        
        public String getMoisComplet (){//retourne le jour
            String s="";
		if (getMois() < 10) {
                    s += "0" + getMois();
                } 
                else {
                    s += getMois();
                }
                return s;
	}
	
	public int getAnnee (){//retourne l'année
		return annee;
        }
	
	public int getHeure (){//retourne l'heure
		return heure;
	}
	
	public int getMinute (){//retourne la minute
		return minute;
	}
	
        public static Date getDateHourFromString(String stringT){
        String j = stringT.substring(0, 2);
        String m = stringT.substring(2, 4);
        String a = stringT.substring(4, 8);
        String h = stringT.substring(8, 10);
        String mi = stringT.substring(10, 12);
        Date date = new Date(Integer.parseInt(j),Integer.parseInt(m),Integer.parseInt(a),Integer.parseInt(h),Integer.parseInt(mi));
        return date;
    }
        
         /**
     * Permet d'obtenir l'annee, le mois et le jour
     *
     * @return un String
     */ 
    public String toStringSql() {
        String s = "";
        
        if (getJour() < 10) {
            s += "0" + getJour();
        } else {
            s += getJour();
        }
        if (getMois() < 10) {
            s += "0" + getMois();
        } else {
            s += getMois();
        }
        s += getAnnee();
        if (getHeure() < 10) {
            s += "0" + getHeure();
        } else {
            s += getHeure();
        }
        if (getMinute() < 10) {
            s += "0" + getMinute();
        } else {
            s += getMinute();
        }
        return s;
    }
	
    
    }

