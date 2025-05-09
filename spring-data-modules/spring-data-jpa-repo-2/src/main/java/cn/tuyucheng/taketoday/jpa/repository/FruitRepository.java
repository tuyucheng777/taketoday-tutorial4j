package cn.tuyucheng.taketoday.jpa.repository;

import cn.tuyucheng.taketoday.jpa.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

   Long deleteByName(String name);

   List<Fruit> deleteByColor(String color);

   Long removeByName(String name);

   List<Fruit> removeByColor(String color);

   @Modifying
   @Query("delete from Fruit f where f.name=:name or f.color=:color")
   int deleteFruits(@Param("name") String name, @Param("color") String color);
}
