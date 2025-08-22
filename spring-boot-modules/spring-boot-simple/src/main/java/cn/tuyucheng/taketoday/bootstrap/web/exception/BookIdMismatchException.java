package cn.tuyucheng.taketoday.bootstrap.web.exception;

public class BookIdMismatchException extends RuntimeException {

   public BookIdMismatchException() {
      super();
   }

   public BookIdMismatchException(final String message, final Throwable cause) {
      super(message, cause);
   }

   public BookIdMismatchException(final String message) {
      super(message);
   }

   public BookIdMismatchException(final Throwable cause) {
      super(cause);
   }
}