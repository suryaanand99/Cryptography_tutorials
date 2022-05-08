package MessageDigest;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JavaMessageDigest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        String plainText = "abcdefghijklmnopqrstuvwxyz";

        byte[] digestText = messageDigest.digest(plainText.getBytes(StandardCharsets.UTF_8));
        String res = DatatypeConverter.printHexBinary(digestText);
        System.out.println("The digest is: " + res);
    }
}
