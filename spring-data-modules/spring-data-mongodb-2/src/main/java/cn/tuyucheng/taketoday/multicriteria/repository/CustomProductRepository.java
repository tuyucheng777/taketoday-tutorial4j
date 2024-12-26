package cn.tuyucheng.taketoday.multicriteria.repository;

import cn.tuyucheng.taketoday.multicriteria.Product;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomProductRepository {
   List<Product> find(Query query, Class<Product> entityClass);
}