package cn.tuyucheng.taketoday.requirenonnull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

class RequireNonNullUnitTest {

   private static final Logger logger = LoggerFactory.getLogger(RequireNonNullUnitTest.class);

   void greet(String name) {
      Objects.requireNonNull(name, "Name cannot be null");
      logger.info("Hello, {}!", name);
   }

   @Test
   void givenObject_whenGreet_thenNoException() {
      Assertions.assertDoesNotThrow(() -> greet("Taketoday"));
   }

   @Test
   void givenNull_whenGreet_thenException() {
      Assertions.assertThrows(NullPointerException.class, () -> greet(null));
   }

   record User(String username, String password) {
         User(String username, String password) {
            this.username = Objects.requireNonNull(username, "Username is null!");
            this.password = Objects.requireNonNull(password, "Password is null!");
         }
      }

   @Test
   void givenValidInput_whenNewUser_thenNoException() {
      Assertions.assertDoesNotThrow(() -> new User("Taketoday", "Secret"));
   }

   @Test
   void givenNull_whenNewUser_thenException() {
      Assertions.assertThrows(NullPointerException.class, () -> new User(null, "Secret"));
      Assertions.assertThrows(NullPointerException.class, () -> new User("Taketoday", null));
   }

   void processOrder(UUID orderId) {
      Objects.requireNonNull(orderId, () -> {
         String message = "Order ID cannot be null! Current timestamp: " + getProcessTimestamp();
         message = message.concat("Total number of invalid orders: " + getOrderAmount());
         message = message.concat("Please provide a valid order.");
         return message;
      });
      logger.info("Processing order with id: {}", orderId);
   }

   private static int getOrderAmount() {
      return new Random().nextInt(100_000);
   }

   private static Instant getProcessTimestamp() {
      return Instant.now();
   }

   @Test
   void givenObject_whenProcessOrder_thenNoException() {
      Assertions.assertDoesNotThrow(() -> processOrder(UUID.randomUUID()));
   }

   @Test
   void givenNull_whenProcessOrder_thenException() {
      Assertions.assertThrows(NullPointerException.class, () -> processOrder(null));
   }
}