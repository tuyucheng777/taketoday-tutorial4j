package cn.tuyucheng.taketoday.flyweight;

import java.awt.*;

/**
 * Interface for a vehicle.
 */
public interface Vehicle {

   /**
    * Starts the vehicle.
    */
   void start();

   /**
    * Stops the vehicle.
    */
   void stop();

   /**
    * Gets the color of the vehicle.
    *
    * @return the color of the vehicle
    */
   Color getColor();
}