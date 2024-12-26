package cn.tuyucheng.taketoday.spring.data.jpa.collectionsvsstream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   Stream<User> findAllByAgeGreaterThan(int age);

   List<User> findByAgeGreaterThan(int age);
}