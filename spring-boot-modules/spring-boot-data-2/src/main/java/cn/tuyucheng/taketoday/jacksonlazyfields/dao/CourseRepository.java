package cn.tuyucheng.taketoday.jacksonlazyfields.dao;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import cn.tuyucheng.taketoday.jacksonlazyfields.model.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {

   Set<Course> findAllByDepartmentId(Long id);
}