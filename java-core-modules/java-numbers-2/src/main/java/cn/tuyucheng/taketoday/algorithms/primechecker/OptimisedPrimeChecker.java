package cn.tuyucheng.taketoday.algorithms.primechecker;

import java.util.stream.IntStream;

public class OptimisedPrimeChecker implements PrimeChecker<Integer> {

   @Override
   public boolean isPrime(Integer number) {
      return number > 1 ? IntStream.rangeClosed(2, (int) Math.sqrt(number))
            .noneMatch(n -> (number % n == 0)) : false;
   }

}
