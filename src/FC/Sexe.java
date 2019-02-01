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
public enum Sexe {
    H ("H"),
    F ("F");
    private String sexe;
    private Sexe (String sexe){
        this.sexe=sexe;
        
    }
    public String toString() {
        return sexe;
    }
}
