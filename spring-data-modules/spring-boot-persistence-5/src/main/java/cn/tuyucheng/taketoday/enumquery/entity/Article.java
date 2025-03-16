package cn.tuyucheng.taketoday.enumquery.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {

   @Id
   @Setter(AccessLevel.NONE)
   private UUID id;

   private String title;

   private String author;

   @Enumerated(EnumType.STRING)
   private ArticleStage stage;

}
