package cn.tuyucheng.taketoday.jacksonlazyfields.dao;

import org.springframework.data.repository.CrudRepository;

import cn.tuyucheng.taketoday.jacksonlazyfields.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}