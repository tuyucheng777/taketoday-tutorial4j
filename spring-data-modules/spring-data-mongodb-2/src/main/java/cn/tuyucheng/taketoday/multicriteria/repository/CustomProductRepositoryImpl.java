package cn.tuyucheng.taketoday.multicriteria.repository;

import cn.tuyucheng.taketoday.multicriteria.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {

   @Autowired
   private MongoTemplate mongoTemplate;

   @Override
   public List<Product> find(Query query, Class<Product> entityClass) {
      return mongoTemplate.find(query, entityClass);
   }
}