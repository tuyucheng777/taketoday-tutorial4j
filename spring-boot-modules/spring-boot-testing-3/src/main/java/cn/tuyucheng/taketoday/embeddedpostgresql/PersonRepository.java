package cn.tuyucheng.taketoday.embeddedpostgresql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}