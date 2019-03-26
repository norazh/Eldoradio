/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import FC.DbConnection;
import FC.Examen;
import FC.RecupererCheminImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import FC.Traitement;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Imane
 */
public class InterfaceTraitementImageExam extends javax.swing.JFrame {

    private static Examen examen;
    public String path;
    public String query;
    public Traitement panel_traitement = new Traitement();
    public RecupererCheminImage r;

    /**
     * Creates new form NewJFrame
     */
    public InterfaceTraitementImageExam() {

        initComponents();

        examen = UI.Medecin_AfficherTOUSLESExamens.getExamen();
        System.out.println(examen.getidExamen());
    }

    /* Code généré automatiquement par la palette Swing NetBeans */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Bouton_RotationD = new javax.swing.JButton();
        Bouton_Inverser = new javax.swing.JButton();
        Bouton_RotationG = new javax.swing.JButton();
        Bouton_SymetrieV = new javax.swing.JButton();
        Bouton_SymetrieH = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Bouton_Eclaircir = new javax.swing.JButton();
        Bouton_Assombrir = new javax.swing.JButton();
        Bouton_reinitialiser = new javax.swing.JButton();
        jButton_chargerImage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Bouton_EnregistrerImage = new javax.swing.JButton();
        Bouton_enregistrerDansPacs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(247, 246, 246));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2), "Traitement d'image", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        Bouton_RotationD.setText("Rotation 90° horaire");
        Bouton_RotationD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_RotationDActionPerformed(evt);
            }
        });

        Bouton_Inverser.setText("Inverser ");
        Bouton_Inverser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_InverserActionPerformed(evt);
            }
        });

        Bouton_RotationG.setText("Rotation 90° anti-horaire");
        Bouton_RotationG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_RotationGActionPerformed(evt);
            }
        });

        Bouton_SymetrieV.setText("Symétrie verticale");
        Bouton_SymetrieV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_SymetrieVActionPerformed(evt);
            }
        });

        Bouton_SymetrieH.setText("Symétrie horizontale");
        Bouton_SymetrieH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_SymetrieHActionPerformed(evt);
            }
        });

        jLabel2.setText("Luminosité");

        Bouton_Eclaircir.setText("Plus");
        Bouton_Eclaircir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_EclaircirActionPerformed(evt);
            }
        });

        Bouton_Assombrir.setText("Moins");
        Bouton_Assombrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_AssombrirActionPerformed(evt);
            }
        });

        Bouton_reinitialiser.setText("Réinitialiser");
        Bouton_reinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_reinitialiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Bouton_reinitialiser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Bouton_Assombrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bouton_Eclaircir))
                    .addComponent(Bouton_SymetrieH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bouton_SymetrieV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bouton_RotationD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bouton_Inverser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bouton_RotationG, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Bouton_RotationD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bouton_RotationG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bouton_Inverser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bouton_SymetrieV, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Bouton_SymetrieH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bouton_Eclaircir)
                    .addComponent(Bouton_Assombrir))
                .addGap(29, 29, 29)
                .addComponent(Bouton_reinitialiser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jButton_chargerImage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_chargerImage.setText("CHARGER UNE IMAGE");
        jButton_chargerImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2));
        jButton_chargerImage.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_chargerImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_chargerImageActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Bouton_EnregistrerImage.setText("Enregistrer");
        Bouton_EnregistrerImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_EnregistrerImageActionPerformed(evt);
            }
        });

        Bouton_enregistrerDansPacs.setText("Enregistrer dans le PACS");
        Bouton_enregistrerDansPacs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bouton_enregistrerDansPacsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton_chargerImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Bouton_enregistrerDansPacs, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Bouton_EnregistrerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_chargerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bouton_enregistrerDansPacs, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bouton_EnregistrerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1117, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Insérer une images dans la table 'pacs' de la BD
     *
     * @param evt
     */
    private void Bouton_enregistrerDansPacsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_enregistrerDansPacsActionPerformed
        DbConnection c = new DbConnection();
        c.connexionB();
        BufferedImage image_panel = panel_traitement.getImagePanneau();

        /* ----------- tester pour voir si on récupère bien l'image du panneau ----------- */
//        JFrame frame = new JFrame();
//        frame.getContentPane().setLayout(new FlowLayout());
//        frame.setSize(500, 500);
//        frame.getContentPane().add(new JLabel(new ImageIcon(image_panel)));
//        frame.setVisible(true);
        /* --------------------------------- fin du test --------------------------------- */

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image_panel, "jpg", baos);
            byte[] imageInByte = baos.toByteArray();

            PreparedStatement pstmt = c.insert("pacs", "IDDMR,idExam,Fichier");

            // On incrémente le dernier idExamen stocké dans la BD pour l'afficher dans l'UI
//            query = "SELECT NumArchivage FROM pacs ORDER BY NumArchivage DESC LIMIT 1";
//            ResultSet rs = c.select(query);
//            while (rs.next()) {
//            int max = rs.getInt(1);
//            max++;
//            }
            ResultSet rs = c.select("SELECT IDDMR FROM examen WHERE idExamen = '" + examen.getidExamen() + "'");
            while (rs.next()) {
                pstmt.setString(1, rs.getString(1));
                pstmt.setString(2, examen.getidExamen());
                pstmt.setBytes(3, imageInByte);
                pstmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "L'image a bien été ajoutée à la base de données.", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            Logger.getLogger(InterfaceTraitementImageExam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InterfaceTraitementImageExam.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_Bouton_enregistrerDansPacsActionPerformed

    private void Bouton_EnregistrerImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_EnregistrerImageActionPerformed
        // TODO add your handling code here:
        JFileChooser fileEnregistrerImage = new JFileChooser();
        fileEnregistrerImage.setCurrentDirectory(new File(System.getProperty("user.home")));
        if (fileEnregistrerImage.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fichierEnregistrement = new File(fileEnregistrerImage.getSelectedFile().getAbsolutePath() + ".jpg");
            try {
                panel_traitement.enregistrerImage(fichierEnregistrement);
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_Bouton_EnregistrerImageActionPerformed

    private void jButton_chargerImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_chargerImageActionPerformed
        RecupererCheminImage r = new RecupererCheminImage();
        path = r.getPath();
        panel_traitement.afficherImageChargee(new File(path));

        panel_traitement.setPreferredSize(jPanel2.getSize());
        //jPanel2.setLayout(new FlowLayout());
        jPanel2.setLayout(new BorderLayout());

        jPanel2.add(panel_traitement);

        this.revalidate();
    }//GEN-LAST:event_jButton_chargerImageActionPerformed

    private void Bouton_reinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_reinitialiserActionPerformed
        // TODO add your handling code here:
        panel_traitement.afficherImageChargee(new File(path));
        panel_traitement.setPreferredSize(jPanel2.getSize());
        jPanel2.setLayout(new FlowLayout());
        jPanel2.add(panel_traitement);
        //this.revalidate();
    }//GEN-LAST:event_Bouton_reinitialiserActionPerformed

    private void Bouton_AssombrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_AssombrirActionPerformed
        // TODO add your handling code here:
        panel_traitement.imageSombre();
    }//GEN-LAST:event_Bouton_AssombrirActionPerformed

    private void Bouton_EclaircirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_EclaircirActionPerformed

        panel_traitement.imageEclaircie();
    }//GEN-LAST:event_Bouton_EclaircirActionPerformed

    private void Bouton_SymetrieHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_SymetrieHActionPerformed
        // TODO add your handling code here:
        panel_traitement.symetrieHorizontale();
    }//GEN-LAST:event_Bouton_SymetrieHActionPerformed

    private void Bouton_SymetrieVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_SymetrieVActionPerformed
        panel_traitement.symetrieVerticale();
    }//GEN-LAST:event_Bouton_SymetrieVActionPerformed

    private void Bouton_RotationGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_RotationGActionPerformed
        panel_traitement.rotationGauche();
    }//GEN-LAST:event_Bouton_RotationGActionPerformed

    private void Bouton_InverserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_InverserActionPerformed
        // TODO add your handling code here:
        panel_traitement.inversionNiveauGris();
    }//GEN-LAST:event_Bouton_InverserActionPerformed

    private void Bouton_RotationDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bouton_RotationDActionPerformed
        panel_traitement.rotationDroite();
    }//GEN-LAST:event_Bouton_RotationDActionPerformed

//    public void RotateImage(int angle){
//        rotate_angle=angle*3.6;
//        repaint();
//        
//    }
//    
//    public void paint(Graphics g) {
//        super.paint(g);
//        try {
//            buff_image=ImageIO.read(new File(selectedFile.getAbsolutePath()));
//        } catch (IOException ex) {
//            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(buff_image!=null){
//            Graphics2D g2D = (Graphics2D)g;
//            g2D.translate(this.getSize().width/2, this.getSize().height/2);
//            g2D.rotate(Math.toRadians(rotate_angle));
//            g2D.drawImage( buff_image, -buff_image.getWidth()/2, -buff_image.getHeight()/2, null);
//        } 
//        
//        
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceTraitementImageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceTraitementImageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceTraitementImageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceTraitementImageExam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceTraitementImageExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bouton_Assombrir;
    private javax.swing.JButton Bouton_Eclaircir;
    private javax.swing.JButton Bouton_EnregistrerImage;
    private javax.swing.JButton Bouton_Inverser;
    private javax.swing.JButton Bouton_RotationD;
    private javax.swing.JButton Bouton_RotationG;
    private javax.swing.JButton Bouton_SymetrieH;
    private javax.swing.JButton Bouton_SymetrieV;
    private javax.swing.JButton Bouton_enregistrerDansPacs;
    private javax.swing.JButton Bouton_reinitialiser;
    private javax.swing.JButton jButton_chargerImage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables

}
