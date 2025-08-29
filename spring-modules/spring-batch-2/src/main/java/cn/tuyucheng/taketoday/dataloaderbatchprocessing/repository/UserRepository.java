package cn.tuyucheng.taketoday.dataloaderbatchprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tuyucheng.taketoday.dataloaderbatchprocessing.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}