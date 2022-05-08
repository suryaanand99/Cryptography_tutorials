package Mac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import java.security.Key;
import java.util.Base64;

public class JavaMac {
    private static Key key;

    public static void generateKey() throws Exception {
        //Creating a KeyGenerator object
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");

        //Initializing the KeyGenerator
        keyGen.init(256);

        //Creating/Generating a key
        key = keyGen.generateKey();
    }

    public String generateMac(String msg) throws Exception{
        //Creating a Mac object
        Mac mac = Mac.getInstance("HmacSHA256");

        //Initializing the Mac object
        mac.init(key);

        //Computing the Mac
        byte[] bytes = msg.getBytes();
        byte[] macResult = mac.doFinal(bytes);
        return Base64.getEncoder().encodeToString(macResult);
    }

    public boolean verifyMac(String plainText, String mac) throws Exception{
        String genMac = generateMac(plainText);
        System.out.println("The verify generated mac is " + genMac);
        if(genMac.equals(mac))
            return true;
        return false;
    }

    public static void main(String args[]) throws Exception{
        JavaMac javaMac = new JavaMac();
        generateKey();

        String PLainText = "hi, how are you?";

        String mac = javaMac.generateMac(PLainText);
        System.out.println("The generated mac is " + mac);

        System.out.println("Verifying the mac: " + javaMac.verifyMac(PLainText, mac));
    }
}
