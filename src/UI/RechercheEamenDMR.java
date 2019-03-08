/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JOptionPane;
import FC.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
/**
 *
 * @author menar
 */
public class RechercheEamenDMR extends javax.swing.JPanel {

    /**
     * Creates new form RechercheEamenDMR
     */
    AccueilManip3 accueilManip;
    AccueilPH accueilPH;
    SIR sir;
    public RechercheEamenDMR(SIR sir,AccueilManip3 accueil) {
        this.sir=sir;
        this.accueilManip=accueil;
        initComponents();
    }
    
    public RechercheEamenDMR(SIR sir,AccueilPH accueil) {
        this.sir=sir;
        this.accueilPH=accueil;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();

        jLabel1.setText("                                  RECHERCHE");

        jCheckBox1.setText("DMR");

        jCheckBox2.setText("Examen");

        jLabel2.setText("Que souhaitez vous rechercher?");

        jCheckBox3.setText("idDMR :");

        jCheckBox4.setText("Nom du Patient : ");

        jCheckBox5.setText("idSIR :");

        jTextField1.setText("idDMR");

        jTextField2.setText("Nom");

        jTextField3.setText("idSIR");

        jLabel3.setText("rechercher par:");

        jLabel4.setText("Ou");

        jLabel5.setText("ou");

        jLabel6.setText("ou");

        jLabel7.setText("rechercher par:");

        jCheckBox6.setText("idDMR et idExamen :");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jTextField4.setText("idDMR");

        jLabel8.setText("et");

        jTextField5.setText("idExamen");

        jLabel9.setText("ou");

        jCheckBox7.setText("Type examen :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "type ", "RADIOLOGIE", "IRM", "SCAN", "ECHOGRAPHIE", "ANGIOGRAPHIE", "ECHOENDOGRAPHIE", "MAMMOGRAPHIE", "RADIOTHERAPIE", "PET" }));

        jLabel10.setText("ou");

        jCheckBox8.setText("Nom du Médecin :");

        jTextField6.setText("Nom");

        jLabel11.setText("ou");

        jCheckBox9.setText("date :");

        jTextField7.setText("JJ");

        jLabel12.setText("ou");

        jCheckBox10.setText("Avec Compte rendu ");

        jCheckBox11.setText("Sans compte rendu");

        jLabel13.setText("ou");

        jButton1.setText("VALIDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ANNULER");

        jLabel14.setText("/");

        jLabel15.setText("/");

        jTextField8.setText("MM");

        jTextField9.setText("AAAA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(213, 213, 213)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jCheckBox5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jCheckBox3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jCheckBox4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel7)
                                    .addGap(205, 205, 205)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jCheckBox7)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox6)
                                            .addComponent(jCheckBox8)
                                            .addComponent(jLabel11)
                                            .addComponent(jCheckBox9)
                                            .addComponent(jLabel12)
                                            .addComponent(jCheckBox10)
                                            .addComponent(jCheckBox11)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel8)
                                                .addGap(27, 27, 27)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jCheckBox2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(132, 132, 132)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox5))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addGap(1, 1, 1)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ((jCheckBox1.isSelected() && !jCheckBox2.isSelected()) ){
            if(jCheckBox3.isSelected() && !jCheckBox4.isSelected() && !jCheckBox5.isSelected()){
                if(jTextField1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner le champs idDMR par l'identifiant du DMR recherché "+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                else{
                String id= jTextField1.getText();
                DMR dmrTrouve=sir.RechercheDMRParidDMR(id);
                //affichage du DMR trouvé dans le tableau d'Accueil
                }
            }
            else if(!jCheckBox3.isSelected() && jCheckBox4.isSelected() && !jCheckBox5.isSelected()){
                 if(jTextField2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner le champs nomp Patient par le nom du patient recherché "+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                 else{
                String nomPatient=jTextField2.getText();
                DMR dmrTrouve=sir.RechercheDMRParNomPatient(nomPatient);
                //affichage du DMR trouvé dans le tableau d'Accueil
                 }
            }
            else if(!jCheckBox3.isSelected() && !jCheckBox4.isSelected() && jCheckBox5.isSelected()){
                 if(jTextField3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner le champs idSIR par l'identifiant SIR du patient recherché "+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                 else{
                String idSIR=jTextField3.getText();
                DMR dmrTrouve=sir.RechercheDMRParIdSIR(idSIR);
                //affichage du DMR trouvé dans le tableau d'Accueil
                 }
            }
            else{
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner et renseigner un champs de recherche de DMR à savoir soit idDMR, soit nom du patient, soit idSIR."+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
            }
            
        }
        else if(!jCheckBox1.isSelected() && jCheckBox2.isSelected()){
            if(jCheckBox6.isSelected() && !jCheckBox7.isSelected() && !jCheckBox8.isSelected()&& !jCheckBox9.isSelected() && !jCheckBox10.isSelected()&& !jCheckBox11.isSelected()){
                if(jTextField4.getText().isEmpty() || jTextField5.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner les champs idDMR par l'identifiant du DMR recherché  ainsi que l'identifiant de l'examen recherché"+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                else{
                String id= jTextField4.getText();
                DMR dmrTrouve=sir.RechercheDMRParidDMR(id);
                String idexam=jTextField5.getText();
                Examen exam= dmrTrouve.getExamenParIdExamen(idexam);
                //affichage du DMR trouvé dans le tableau d'Accueil
                }
            }
            else if(!jCheckBox6.isSelected() && jCheckBox7.isSelected() && !jCheckBox8.isSelected()&& !jCheckBox9.isSelected() && !jCheckBox10.isSelected()&& !jCheckBox11.isSelected()){
                 if(jComboBox1.getSelectedIndex() == -1){
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un type d'examen parmis la liste "+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                 else{
                TypeExamen typeExamen=TypeExamen.valueOf(jComboBox1.getSelectedItem().toString());
                ArrayList<Examen>  listeExamen=sir.RechercheExamenParTypeExamen(typeExamen);
                //affichage du DMR trouvé dans le tableau d'Accueil
                 }
            }
            
            if(!jCheckBox6.isSelected() && !jCheckBox7.isSelected() && jCheckBox8.isSelected()&& !jCheckBox9.isSelected() && !jCheckBox10.isSelected()&& !jCheckBox11.isSelected()){
                if(jTextField6.getText().isEmpty() ){
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner le nom du médecin de l'examen recherché"+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                else{
                String nommed= jTextField6.getText();
                ArrayList<Examen> listeExam = sir.RechercheExamenParNomMedecin(nommed);
                //affichage du DMR trouvé dans le tableau d'Accueil
                }
            }
            if(!jCheckBox6.isSelected() && !jCheckBox7.isSelected() && !jCheckBox8.isSelected()&& jCheckBox9.isSelected() && !jCheckBox10.isSelected()&& !jCheckBox11.isSelected()){
                if(jTextField6.getText().isEmpty() || jTextField7.getText().isEmpty() || jTextField8.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Veuillez renseigner la date de l'examen recherché"+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
                }
                else{
                int jour= parseInt(jTextField6.getText());
                int mois= parseInt(jTextField7.getText());
                int annee= parseInt(jTextField8.getText());
                Date date = new Date(jour,mois,annee);
                ArrayList<Examen> listeExamen= sir.RechercheExamenParDate(date);
                //affichage du DMR trouvé dans le tableau d'Accueil
                }
            }
            if(!jCheckBox6.isSelected() && !jCheckBox7.isSelected() && !jCheckBox8.isSelected()&& !jCheckBox9.isSelected() && jCheckBox10.isSelected()&& !jCheckBox11.isSelected()){
                ArrayList<Examen> listeExamen= sir.RechercherExamenAvecCR();
                //affichage du DMR trouvé dans le tableau d'Accueil
            }
            if(!jCheckBox6.isSelected() && !jCheckBox7.isSelected() && !jCheckBox8.isSelected()&& !jCheckBox9.isSelected() && !jCheckBox10.isSelected()&& jCheckBox11.isSelected()){
                ArrayList<Examen> listeExamen= sir.RechercherExamenSansCR();
                //affichage du DMR trouvé dans le tableau d'Accueil
            }
            else{
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner et renseigner UN champs de recherche d'Examen à savoir soit idDMR et idExamen, soit type d'examen, soit par nom du médecin, soit par date , soit avec ou sans compte rendu."+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
            }
        }
        else if(!jCheckBox1.isSelected() && !jCheckBox2.isSelected()){
            JOptionPane.showMessageDialog(null, "Veuillez selectionner une des recherches. Soit par DMR soit par Examen"+"\n"+"Si vous ne souhaitez plus faire cette recherche, cliquez sur 'annuler'.");
        }
        else{
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un seul type de recherche. Vous pouvez rechercher des DMR OU des examen");
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
