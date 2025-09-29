package cn.tuyucheng.taketoday.abstractfactory2;

public class AbstractFactoryRunner {

   static void main() {
      new AnimalAbstractFactory().createAnimal(AnimalType.LAND);
   }
}