package UI;

import FC.Cryptage;
import FC.DbConnection;
import FC.MDP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author loicdancelme
 */
public class Initialiser_MDP extends javax.swing.JFrame {

    public Initialiser_MDP() {
        initComponents();
        PanelDroit.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelGauche = new javax.swing.JPanel();
        Defaut_MDP = new javax.swing.JTextField();
        ID_Defaut = new javax.swing.JTextField();
        ChangeMDP = new javax.swing.JButton();
        PanelDroit = new javax.swing.JPanel();
        NewMDP_Txt = new javax.swing.JTextField();
        RepeatMDP = new javax.swing.JTextField();
        NewMDP_Bt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(236, 187, 32));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("INITIALISER VOTRE MOT DE PASSE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelGauche.setBackground(new java.awt.Color(255, 255, 255));
        PanelGauche.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2));

        Defaut_MDP.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        Defaut_MDP.setText("Votre Mot de Passe provisoire");
        Defaut_MDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Defaut_MDPMouseClicked(evt);
            }
        });
        Defaut_MDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Defaut_MDPActionPerformed(evt);
            }
        });

        ID_Defaut.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        ID_Defaut.setText("Votre Identifiant par défaut");
        ID_Defaut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ID_DefautMouseClicked(evt);
            }
        });
        ID_Defaut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_DefautActionPerformed(evt);
            }
        });

        ChangeMDP.setText("Changer de Mot de Passe");
        ChangeMDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangeMDPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGaucheLayout = new javax.swing.GroupLayout(PanelGauche);
        PanelGauche.setLayout(PanelGaucheLayout);
        PanelGaucheLayout.setHorizontalGroup(
            PanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGaucheLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Defaut_MDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_Defaut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChangeMDP))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        PanelGaucheLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ChangeMDP, Defaut_MDP, ID_Defaut});

        PanelGaucheLayout.setVerticalGroup(
            PanelGaucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGaucheLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Defaut_MDP)
                .addGap(18, 18, 18)
                .addComponent(ID_Defaut)
                .addGap(18, 18, 18)
                .addComponent(ChangeMDP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        PanelDroit.setBackground(new java.awt.Color(255, 255, 255));
        PanelDroit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 187, 32), 2));

        NewMDP_Txt.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        NewMDP_Txt.setText("Votre Nouveau Mot de Passe");
        NewMDP_Txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewMDP_TxtMouseClicked(evt);
            }
        });
        NewMDP_Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMDP_TxtActionPerformed(evt);
            }
        });

        RepeatMDP.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        RepeatMDP.setText("Répètez votre Mot de Passe");
        RepeatMDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RepeatMDPMouseClicked(evt);
            }
        });

        NewMDP_Bt.setText("Nouveau Mot de Passe");
        NewMDP_Bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMDP_BtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDroitLayout = new javax.swing.GroupLayout(PanelDroit);
        PanelDroit.setLayout(PanelDroitLayout);
        PanelDroitLayout.setHorizontalGroup(
            PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDroitLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewMDP_Bt)
                    .addComponent(RepeatMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewMDP_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        PanelDroitLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {NewMDP_Bt, NewMDP_Txt, RepeatMDP});

        PanelDroitLayout.setVerticalGroup(
            PanelDroitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDroitLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(NewMDP_Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RepeatMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewMDP_Bt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(PanelGauche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelDroit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelGauche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelDroit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void Defaut_MDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Defaut_MDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Defaut_MDPActionPerformed

    private void ID_DefautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_DefautActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_DefautActionPerformed

    private void Defaut_MDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Defaut_MDPMouseClicked
        Defaut_MDP.setText("");
    }//GEN-LAST:event_Defaut_MDPMouseClicked

    private void ID_DefautMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ID_DefautMouseClicked
        ID_Defaut.setText("");
    }//GEN-LAST:event_ID_DefautMouseClicked

    private void NewMDP_TxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMDP_TxtMouseClicked
        NewMDP_Txt.setText("");
    }//GEN-LAST:event_NewMDP_TxtMouseClicked

    private void RepeatMDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RepeatMDPMouseClicked
        RepeatMDP.setText("");
    }//GEN-LAST:event_RepeatMDPMouseClicked

    private void ChangeMDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangeMDPActionPerformed
        try {
            // On va chercher le Token par défaut correspondant au MDP Defaut dans la BD
            DbConnection c = new DbConnection();
            c.connexionB();
            ResultSet rs = c.select("SELECT Identifiant, Token_Defaut FROM InitMDP WHERE (Identifiant = '" + ID_Defaut.getText() + "')");
            while (rs.next()) {
                String tk = rs.getString("Token_Defaut");
                // On vérifie que ce soit le bon MDP
                Cryptage cr = new Cryptage();
                boolean b = cr.authenticate(Defaut_MDP.getText().toCharArray(), tk);
                if (b) {
                    // Changement de Panel
                    PanelDroit.setVisible(true);
                    PanelGauche.setVisible(false);
                }
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Initialiser_MDP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ChangeMDPActionPerformed

    private void NewMDP_BtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMDP_BtActionPerformed
        
    if (NewMDP_Txt.getText().equals(RepeatMDP.getText()) && MDP.MdpValide(NewMDP_Txt.getText())) {
            try {
                DbConnection c = new DbConnection();
                c.connexionB();
                
                // On créer un token crypté pour le nouveau MDP
                Cryptage cr = new Cryptage();
                char[] mdp = RepeatMDP.getText().toCharArray();
                String tk = cr.hash(mdp);
                System.out.println(tk);
                
                // On insère le nouveau token dans la BD pour le personnel choisi
                c.update("UPDATE personnel SET Token = '" + tk + "' WHERE Identifiant = '" + ID_Defaut.getText() + "'");
               
                // On confirme que le MDP a été initialisé et on revient vers la page Connexion
                Initialiser_MDP.this.dispose();       
                JOptionPane.showMessageDialog(this, "Votre Mot de Passe a été modifié");
            
            } catch (SQLException ex) {
                Logger.getLogger(Initialiser_MDP.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Les Mot de Passe ne sont pas les mêmes");
        }


    }//GEN-LAST:event_NewMDP_BtActionPerformed

    private void NewMDP_TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMDP_TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewMDP_TxtActionPerformed

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
            java.util.logging.Logger.getLogger(Initialiser_MDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Initialiser_MDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Initialiser_MDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Initialiser_MDP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Initialiser_MDP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChangeMDP;
    private javax.swing.JTextField Defaut_MDP;
    private javax.swing.JTextField ID_Defaut;
    private javax.swing.JButton NewMDP_Bt;
    private javax.swing.JTextField NewMDP_Txt;
    private javax.swing.JPanel PanelDroit;
    private javax.swing.JPanel PanelGauche;
    private javax.swing.JTextField RepeatMDP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
