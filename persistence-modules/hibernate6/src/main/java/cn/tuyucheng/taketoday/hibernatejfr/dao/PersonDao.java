package cn.tuyucheng.taketoday.hibernatejfr.dao;

import cn.tuyucheng.taketoday.hibernatejfr.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<PersonEntity, Long> {


}
