package cn.tuyucheng.taketoday.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * Represents a car. This class is immutable.
 */
public class Car implements Vehicle {

   /**
    * Logger.
    */
   private final static Logger LOG = LoggerFactory.getLogger(Car.class);

   /**
    * The car's engine.
    */
   private Engine engine;

   /**
    * The car's color.
    */
   private Color color;

   /**
    * Instantiates a new Car.
    *
    * @param engine the {@link #engine}
    * @param color  the {@link #color}
    */
   public Car(Engine engine, Color color) {
      this.engine = engine;
      this.color = color;

      // Building a new car is a very expensive operation!
      try {
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         LOG.error("Error while creating a new car", e);
      }
   }

   /*
    * (non-Javadoc)
    *
    * @see cn.tuyucheng.taketoday.flyweight.Vehicle#start()
    */
   @Override
   public void start() {
      LOG.info("Car is starting!");
      engine.start();
   }

   /*
    * (non-Javadoc)
    *
    * @see cn.tuyucheng.taketoday.flyweight.Vehicle#stop()
    */
   @Override
   public void stop() {
      LOG.info("Car is stopping!");
      engine.stop();
   }

   /*
    * (non-Javadoc)
    *
    * @see cn.tuyucheng.taketoday.flyweight.Vehicle#getColor()
    */
   @Override
   public Color getColor() {
      return this.color;
   }
}