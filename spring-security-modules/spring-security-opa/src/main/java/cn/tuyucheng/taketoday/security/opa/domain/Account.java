package cn.tuyucheng.taketoday.security.opa.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

   private String id;
   private BigDecimal balance;
   private String currency;

   public static Account of(String id, BigDecimal balance, String currency) {
      Account account = new Account();
      account.setId(id);
      account.setBalance(balance);
      account.setCurrency(currency);
      return account;
   }
}