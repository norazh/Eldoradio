/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author noraz
 */
public class CodePourConnexion {
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        DossierUtilisateurs BaseDonnee = new DossierUtilisateurs();
        Utilisateur user = BaseDonnee.IdentificationValide(jTextField2.getText(),new String(jPasswordField1.getPassword()));
        if(user!=null){
            switch(user.getFonction()){
                case MEDECIN:
                    new AccueilMed(user).setVisible(true); //rajouter dans le constructeur un param utilisateur ?
                  break;
                case SECRETAIRE_MEDICAL:
                    
                    new AccueilMed(user).setVisible(true);
                    break;
                case SECRETAIRE:
                    new AccueilMed(user).setVisible(true);
                    break;
                default:
                    break;
            } 
            this.setVisible(false);
            
        }
        else{

            JOptionPane.showMessageDialog(this, "Authentification Incorrecte", "Erreur", JOptionPane.WARNING_MESSAGE);
        }
    }                                        

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {                                    
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DossierUtilisateurs BaseDonnee = new DossierUtilisateurs();
            Utilisateur user = BaseDonnee.IdentificationValide(jTextField2.getText(), new String(jPasswordField1.getPassword()));
            if (user != null) {
                switch (user.getFonction()) {
                    case MEDECIN:
                        new AccueilMed(user).setVisible(true); //rajouter dans le constructeur un param utilisateur ?
                        break;
                    case SECRETAIRE_MEDICAL:

                        new AccueilMed(user).setVisible(true);
                        break;
                    case SECRETAIRE:
                        new AccueilMed(user).setVisible(true);
                        break;
                    default:
                        break;
                }
                this.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(this, "Authentification Incorrecte", "Erreur", JOptionPane.WARNING_MESSAGE);
            }
        }
    }                                   

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {                                           
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DossierUtilisateurs BaseDonnee = new DossierUtilisateurs();
            Utilisateur user = BaseDonnee.IdentificationValide(jTextField2.getText(), new String(jPasswordField1.getPassword()));
            if (user != null) {
                switch (user.getFonction()) {
                    case MEDECIN:
                        new AccueilMed(user).setVisible(true); //rajouter dans le constructeur un param utilisateur ?
                        break;
                    case SECRETAIRE_MEDICAL:

                        new AccueilMed(user).setVisible(true);
                        break;
                    case SECRETAIRE:
                        new AccueilMed(user).setVisible(true);
                        break;
                    default:
                        break;
                }
               
                this.dispose();

            } else {

                JOptionPane.showMessageDialog(this, "Authentification Incorrecte", "Erreur", JOptionPane.WARNING_MESSAGE);
            }
        }
    }  
}
