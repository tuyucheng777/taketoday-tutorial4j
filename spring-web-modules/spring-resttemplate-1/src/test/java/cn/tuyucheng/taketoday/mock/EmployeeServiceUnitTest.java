package cn.tuyucheng.taketoday.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cn.tuyucheng.taketoday.resttemplate.web.model.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {

   @Mock
   private RestTemplate restTemplate;

   @InjectMocks
   private EmployeeService empService = new EmployeeService();

   @Test
   public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() throws Exception {
      Employee emp = new Employee("E001", "Eric Simmons");
      Mockito.when(restTemplate.getForEntity("http://localhost:8080/employee/E001", Employee.class))
            .thenReturn(new ResponseEntity(emp, HttpStatus.OK));

      Employee employee = empService.getEmployee("E001");

      assertEquals(emp, employee);
   }
}