package cn.tuyucheng.taketoday.reducingIfElse;

public class Modulo implements Operation {
   @Override
   public int apply(int a, int b) {
      return a % b;
   }
}