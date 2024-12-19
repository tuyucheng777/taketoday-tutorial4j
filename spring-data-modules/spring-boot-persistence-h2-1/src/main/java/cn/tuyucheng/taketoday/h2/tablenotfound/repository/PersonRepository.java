package cn.tuyucheng.taketoday.h2.tablenotfound.repository;

import cn.tuyucheng.taketoday.h2.tablenotfound.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}