package cn.tuyucheng.taketoday.classorders.orderannotation;

import cn.tuyucheng.taketoday.classorders.TestA;
import cn.tuyucheng.taketoday.classorders.TestB;
import cn.tuyucheng.taketoday.classorders.TestC;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.ClassName.class)
public class ClassNameOrderUnitTest {
   @Nested
   class C extends TestC {
   }

   @Nested
   class B extends TestB {
   }

   @Nested
   class A extends TestA {
   }
}