/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraitementImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Imane
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFrame f = new JFrame("Titre");
        f.setSize(400, 250);
        ImageIcon ii = new ImageIcon("D:\\TIS4\\S8\\Projet_SIR\\jpg\\jpg\\sinus\\sinus1_0000.jpg");
        JLabel lab = new JLabel(ii);
        f.add(lab);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setVisible(true);
    }

}
