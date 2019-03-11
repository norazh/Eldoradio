package FC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestBD {

    public static void main(String[] args) throws Exception {
        DbConnection c = new DbConnection();
        c.connexionP();

        //  --------------------------------------- Test BDD ---------------------------------------
        System.out.print("\n--------------------------------------------------------");
        System.out.print("\n---------------------- TEST BDD ------------------------");
        System.out.println("\n----------------------- SELECT -------------------------\n");

        // Test 1 Requête de type  : "SELECT * FROM table"
        System.out.println("Requête : SELECT * FROM personnel");
        System.out.print("Résultat : ");
        ArrayList<ArrayList<String>> arrRes = c.select("*", "personnel");
        afficher(arrRes);

        // Test 2 : Requête de type "SELECT * FROM table WHERE condition"
        System.out.println("\n\nRequête : SELECT Nom,Prénom,Spécialité FROM personnel WHERE IDPers >1");
        System.out.print("Résultat : ");
        ArrayList<ArrayList<String>> arrRes1 = c.select("Nom,Prénom,Spécialité", "personnel", "IDPers > 1");
        afficher(arrRes1);

        System.out.println("\n\n--------------------------------------------------------\n");

        System.out.println("Requête : SELECT * FROM personnel WHERE Nom = 'Bono'");
        System.out.print("Résultat : ");
        ArrayList<ArrayList<String>> arrRes2 = c.select("*", "personnel", "Nom = 'Bono'");
        afficher(arrRes2);

        System.out.println("\n\n----------------------- UPDATE -------------------------\n");

        //  ----------------------------- Test Chiffrement des données -----------------------------
        System.out.print("\n\n--------------------------------------------------------");
        System.out.print("\n-------------------- TEST CRYPTAGE ---------------------");
        System.out.print("\n--------------------------------------------------------\n\n");

        
        String dec, enc;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Entrer le mot à coder : ");
        dec = br.readLine(); // Mise en tampon du mot à coder
        
        enc = Cryptage.crypt(dec); // Cryptage...
        System.out.println(enc);
        
        dec = Cryptage.decrypt(enc); // Decryptage...
        System.out.println(dec);

        System.out.println("\n\n--------------------------------------------------------\n");
    }

    public static void afficher(ArrayList<ArrayList<String>> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }

}
