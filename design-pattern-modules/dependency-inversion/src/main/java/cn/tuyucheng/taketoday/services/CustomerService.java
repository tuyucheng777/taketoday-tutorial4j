package cn.tuyucheng.taketoday.services;

import cn.tuyucheng.taketoday.daointerfaces.CustomerDao;
import cn.tuyucheng.taketoday.entities.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerService {

   private final CustomerDao customerDao;

   public CustomerService(CustomerDao customerDao) {
      this.customerDao = customerDao;
   }

   public Optional<Customer> findById(int id) {
      return customerDao.findById(id);
   }

   public List<Customer> findAll() {
      return customerDao.findAll();
   }
}