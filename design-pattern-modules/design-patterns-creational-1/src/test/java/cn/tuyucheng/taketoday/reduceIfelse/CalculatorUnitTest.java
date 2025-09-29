package cn.tuyucheng.taketoday.reduceIfelse;

import cn.tuyucheng.taketoday.reducingIfElse.AddCommand;
import cn.tuyucheng.taketoday.reducingIfElse.Calculator;
import cn.tuyucheng.taketoday.reducingIfElse.Operator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorUnitTest {

   @Test
   public void whenCalculateUsingStringOperator_thenReturnCorrectResult() {
      Calculator calculator = new Calculator();
      int result = calculator.calculate(3, 4, "add");
      assertEquals(7, result);
   }

   @Test
   public void whenCalculateUsingEnumOperator_thenReturnCorrectResult() {
      Calculator calculator = new Calculator();
      int result = calculator.calculate(3, 4, Operator.valueOf("ADD"));
      assertEquals(7, result);
   }

   @Test
   public void whenCalculateUsingCommand_thenReturnCorrectResult() {
      Calculator calculator = new Calculator();
      int result = calculator.calculate(new AddCommand(3, 7));
      assertEquals(10, result);
   }

   @Test
   public void whenCalculateUsingFactory_thenReturnCorrectResult() {
      Calculator calculator = new Calculator();
      int result = calculator.calculateUsingFactory(3, 4, "add");
      assertEquals(7, result);
   }
}