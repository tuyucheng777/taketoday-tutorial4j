package cn.tuyucheng.taketoday.boot.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemType {

   @Id
   private Long id;
   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "ITEM_TYPE_ID")
   private List<Item> items = new ArrayList<>();

   private String name;

   public Long getId() {
      return id;
   }

   public List<Item> getItems() {
      return items;
   }

   public String getName() {
      return name;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public void setItems(List<Item> items) {
      this.items = items;
   }

   public void setName(String name) {
      this.name = name;
   }
}
