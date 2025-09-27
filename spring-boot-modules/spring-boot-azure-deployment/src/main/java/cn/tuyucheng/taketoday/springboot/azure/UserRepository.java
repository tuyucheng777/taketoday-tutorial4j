package cn.tuyucheng.taketoday.springboot.azure;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}