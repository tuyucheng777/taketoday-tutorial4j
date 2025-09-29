package cn.tuyucheng.taketoday.monkey.patching.reflection;

import cn.tuyucheng.taketoday.monkey.patching.converter.MoneyConverter;
import cn.tuyucheng.taketoday.monkey.patching.converter.MoneyConverterImpl;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionUnitTest {

   @Test
   public void givenPrivateField_whenUsingReflection_thenBehaviorCanBeChanged() throws IllegalAccessException, NoSuchFieldException {
      MoneyConverter moneyConvertor = new MoneyConverterImpl();

      Field conversionRate = MoneyConverterImpl.class.getDeclaredField("conversionRate");
      conversionRate.setAccessible(true);
      conversionRate.set(moneyConvertor, 1.2);
      double result = moneyConvertor.convertEURtoUSD(10);

      assertEquals(12, result);
   }
}