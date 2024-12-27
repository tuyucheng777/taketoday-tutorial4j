package cn.tuyucheng.taketoday.spring.jms;

public record Employee(String name, Integer age) {

   public String toString() {
      return "Employee: name(" + name + "), age(" + age + ")";
   }
}