package cn.tuyucheng.taketoday.arthas;

import java.io.IOException;

public class FibonacciGenerator {

   public static void main(String[] args) throws IOException {
      System.out.println("Press a key to continue");
      System.in.read();
      for (int i = 0; i < 100; i++) {
         long result = fibonacci(i);
         System.out.printf("fib(%d): %d%n", i, result);
      }
   }

   public static long fibonacci(int n) {
      if (n == 0 || n == 1) {
         return 1L;
      } else {
         return fibonacci(n - 1) + fibonacci(n - 2);
      }
   }
}