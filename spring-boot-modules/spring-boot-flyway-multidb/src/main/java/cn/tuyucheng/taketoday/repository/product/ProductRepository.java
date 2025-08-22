package cn.tuyucheng.taketoday.repository.product;

import cn.tuyucheng.taketoday.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}