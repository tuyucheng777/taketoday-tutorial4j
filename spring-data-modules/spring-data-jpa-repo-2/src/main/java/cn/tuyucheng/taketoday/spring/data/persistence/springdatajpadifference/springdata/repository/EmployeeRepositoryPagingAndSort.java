package cn.tuyucheng.taketoday.spring.data.persistence.springdatajpadifference.springdata.repository;

import cn.tuyucheng.taketoday.spring.data.persistence.springdatajpadifference.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryPagingAndSort extends JpaRepository<Employee, Long> {

}