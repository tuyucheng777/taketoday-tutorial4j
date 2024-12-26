package cn.tuyucheng.taketoday.multicriteria.repository;

import cn.tuyucheng.taketoday.multicriteria.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>, QuerydslPredicateExecutor<Product> {
   @org.springframework.data.mongodb.repository.Query("{ 'name': ?0, 'price': { $gt: ?1 }, 'category': ?2, 'available': ?3 }")
   List<Product> findProductsByNamePriceCategoryAndAvailability(String name, double minPrice, String category, boolean available);

   @org.springframework.data.mongodb.repository.Query("{ $or: [ { 'category': ?0, 'available': ?1 }, { 'price': { $gt: ?2 } } ] }")
   List<Product> findProductsByCategoryAndAvailabilityOrPrice(String category, boolean available, double minPrice);
}