package cn.tuyucheng.taketoday.hibernate.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.hibernate.entities.Product;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Long> {

}
