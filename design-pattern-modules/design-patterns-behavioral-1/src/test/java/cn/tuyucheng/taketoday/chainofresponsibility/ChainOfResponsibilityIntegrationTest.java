package cn.tuyucheng.taketoday.chainofresponsibility;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChainOfResponsibilityIntegrationTest {

   private static AuthenticationProcessor getChainOfAuthProcessor() {
      AuthenticationProcessor oAuthProcessor = new OAuthAuthenticationProcessor(null);
      return new UsernamePasswordAuthenticationProcessor(oAuthProcessor);
   }

   @Test
   public void givenOAuthProvider_whenCheckingAuthorized_thenSuccess() {
      AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
      boolean isAuthorized = authProcessorChain.isAuthorized(new OAuthTokenProvider());
      assertTrue(isAuthorized);
   }

   @Test
   public void givenUsernamePasswordProvider_whenCheckingAuthorized_thenSuccess() {
      AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
      boolean isAuthorized = authProcessorChain.isAuthorized(new UsernamePasswordProvider());
      assertTrue(isAuthorized);
   }

   @Test
   public void givenSamlAuthProvider_whenCheckingAuthorized_thenFailure() {
      AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
      boolean isAuthorized = authProcessorChain.isAuthorized(new SamlAuthenticationProvider());
      assertFalse(isAuthorized);
   }
}