/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import FC.DbConnection;
import FC.Sexe;
import FC.Patient;
import FC.Personnel;
import FC.TypeExamen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Imane
 */
public class Manipulateur_RechercherPatient extends javax.swing.JFrame {
    
    /* Déclaration des variables de classe */ 
    String IDPatient = "";
    Personnel p;
    static Patient pat = new Patient();
    RemplissageTableau rt = new RemplissageTableau();
    String qTabInit = "SELECT IPP, IDDMR, Prenom, Nom, Sexe, DateNaissance FROM patients";
    
   
    
    
    
    public Manipulateur_RechercherPatient() throws SQLException, ParseException {
        
        initComponents();
        
        this.p = UI.Manipulateur_Accueil.getPersonnel(); // Attributs de Personnel p récupérés depuis UI.Medecin_Accueil 
        jLabel2.setText(p.getPrenom() + " " + p.getNom());
        
        /* Initialisation du tableau depuis la BD à l'ouverture de  la fenêtre */
        rt.TabInit(qTabInit, tablepatients);                      
        

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
        tablepatients = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        field_nompatient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        field_prenompatient = new javax.swing.JTextField();
        OK_nompatient = new javax.swing.JButton();
        OK_prenompatient = new javax.swing.JButton();
        bt_ReinitTable = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rechercher un patient");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jPanel2.setBackground(new java.awt.Color(236, 187, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RECHERCHER UN PATIENT");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(jLabel3)
                .addContainerGap(462, Short.MAX_VALUE))
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

        tablepatients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "idPatient", "idDMR", "Prénom du patient", "Nom du patient", "Sexe", "Date de naissance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablepatients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablepatientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablepatients);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Critères de recherche"));

        jLabel4.setText("Nom du patient : ");

        jLabel5.setText("Prénom du patient :");

        OK_nompatient.setText("OK");
        OK_nompatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_nompatientActionPerformed(evt);
            }
        });

        OK_prenompatient.setText("OK");
        OK_prenompatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OK_prenompatientActionPerformed(evt);
            }
        });

        bt_ReinitTable.setText("Réinitialiser ");
        bt_ReinitTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ReinitTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(field_nompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OK_nompatient))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(field_prenompatient, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OK_prenompatient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_ReinitTable)
                .addGap(66, 66, 66))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(field_nompatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OK_nompatient))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(field_prenompatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OK_prenompatient)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(bt_ReinitTable, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Connecté(e) en tant que :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

    
    
    private void OK_nompatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_nompatientActionPerformed
        
        try {
            String qNomPatient = "SELECT IPP, IDDMR, Prenom, Nom, Sexe, DateNaissance FROM patients WHERE Nom ='" 
                    + field_nompatient.getText() + "'";
            rt.setTable(qNomPatient, tablepatients);
        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_OK_nompatientActionPerformed

    private void OK_prenompatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OK_prenompatientActionPerformed
        
        try {
            String qPrenomPatient = "SELECT IPP, IDDMR, Prenom, Nom, Sexe, DateNaissance FROM patients WHERE Prenom ='" 
                    + field_prenompatient.getText() + "'";
            rt.setTable(qPrenomPatient, tablepatients);
        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_OK_prenompatientActionPerformed

    private void tablepatientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablepatientsMouseClicked
        
        /* On récupère l'ID du patient, correspondant à la première valeur de la ligne sélectionnée dans le tableau */
        IDPatient = getIDPatient();
        
        
        /* -------------------  Initialisation du patient avec les données extraites de la BD -------------------- */ 
        try {
            DbConnection c = new DbConnection();
            c.connexionB();
             String qPatient = "SELECT IPP , pat.Prenom, pat.Nom, DateNaissance, Sexe, Adresse, CodePostal, Ville, pat.IDDMR,"
                     + " DMRPapier FROM `examen` e,`patients` pat WHERE (IPP = '" + IDPatient + "') AND (pat.IDDMR = e.IDDMR)";
            ResultSet rs = c.select(qPatient);
            while (rs.next()) {
                
                pat.setIPP(Integer.parseInt(rs.getString("IPP")));
                pat.setidDMR(Integer.parseInt(rs.getString("IDDMR")));
                pat.setNom(rs.getString("pat.Nom"));
                pat.setPrenom(rs.getString("pat.Prenom"));
                pat.setAdresse(rs.getString("Adresse"));
                pat.setVille(rs.getString("Ville"));
                pat.setCodePostal(rs.getString("CodePostal"));
                pat.setDateNaissance(rs.getDate("DateNaissance"));
                pat.setSexe(Sexe.valueOf(rs.getString("Sexe")));
            }
        /* -------------------------------------------------------------------------------------------------------  */    

            //On affiche la nouvelle fenêtre destinée à afficher le DMR du patient sélectionné.
            UI.Manipulateur_AfficherDMR admr;
            admr = new UI.Manipulateur_AfficherDMR();
            admr.setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(Manipulateur_AfficherTOUSLESExamens.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tablepatientsMouseClicked

    private void bt_ReinitTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ReinitTableActionPerformed
        rt.TabInit(qTabInit, tablepatients);
    }//GEN-LAST:event_bt_ReinitTableActionPerformed

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
            java.util.logging.Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Manipulateur_RechercherPatient().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Manipulateur_RechercherPatient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OK_nompatient;
    private javax.swing.JButton OK_prenompatient;
    private javax.swing.JButton bt_ReinitTable;
    private javax.swing.JTextField field_nompatient;
    private javax.swing.JTextField field_prenompatient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablepatients;
    // End of variables declaration//GEN-END:variables

    public static Sexe stringToSexe(String s) {
        Sexe se = null;
        switch (s) {
            case "Homme":
                se = Sexe.Homme;
                break;
            case "Femme":
                se = Sexe.Femme;
                break;

            default:
                break;

        }
        return se;
    }

    public static TypeExamen stringToTypeExamen(String s) {
        TypeExamen tp = null;
        switch (s) {
            case "SCANNER":
                tp = TypeExamen.SCANNER;
                break;
            case "PET":
                tp = TypeExamen.PET;
                break;
            case "ANGIOGRAPHIE":
                tp = TypeExamen.ANGIOGRAPHIE;
                break;
            case "IRM":
                tp = TypeExamen.IRM;
                break;
            case "RADIOLOGIE":
                tp = TypeExamen.RADIOLOGIE;
                break;
            case "ECHOENDOGRAPHIE":
                tp = TypeExamen.ECHOENDOGRAPHIE;
                break;
            case "RADIOTHRAPIE":
                tp = TypeExamen.RADIOTHERAPIE;
                break;
            case "MAMMOGRAPHIE":
                tp = TypeExamen.MAMMOGRAPHIE;
                break;
            case "ECHOGRAPHIE":
                tp = TypeExamen.ECHOGRAPHIE;
                break;
            default:
                break;

        }
        return tp;
    }


    public String getIDPatient() {
        String idExamenSelectedRow = tablepatients.getValueAt(tablepatients.getSelectedRow(), 0).toString();
        return idExamenSelectedRow;
    }
    public static Patient getPatient() {
        return pat;
    }
}
