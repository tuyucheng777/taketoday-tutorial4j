package cn.tuyucheng.taketoday.envers.customrevision.repository;

import cn.tuyucheng.taketoday.envers.customrevision.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

   Optional<Species> findByName(String name);
}