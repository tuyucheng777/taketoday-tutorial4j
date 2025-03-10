package cn.tuyucheng.taketoday.multipledb.repository.secondary;

import cn.tuyucheng.taketoday.multipledb.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

   Account findByAccountDomain(String account);
}