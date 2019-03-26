
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import FC.DbConnection;
import FC.Examen;
import FC.Patient;
import FC.Personnel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Imane
 */
public class Medecin_AfficherUNExamenAPartirDuDMR extends javax.swing.JFrame {

    private static Examen examen;
    private Patient patient;
    private Personnel pers;

    /**
     * Creates new form AccueilSecretaire2
     */
    public Medecin_AfficherUNExamenAPartirDuDMR() throws SQLException {

        initComponents();
        
        /*  On récupère les données de la personne connectée pour initialiser le label indiquant qui est connecté */
        pers = UI.Connexion.getP();
        jLabel2.setText(pers.getPrenom() + " " + pers.getNom());

        /* On récupère l'instance de Examen créée dans UI.Medecin_AfficherDMR */
        examen = UI.Medecin_AfficherDMR.getExamen();

        /* On récupère l'instance de Patient créée dans UI.Medecin_RechercherPatient */
        patient = UI.Medecin_RechercherPatient.getPatient();
        
        

        /* Nécessité de faire une requête pour récupérer les informaions relatives à un examen */
        DbConnection c = new DbConnection();
        c.connexionB();
        String query = "SELECT IPP, pat.Prenom, pat.Nom, DateNaissance, Sexe, Adresse, CodePostal, idExamen, Ville, pers.Nom, pers.Prenom, TypeExamen, DateExamen, DMRPapier, CompteRendu FROM `examen` e,`patients` pat,`personnel` pers WHERE (idExamen = '" + examen.getidExamen() + "') AND (pat.IDDMR = e.IDDMR) AND (pers.IDPERS=e.IDPERS)";
        ResultSet rs = c.select(query);
        while (rs.next()) {
            label_idExam.setText(String.valueOf(examen.getidExamen()));
            label_nomMedecin.setText(rs.getString("pers.Nom"));
            label_prenomMedecin.setText(rs.getString("pers.Prenom"));
            label_typeExam.setText(rs.getString("TypeExamen"));
            label_sexe.setText(rs.getString("Sexe"));
            label_dateExam.setText(rs.getString("DateExamen"));
            cr.setText(rs.getString("CompteRendu"));
        }
        c.close();

        //Initialisation des labels concernant le patient en fonction des données du patient
        label_adresse.setText(patient.getAdresse() + "    " + patient.getCodePostal() + "    " + patient.getVille());
        label_datenaissance.setText(patient.getDateDeNaissance().toString());
        label_ipp.setText(String.valueOf(patient.getIPP()));
        label_nomPatient.setText(patient.getNom());
        label_prenomPatient.setText(patient.getPrenom());
        label_sexe.setText(patient.getSexe().toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_nomPatient = new javax.swing.JLabel();
        label_prenomPatient = new javax.swing.JLabel();
        label_datenaissance = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        label_sexe = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label_ipp = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        label_adresse = new javax.swing.JLabel();
        btn_voirImages = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        label_dateExam = new javax.swing.JLabel();
        label_typeExam = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        label_prenomMedecin = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        label_nomMedecin = new javax.swing.JLabel();
        label_idExam = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cr = new javax.swing.JTextArea();
        btn_EditCR = new javax.swing.JButton();
        bouton_impressionCR = new javax.swing.JButton();
        btn_ajouterImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(236, 187, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AFFICHER UN EXAMEN");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(539, 539, 539)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2), "Informations du patient", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel4.setText("Nom du patient : ");

        jLabel5.setText("Prénom du patient :");

        jLabel7.setText("Date de naissance :");

        label_nomPatient.setText("jLabel8");

        label_prenomPatient.setText("jLabel9");

        label_datenaissance.setText("jLabel10");

        jLabel11.setText("Sexe :");

        label_sexe.setText("jLabel12");

        jLabel6.setText("idPatient : ");

        label_ipp.setText("jLabel15");

        jLabel18.setText("Adresse :");

        label_adresse.setText("jLabel19");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(label_datenaissance)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(label_nomPatient))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(label_prenomPatient)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label_adresse)
                                .addGap(567, 567, 567))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(label_sexe)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_ipp)
                                .addGap(224, 224, 224))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(label_ipp))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(label_nomPatient)
                        .addComponent(jLabel11)
                        .addComponent(label_sexe)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(label_prenomPatient)
                    .addComponent(jLabel18)
                    .addComponent(label_adresse))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_datenaissance))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_voirImages.setText("Voir les images de l'examen");
        btn_voirImages.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 3));
        btn_voirImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voirImagesActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 21), 2), "Informations de l'examen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel13.setText("Type d'examen : ");

        jLabel14.setText("Date : ");

        label_dateExam.setText("jLabel17");

        label_typeExam.setText("jLabel20");

        jLabel22.setText("Prénom du praticien en charge :");

        jLabel23.setText("idExamen :");

        label_prenomMedecin.setText("jLabel24");

        jLabel25.setText("Nom du praticien en charge :");

        label_nomMedecin.setText("jLabel26");

        label_idExam.setText("jLabel27");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(label_dateExam))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(label_typeExam)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nomMedecin)
                    .addComponent(label_prenomMedecin))
                .addGap(204, 204, 204)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(label_idExam)
                .addGap(217, 217, 217))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(label_typeExam)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(label_prenomMedecin)
                    .addComponent(label_idExam))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(label_dateExam)
                    .addComponent(jLabel25)
                    .addComponent(label_nomMedecin))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2), "Compte-rendu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        cr.setColumns(20);
        cr.setRows(5);
        jScrollPane1.setViewportView(cr);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btn_EditCR.setText("Editer le compte rendu");
        btn_EditCR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 3));
        btn_EditCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditCRActionPerformed(evt);
            }
        });

        bouton_impressionCR.setText("Imprimer le compte-rendu");
        bouton_impressionCR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2));
        bouton_impressionCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton_impressionCRActionPerformed(evt);
            }
        });

        btn_ajouterImage.setText("Ajouter une image");
        btn_ajouterImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 3));
        btn_ajouterImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajouterImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_voirImages, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn_ajouterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_EditCR, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bouton_impressionCR, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bouton_impressionCR, btn_EditCR, btn_ajouterImage, btn_voirImages});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bouton_impressionCR, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_voirImages, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_ajouterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_EditCR, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Connecté(e) en tant que :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EditCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditCRActionPerformed
        UI.Medecin_AjouterCR acr = new UI.Medecin_AjouterCR();
        acr.setVisible(true);
    }//GEN-LAST:event_btn_EditCRActionPerformed

    private void btn_voirImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voirImagesActionPerformed
        String idExam = String.valueOf(examen.getidExamen());

        DbConnection c = new DbConnection();
        c.connexionB();
        String requete = "SELECT * FROM pacs WHERE idExam = '" + idExam + "'";
        ResultSet rs = c.select(requete);

        try {
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Cet examen ne contient pas d'images.", "Aucun résultat", JOptionPane.INFORMATION_MESSAGE);

            } else {
                rs.beforeFirst(); //On remet le curseur sur la ligne avant la première ligne des résultats
                while (rs.next()) {
                    byte[] img = rs.getBytes("Fichier");
                    ImageIcon image = new ImageIcon(img);
//            liste_images.add(image);
                    UI.Medecin_AfficherImagesExam aie = new UI.Medecin_AfficherImagesExam();
                    aie.label.setIcon(image);
                    aie.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Medecin_AfficherUNExamenAPartirDuDMR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_voirImagesActionPerformed
    
    
    /**
     * Ouvre une fenêtre ApercuAvantImpression pour imprimer le contenu de 
     * l'examen (CR, informations patient)
     * @param evt 
     */
    private void bouton_impressionCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_impressionCRActionPerformed
        // Mise en page du compte-rendu à imprimer
        
        String s = ("Nom du patient : " + patient.getNom() + "\n" + "Prenom du patient: " + patient.getPrenom() + "\n" + "Nom du médecin: " + this.label_nomMedecin.getText() + "\n" + "Date de l'examen : " + this.label_dateExam.getText() + "\n" + "COMPTE RENDU : " + "\n" + this.cr.getText());

        UI.ApercuAvantImpression a = new UI.ApercuAvantImpression(s);
        a.jTextArea1.setText(s);
        a.setVisible(true);

    }//GEN-LAST:event_bouton_impressionCRActionPerformed
    
    /**
     * Ouvre une fenêtre InterfaceTraitementImage pour ajouter une 
     * image à la BD
     * @param evt 
     */
    private void btn_ajouterImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajouterImageActionPerformed
       InterfaceTraitementImage iTi = new InterfaceTraitementImage();
       iTi.setVisible(true);
    }//GEN-LAST:event_btn_ajouterImageActionPerformed

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
            java.util.logging.Logger.getLogger(Medecin_AfficherUNExamenAPartirDuDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Medecin_AfficherUNExamenAPartirDuDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Medecin_AfficherUNExamenAPartirDuDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Medecin_AfficherUNExamenAPartirDuDMR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Medecin_AfficherUNExamenAPartirDuDMR().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Medecin_AfficherUNExamenAPartirDuDMR.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouton_impressionCR;
    private javax.swing.JButton btn_EditCR;
    private javax.swing.JButton btn_ajouterImage;
    private javax.swing.JButton btn_voirImages;
    public javax.swing.JTextArea cr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel label_adresse;
    public javax.swing.JLabel label_dateExam;
    public javax.swing.JLabel label_datenaissance;
    public javax.swing.JLabel label_idExam;
    public javax.swing.JLabel label_ipp;
    public javax.swing.JLabel label_nomMedecin;
    public javax.swing.JLabel label_nomPatient;
    public javax.swing.JLabel label_prenomMedecin;
    public javax.swing.JLabel label_prenomPatient;
    public javax.swing.JLabel label_sexe;
    public javax.swing.JLabel label_typeExam;
    // End of variables declaration//GEN-END:variables

    /**
     * @return Examen intialisé à partir de cette classe 
     */
    public static Examen getExamen() {
        return examen;
    }
    
   
}
