package cn.tuyucheng.taketoday.exceptions.chainedexception.exceptions;

public class ManagerUpsetException extends Exception {

   public ManagerUpsetException(String message, Throwable cause) {
      super(message, cause);
   }

   public ManagerUpsetException(String message) {
      super(message);
   }
}
