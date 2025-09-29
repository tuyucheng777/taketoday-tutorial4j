package cn.tuyucheng.taketoday.dip.daos;

import cn.tuyucheng.taketoday.dip.entities.Customer;

import java.util.Map;
import java.util.Optional;

public interface CustomerDao {

   Optional<Customer> findById(int id);

   List<Customer> findAll();
}