package cn.tuyucheng.taketoday.boot.count.dao;

import cn.tuyucheng.taketoday.boot.count.data.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CarRepository extends MongoRepository<Car, String> {
   @Query(value = "{brand: ?0}", count = true)
   public long countBrand(String brand);

   Long countByBrand(String brand);

   @Query(value = "{}", count = true)
   Long countWithAnnotation();
}