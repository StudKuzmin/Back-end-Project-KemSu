package classes.model.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;


public class Crypto implements ICrypto{

    public String encrypt(String data) throws Exception{
        if (data == null)
            return null;


        byte[] decodedKey = Base64.getDecoder().decode("secret");

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));

            System.out.println("TEST ENCRYPT " + new Throwable().getStackTrace()[0].getMethodName() + ": " + data + " " + Base64.getEncoder().encodeToString(cipherText));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }

    }

    public String decrypt(String encryptedString) throws Exception{
        if (encryptedString == null)
            return null;

        byte[] decodedKey = Base64.getDecoder().decode("secret");

        try {
            Cipher cipher = Cipher.getInstance("AES");
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));

            System.out.println("TEST DECRYPT " + new Throwable().getStackTrace()[0].getMethodName() + ": " + encryptedString + " " + new String(cipherText));
            return new String(cipherText);
        } catch (Exception ex) {
            System.out.printf("ERROR in %s.%s: %s%n",
                    this.getClass(),
                    new Throwable().getStackTrace()[0].getMethodName(),
                    ex.getMessage());
            return null;
        }
    }
}
