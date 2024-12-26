package cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotation;

import jakarta.persistence.Id;

public class EntityWithoutAnnotation {
   @Id
   private Long id;
}