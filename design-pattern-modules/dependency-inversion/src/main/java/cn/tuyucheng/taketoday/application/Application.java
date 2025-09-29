package cn.tuyucheng.taketoday.application;

import cn.tuyucheng.taketoday.daoimplementations.SimpleCustomerDao;
import cn.tuyucheng.taketoday.entities.Customer;
import cn.tuyucheng.taketoday.services.CustomerService;

import java.util.Map;
import java.util.HashMap;

public class Application {

   public static void main(String[] args) {
      Map<Integer, Customer> customers = new HashMap<>();
      customers.put(1, new Customer("John"));
      customers.put(2, new Customer("Susan"));
      CustomerService customerService = new CustomerService(new SimpleCustomerDao(customers));
      customerService.findAll().forEach(System.out::println);
   }
}