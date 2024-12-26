package cn.tuyucheng.taketoday.repository;

import cn.tuyucheng.taketoday.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {
}