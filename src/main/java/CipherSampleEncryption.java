import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CipherSampleEncryption {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        String algorithm  = "AES";
        SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] plainText  = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
        byte[] cipherText = cipher.doFinal(plainText);
        System.out.println("The encrypted text: " + cipherText);
    }
}
