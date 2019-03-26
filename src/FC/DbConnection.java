package FC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DbConnection {

    private String url;
    private String user;
    private String pwd;
    private String query;
    private Connection con = null;
    private ResultSet rs = null;
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
    
    /* -------------------------------------------------------------------------------------------------- */
    /* ----------------------------------- Lien BD — Application Java ----------------------------------- */
    /* -------------------------------------------------------------------------------------------------- */
    
    /*  Variable boolean assurant le lien avec la BD
        Le Driver JDBC utilisé est Connector/J 8.0
        Les attributs du serveur SQL sont définis dans le constructeur */
    
    public boolean connexionB() {
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

    // ferme le lien avec la BD
    public void close() {
        if (rs != null) {
            try {
                rs.close();
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
    
    /* -------------------------------------------------------------------------------------------------- */
    /* --------------------------------- SQL : SELECT | UPDATE | INSERT --------------------------------- */
    /* -------------------------------------------------------------------------------------------------- */
    
    
        /*  ---------------------------------------- SELECT ---------------------------------------
            Stocke le résultat d'une requête SQL de type SELECT dans un objet de type Resultset 
            Syntaxe SQL :   SELECT  champ
                            FROM    table
                            WHERE   condition                                                                 
            --------------------------------------------------------------------------------------- */
    
    public ResultSet select(String query) {
        try {
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
        /*   --------------------------------------- UPDATE ---------------------------------------
            Modifie une ou plusieurs ligne de la table choisie en requête dans la BD 
            Syntaxe SQL :   UPDATE table
                            SET nom_colonne = 'nouvelle valeur'
                            WHERE condition                                         
            --------------------------------------------------------------------------------------- */
    
    public void update(String query) throws SQLException {
        stmt = con.createStatement();
        stmt.executeUpdate(query);
        close();
    }
    
        /*  ---------------------------------------- INSERT ---------------------------------------
            Génére un PreparedStatement à modifier selon les valeurs à ajouter dans la BDD 
            Syntaxe SQL :   INSERT INTO table
                            VALUES ('valeur_1', 'valeur_2', ...)
            @param  table   nom de la table où l'on souhaite insérer une ligne
            @param  field   champs où l'on souhaite insérer des valeurs 
                            (champs non renseignés == null)
            --------------------------------------------------------------------------------------- */
    
    public PreparedStatement insert(String table, String field) throws SQLException {
        ArrayList<String> sepField = separate(field);
        int nbValues = sepField.size();
        query = "INSERT INTO " + table + "(" + field + ") VALUES (";
        
        // Ajoute autant de ? que de champs à la requête
        for (int i = 0; i < nbValues - 1; i++) {
            query += "?, ";
        } query += "?)";

        pstmt = con.prepareStatement(query);
        return pstmt;
    }
    
    /* -------------------------------------------------------------------------------------------------- */
    /* ---------------------- Opérations sur les dimensions d'une table dans la BD ---------------------- */
    /* -------------------------------------------------------------------------------------------------- */
    
    // Stocke les éléments d'un String dans une ArrayList<String>, chaque élément du String doit être séparé par un ','
    public ArrayList<String> separate(String StringtoSeparate) {
        Pattern pat = Pattern.compile("([0-9]+)|([a-z]|[A-Z]|é)+([^,])");
        Matcher mat = pat.matcher(StringtoSeparate);
        ArrayList<String> arrField = new ArrayList<String>();
        while (mat.find()) {
            arrField.add(mat.group());
        }
        return arrField;
    }
    
    public String joint(ArrayList<String> fields) {
        String f = "";
        for (int i = 0 ; i < fields.size() - 1 ; i++) {
        f  = fields.get(i) + ",";
        } f += ",";
        return f;
    }
    
    
    
    
    // Taille d'un ResultSet à partir du nom d'une table
    public int resultSetSize(String table) throws SQLException {
        query = "SELECT COUNT(*) FROM " + table;
        this.rs = select(query);
        rs.next();
        int size = rs.getInt(1);
        return size;
    }

    // Nombre de lignes d'un ResultSet 
    public int resultSetSize(ResultSet res) throws SQLException {
        int size = 0;
        if (res != null) {
            res.beforeFirst();
            res.last();
            size = res.getRow();
        }
        return size;
    }
    
    /*  Renvoie une Arraylist<String> contenant le nom de toutes colonnes d'une table dans la BD
        fields.size() permet d'obtenir le nombre de colonnes de la table */
    public ArrayList<String> arrColNames(String table) throws SQLException {
        ArrayList<String> fields = new ArrayList<String>();
        rs = select("SELECT * from " + table);
        resMeta = rs.getMetaData();
        int NbCol = resMeta.getColumnCount();
        
        // l'index de resMeta démarre à 1
        for (int i = 1; i <= NbCol; i++) {
            String name = resMeta.getColumnName(i);
            fields.add(name);
        }
        return fields;
    }
    
    public String query(String field, String table, String condition) {
        if (condition == "") {
        query = "SELECT " + field + " FROM " + table;
        rs = select(query);
        
        } else {
            if (field == "*") { 
                

            } else {

            }
        }
        return null;
    }
}
    
    
    /* -------------------------------------------------------------------------------------------------- */
    /*  ------------------------------------ Historique des fonctions ----------------------------------- */
    /* -------------------------------------------------------------------------------------------------- */
    /*
    // ArrayList 2D, requête SELECT avec condition 
    public ArrayList<ArrayList<String>> select(String field, String table, String condition) throws SQLException {
        String query = "SELECT " + field + " FROM " + table + " WHERE " + condition;
        ArrayList<String> sepField = separate(field);
        if (field == "*") {
            ArrayList<ArrayList<String>> arr2D = new ArrayList<ArrayList<String>>();
            this.res = select(query);
            // System.out.println(query); // Test valeur de query (Erreur SQLSyntax)
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
    }
    
    // retourne le nom des colonnes d'un ResultSet
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

    // Retourne une image depuis la BD depuis un numéro d'archivage ——— Ne fonctionne pas !! : SQLException: Column index out of range.
    public ImageIcon importPic(String numArchivage) throws SQLException {
        String query = "SELECT Fichier FROM pacs WHERE numArchivage = " + numArchivage;
        this.res = select(query);
        if (res.next()) {
            byte[] img = res.getBytes("Fichier");
            ImageIcon imgIcon = new ImageIcon(img);
            Image im = imgIcon.getImage();
            ImageIcon newImg = new ImageIcon(im);
            return newImg;
        } else {
            return null;
        }
    }

    public ArrayList<ArrayList<String>> listeExam(String idMed) throws SQLException {
        ArrayList<ArrayList<String>> listeExam = select("*", "examen", "(IDPERS = '" + idMed + "')");
        return listeExam;
    }

    public ArrayList<ArrayList<String>> infosPatient(String idPers) throws SQLException {
        ArrayList<ArrayList<String>> listeIDSIR = select("*", "examen", "(IDPERS = '" + idPers + "')"); // liste des IDSIR d'`examen` par IDPERS
        Set set = new HashSet();
        set.addAll(listeIDSIR);
        ArrayList distinctList = new ArrayList(set);

        ArrayList<ArrayList<String>> Patients;
        for (int i = 0; i < listeIDSIR.size(); i++) {
            String IDSIR = listeIDSIR.get(1).get(i);
            ArrayList<ArrayList<String>> infoPatient = select("*", "dmr", "(IDSIR = '" + IDSIR + "')");

        }
        return null;
    }
    
    // ArrayList 2 dimensions contenant les données d'un ResultSet / SELECT
    public ArrayList<ArrayList<String>> select(String field, String table) throws SQLException {
        String query = "SELECT " + field + " FROM " + table;
        ArrayList<String> sepField = separate(field);
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
    }
    */

