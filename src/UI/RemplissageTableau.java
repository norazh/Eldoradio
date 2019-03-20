/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import FC.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Imane
 */
public class RemplissageTableau {

    
    private ResultSet rs;
    
    public void TabInit(String requete, JTable table) {
        try {
            DbConnection c = new DbConnection();
            c.connexionP();
            //String query = "SELECT idExamen, TypeExamen, DateExamen, p1.Prenom, p1.Nom, p2.Prenom, p2.Nom, DMRPapier FROM examen e, personnel p1, patients p2 WHERE (p2.IDDMR = e.IDDMR) AND (p1.IDPERS = e.IDPERS) AND (p1.IDPERS = e.IDPERS)";
            this.rs = c.select(requete);
            setTable(rs,table);
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    public void setTable(ResultSet rs, JTable table) throws SQLException {
        try {
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            /* On créer un int columns avec le nombre de colonne de notre rs.getMetaData qui prend l'entête*/
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                /* On crée un tableau d'objet qui est initialisé avec un nombre de colonne = à columns */
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    /* Dans chaque ligne de notre table, on get l'object (donc une ligne de patient) de notre resulset*/
                    row[i - 1] = rs.getObject(i);
                }

                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setTable(String query, JTable table) throws SQLException {
        try {
            DbConnection c = new DbConnection();
            c.connexionP();
            ResultSet rs = c.select(query);
            while (table.getRowCount() > 0) {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }
            c.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
