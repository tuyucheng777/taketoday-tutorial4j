package cn.tuyucheng.taketoday.boot.unique.field.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.tuyucheng.taketoday.boot.unique.field.data.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByStoreIdAndNumber(Long storeId, Long number);
}
