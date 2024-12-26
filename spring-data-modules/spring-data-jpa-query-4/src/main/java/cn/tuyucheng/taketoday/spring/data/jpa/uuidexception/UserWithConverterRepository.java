package cn.tuyucheng.taketoday.spring.data.jpa.uuidexception;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserWithConverterRepository extends JpaRepository<UserWithConverter, Long> {
   Optional<UserWithConverter> findById(Long id);

   Optional<UserWithConverter> findByUuid(UUID uuid);
}