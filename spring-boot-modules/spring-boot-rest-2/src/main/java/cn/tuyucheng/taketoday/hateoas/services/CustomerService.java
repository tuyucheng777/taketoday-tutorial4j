package cn.tuyucheng.taketoday.hateoas.services;

import cn.tuyucheng.taketoday.hateoas.persistence.model.Customer;

import java.util.List;

public interface CustomerService {

   List<Customer> allCustomers();

   Customer getCustomerDetail(final String id);
}