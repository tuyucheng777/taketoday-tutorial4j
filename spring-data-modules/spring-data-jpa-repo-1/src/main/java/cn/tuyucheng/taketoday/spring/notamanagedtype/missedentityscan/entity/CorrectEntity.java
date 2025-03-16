package cn.tuyucheng.taketoday.spring.notamanagedtype.missedentityscan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CorrectEntity {
   @Id
   private Long id;
}
