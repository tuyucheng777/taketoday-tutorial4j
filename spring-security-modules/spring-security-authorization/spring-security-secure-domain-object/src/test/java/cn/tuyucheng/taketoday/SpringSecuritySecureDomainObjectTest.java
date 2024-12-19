package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.model.Account;
import cn.tuyucheng.taketoday.repo.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class SpringSecuritySecureDomainObjectTest {

   @Autowired
   private AccountService accountService;

   @Test
   @WithMockUser(username = "user", password = "password", authorities = "none")
   void whenUnauthorizedAccountBalanceAccessThanAccessDeniedException() {
      Optional<Account> account = accountService.getAccountByIban("F1234");
      assertThatExceptionOfType(AccessDeniedException.class).isThrownBy(() -> account.get()
            .getBalance());
   }

   @Test
   @WithMockUser(username = "user", password = "password", authorities = "read")
   void whenAuthorizedThanAccessAccountBalance() throws Exception {
      Optional<Account> account = accountService.getAccountByIban("F1234567809");
      assertEquals(2345.6, account.get().getBalance());
   }

   @Test
   @WithMockUser(username = "user", password = "password", authorities = "none")
   void whenUnAuthorizedWithAuthorizationHandlerThanMaskedIban() throws Exception {
      Optional<Account> account = accountService.getAccountByIban("F1234567809");
      assertEquals("****", account.get().getIban());
   }
}