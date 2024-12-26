package cn.tuyucheng.taketoday.spring.data.keyvalue.services.test;

import cn.tuyucheng.taketoday.spring.data.keyvalue.SpringDataKeyValueApplication;
import cn.tuyucheng.taketoday.spring.data.keyvalue.repositories.EmployeeRepository;
import cn.tuyucheng.taketoday.spring.data.keyvalue.services.EmployeeService;
import cn.tuyucheng.taketoday.spring.data.keyvalue.vo.Employee;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringDataKeyValueApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServicesWithRepositoryIntegrationTest {

   @Autowired
   @Qualifier("employeeServicesWithRepository")
   EmployeeService employeeService;

   @Autowired
   EmployeeRepository employeeRepository;

   static Employee employee1;

   @BeforeClass
   public static void setUp() {
      employee1 = new Employee(1, "Karan", "IT", "5000");
   }

   @Test
   public void test1_whenEmployeeSaved_thenEmployeeIsAddedToMap() {
      employeeService.save(employee1);
      assertEquals(employeeRepository.findById(1).get(), employee1);
   }

   @Test
   public void test2_whenEmployeeGet_thenEmployeeIsReturnedFromMap() {
      Employee employeeFetched = employeeService.get(1).get();
      assertEquals(employeeFetched, employee1);
   }

   @Test
   public void test3_whenEmployeesFetched_thenEmployeesAreReturnedFromMap() {
      List<Employee> employees = (List<Employee>) employeeService.fetchAll();
      assertEquals(1, employees.size());
      assertEquals(employees.get(0), employee1);
   }

   @Test
   public void test4_whenEmployeeUpdated_thenEmployeeIsUpdatedToMap() {
      employee1.setName("Pawan");
      employeeService.update(employee1);
      assertEquals("Pawan", employeeRepository.findById(1).get().getName());
   }

   @Test
   public void test5_whenEmployeeDeleted_thenEmployeeIsRemovedMap() {
      employeeService.delete(1);
      assertFalse(employeeRepository.findById(1).isPresent());
   }
}