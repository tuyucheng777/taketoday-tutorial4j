package cn.tuyucheng.taketoday.bouncycastle.pgp;

import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;

import java.io.*;
import java.security.NoSuchProviderException;
import java.util.Iterator;

class PGPExampleUtil {
   static byte[] compressFile(String fileName, int algorithm) throws IOException {
      ByteArrayOutputStream bOut = new ByteArrayOutputStream();
      PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(algorithm);
      PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY, new File(fileName));
      comData.close();
      return bOut.toByteArray();
   }

   /**
    * Search a secret key ring collection for a secret key corresponding to keyID if it
    * exists.
    *
    * @param pgpSec a secret key ring collection.
    * @param keyID  keyID we want.
    * @param pass   passphrase to decrypt secret key with.
    * @return the private key.
    * @throws PGPException
    * @throws NoSuchProviderException
    */
   static PGPPrivateKey findSecretKey(PGPSecretKeyRingCollection pgpSec, long keyID, char[] pass) throws PGPException, NoSuchProviderException {
      PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);
      if (pgpSecKey == null) {
         return null;
      }
      return pgpSecKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider("BC")
            .build(pass));
   }

   static PGPPublicKey readPublicKey(String fileName) throws IOException, PGPException {
      InputStream keyIn = new BufferedInputStream(new FileInputStream(fileName));
      PGPPublicKey pubKey = readPublicKey(keyIn);
      keyIn.close();
      return pubKey;
   }

   /**
    * A simple method that opens a key ring file and loads the first available key
    * suitable for encryption.
    *
    * @param input data stream containing the public key data
    * @return the first public key found.
    * @throws IOException
    * @throws PGPException
    */
   static PGPPublicKey readPublicKey(InputStream input) throws IOException, PGPException {
      PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());
      Iterator keyRingIter = pgpPub.getKeyRings();
      while (keyRingIter.hasNext()) {
         PGPPublicKeyRing keyRing = (PGPPublicKeyRing) keyRingIter.next();

         Iterator keyIter = keyRing.getPublicKeys();
         while (keyIter.hasNext()) {
            PGPPublicKey key = (PGPPublicKey) keyIter.next();

            if (key.isEncryptionKey()) {
               return key;
            }
         }
      }
      throw new IllegalArgumentException("Can't find encryption key in key ring.");
   }

   static PGPSecretKey readSecretKey(String fileName) throws IOException, PGPException {
      InputStream keyIn = new BufferedInputStream(new FileInputStream(fileName));
      PGPSecretKey secKey = readSecretKey(keyIn);
      keyIn.close();
      return secKey;
   }

   /**
    * A simple method that opens a key ring file and loads the first available key
    * suitable for signature generation.
    *
    * @param input stream to read the secret key ring collection from.
    * @return a secret key.
    * @throws IOException  on a problem with using the input stream.
    * @throws PGPException if there is an issue parsing the input stream.
    */
   static PGPSecretKey readSecretKey(InputStream input) throws IOException, PGPException {
      PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(input), new JcaKeyFingerprintCalculator());
      Iterator keyRingIter = pgpSec.getKeyRings();
      while (keyRingIter.hasNext()) {
         PGPSecretKeyRing keyRing = (PGPSecretKeyRing) keyRingIter.next();
         Iterator keyIter = keyRing.getSecretKeys();
         while (keyIter.hasNext()) {
            PGPSecretKey key = (PGPSecretKey) keyIter.next();
            if (key.isSigningKey()) {
               return key;
            }
         }
      }
      throw new IllegalArgumentException("Can't find signing key in key ring.");
   }
}