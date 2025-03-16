package cn.tuyucheng.taketoday.tomcatconnectionpool.application.repositories;

import cn.tuyucheng.taketoday.tomcatconnectionpool.application.entities.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

   List<Customer> findByLastName(String lastName);
}
