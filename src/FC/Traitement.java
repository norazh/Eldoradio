/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Blob;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Imane
 */
public class Traitement extends JPanel {

    BufferedImage monImage = null;
    int[] pgm = null;
    int[][] pgm2 = null;

    public Traitement() {
        super();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (monImage != null) {
            g2.drawImage(monImage, 0, 0, null);
        }
    }

    public void reduireImage() { // Reduire la taille d'une image
        BufferedImage imageReduite = new BufferedImage((int) (monImage.getWidth() * 0.5), (int) (monImage.getHeight() * 0.5), monImage.getType());
        AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
        int interpolation = AffineTransformOp.TYPE_BICUBIC;
        AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
        retaillerImage.filter(monImage, imageReduite);
        monImage = imageReduite;
        repaint();
    }

    public void agrandirImage() { // Agrandir la taille de l'image
        BufferedImage imageZoomer = new BufferedImage((int) (monImage.getWidth() * 1.5), (int) (monImage.getHeight() * 1.5), monImage.getType());
        AffineTransform agrandir = AffineTransform.getScaleInstance(1.5, 1.5);
        int interpolation = AffineTransformOp.TYPE_BICUBIC;
        AffineTransformOp retaillerImage = new AffineTransformOp(agrandir, interpolation);
        retaillerImage.filter(monImage, imageZoomer);
        monImage = imageZoomer;
        repaint();
    }

    public void imageEclaircie() { // Eclaircir l'image
        /*
		 *    RescaleOp brillance = new RescaleOp(A, K, null);
		 *    1.  A< 1, l’image devient plus sombre.
   			  2.  A > 1, l’image devient  plus brillante.
   			  3. K est compris entre 0 et 256 et ajoute un éclairement .
         */
        BufferedImage imgBrillant = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        RescaleOp brillance = new RescaleOp(1.2f, 0, null);
        Graphics2D surfaceImg = imgBrillant.createGraphics();
        imgBrillant = brillance.filter(monImage, imgBrillant);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgBrillant;
        repaint();

    }

    public void imageSombre() { // Assombrir l'image
        /* RescaleOp assombrir = new RescaleOp(A, K, null);
		 *    
		 *    1.  A < 1, l’image devient plus sombre.
   			  2.  A > 1, l’image devient  plus brillante.
   			  3.  K est compris entre 0 et 256 et ajoute un éclairement .
		 *    
         */
        BufferedImage imgSombre = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        RescaleOp assombrir = new RescaleOp(0.7f, 10, null);
        Graphics2D surfaceImg = imgSombre.createGraphics();
        imgSombre = assombrir.filter(monImage, null);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgSombre;
        repaint();
    }

    public void inversionNiveauGris() {
        BufferedImage imageInv = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        Graphics2D surfaceImg = imageInv.createGraphics();
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);
        imageInv = op.filter(monImage, null);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imageInv;
        repaint();
    }

    public void rotationDroite() {
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageRot.createGraphics();
        AffineTransform rotation = new AffineTransform();
        rotation.rotate(Math.PI / 2, (int) (monImage.getWidth(null) / 2), (int) (monImage.getHeight(null) / 2));
        surfaceImg.drawImage(monImage, rotation, null);
        monImage = imageRot;
        repaint();
    }

    public void rotationGauche() {
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageRot.createGraphics();
        AffineTransform rotation = new AffineTransform();
        rotation.rotate(-Math.PI / 2, (int) (monImage.getWidth(null) / 2), (int) (monImage.getHeight(null) / 2));
        surfaceImg.drawImage(monImage, rotation, null);
        monImage = imageRot;
        repaint();
    }

    public void symetrieVerticale() {
        int width = monImage.getWidth();
        int height = monImage.getHeight();
        BufferedImage imageSymVer = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageSymVer.createGraphics();
        surfaceImg.drawImage(monImage, width, 0, 0, height, 0, 0, width, height, this);
        monImage = imageSymVer;
        repaint();
    }

    public void symetrieHorizontale() {
        int width = monImage.getWidth();
        int height = monImage.getHeight();
        BufferedImage imageSymHori = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageSymHori.createGraphics();
        surfaceImg.drawImage(monImage, 0, height, width, 0, 0, 0, width, height, this);
        monImage = imageSymHori;
        repaint();
    }

    public void afficherImageChargee(File fichierImage) {   // dessiner une image à l'ecran	
        if (this.getExtension(fichierImage).contentEquals("pgm")) {
            try {

                LecteurPGM im = new LecteurPGM(fichierImage);
                pgm = im.getImage();
                pgm2 = im.getImage2();

                monImage = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
                final WritableRaster raster = monImage.getRaster();
                raster.setPixels(0, 0, im.getWidth(), im.getHeight(), im.getImage());
                monImage.getGraphics().drawImage(monImage, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                monImage = ImageIO.read(fichierImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (monImage == null) {
                JOptionPane.showMessageDialog(this, "Ce format d'image n'est pas supporté", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        repaint();
    }

    public BufferedImage getImage(File fichierImage) {   // retourner une BufferedImage d'un fichier Image	
        if (this.getExtension(fichierImage).contentEquals("pgm")) {
            try {

                LecteurPGM im = new LecteurPGM(fichierImage);
                pgm = im.getImage();
                pgm2 = im.getImage2();

                monImage = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
                final WritableRaster raster = monImage.getRaster();
                raster.setPixels(0, 0, im.getWidth(), im.getHeight(), im.getImage());
                monImage.getGraphics().drawImage(monImage, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                monImage = ImageIO.read(fichierImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return monImage;

    }

    public BufferedImage getImagePanneau() {      // récupérer une image du panneau
        int width = this.getWidth();
        int height = this.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        this.paintAll(g);
        g.dispose();
        return image;
    }

    public void enregistrerImage(File fichierImage) throws FileNotFoundException { //Enregistrer une image en local
        String format = "JPG";
        BufferedImage image = monImage;
        if (monImage == null) {
            JOptionPane.showMessageDialog(this, "Pas d'image à enregistrer", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {

                ImageIO.write(image, format, fichierImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

//        public void getFromPacsURL() throws SQLException { // Récupérer une image à partir d'un URL stocké dans le PACS
//        int numArch = 2;
//        String user = System.getProperty("user.home");
//        ConnexionBD c = new ConnexionBD();
//        boolean b = c.connexion();
//        URL url = null;
//        File target = null;
//        ResultSet resultat = c.exec("SELECT * FROM `hostis_dmr`.`PACS` WHERE `NumArchivage` = " + numArch);
//        String chemin = null;
//        if (resultat.next()) {
//            url = resultat.getURL(2);
//        }
//
//        try {
//            InputStream fileIn = url.openStream();
//            //target = File.createTempFile("image", ".pgm");
//            Random random = new Random();
//            int randomNum = random.nextInt(6) + 100;
//            target = new File("PGM" + randomNum + ".pgm");
//            BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("PGM" + randomNum + ".pgm"));
//            int b2;
//            while ((b2 = fileIn.read()) != -1) {
//                fileOut.write(b2);
//            }
//            fileOut.flush();
//            fileOut.close();
//
//            fileIn.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        this.ajouterImage(target);
//        c.close();
//
//    }
//                
//        public void getFromPacs(int numArch) { // Récupérer une image en local à parti de son chemin stocké dans le PACS
//
//        String user = System.getProperty("user.home");
//        ConnexionBD c = new ConnexionBD();
//        boolean b = c.connexion();
//        URL url = null;
//        File target = null;
//        ResultSet resultat = c.exec("SELECT * FROM `hostis_dmr`.`PACS` WHERE `NumArchivage` = " + numArch);
//        String chemin = null;
//
//        try {
//            if (resultat.next()) {
//                chemin = resultat.getString(2);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PanDessin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        File targt = new File(chemin);
//        this.ajouterImage(targt);
//        c.close();
//
//    }
    public String getExtension(File f) { // Retourne l'extension d'un fichier
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }
        }
        return null;
    }

    public int getMax() { // Retourne la valeur maximum des pixels de l'image
        int max = monImage.getRGB(0, 0);
        int pivot;

        for (int j = 0; j < monImage.getWidth(); j++) {
            for (int k = 0; k < monImage.getHeight(); k++) {
                pivot = monImage.getRGB(k, j);

                if (pivot > max) {
                    max = pivot;
                }

            }
        }
        return max;

    }

//    public void writeInPacs() { // ajouter une image au PACS pour un nouvel Examen
//
//        ConnexionBD c = new ConnexionBD();
//        boolean b = c.connexion();
//        Random random = new Random();
//        int randomNum = random.nextInt(999) + 1000;
//        int max1 = 0;
//        int max2 = 0;
//        String path = "C:\\Users\\Julien\\Desktop\\PACS\\" + randomNum + ".jpg";
//        String file = randomNum + ".jpg";
//
//        File fichierEnregistrement = new File(path);
//        if (b) {
//            ResultSet ph4 = c.exec("SELECT MAX(`id`) AS 'max1' FROM `hostis_dmr`.`PACS`");
//
//            try {
//                while (ph4.next()) {
//                    max1 = ph4.getInt("max1");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(PanDessin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            ResultSet ph5 = c.exec("SELECT MAX(`NumArchivage`) AS 'max2' FROM `hostis_dmr`.`Examen`");
//
//            try {
//                while (ph5.next()) {
//                    max2 = ph5.getInt("max2");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(PanDessin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            c.insererBD("INSERT INTO `hostis_dmr`.`PACS` (`id`,`NumArchivage`, `FichierImage`)VALUES ('" + (max1 + 1) + "','" + (max2 + 1) + "','" + file + "')");
//
//        }
//        try {
//            this.enregistrerImage(fichierEnregistrement);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PanDessin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        c.close();
//
//    }
//
//    public void writeInPacs(int n) { // ajouter une image au PACS pour un examen existant déjà (numArchivage = n)
//        int numArch = n;
//        ConnexionBD c = new ConnexionBD();
//        boolean b = c.connexion();
//        Random random = new Random();
//        int randomNum = random.nextInt(6) + 100;
//        int max1 = 0;
//
//        String path = "C:\\Users\\Julien\\Desktop\\PACS\\" + randomNum + ".jpg";
//        String file = randomNum + ".jpg";
//
//        File fichierEnregistrement = new File(path);
//        if (b) {
//            ResultSet ph4 = c.exec("SELECT MAX(`id`) AS 'max1' FROM `hostis_dmr`.`PACS`");
//
//            try {
//                while (ph4.next()) {
//                    max1 = ph4.getInt("max1");
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(PanDessin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            c.insererBD("INSERT INTO `hostis_dmr`.`PACS` (`id`,`NumArchivage`, `FichierImage`)VALUES ('" + (max1 + 1) + "','" + numArch + "','" + file + "')");
//
//        }
//        try {
//            this.enregistrerImage(fichierEnregistrement);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(PanDessin.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        c.close();
//    }
}
