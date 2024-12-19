package cn.tuyucheng.taketoday.repo;

import cn.tuyucheng.taketoday.model.Account;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

   @AuthorizeReturnObject
   public Optional<Account> getAccountByIban(String iban) {
      return Optional.of(new Account("XX1234567809", 2345.6));
   }
}