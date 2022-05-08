package signature;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Base64;

public class JavaSignature {
    private static KeyPair keyPair;
    private static SecureRandom secureRandom;

    public static void generateKeyPair() throws Exception {
        secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public byte[] generateSignature(String plainText) throws Exception {
        Signature signature = Signature.getInstance("SHA256WithDSA");
        signature.initSign(keyPair.getPrivate(), secureRandom);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));
        byte[] sign = signature.sign();
        return sign;
    }

    public boolean verifySignature(String plainText, byte[] sign) throws Exception {
        Signature signature = Signature.getInstance("SHA256WithDSA");
        signature.initVerify(keyPair.getPublic());
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));
        return signature.verify(sign);
    }

    public static void main(String[] args) throws Exception {
        JavaSignature javaSignature = new JavaSignature();
        JavaSignature.generateKeyPair();

        String plaintext = "sdfghjklertyuiopcvbnm,";

        byte[] sign = javaSignature.generateSignature(plaintext);
        System.out.println("The signature is "  + Base64.getEncoder().encodeToString(sign));

        System.out.println("Verify Signature: "  + javaSignature.verifySignature(plaintext, sign));
    }
}
