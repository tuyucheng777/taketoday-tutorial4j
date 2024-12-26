package cn.tuyucheng.taketoday.spring.data.noconverterfound.repositories;

import cn.tuyucheng.taketoday.spring.data.noconverterfound.models.Employee;
import cn.tuyucheng.taketoday.spring.data.noconverterfound.models.EmployeeFullName;
import cn.tuyucheng.taketoday.spring.data.noconverterfound.models.IEmployeeFullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   EmployeeFullName findEmployeeFullNameById(int id);

   IEmployeeFullName findIEmployeeFullNameById(int id);
}