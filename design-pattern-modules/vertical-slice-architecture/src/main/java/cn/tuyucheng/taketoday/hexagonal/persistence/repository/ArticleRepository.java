package cn.tuyucheng.taketoday.hexagonal.persistence.repository;

import cn.tuyucheng.taketoday.hexagonal.persistence.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
   Optional<Article> findBySlug(String slug);
}