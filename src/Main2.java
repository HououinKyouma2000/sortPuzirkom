import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main2 {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String sharedSecret = "London123";
        String  acceptorID = "EMR0002";
        String timeStampUTC = String.valueOf(System.currentTimeMillis() / 1000L);
        byte[] HMACDigest = hmac(sharedSecret, timeStampUTC + acceptorID);
        String digest = new BigInteger(1, HMACDigest).toString(16);
        String input = acceptorID + ":" + timeStampUTC +  ":" + digest;
        String auth = Base64.getEncoder().encodeToString(input.getBytes());
        System.out.println(auth);
    }

    static byte[] hmac(String secretKey, String data) throws InvalidKeyException, NoSuchAlgorithmException {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(data.getBytes());
    }
}
/*
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

def hmac(String secretKey, String data) {
  Mac mac = Mac.getInstance("HmacSHA256")
  SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256")
  mac.init(secretKeySpec)
  byte[] digest = mac.doFinal(data.getBytes())
  return digest
}

def sharedSecret = 'London123'
def acceptorID = 'EMR0002'

def timeStampUTC = String.valueOf(1660735571.intdiv(1000L))

def HMACDigest = hmac(sharedSecret, timeStampUTC + acceptorID)
def digest = HMACDigest.encodeHex().toString()

def input = String;
input = acceptorID + ":" + timeStampUTC +  ":" + digest


def auth = String;
auth = Base64.getEncoder().encodeToString(input.getBytes());
println auth*/
