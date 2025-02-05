package cn.tuyucheng.taketoday.switchpatterns;

public class GuardedPatterns {

   static double getDoubleValueUsingIf(Object o) {
      return switch (o) {
         case String s -> {
            if (!s.isEmpty()) {
               yield Double.parseDouble(s);
            } else {
               yield 0d;
            }
         }
         default -> 0d;
      };
   }

   static double getDoubleValueUsingGuardedPatterns(Object o) {
      return switch (o) {
         case String s when !s.isEmpty() -> Double.parseDouble(s);
         default -> 0d;
      };
   }
}