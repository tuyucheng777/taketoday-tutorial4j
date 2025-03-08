package cn.tuyucheng.taketoday.findby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

   Account findByEmail(String email);

   Account findByUsernameAndEmail(String username, String email);

   Account findByUsernameOrEmail(String username, String email);

   List<Account> findByUsernameInOrEmailIn(List<String> usernames, List<String> emails);
}