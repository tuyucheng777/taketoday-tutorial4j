package cn.tuyucheng.taketoday.cats.model;

import cn.tuyucheng.taketoday.cats.config.ZeroWidthIntDeserializer;
import cn.tuyucheng.taketoday.cats.config.ZeroWidthStringDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Item {

   @Size(min = 37, max = 37)
   @JsonDeserialize(using = ZeroWidthStringDeserializer.class)
   private String id;

   @NotNull
   @Size(min = 1, max = 20)
   @JsonDeserialize(using = ZeroWidthStringDeserializer.class)
   private String name;

   @Min(1)
   @Max(100)
   @NotNull
   @JsonDeserialize(using = ZeroWidthIntDeserializer.class)
   private int value;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   @Override
   public String toString() {
      return "Item [id=" + id + ", name=" + name + ", value=" + value + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Item other = (Item) obj;
      return Objects.equals(id, other.id);
   }
}