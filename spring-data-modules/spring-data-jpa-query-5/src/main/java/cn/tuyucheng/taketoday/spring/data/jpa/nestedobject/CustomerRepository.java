package cn.tuyucheng.taketoday.spring.data.jpa.nestedobject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}