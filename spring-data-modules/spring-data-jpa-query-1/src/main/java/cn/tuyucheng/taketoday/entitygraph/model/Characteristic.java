package cn.tuyucheng.taketoday.entitygraph.model;

import jakarta.persistence.*;

@Entity
public class Characteristic {

   @Id
   private Long id;
   private String type;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn
   private Item item;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public Item getItem() {
      return item;
   }

   public void setItem(Item item) {
      this.item = item;
   }
}