import java.security.*;

/**
 * 339: Edwards-Curve Digital Signature Algorithm (EdDSA)
 */
public class JEP339 {
    public static void main(final String[] args) {

        try {
            // example: generate a key pair and sign
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
            KeyPair kp = kpg.generateKeyPair();
            // algorithm is pure Ed25519
            Signature sig = null;
            sig = Signature.getInstance("Ed25519");
            sig.initSign(kp.getPrivate());
            sig.update("foo".getBytes());
            byte[] s = sig.sign();
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }

    }
}
