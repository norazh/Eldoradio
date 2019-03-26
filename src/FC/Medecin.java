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
public class Medecin extends Personnel {

    String specialite;

    public Medecin(String idpers, String nom, String prenom, String identifiant, MDP mdp, String specialite) {

        super(idpers, nom, prenom, identifiant, mdp);
        this.setStatut(Statut.MEDECIN);
        this.specialite = specialite;

    }

    public Medecin(String nom, String prenom) {
        super(nom, prenom);
    }

}
