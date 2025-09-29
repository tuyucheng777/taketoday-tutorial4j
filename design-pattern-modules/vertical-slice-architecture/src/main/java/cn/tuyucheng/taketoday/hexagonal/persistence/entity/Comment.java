package cn.tuyucheng.taketoday.hexagonal.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Comment {

   @Id
   private Long id;
}