package cn.tuyucheng.taketoday.spring.data.noconverterfound.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.spring.data.noconverterfound.models.Employee;
import cn.tuyucheng.taketoday.spring.data.noconverterfound.models.EmployeeFullName;
import cn.tuyucheng.taketoday.spring.data.noconverterfound.models.IEmployeeFullName;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   @Query("SELECT new cn.tuyucheng.taketoday.spring.data.noconverterfound.models.EmployeeFullName(e.firstName, e.lastName) FROM Employee e WHERE e.id = :id")
   EmployeeFullName findEmployeeFullNameById(@Param("id") int id);

   IEmployeeFullName findIEmployeeFullNameById(int id);
}