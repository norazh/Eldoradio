package FC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class DbConnection {

    private String url;
    private String user;
    private String pwd;
    private Connection connection = null;
    private String query = null;
    private ResultSet res = null;
    private ResultSetMetaData resMeta = null;
    private Statement stmt = null;

    public DbConnection() {
        this.url = "jdbc:mysql://mysql-ldancelme.alwaysdata.net/ldancelme_eldoradio";
        this.url += "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "ldancelme";
        this.pwd = "datingoskra";
    }

    public DbConnection(String url, String user, String pwd) {
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public Connection getConnection() throws ClassNotFoundException {
        if (connection == null) {
            setConnection();
            return connection;
        } else {
            return connection;
        }

    }

    private void setConnection() throws ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (connection != null)
                try {
                    // Fermeture de la connexion
                    connection.close();
                } catch (SQLException ignore) {
                    // Si une erreur survient lors de la fermeture, il suffit de l'ignorer.
                    System.out.println("pas connecté");
                }
            else {
                System.out.println("connecté");
            }


        }
    }

    // Stocke le résultat d'une requête ("query") dans un objet de type Resultset
    public ResultSet result(String query) {
        this.query = query;
        try {
            res = stmt.executeQuery(query);
            this.res = res;
            resMeta = res.getMetaData();
            this.resMeta = resMeta;
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public void afficherPersonnel(ResultSet resultat) {
        try {

            System.out.println();
            while (resultat.next()) {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.print("\t" + resultat.getInt("IDPERS") + "\t |");
                System.out.print("\t" + resultat.getString("Nom") + "\t |");
                System.out.print("\t" + resultat.getString("Prénom") + "\t |");
                System.out.print("\t" + resultat.getString("Spécialité") + "\t |");
                System.out.print("\t" + resultat.getString("ID") + "\t |");
                System.out.print("\t" + resultat.getInt("MDP") + "\t |");
                System.out.println("\n--------------------------------------------------------------------------------------");
            }
        } catch (SQLException e) {
        }
    }


    public ArrayList<ArrayList<String>> requete(String champs, String table, String condition) throws SQLException { //gestion des resultats de requetes vides a implementer, tester avec éléments nulls

        String stringToSplit = new String(champs);
        String[] tempArray;
        String delimiter = ",";
        String compositionRequete = "";
        ResultSet resultatRequete;
        int nbChamps = 0;
        tempArray = stringToSplit.split(delimiter);// les champs sont séparés et stocké dans un Array
        nbChamps = tempArray.length;
        //élaboration de la requete à partir des paramètres
        compositionRequete = "SELECT " + champs + " FROM " + table + " " + condition + ";";
        resultatRequete = result(compositionRequete);
        ArrayList<ArrayList<String>> listResultat = new ArrayList<ArrayList<String>>(nbChamps);
        for (int i = 0; i < nbChamps; i++) {
            listResultat.add(new ArrayList<String>());
        }
        try {
            while (resultatRequete.next()) {
                for (int i = 0; i < nbChamps; i++) {
                    listResultat.get(i).add(resultatRequete.getString(tempArray[i]));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listResultat;
    }


    /*
    // Stocke le contenu d'un ResultSet dans une Arraylist
    public ArrayList listePersonnel(ResultSet resultat) throws SQLException {
        ArrayList liste = new ArrayList();
        while (resultat.next()) {
            for (int i = 1; i < liste.size(); i++) {
                if (resultat.getObject(i) != null) {
                    liste.add(resultat.getObject(i).toString());
                } else {
                    System.out.println("erreur : champ null");
                }
                // affiche le contenu de liste dans la console
                for (int j = 0; j < liste.size(); j++) {
                    System.out.println(liste.get(j));
                }
            }
        }
        return liste;
    }
    */


    /*
    public ArrayList listePersonnel(ResultSet resultat) throws SQLException {

        ArrayList<ArrayList<String>> mainList = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();

        while (resultat.next()) {
            for (int i = 1; i < list.size(); i++) {
                if (resultat.getObject(i) != null) {
                    list.add(resultat.getObject(i).toString());
                    for (int j = 1; j < list.size(); j++) {
                        mainList.add(list);
                    }
                } else {
                    System.out.println("erreur : champ null");
                }

            }
        }
        return mainList;
    }
    */

}
