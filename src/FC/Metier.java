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
public enum Metier {
    INTERNE("INTERNE"),
    MEDECIN("MEDECIN"),
    MANIP("MANIP"),
    SECRETAIRE("SECRETAIRE");
    private String metier;

    private Metier(String metier) {
        this.metier = metier;
    }

    public String toString() {
        return metier;
    }

}
