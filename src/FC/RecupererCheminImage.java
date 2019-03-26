/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Imane
 */
public class RecupererCheminImage {

    private String path;

    /**
     * Ouvre un JFileChooser pour choisir l'image à charger dans l'interface de traitement d'image
     * @return le chemin de l'image
     */
    public String getPath() {
        JFileChooser file = new JFileChooser();
        int result = file.showOpenDialog(null);

        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png","pgm");
        file.addChoosableFileFilter(filter);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String p = selectedFile.getAbsolutePath();
            path=p;
        }
        
         else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Aucun fichier sélectionné");
        }
        
        return path;
    }
    
    
}
