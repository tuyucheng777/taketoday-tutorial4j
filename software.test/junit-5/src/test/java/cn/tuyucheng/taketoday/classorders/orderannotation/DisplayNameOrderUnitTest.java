package cn.tuyucheng.taketoday.classorders.orderannotation;

import cn.tuyucheng.taketoday.classorders.TestA;
import cn.tuyucheng.taketoday.classorders.TestB;
import cn.tuyucheng.taketoday.classorders.TestC;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.DisplayName.class)
public class DisplayNameOrderUnitTest {
   @Nested
   @DisplayName("Class C")
   class Z extends TestC {
   }

   @Nested
   @DisplayName("Class B")
   class A extends TestA {
   }

   @Nested
   @DisplayName("Class A")
   class B extends TestB {
   }
}