package cn.tuyucheng.taketoday.keystorealias;

import org.junit.jupiter.api.Test;

import java.security.Key;
import java.security.KeyStore;
import java.security.cert.Certificate;

import static org.assertj.core.api.Assertions.assertThat;

public class KeystoreChangeCertificateNameAliasUnitTest {
   private static final String KEYSTORE = "my-keystore.jks";
   private static final String PWD = "storepw@1";
   private static final String OLD_ALIAS = "tuyucheng";
   private static final String NEW_ALIAS = "tuyucheng.com";

   @Test
   void whenAliasIsRenamed_thenNewAliasIsCreated() throws Exception {
      KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
      keystore.load(getClass().getResourceAsStream(KEYSTORE), PWD.toCharArray());

      assertThat(keystore.containsAlias(OLD_ALIAS)).isTrue();
      assertThat(keystore.containsAlias(NEW_ALIAS)).isFalse();

      Key key = keystore.getKey(OLD_ALIAS, PWD.toCharArray());
      Certificate[] certificateChain = keystore.getCertificateChain(OLD_ALIAS);

      keystore.deleteEntry(OLD_ALIAS);
      keystore.setKeyEntry(NEW_ALIAS, key, PWD.toCharArray(), certificateChain);

      assertThat(keystore.containsAlias(OLD_ALIAS)).isFalse();
      assertThat(keystore.containsAlias(NEW_ALIAS)).isTrue();
   }
}