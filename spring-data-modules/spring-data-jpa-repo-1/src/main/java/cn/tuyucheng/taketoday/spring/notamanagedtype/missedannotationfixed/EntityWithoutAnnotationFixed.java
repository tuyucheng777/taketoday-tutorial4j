package cn.tuyucheng.taketoday.spring.notamanagedtype.missedannotationfixed;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EntityWithoutAnnotationFixed {
   @Id
   private Long id;
}
