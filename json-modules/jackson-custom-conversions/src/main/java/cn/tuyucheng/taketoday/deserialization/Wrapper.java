package cn.tuyucheng.taketoday.deserialization;

public class Wrapper<T> {

   T value;

   public T getValue() {
      return value;
   }

   public void setValue(T value) {
      this.value = value;
   }

}
