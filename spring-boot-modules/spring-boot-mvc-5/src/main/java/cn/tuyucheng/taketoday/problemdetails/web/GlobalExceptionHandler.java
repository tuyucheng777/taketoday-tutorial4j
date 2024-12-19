package cn.tuyucheng.taketoday.problemdetails.web;

import cn.tuyucheng.taketoday.problemdetails.model.InvalidInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(InvalidInputException.class)
   public ProblemDetail handleInvalidOpException(InvalidInputException e, WebRequest request) {
      final ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
      problemDetail.setInstance(URI.create("discount"));
      return problemDetail;
   }
}