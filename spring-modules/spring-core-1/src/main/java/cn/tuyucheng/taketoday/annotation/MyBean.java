package cn.tuyucheng.taketoday.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

   private final TestBean testBean;

   public MyBean(TestBean testBean) {
      this.testBean = testBean;
      System.out.println("Hello from constructor");
   }

   @PostConstruct
   private void postConstruct() {
      System.out.println("Hello from @PostConstruct method");
   }

   @PreDestroy
   public void preDestroy() {
      System.out.println("Bean is being destroyed");
   }
}