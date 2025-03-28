package cn.tuyucheng.taketoday.hibernate.dirtychecking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.tuyucheng.taketoday.hibernate.dirtychecking.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   Optional<Product> findByCode(String code);
}
