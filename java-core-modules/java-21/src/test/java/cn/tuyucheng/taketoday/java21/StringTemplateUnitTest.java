package cn.tuyucheng.taketoday.java21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringTemplateUnitTest {

   @Test
   void whenNoSwitchPattern_thenReturnSavingsAccountBalance() {
      StringTemplates stringTemplates = new StringTemplates();
      assertEquals("Welcome to Tuyucheng", stringTemplates.getStringTemplate());
   }
}