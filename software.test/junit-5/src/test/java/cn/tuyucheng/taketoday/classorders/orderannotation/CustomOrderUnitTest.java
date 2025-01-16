package cn.tuyucheng.taketoday.classorders.orderannotation;

import cn.tuyucheng.taketoday.classorders.CustomClassOrderer;
import cn.tuyucheng.taketoday.classorders.TestA;
import cn.tuyucheng.taketoday.classorders.TestB;
import cn.tuyucheng.taketoday.classorders.TestC;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(CustomClassOrderer.class)
public class CustomOrderUnitTest {
   @Nested
   class Longest extends TestA {
   }

   @Nested
   class Middle extends TestB {
   }

   @Nested
   class Short extends TestC {
   }
}