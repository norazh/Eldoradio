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
import FC.Sexe;
import FC.TypeExamen;
import static UI.Medecin_RechercherPatient.stringToSexe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Imane
 */
public class Manipulateur_AfficherTOUSLESExamens extends javax.swing.JFrame {

    /* Déclaration des variables de classe */
    public String idExam;
    private Personnel pers;
    private static Patient pat;
    private static Examen examen;

    RemplissageTableau rt = new RemplissageTableau();
    private String query = "";

    public Manipulateur_AfficherTOUSLESExamens() {

        initComponents();

        /* On récupère les données de la personne connectée pour initialiser le label indiquant qui est connecté */
        pers = UI.Connexion.getP();
        jLabel2.setText(pers.getPrenom() + " " + pers.getNom());

        /* On initialise le tableau d'examens */
        query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p1.IDPERS = e.IDPERS)";
        rt.TabInit(query, table);

    }

    /* Code généré automatiquement par la palette Swing NetBeans */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        NomPatient_jTF = new javax.swing.JTextField();
        Prenom_jTF = new javax.swing.JTextField();
        ComboBox = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        nomBt = new javax.swing.JButton();
        prenomBt = new javax.swing.JButton();
        Reinit_Bt = new javax.swing.JButton();
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
        jLabel3.setText("LISTE DE TOUS LES EXAMENS");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(457, 457, 457))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idExamen", "Type d'examen", "Date de l'examen", "Prénom du praticien", "Nom du praticien", "Prénom du patient", "Nom du patient", "DMR Papier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2), "Critères de recherche", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel4.setText("Nom du patient : ");

        jLabel5.setText("Prénom du patient :");

        jLabel11.setText("Type d'examen : ");

        ComboBox.setModel(new DefaultComboBoxModel(TypeExamen.values()));
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Sans compte-rendu");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        nomBt.setText("OK");
        nomBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomBtActionPerformed(evt);
            }
        });

        prenomBt.setText("OK");
        prenomBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomBtActionPerformed(evt);
            }
        });

        Reinit_Bt.setText("Réinitialiser");
        Reinit_Bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reinit_BtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Prenom_jTF)
                    .addComponent(NomPatient_jTF, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomBt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prenomBt, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(197, 197, 197)
                .addComponent(Reinit_Bt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Reinit_Bt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(NomPatient_jTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1)
                            .addComponent(nomBt))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Prenom_jTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prenomBt))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void nomBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomBtActionPerformed
        try {
            /* On sélectionne uniquement les examens dont le nom correspond au NomPatient_jTF */
            query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                    + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p2.Nom = '" + NomPatient_jTF.getText() + "') ";
            rt.setTable(query, table);
        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nomBtActionPerformed

    /**
     * Permet de sélectionner uniquement les examens dont le nom correspond au
     * Prénom_jTF
     *
     * @param evt
     */
    private void prenomBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomBtActionPerformed
        try {
            query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                    + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p2.Prenom = '" + Prenom_jTF.getText() + "') ";
            rt.setTable(query, table);
        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prenomBtActionPerformed

    /**
     * Permet de réinitaliser le tableau d'examens
     *
     * @param evt
     */
    private void Reinit_BtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reinit_BtActionPerformed
        query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p1.IDPERS = e.IDPERS)";
        rt.TabInit(query, table);
    }//GEN-LAST:event_Reinit_BtActionPerformed

    /**
     * Permet de sélectionner uniquement les examens sans Compte Rendu ou de
     * revenir au tableau de départ contenant tout les examen en cochant la
     * CheckBox "Sans compte-rendu"
     *
     * @param evt
     */
    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            /* CheckBox cochée : on sélectionne uniquement les examens avec un DMR */
            try {
                query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                        + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND ((LENGTH(e.CompteRendu) = 0) OR (LENGTH(e.CompteRendu) = NULL))";
                rt.setTable(query, table);
            } catch (SQLException ex) {
                Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            /* CheckBox décochée :  on réinitialise le tableau */
            query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                    + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p1.IDPERS = e.IDPERS)";
            rt.TabInit(query, table);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    /**
     * Permet de sélectionner uniquement les examens appartenant à un type
     * d'examen de type TypeExamen
     *
     * @param evt
     */
    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        Object obj = evt.getSource();
        if (obj == ComboBox) {

            try {
                ArrayList<String> queries = new ArrayList(TypeExamen.values().length);

                for (TypeExamen te : TypeExamen.values()) {
                    query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, "
                            + "patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p1.IDPERS = e.IDPERS) AND (TypeExamen = '" + te.name() + "')";
                    queries.add(query);
                }

                String s = ComboBox.getSelectedItem().toString();
                switch (s) {
                    case "RADIOLOGIE":
                        rt.setTable(queries.get(0), table);
                        break;
                    case "IRM":
                        rt.setTable(queries.get(1), table);
                        break;
                    case "SCANNER":
                        rt.setTable(queries.get(2), table);
                        break;
                    case "ECHOGRAPHIE":
                        rt.setTable(queries.get(3), table);
                        break;
                    case "ANGIOGRAPHIE":
                        rt.setTable(queries.get(4), table);
                        break;
                    case "ECHOENDOGRAPHIE":
                        rt.setTable(queries.get(5), table);
                        break;
                    case "MAMMOGRAPHIE":
                        rt.setTable(queries.get(6), table);
                        break;
                    case "RADIOTHERAPIE":
                        rt.setTable(queries.get(7), table);
                        break;
                    case "PET":
                        rt.setTable(queries.get(8), table);
                        break;
                }

            } catch (SQLException ex) {
                Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ComboBoxActionPerformed

    /**
     * Permet d'ouvrir un fenêtre affichant l'examen sélectionné en cliquant sur
     * une ligne du tableau d'examens
     *
     * @param evt
     */
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

        /* Initialisation de l'examen avec les données extraites de la BD */
        idExam = getIdExam();
        examen = new Examen(idExam);

        /* Ouverture d'une connexion avec la BD */
        DbConnection c = new DbConnection();
        c.connexionB();
        query = "SELECT IPP , pat.Prenom, pat.Nom, DateNaissance, Sexe, Adresse, CodePostal, Ville, pat.IDDMR, DMRPapier, "
                + "idExamen FROM `examen` e,`patients` pat WHERE (IDExamen = '" + idExam + "') AND (pat.IDDMR = e.IDDMR)";
        ResultSet rs = c.select(query);

        try {
            while (rs.next()) {

                /* Initialisation du patient avec les données extraites de la BD */
                
                pat = new Patient(Integer.parseInt(rs.getString("IPP")), Integer.parseInt(rs.getString("IDDMR")), rs.getString("pat.Nom"), rs.getString("pat.Prenom"), rs.getString("Adresse"),
                        rs.getString("Ville"), rs.getString("CodePostal"), rs.getDate("DateNaissance"), stringToSexe(rs.getString("Sexe")));
                
                
//                pat.setIPP(Integer.parseInt(rs.getString("IPP")));
//                pat.setidDMR(Integer.parseInt(rs.getString("IDDMR")));
//                pat.setNom(rs.getString("pat.Nom"));
//                pat.setPrenom(rs.getString("pat.Prenom"));
//                pat.setAdresse(rs.getString("Adresse"));
//                pat.setVille(rs.getString("Ville"));
//                pat.setCodePostal(rs.getString("CodePostal"));
//                pat.setDateNaissance(rs.getDate("DateNaissance"));
//                pat.setSexe(Sexe.valueOf(rs.getString("Sexe")));

                System.out.println(pat.getIPP() + pat.getidDMR() + pat.getAdresse() + pat.getCodePostal() + pat.getNom() + pat.getPrenom());

            }

            c.close(); // Fermeture de la connexion

            /* Ouverture d'une fenêtre Medecin_AfficherUNExamen */
            UI.Manipulateur_AfficherUNExamen a = new UI.Manipulateur_AfficherUNExamen();
            a.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Manipulateur_AfficherTOUSLESExamens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JTextField NomPatient_jTF;
    private javax.swing.JTextField Prenom_jTF;
    private javax.swing.JButton Reinit_Bt;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nomBt;
    private javax.swing.JButton prenomBt;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    /**
     * @return idExamen de l'examen sélectionné sur le tableau d'exmamens
     */
    public String getIdExam() {
        String idExamenSelectedRow = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
        return idExamenSelectedRow;
    }

    /**
     * @return Patient avec les attribut initialisés depuis cette classe
     * modificateur static
     */
    public static Patient getPatient() {
        return pat;
    }

    /**
     * @return Examen avec les attribut initialisés depuis cette classe
     * modificateur static
     */
    public static Examen getExamen() {
        return examen;

    }
}
