package cn.tuyucheng.taketoday.tutorials.passkey.repository;

import cn.tuyucheng.taketoday.tutorials.passkey.domain.PasskeyUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PasskeyUserRepository extends CrudRepository<PasskeyUser, Long> {
   Optional<PasskeyUser> findByName(String name);

   Optional<PasskeyUser> findByExternalId(String externalId);
}