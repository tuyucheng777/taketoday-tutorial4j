package cn.tuyucheng.taketoday.functionpointer;

public class Calculator {
   public int calculate(int a, int b, MathOperation operation) {
      return operation.operate(a, b);
   }
}