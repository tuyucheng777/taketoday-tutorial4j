package cn.tuyucheng.taketoday.java21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchPatternUnitTest {

   @Test
   void whenNoSwitchPattern_thenReturnSavingsAccountBalance() {
      SwitchPattern.SavingsAccount savingsAccount = new SwitchPattern.SavingsAccount();
      assertEquals(100, SwitchPattern.getBalanceWithOutSwitchPattern(savingsAccount), 0);
   }

   @Test
   void whenSwitchPattern_thenReturnSavingsAccountBalance() {
      SwitchPattern.SavingsAccount savingsAccount = new SwitchPattern.SavingsAccount();
      assertEquals(100, SwitchPattern.getBalanceWithSwitchPattern(savingsAccount), 0);
   }
}