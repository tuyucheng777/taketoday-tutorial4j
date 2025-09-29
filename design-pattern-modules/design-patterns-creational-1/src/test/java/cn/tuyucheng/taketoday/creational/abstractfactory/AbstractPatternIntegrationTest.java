package cn.tuyucheng.taketoday.creational.abstractfactory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractPatternIntegrationTest {
   @Test
   public void givenAbstractFactory_whenGettingObjects_thenSuccessful() {
      AbstractFactory abstractFactory;

      // creating a brown toy dog
      abstractFactory = FactoryProvider.getFactory("Toy");
      Animal toy = (Animal) abstractFactory.create("Dog");

      abstractFactory = FactoryProvider.getFactory("Color");
      Color color = (Color) abstractFactory.create("Brown");

      String result = "A " + toy.getType() + " with " + color.getColor() + " color " + toy.makeSound();
      assertEquals("A Dog with brown color Barks", result);
   }
}