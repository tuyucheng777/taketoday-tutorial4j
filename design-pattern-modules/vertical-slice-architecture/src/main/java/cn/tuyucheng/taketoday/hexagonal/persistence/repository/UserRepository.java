package cn.tuyucheng.taketoday.hexagonal.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tuyucheng.taketoday.hexagonal.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}