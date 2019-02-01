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
public enum TypeExamen {
    RADIOLOGIE("RADIOLOGIE"),
    IRM("IRM"),
    SCAN("SCAN"),
    ECHOGRAPHIE("ECHOGRAPHIE"),
    ANGIOGRAPHIE("ANGIOGRAPHIE"),
    ECHOENDOGRAPHIE("ECHOENDOGRAPHIE"),
    MAMMOGRAPHIE("MAMMOGRAPHIE"),
    RADIOTHERAPIE("RADIOTHERAPIE"),
    PET("PET");
    
    private String type;
     private TypeExamen(String type) {
        this.type = type;
    }

    
    public String toString() {
        return type;
    }
}
