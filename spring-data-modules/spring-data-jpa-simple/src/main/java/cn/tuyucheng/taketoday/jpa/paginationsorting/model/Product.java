package cn.tuyucheng.taketoday.jpa.paginationsorting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "products")
public class Product {

   @Id
   private int id;

   private String name;

   private double price;

   public Product() {
      super();
   }

   private Product(int id, String name, double price) {
      super();
      this.id = id;
      this.name = name;
      this.price = price;
   }

   public static Product from(int id, String name, double price) {
      return new Product(id, name, price);
   }

   public int getId() {
      return id;
   }

   public void setId(final int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(final double price) {
      this.price = price;
   }

   @Override
   public String toString() {
      return "Product [name=" +
            name +
            ", id=" +
            id +
            "]";
   }
}