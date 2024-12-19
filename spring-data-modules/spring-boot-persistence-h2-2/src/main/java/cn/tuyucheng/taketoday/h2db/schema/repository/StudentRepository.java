package cn.tuyucheng.taketoday.h2db.schema.repository;

import cn.tuyucheng.taketoday.h2db.schema.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}