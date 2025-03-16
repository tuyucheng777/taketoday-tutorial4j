package cn.tuyucheng.taketoday.spring.data.jpa.joinquery.repositories;

import cn.tuyucheng.taketoday.spring.data.jpa.joinquery.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
