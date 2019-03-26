/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Imane
 */
public class TestNF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {


 
        /* ----------------------------- Test Chiffrement des données ---------------------------- */
        System.out.print("\n\n--------------------------------------------------------");
        System.out.print("\n-------------------- TEST CRYPTAGE ---------------------");
        System.out.print("\n--------------------------------------------------------\n\n");

        Cryptage cr = new Cryptage();
        String dec, enc;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Entrer le mot à coder : ");
        dec = br.readLine(); // Mise en tampon du mot à coder
        
        enc = cr.hash(dec.toCharArray()); // Cryptage...
        System.out.println(enc);
        
        boolean b = cr.authenticate(dec.toCharArray(), enc); // Decryptage...
        System.out.println(b);

        System.out.println("\n\n--------------------------------------------------------\n");

    }
    
}
