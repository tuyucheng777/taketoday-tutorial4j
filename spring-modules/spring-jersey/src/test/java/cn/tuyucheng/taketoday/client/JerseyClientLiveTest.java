package cn.tuyucheng.taketoday.client;

import cn.tuyucheng.taketoday.client.rest.RestClient;
import cn.tuyucheng.taketoday.server.model.Employee;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class JerseyClientLiveTest {

   public static final int HTTP_CREATED = 201;

   private RestClient client = new RestClient();

   @Test
   public void givenCorrectObject_whenCorrectJsonRequest_thenResponseCodeCreated() {
      Employee emp = new Employee(6, "Johny");

      Response response = client.createJsonEmployee(emp);

      assertEquals(HTTP_CREATED, response.getStatus());
   }

   @Test
   public void givenCorrectObject_whenCorrectXmlRequest_thenResponseCodeCreated() {
      Employee emp = new Employee(7, "Jacky");

      Response response = client.createXmlEmployee(emp);

      assertEquals(HTTP_CREATED, response.getStatus());
   }

   @Test
   public void givenCorrectId_whenCorrectJsonRequest_thenCorrectEmployeeRetrieved() {
      int employeeId = 1;

      Employee emp = client.getJsonEmployee(employeeId);

      assertEquals("Jane", emp.getFirstName());
   }

   @Test
   public void givenCorrectId_whenCorrectXmlRequest_thenCorrectEmployeeRetrieved() {
      int employeeId = 1;

      Employee emp = client.getXmlEmployee(employeeId);

      assertEquals("Jane", emp.getFirstName());
   }
}