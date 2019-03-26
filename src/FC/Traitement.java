/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JPanel;
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

    /**
     * Eclaircit une image
     */
    public void imageEclaircie() {
        BufferedImage imgBrillant = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        RescaleOp brillance = new RescaleOp(1.2f, 0, null);
        Graphics2D surfaceImg = imgBrillant.createGraphics();
        imgBrillant = brillance.filter(monImage, imgBrillant);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgBrillant;
        repaint();

    }

    /**
     * Assombrit une image
     */
    public void imageSombre() {
        BufferedImage imgSombre = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        RescaleOp assombrir = new RescaleOp(0.7f, 10, null);
        Graphics2D surfaceImg = imgSombre.createGraphics();
        imgSombre = assombrir.filter(monImage, null);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgSombre;
        repaint();
    }

    /**
     * Fait une inversion en niveau de gris
     */
    public void inversionNiveauGris() {
        BufferedImage imageInv = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        Graphics2D surfaceImg = imageInv.createGraphics();
        RescaleOp op = new RescaleOp(-1.0f, 255f, null);
        imageInv = op.filter(monImage, null);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imageInv;
        repaint();
    }

    /**
     * Fait une rotation à droite
     */
    public void rotationDroite() {
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageRot.createGraphics();
        AffineTransform rotation = new AffineTransform();
        rotation.rotate(Math.PI / 2, (int) (monImage.getWidth(null) / 2), (int) (monImage.getHeight(null) / 2));
        surfaceImg.drawImage(monImage, rotation, null);
        monImage = imageRot;
        repaint();
    }

    /**
     * Fait une rotation à gauche
     */
    public void rotationGauche() {
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageRot.createGraphics();
        AffineTransform rotation = new AffineTransform();
        rotation.rotate(-Math.PI / 2, (int) (monImage.getWidth(null) / 2), (int) (monImage.getHeight(null) / 2));
        surfaceImg.drawImage(monImage, rotation, null);
        monImage = imageRot;
        repaint();
    }

    /**
     * Symétrise verticalement
     */
    public void symetrieVerticale() {
        int width = monImage.getWidth();
        int height = monImage.getHeight();
        BufferedImage imageSymVer = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageSymVer.createGraphics();
        surfaceImg.drawImage(monImage, width, 0, 0, height, 0, 0, width, height, this);
        monImage = imageSymVer;
        repaint();
    }

    /**
     * Symétrise horizontalement
     */
    public void symetrieHorizontale() {
        int width = monImage.getWidth();
        int height = monImage.getHeight();
        BufferedImage imageSymHori = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());
        Graphics2D surfaceImg = imageSymHori.createGraphics();
        surfaceImg.drawImage(monImage, 0, height, width, 0, 0, 0, width, height, this);
        monImage = imageSymHori;
        repaint();
    }

    /**
     * Affiche l'image chargée dans le panel d'affichage
     *
     * @param fichierImage
     */
    public void afficherImageChargee(File fichierImage) {
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

    public BufferedImage getImage(File fichierImage) {
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

    /**
     * Récupère l'image du panel d'intérêt
     *
     * @return une BufferedImage
     */
    public BufferedImage getImagePanneau() {
        int width = this.getWidth();
        int height = this.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        this.paintAll(g);
        g.dispose();
        return image;
    }

    /**
     * Enregistre l'image affichée en local
     *
     * @param fichierImage
     * @throws FileNotFoundException
     */
    public void enregistrerImage(File fichierImage) throws FileNotFoundException {
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

    /**
     * Retourne l'extension d'un fichier
     *
     * @param f Fichier
     * @return l'extension d'un fichier en String
     */
    public String getExtension(File f) {
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }
        }
        return null;
    }

    /**
     * Retourne la valeur maximum des pixels de l'image
     *
     * @return le int correspondant à la valeur maximum des pixels de l'image
     */
    public int getMax() {
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

}
