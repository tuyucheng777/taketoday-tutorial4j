package cn.tuyucheng.taketoday.startdbwithawssecretsmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.startdbwithawssecretsmanager.model.UserEntity;

@Repository
public interface UserRepository
      extends CrudRepository<UserEntity, Long> {
}