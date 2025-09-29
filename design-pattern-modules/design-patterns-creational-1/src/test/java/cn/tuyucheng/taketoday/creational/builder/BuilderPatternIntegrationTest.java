package cn.tuyucheng.taketoday.creational.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderPatternIntegrationTest {
   @Test
   public void whenCreatingObjectThroughBuilder_thenObjectValid() {
      BankAccount newAccount = new BankAccount
            .BankAccountBuilder("Jon", "22738022275")
            .withEmail("jon@example.com")
            .wantNewsletter(true)
            .build();

      assertEquals("Jon", newAccount.getName());
      assertEquals("22738022275", newAccount.getAccountNumber());
      assertEquals("jon@example.com", newAccount.getEmail());
      assertEquals(true, newAccount.isNewsletter());
   }

   @Test
   public void whenSkippingOptionalParameters_thenObjectValid() {
      BankAccount newAccount = new BankAccount
            .BankAccountBuilder("Jon", "22738022275")
            .build();

      assertEquals("Jon", newAccount.getName());
      assertEquals("22738022275", newAccount.getAccountNumber());
      assertEquals(null, newAccount.getEmail());
      assertEquals(false, newAccount.isNewsletter());
   }
}