package cn.tuyucheng.taketoday.bouncycastle;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BouncyCastleLiveTest {

   String certificatePath = "src/main/resources/Tuyucheng.cer";
   String privateKeyPath = "src/main/resources/Tuyucheng.p12";
   char[] p12Password = "password".toCharArray();
   char[] keyPassword = "password".toCharArray();

   @Test
   public void givenCryptographicResource_whenOperationSuccess_returnTrue() throws CertificateException, NoSuchProviderException, NoSuchAlgorithmException, IOException, KeyStoreException, UnrecoverableKeyException, CMSException, OperatorCreationException {
      Security.addProvider(new BouncyCastleProvider());

      CertificateFactory certFactory = CertificateFactory.getInstance("X.509", "BC");
      X509Certificate certificate = (X509Certificate) certFactory.generateCertificate(new FileInputStream(certificatePath));
      KeyStore keystore = KeyStore.getInstance("PKCS12");
      keystore.load(new FileInputStream(privateKeyPath), p12Password);
      PrivateKey privateKey = (PrivateKey) keystore.getKey("tuyucheng", keyPassword);
      String secretMessage = "My password is 123456Seven";
      System.out.println("Original Message : " + secretMessage);
      byte[] stringToEncrypt = secretMessage.getBytes();
      byte[] encryptedData = BouncyCastleCrypto.encryptData(stringToEncrypt, certificate);
      byte[] rawData = BouncyCastleCrypto.decryptData(encryptedData, privateKey);
      String decryptedMessage = new String(rawData);
      assertEquals(secretMessage, decryptedMessage);
      byte[] signedData = BouncyCastleCrypto.signData(rawData, certificate, privateKey);
      Boolean check = BouncyCastleCrypto.verifSignData(signedData);
      assertTrue(check);
   }
}