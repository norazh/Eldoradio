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
        if (MdpValide(mdp)){
        this.mdp=mdp;
        }
        else{
            System.out.println("Mot de passe incorrect. Le mdp doit avoir au minimum 5 caractères, au minimum 1 majuscule, 1 minuscule, au moins 1 chiffre et au moins u caractère spécial");
        }
    }
    public boolean MdpValide(String mdp){
        // 8 caractères minimum
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
        boolean charSpecial=false;
        
        if(mdp.length()<8){
            System.out.println("Mot de Passe invalide : trop petit. Il doit faire au moins 8 caractères");
            return false;
        }
        
            while(i<mdp.length() && (majuscule==false || minuscule==false || lettre==false || nombre==false || charSpecial==false)){
            c = mdp.charAt(i);
            if((c>='0')&&(c<='9')){
  
                nombre = true;
              }
            else if ((c=='%') ||(c=='#') || (c==':') || (c=='$') || (c=='*')|| (c=='!')|| (c=='"')|| (c=='&')|| (c=='+')|| (c==',')|| (c=='-')|| (c=='.')|| (c=='/')|| (c==';')|| (c=='<')|| (c=='=')|| (c=='>')|| (c=='?')|| (c=='@')|| (c=='^')|| (c=='_')|| (c=='~')) {
                
                    charSpecial=true;
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
        if(lettre && majuscule && minuscule && nombre && charSpecial){
            return true;
        }
        else{
            return false;
        }
    }
    }
    
