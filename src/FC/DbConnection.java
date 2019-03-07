package FC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbConnection {

    private String url;
    private String user;
    private String pwd;
    private Connection con = null;
    private ResultSet res = null;
    private ResultSetMetaData resMeta = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

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

    // Parrain variable boolean assurant la connexion
    public boolean connexionP() {
        /* Chargement du drier JDBC par MySQL */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, pwd);
            stmt = con.createStatement();
            return true;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
        return false;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            if (con == null) {
                setConnection();
            }
            return con;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    private void setConnection() throws ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            stmt = connection.createStatement();
        } catch (SQLException ex) {;
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            if (con == null) {
                System.out.println("pas connecté");
            }
        }
    }

    // ferme le lien avec la BD
    public void close() {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException ignore) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ignore) {
            }
        }

        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ignore) {
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ignore) {
            }
        }
    }

    // Stocke le résultat d'une requête SQL de type SELECT dans un objet de type Resultset
    public ResultSet select(String query) {
        try {
            res = stmt.executeQuery(query);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // ------------------------ Traitement générique des requête SQL ----------------------
    // Stocke les éléments d'un String dans un ArrayList<String>
    public ArrayList<String> separate(String StringtoSeparate) {
        Pattern pat = Pattern.compile("([0-9]+)|([a-z]|[A-Z]|é)+([^,])");
        Matcher mat = pat.matcher(StringtoSeparate);
        ArrayList<String> arrField = new ArrayList<String>();
        while (mat.find()) {
            arrField.add(mat.group());
        }
        return arrField;
    }

    // ArrayList 2 dimensions contenant les données d'un ResultSet / SELECT
    public ArrayList<ArrayList<String>> select(String field, String table) throws SQLException {
        String query = "SELECT " + field + " FROM " + table;
        ArrayList<String> sepField = separate(field);
        try {
            if (field == "*") {
                ArrayList<ArrayList<String>> arr2D = new ArrayList<ArrayList<String>>();
                this.res = select(query);
                this.resMeta = res.getMetaData();
                int col = resMeta.getColumnCount();
                for (int i = 0; i < col; i++) {
                    arr2D.add(new ArrayList<String>());
                }
                while (res.next()) {
                    for (int i = 1; i < col + 1; i++) {
                        arr2D.get(i - 1).add(res.getString(i));
                    }
                }
                return arr2D;
            } else {
                ArrayList<ArrayList<String>> arr2D = new ArrayList<ArrayList<String>>(sepField.size());
                this.res = select(query);
                for (int i = 0; i < sepField.size(); i++) {
                    arr2D.add(new ArrayList<String>());
                }
                while (res.next()) {
                    for (int i = 0; i < sepField.size(); i++) {
                        arr2D.get(i).add(res.getString(sepField.get(i)));
                    }
                }
                return arr2D;
            }
        } finally {
            res.close();
        }
    }

    // ArrayList 2D, requête SELECT avec condition 
    public ArrayList<ArrayList<String>> select(String field, String table, String condition) throws SQLException {
        String query = "SELECT " + field + " FROM " + table + "WHERE " + condition;
        ArrayList<String> sepField = separate(field);
        try {
            if (field == "*") {
                ArrayList<ArrayList<String>> arr2D = new ArrayList<ArrayList<String>>();
                this.res = select(query);
                this.resMeta = res.getMetaData();
                int col = resMeta.getColumnCount();
                for (int i = 0; i < col; i++) {
                    arr2D.add(new ArrayList<String>());
                }
                while (res.next()) {
                    for (int i = 1; i < col + 1; i++) {
                        arr2D.get(i - 1).add(res.getString(i));
                    }
                }
                return arr2D;
            } else {
                ArrayList<ArrayList<String>> arr2D = new ArrayList<>(sepField.size());
                this.res = select(query);
                for (int i = 0; i < sepField.size(); i++) {
                    arr2D.add(new ArrayList<String>());
                }
                while (res.next()) {
                    for (int i = 0; i < sepField.size(); i++) {
                        arr2D.get(i).add(res.getString(sepField.get(i)));
                    }
                }
                return arr2D;
            }
        } finally {
            res.close();
        }
    }

    // Génére un PreparedStatement à modifier selon les valeurs à ajouter dans la BDD
        public void insert(String table, String field) throws SQLException {
        ArrayList<String> sepField = separate(field);
        int nbValues = sepField.size();
        String query = "INSERT INTO " + table + "(" + field + ") VALUES (";
        for (int i = 0; i < nbValues - 1; i++) {
            query += "?, ";
        }
        query += "?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.execute();
        } finally {
            close();
        }
    }

    public ArrayList<ArrayList<String>> info(ResultSet res) throws SQLException {
        resMeta = res.getMetaData();
        int arrSize = resMeta.getColumnCount();
        ArrayList<ArrayList<String>> listResultat = new ArrayList<>(arrSize);
        for (int i = 0; i < arrSize; i++) {
            listResultat.add(new ArrayList<>());
        }
        try {
            while (res.next()) {
                for (int i = 0; i < arrSize; i++) {
                    listResultat.get(i).add(res.getString(resMeta.getColumnLabel(i)));
                }
            }
        } catch (SQLException SqlEx) {
            System.out.println("SQLException: " + SqlEx.getMessage());
            System.out.println("SQLState: " + SqlEx.getSQLState());
            System.out.println("VendorError: " + SqlEx.getErrorCode());
        }
        return listResultat;
    }
    
    
    // -------------------------------------- Historique des Méthodes  --------------------------------------
    
    /*   
    
    public ArrayList<String> requetePstmt(Personnel pers) throws SQLException, ClassNotFoundException {
            int arrSize = 3;
            ArrayList<String> listResultat = new ArrayList<>(arrSize);
            try {
                String SQLquery = "SELECT Prénom, Nom, Spécialité FROM ? WHERE ? = ? ";
                if (connection == null) {
                    PreparedStatement pstmt = connection.prepareStatement(SQLquery);
                    System.out.println("con is null");
                } else {
                    System.out.println("con is not null");
                }
                pstmt.setString(1, "'personnel");
                pstmt.setString(2, "Prénom");
                pstmt.setString(3, pers.getPrenom());
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    for (int i = 1; i < arrSize; i++) {
                        listResultat.add(rs.getString(i));
                    }
                }
            } catch (SQLException e) {
            }
            /*finally { try { res.close();
                    pstmt.close();
                } catch (SQLException e) {e.printStackTrace();}}return listResultat;} 
        
       
        // Renvoie un objet Personnel() avec Prénom/Nom/Statut à partir d'une recherche prénom
        public Personnel infoPersonnel(String prenomPers) throws SQLException {
            DbConnection con = new DbConnection();
            Personnel pers = new Personnel();
            Statut statut = pers.getStatut();
            ArrayList<ArrayList<String>> info = con.requetePstmt();
            pers.setPrenom(info.get(1).get(1));
            pers.setNom(info.get(2).get(1));
            pers.setStatut(statut.valueOf(info.get(3).get(1)));
            return pers;
        }
    
    
   
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
}
