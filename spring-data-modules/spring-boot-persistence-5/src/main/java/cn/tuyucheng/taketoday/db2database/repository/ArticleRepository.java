package cn.tuyucheng.taketoday.db2database.repository;

import cn.tuyucheng.taketoday.db2database.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}