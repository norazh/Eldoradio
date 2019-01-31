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
public class MDP {
    private String mdp;
    public MDP (String mdp){
        this.mdp=mdp;
        
    /**
     *
     * @param mdp
     * @return
     */
    public boolean MdpValide(String mdp){
        // 5 caractères minimum
        // 1 majuscule minimum
        // 1 minuscule minimum
        // 1 chiffre minimum
        //1 lettre minimum
        char c;
        int i=0;
        boolean majuscule = false;
        boolean minuscule = false;
        boolean lettre = false;
        boolean nombre=false;
        
        if(mdp.length()<5){
            System.out.println("Mot de Passe invalide : trop petit");
            return false;
        }
        
            while(i<mdp.length() && (majuscule==false || minuscule==false || lettre==false || nombre==false)){
            c = mdp.charAt(i);
            if((c>='0')&&(c<='9')){
  
                nombre = true;
              }
            else{

                lettre = true;
            }
            if((c>='a')&&(c<='z')){

                minuscule = true;
            }
            else if((c>='A')&&(c<='Z')){
               
                majuscule = true;
            }
            i++;
            
        }
        if(lettre && majuscule && minuscule && nombre){
            return true;
        }
        else{
            return false;
        }
    }
    }
    
