

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author loicdancelme
 */
public class Cryptage {

    static SecretKey cle;

    public Cryptage() throws NoSuchAlgorithmException {
        Cryptage.cle = KeyGenerator.getInstance("BlowFish").generateKey();
    }
    
    @SuppressWarnings("all")
    public static String crypt(String dec) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        Cryptage cr = new Cryptage();
        cle = Cryptage.cle;
        Cipher c = Cipher.getInstance("BlowFish"); // On défini un crypteur et un algorithme de chiffrement
        c.init(Cipher.ENCRYPT_MODE, cle); // Initialise le crypteur avec la clé de chiffrage
        byte[] dByte = dec.getBytes("UTF8"); // Encode le mot à crypter en une séquence de Bytes
        byte[] enc = c.doFinal(dByte); // Fini la procédure de cryptage
        String str = new BASE64Encoder().encode(enc);
        return str;
    }
    
    @SuppressWarnings("all")
    public static String decrypt(String cry) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        cle = Cryptage.cle;
        Cipher c = Cipher.getInstance("BlowFish");
        c.init(Cipher.DECRYPT_MODE, cle);
        byte[] enc = new BASE64Decoder().decodeBuffer(cry);
        byte[] dByte = c.doFinal(enc);
        String str = new String(dByte,"UTF8");
        return str;
    }

}