package cn.tuyucheng.taketoday.primitive;

import org.openjdk.jmh.annotations.*;

@State(Scope.Thread)
public class FloatWrapperLookup extends Lookup {
   private Float[] elements;
   private final float pivot = 2;

   @Override
   @Setup
   public void prepare() {
      float common = 1;
      elements = new Float[s];
      for (int i = 0; i < s - 1; i++) {
         elements[i] = common;
      }
      elements[s - 1] = pivot;
   }

   @Override
   @TearDown
   public void clean() {
      elements = null;
   }

   @Override
   @Benchmark
   @BenchmarkMode(Mode.AverageTime)
   public int findPosition() {
      int index = 0;
      Float pivotWrapper = pivot;
      while (!pivotWrapper.equals(elements[index])) {
         index++;
      }
      return index;
   }

   @Override
   public String getSimpleClassName() {
      return FloatWrapperLookup.class.getSimpleName();
   }
}
