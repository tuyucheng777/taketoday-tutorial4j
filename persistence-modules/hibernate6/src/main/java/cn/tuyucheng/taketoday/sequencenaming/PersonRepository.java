package cn.tuyucheng.taketoday.sequencenaming;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}