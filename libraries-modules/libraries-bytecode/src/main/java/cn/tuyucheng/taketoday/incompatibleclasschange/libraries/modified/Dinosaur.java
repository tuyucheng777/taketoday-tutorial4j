package cn.tuyucheng.taketoday.incompatibleclasschange.libraries.modified;

import java.util.Objects;

public class Dinosaur {

   /**
    * This is the modified version of the library where the species() method is made static.
    * The original version of the same hierarchy is not static.
    */
   public static void species(String sp) {
      System.out.println(Objects.requireNonNullElse(sp, "I am a generic Dinosaur"));
   }
}