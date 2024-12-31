package cn.tuyucheng.taketoday.micronaut.globalexceptionhandler.error;

public class CustomChildException extends CustomException {
   public CustomChildException(String message) {
      super(message);
   }
}