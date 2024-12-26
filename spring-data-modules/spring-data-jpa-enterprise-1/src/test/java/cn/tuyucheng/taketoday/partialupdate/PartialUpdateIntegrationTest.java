package cn.tuyucheng.taketoday.partialupdate;

import cn.tuyucheng.taketoday.partialupdate.model.Customer;
import cn.tuyucheng.taketoday.partialupdate.model.CustomerDto;
import cn.tuyucheng.taketoday.partialupdate.model.CustomerStructured;
import cn.tuyucheng.taketoday.partialupdate.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PartialUpdateApplication.class)
public class PartialUpdateIntegrationTest {

   @Autowired
   CustomerService service;

   @Test
   public void givenCustomer_whenUpdate_thenSuccess() {
      Customer myCustomer = service.addCustomer("John");
      myCustomer = service.updateCustomer(myCustomer.id, "+00");
      assertEquals("+00", myCustomer.phone);
   }

   @Test
   public void givenCustomer_whenUpdateWithQuery_thenSuccess() {
      Customer myCustomer = service.addCustomer("John");
      service.updateCustomerWithCustomQuery(myCustomer.id, "+88");
      myCustomer = service.getCustomer(myCustomer.id);
      assertEquals("+88", myCustomer.phone);
   }

   @Test
   public void givenCustomerDto_whenUpdateWithMapper_thenSuccess() {
      CustomerDto dto = new CustomerDto(new Customer());
      dto.name = "Johnny";
      Customer entity = service.addCustomer(dto);

      CustomerDto dto2 = new CustomerDto(entity.id);
      dto2.phone = "+44";
      entity = service.updateCustomer(dto2);

      assertEquals("Johnny", entity.name);
   }

   @Test
   public void givenCustomerStructured_whenUpdateCustomerPhone_thenSuccess() {
      CustomerStructured myCustomer = service.addCustomerStructured("John");
      assertNull(myCustomer.contactPhones);

      service.addCustomerPhone(myCustomer.id, "+44");
      myCustomer = service.updateCustomerStructured(myCustomer.id, "Mr. John");

      assertNotEquals(null, myCustomer.contactPhones);
      assertEquals(1, myCustomer.contactPhones.size());
   }
}