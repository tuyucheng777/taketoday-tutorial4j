package cn.tuyucheng.taketoday.transactionalandasync;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
