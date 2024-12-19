package cn.tuyucheng.taketoday.security;

import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;

public class PasswordCheckerSimulator implements CompromisedPasswordChecker {

   public static final String FAILURE_KEYWORD = "compromised";

   @Override
   public CompromisedPasswordDecision check(String password) {
      boolean isPasswordCompromised = password.contains(FAILURE_KEYWORD);
      return new CompromisedPasswordDecision(isPasswordCompromised);
   }
}