package cn.tuyucheng.taketoday.caching.twolevelcache;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
}