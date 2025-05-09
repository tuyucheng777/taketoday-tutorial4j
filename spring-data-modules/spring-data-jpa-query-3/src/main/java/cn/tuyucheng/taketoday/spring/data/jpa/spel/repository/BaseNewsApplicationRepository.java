package cn.tuyucheng.taketoday.spring.data.jpa.spel.repository;

import cn.tuyucheng.taketoday.spring.data.jpa.spel.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseNewsApplicationRepository<T, I> extends JpaRepository<T, I> {

   @Query(value = "select e from #{#entityName} e")
   List<Article> findAllEntitiesUsingEntityPlaceholder();

   @Query(value = "SELECT * FROM #{#entityName}", nativeQuery = true)
   List<Article> findAllEntitiesUsingEntityPlaceholderWithNativeQuery();
}