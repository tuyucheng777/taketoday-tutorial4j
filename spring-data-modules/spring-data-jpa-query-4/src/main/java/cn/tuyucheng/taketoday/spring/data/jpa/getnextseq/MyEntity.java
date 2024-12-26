package cn.tuyucheng.taketoday.spring.data.jpa.getnextseq;

import jakarta.persistence.*;

@Entity
public class MyEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mySeqGen")
   @SequenceGenerator(name = "mySeqGen", sequenceName = "my_sequence_name", allocationSize = 1)
   private Long id;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }
}