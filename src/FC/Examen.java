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
public class Examen {
    private Date date;
    private PH ph;
    private TypeExamen type;
    private CompteRendu CR;
    private PACS pacs;
    
    public Examen (Date date, PH ph, TypeExamen type, CompteRendu CR, PACS pacs){
        this.date=date;
        this.type= type;
        this.CR=CR;
        this.pacs=pacs;
    }
}
