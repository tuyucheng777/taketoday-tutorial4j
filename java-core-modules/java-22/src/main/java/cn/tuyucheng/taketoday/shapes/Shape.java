package cn.tuyucheng.taketoday.shapes;

public abstract class Shape {
   private int sides;
   private int length;

   Shape(int sides, int length) {
      this.sides = sides;
      this.length = length;
   }

   abstract int getArea();
}