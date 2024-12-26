package cn.tuyucheng.taketoday.jpa.schemageneration.repository;

import cn.tuyucheng.taketoday.jpa.schemageneration.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
   Account findByName(String name);
}