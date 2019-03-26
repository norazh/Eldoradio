/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import FC.DbConnection;
import FC.Patient;
import FC.Examen;
import FC.Medecin;
import FC.Personnel;
import FC.Salle;
import FC.TypeExamen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Imane
 */
public class Manipulateur_AjouterExamen extends javax.swing.JFrame {

    private Personnel pers;
    private static Patient pat;
    TypeExamen te;
    Salle sl;
    Medecin m;
    private Examen exam = new Examen();

    public Manipulateur_AjouterExamen() throws SQLException {
        initComponents();
        pat = UI.Manipulateur_RechercherPatient.getPatient();
        pers = UI.Connexion.getP();

        // Nom du Medecin connecté
        jLabel2.setText(pers.getPrenom() + " " + pers.getNom());

        // Initialisation des informations à partir du patient
        label_prenomPat.setText(pat.getPrenom());
        label_nomPat.setText(pat.getNom());
        label_dN.setText(pat.getDateDeNaissance().toString());
        label_Sx.setText(pat.getSexe().toString());
        label_adress.setText(pat.getAdresse());
        label_idDMR.setText(String.valueOf(pat.getidDMR()));
        label_IPP.setText(String.valueOf(pat.getIPP()));

        // Initialisation date exam à la date courante 
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        label_DateExam.setText(dateFormat.format(d));

        // Initialisation du numéro idExamen = dernier idExamen + 1
        DbConnection c = new DbConnection();
        c.connexionB();

        // On incrémente le dernier idExamen stocké dans la BD pour l'afficher dans l'UI
        String query = "SELECT idExamen FROM examen ORDER BY idExamen DESC LIMIT 1";
        ResultSet rs = c.select(query);
        while (rs.next()) {
            int idExam = rs.getInt(1);
            idExam++;
            label_idExam.setText(String.valueOf(idExam));
        }
        c.close();
    }

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
        label_nomPat = new javax.swing.JLabel();
        label_prenomPat = new javax.swing.JLabel();
        label_dN = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        label_Sx = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        label_adress = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        label_idDMR = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        label_IPP = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        label_DateExam = new javax.swing.JLabel();
        label_PrenomPers = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        labelNomPers = new javax.swing.JLabel();
        label_idExam = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtF_Prenom = new javax.swing.JTextField();
        txtF_Nom = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        DMRPapier = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Accueil : Secrétaire médicale");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(236, 187, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AJOUTER UN EXAMEN");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(480, 480, 480))
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

        label_nomPat.setText("label_nomPat");

        label_prenomPat.setText("label_prenomPat");

        label_dN.setText("label_dN");

        jLabel11.setText("Sexe :");

        label_Sx.setText("label_Sx");

        jLabel13.setText("Adresse : ");

        label_adress.setText("label_adress");

        jLabel6.setText("idDMR : ");

        label_idDMR.setText("label_idDMR");

        jLabel24.setText("IPP :");

        label_IPP.setText("label_IPP");

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
                        .addComponent(label_dN)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_nomPat))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(label_prenomPat)))
                        .addGap(250, 250, 250)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_Sx))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(label_adress)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_idDMR)
                            .addComponent(label_IPP))
                        .addGap(62, 62, 62))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_nomPat)
                    .addComponent(jLabel11)
                    .addComponent(label_Sx)
                    .addComponent(jLabel6)
                    .addComponent(label_idDMR))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(label_prenomPat)
                    .addComponent(jLabel13)
                    .addComponent(label_adress)
                    .addComponent(jLabel24)
                    .addComponent(label_IPP))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_dN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("Ajouter l'examen");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 21), 2), "Informations de l'examen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel16.setText("Type d'examen : ");

        jLabel17.setText("Date : ");

        label_DateExam.setText("jLabel17");

        label_PrenomPers.setText("Prénom du praticien en charge :");

        jLabel23.setText("idExamen :");

        labelNomPers.setText("Nom du praticien en charge :");

        label_idExam.setText("jLabel27");

        jComboBox1.setModel(new DefaultComboBoxModel(TypeExamen.values()));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txtF_Prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF_PrenomActionPerformed(evt);
            }
        });

        jLabel20.setText("Salle :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(Salle.values()));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        DMRPapier.setText("DMR Papier");
        DMRPapier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DMRPapierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_DateExam))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(160, 160, 160)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(labelNomPers)
                    .addComponent(label_PrenomPers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtF_Prenom, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtF_Nom))
                        .addGap(180, 180, 180)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(label_idExam))
                            .addComponent(DMRPapier)))
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(label_PrenomPers)
                    .addComponent(jLabel23)
                    .addComponent(label_idExam)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtF_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNomPers)
                            .addComponent(txtF_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DMRPapier)
                            .addComponent(jLabel17)
                            .addComponent(label_DateExam))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
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

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String s = jComboBox1.getSelectedItem().toString();
        switch (s) {
            case "RADIOLOGIE":
                exam.setTypeExamen(te.RADIOLOGIE);
                break;
            case "IRM":
                exam.setTypeExamen(te.IRM);
                break;
            case "SCANNER":
                exam.setTypeExamen(te.SCANNER);
                break;
            case "ECHOGRAPHIE":
                exam.setTypeExamen(te.ECHOGRAPHIE);
                break;
            case "ANGIOGRAPHIE":
                exam.setTypeExamen(te.ANGIOGRAPHIE);
                break;
            case "ECHOENDOGRAPHIE":
                exam.setTypeExamen(te.ECHOENDOGRAPHIE);
                break;
            case "MAMMOGRAPHIE":
                exam.setTypeExamen(te.MAMMOGRAPHIE);
                break;
            case "RADIOTHERAPIE":
                exam.setTypeExamen(te.RADIOTHERAPIE);
                break;
            case "PET":
                exam.setTypeExamen(te.PET);
                break;
            default:
                throw new AssertionError();
                }    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void DMRPapierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DMRPapierActionPerformed
        if (DMRPapier.isSelected()) {
            exam.setDMRpapier(true);
        } else {
            exam.setDMRpapier(false);
        }
    }//GEN-LAST:event_DMRPapierActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            DbConnection c = new DbConnection();
            c.connexionB();
            // Définiton du PreparedStatement
            //PreparedStatement pstmt = c.insert("examen", "TypeExamen,DMRPapier,Salle,CompteRendu,IDPERS,IDDMR");
                        PreparedStatement pstmt = c.insert("examen", "TypeExamen,DMRPapier,Salle,IDPERS,IDDMR");

            // Initialisation des valeurs de chaque champs spécifié dans le PreparedStatement (6 champs)
            // --------------------------------------------------------------------------------------------------------------------------------------------------
            pstmt.setString(1, exam.getTypeExamen().toString());                        // 1 : TypeExamen

            if (exam.getDMRPapier()) {                                                  // |
                pstmt.setString(2, "Oui");                                              // |
            } else {                                                                    // | 2 : Colonne DMRPapier rempli en fonction de l'état de la Checkbox
                pstmt.setString(2, "Non");                                              // |       
            }                                                                           // |

            pstmt.setString(3, exam.getSalle().toString());                             // 3 : Salle
            //pstmt.setString(4, jTextArea1.getText());                                   // 4 : CompteRendu   

            ResultSet rs = c.select("SELECT IDPERS FROM personnel WHERE Prenom = '" + txtF_Prenom.getText() + "' AND Nom = '" + txtF_Nom.getText() + "'");
            while (rs.next()) {                                                         // Choix du personnel en charge de l'examen
                if (rs.isFirst()) {                                                     // |
                    m = new Medecin(txtF_Nom.getText(), txtF_Prenom.getText());         // |
                    exam.setMedecin(m);                                                 // |
                    exam.getMedecin().setIdpers(String.valueOf(rs.getInt(1)));          // |
                    System.out.println(exam.getMedecin().getIdpers());                  // |
                    pstmt.setInt(4, Integer.parseInt(exam.getMedecin().getIdpers()));   // | 5 : IDPERS                          
                } else {                                                                // |   
                    JOptionPane.showMessageDialog(this, "Nom et Prenom du " // |
                            + "praticien en charge " // |
                            + "introuvable\nVeuillez recommencer");                     // |
                }                                                                       // |
            }                                                                           // |

            pstmt.setInt(5, pat.getidDMR());                                            // 6 : IDDMR
            // --------------------------------------------------------------------------------------------------------------------------------------------------
            int count = pstmt.executeUpdate(); // Execution de la requête "insérer l'examen" dans la table examen de la BD
            c.close(); // Fermeture de la BD
            // Affiche une fenêtre d'option pour savoir si l'examen a été ajouté ou non
            if (count > 0) {
                JOptionPane.showMessageDialog(this, "Examen ajouté à la base de données");
                this.dispose();                                                             // fermeture de la fenêtre
            } else {
                JOptionPane.showMessageDialog(this, "Examen non ajouté à la base de données");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_AjouterExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String s = jComboBox2.getSelectedItem().toString();
        switch (s) {
            case "S1":
                exam.setSalle(sl.S1);
                break;
            case "S2":
                exam.setSalle(sl.S2);
                break;
            case "S3":
                exam.setSalle(sl.S3);
                break;
            case "S4":
                exam.setSalle(sl.S4);
                break;
            case "S5":
                exam.setSalle(sl.S5);
                break;
            case "S6":
                exam.setSalle(sl.S6);
                break;
            case "S7":
                exam.setSalle(sl.S7);
                break;
            case "S8":
                exam.setSalle(sl.S8);
                break;
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void txtF_PrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF_PrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF_PrenomActionPerformed

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
            java.util.logging.Logger.getLogger(Manipulateur_AjouterExamen.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_AjouterExamen.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_AjouterExamen.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_AjouterExamen.class

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//             DMRPapierecin_AjouterExamen().setVisible(true);
//            }
//        });
//    }
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
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//             DMRPapierecin_AjouterExamen().setVisible(true);
//            }
//        });
//    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox DMRPapier;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JLabel labelNomPers;
    private javax.swing.JLabel label_DateExam;
    private javax.swing.JLabel label_IPP;
    private javax.swing.JLabel label_PrenomPers;
    private javax.swing.JLabel label_Sx;
    private javax.swing.JLabel label_adress;
    private javax.swing.JLabel label_dN;
    private javax.swing.JLabel label_idDMR;
    private javax.swing.JLabel label_idExam;
    private javax.swing.JLabel label_nomPat;
    private javax.swing.JLabel label_prenomPat;
    private javax.swing.JTextField txtF_Nom;
    private javax.swing.JTextField txtF_Prenom;
    // End of variables declaration//GEN-END:variables
}
