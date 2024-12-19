package cn.tuyucheng.taketoday.problemdetails.model;

public class InvalidInputException extends RuntimeException {

   public InvalidInputException(String s) {
      super(s);
   }
}