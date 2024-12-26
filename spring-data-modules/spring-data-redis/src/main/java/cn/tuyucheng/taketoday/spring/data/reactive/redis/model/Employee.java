package cn.tuyucheng.taketoday.spring.data.reactive.redis.model;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee implements Serializable {
   private static final long serialVersionUID = 1603714798906422731L;
   private String id;
   private String name;
   private String department;
}