package cn.tuyucheng.taketoday.envers.customrevision.repository;

import cn.tuyucheng.taketoday.envers.customrevision.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
   Optional<Owner> findByName(String name);
}