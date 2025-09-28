package cn.tuyucheng.taketoday.bouncycastle.pgp;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.operator.OperatorCreationException;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BouncyCastlePGPUnitTest {

   @Test
   @Order(1)
   public void givenFileWithPlainText_whenPGPEncrypWithPubKey_thenPGPEncryptedFileCreated()
         throws CertificateException, NoSuchProviderException, NoSuchAlgorithmException, IOException, KeyStoreException, UnrecoverableKeyException, CMSException, OperatorCreationException, PGPException {
      Path resourcesPath = Paths.get("src", "main", "resources");
      String pgpresource = resourcesPath.resolve("pgp")
            .toAbsolutePath()
            .toString();
      String pubKeyFileName = pgpresource + "/public_key.asc";
      String encryptedFileName = pgpresource + "/EncryptedOutputFile.pgp";
      String plainTextInputFileName = pgpresource + "/PlainTextInputFile.txt";
      BouncyCastlePGPDemoApplication.encryptFile(encryptedFileName, plainTextInputFileName, pubKeyFileName, true);
      Path path = Paths.get(encryptedFileName);
      Assertions.assertTrue(Files.exists(path));
   }

   @Test
   @Order(2)
   public void givenPGPEncryptedFile_whenDecryptWithPrivateKey_thenFileWithPlainTextCreated()
         throws CertificateException, NoSuchProviderException, NoSuchAlgorithmException, IOException, KeyStoreException, UnrecoverableKeyException, CMSException, OperatorCreationException, PGPException {
      Path resourcesPath = Paths.get("src", "main", "resources");
      String pgpresource = resourcesPath.resolve("pgp")
            .toAbsolutePath()
            .toString();
      String encryptedFileName = pgpresource + "/EncryptedOutputFile.pgp";
      String privKeyFileName = pgpresource + "/private_key.asc";

      BouncyCastlePGPDemoApplication.decryptFile(encryptedFileName, privKeyFileName, "tuyucheng".toCharArray(), "decryptedFile", true);
      File file = new File("decryptedFile");
      Assertions.assertTrue(file.exists());
   }
}