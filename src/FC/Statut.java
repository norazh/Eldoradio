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
public enum Statut {
    DECO ("DECO"),
    INTERNE ("INTERNE"),
    MEDECIN ("MEDECIN"),
    MANIP ("MANIP"),
    SECRET ("SECRET");
    private String statut;
    private Statut (String statut){
        this.statut=statut;
    }
    public String toString() {
        return statut;
    }
    
}
