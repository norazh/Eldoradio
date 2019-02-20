package FC;

import java.util.ArrayList;

public class TestBD {
    public static void main(String[] args) throws Exception {
        DbConnection con = new DbConnection();
        con.getConnection(); // Ouverture connexion depuis DbConnection()
        // con.listePersonnel(con.result("SELECT * FROM personnel")).toString();
        // con.afficherPersonnel(con.result("SELECT * FROM personnel"));
        ArrayList<ArrayList<String>> listeResultat = con.requete("Prénom,Nom,Spécialité,ID,MDP","personnel","");
        for ( int i = 0 ; i < listeResultat.size() ;  i++) {
            System.out.println(listeResultat.get(i));
        }

    }
}
