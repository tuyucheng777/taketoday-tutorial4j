package cn.tuyucheng.taketoday.dynamicquery.repository;

import cn.tuyucheng.taketoday.dynamicquery.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StudentRepository extends JpaRepository<Student, Long>, QuerydslPredicateExecutor<Student>, JpaSpecificationExecutor<Student> {
}