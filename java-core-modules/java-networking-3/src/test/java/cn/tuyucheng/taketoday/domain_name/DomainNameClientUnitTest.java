package cn.tuyucheng.taketoday.domain_name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DomainNameClientUnitTest {

   DomainNameClient domainNameClient = new DomainNameClient();

   @Test
   void givenUrl_whenGetHost_thenReturnSubdomainAndDomainName() {
      Assertions.assertAll(() -> {
         assertEquals("www.taketoday.com", domainNameClient.getHost("https://www.taketoday.com/domain"));
         assertEquals("www.google.co.uk", domainNameClient.getHost("https://www.google.co.uk/domain"));
         assertEquals("jira.taketoday.com", domainNameClient.getHost("https://jira.taketoday.com/secure"));
      });
   }

   @Test
   void givenUrl_whenGetTopPrivateDomain_thenReturnDomainName() {
      assertEquals("taketoday.com", domainNameClient.getTopPrivateDomain("www.taketoday.com"));
   }

   @Test
   void givenUrlWithPublicSuffix_whenGetTopPrivateDomain_thenReturnDomainName() {
      assertEquals("google.co.uk", domainNameClient.getTopPrivateDomain("www.google.co.uk"));
      assertEquals("taketoday.blogspot.com", domainNameClient.getTopPrivateDomain("www.taketoday.blogspot.com"));
   }

   @Test
   void givenUrlWithPublicSuffix_whenGetName_thenReturnSecondLevelDomain() {
      assertEquals("taketoday", domainNameClient.getName("jira.taketoday.com"));
   }

   @Test
   void givenUrlWithPublicSuffix_whenGetName_thenReturnThirdLevelDomain() {
      assertEquals("taketoday", domainNameClient.getName("www.taketoday.co.uk"));
      assertEquals("google", domainNameClient.getName("www.google.co.uk"));
   }

   @Test
   void givenUrl_whenGetDomainNameRegex_thenReturnDomainName() {
      assertEquals("google.com", domainNameClient.getDomainName("www.google.com"));
      assertEquals("google.co.uk", domainNameClient.getDomainName("www.google.co.uk"));
      assertEquals("jira.taketoday.com", domainNameClient.getDomainName("jira.taketoday.com"));
      assertEquals("taketoday.com", domainNameClient.getDomainName("www.taketoday.com/test"));
   }

}
