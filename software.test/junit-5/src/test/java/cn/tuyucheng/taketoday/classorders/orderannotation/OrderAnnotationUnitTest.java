package cn.tuyucheng.taketoday.classorders.orderannotation;

import cn.tuyucheng.taketoday.classorders.TestA;
import cn.tuyucheng.taketoday.classorders.TestB;
import cn.tuyucheng.taketoday.classorders.TestC;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class OrderAnnotationUnitTest {
   @Nested
   @Order(3)
   class A extends TestA {
   }

   @Nested
   @Order(1)
   class B extends TestB {
   }

   @Nested
   @Order(2)
   class C extends TestC {
   }
}