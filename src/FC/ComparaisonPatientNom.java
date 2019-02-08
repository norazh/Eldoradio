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
class ComparaisonPatientNom implements ComparaisonPatient{
 public int comparerPatient(Patient p1, Patient p2) {// l'int retourné sera la différence des années des 2 fiches si elles sont d'années diff, la différence des mois si elles sont d'années égales, et la différence des jours si elles sont de même année et de même mois
        return p1.getNom().compareTo(p2.getNom());
 }
}
