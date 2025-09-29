package cn.tuyucheng.taketoday.daointerfaces;

import cn.tuyucheng.taketoday.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

   Optional<Customer> findById(int id);

   List<Customer> findAll();
}