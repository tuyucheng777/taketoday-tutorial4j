package cn.tuyucheng.taketoday.model;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

import cn.tuyucheng.taketoday.error.handler.MaskMethodAuthorizationDeniedHandler;

public class Account {

   private String iban;
   private Double balance;

   public Account(String iban, Double balance) {
      this.iban = iban;
      this.balance = balance;
   }

   @PreAuthorize("hasAuthority('read')")
   @HandleAuthorizationDenied(handlerClass = MaskMethodAuthorizationDeniedHandler.class)
   public String getIban() {
      return iban;
   }

   @PreAuthorize("hasAuthority('read')")
   public Double getBalance() {
      return balance;
   }

   @Override
   public String toString() {
      return "Account [iban=" + iban + ", balance=" + balance + "]";
   }
}