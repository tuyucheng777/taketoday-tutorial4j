package cn.tuyucheng.taketoday.incompatibleclasschange.libraries.original;

import java.util.Objects;

public class Dinosaur {
   public void species(String sp) {
      System.out.println(Objects.requireNonNullElse(sp, "I am a generic Dinosaur"));
   }
}