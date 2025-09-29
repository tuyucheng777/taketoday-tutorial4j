package cn.tuyucheng.taketoday.reduceIfelse;

import cn.tuyucheng.taketoday.reducingIfElse.Expression;
import cn.tuyucheng.taketoday.reducingIfElse.Operator;
import cn.tuyucheng.taketoday.reducingIfElse.Result;
import cn.tuyucheng.taketoday.reducingIfElse.RuleEngine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RuleEngineUnitTest {

   @Test
   public void whenNumbersGivenToRuleEngine_thenReturnCorrectResult() {
      Expression expression = new Expression(5, 5, Operator.ADD);
      RuleEngine engine = new RuleEngine();
      Result result = engine.process(expression);

      assertNotNull(result);
      assertEquals(10, result.getValue());
   }
}