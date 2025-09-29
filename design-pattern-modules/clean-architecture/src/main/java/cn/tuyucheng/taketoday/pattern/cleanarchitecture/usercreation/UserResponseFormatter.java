package cn.tuyucheng.taketoday.pattern.cleanarchitecture.usercreation;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class UserResponseFormatter implements UserPresenter {

   @Override
   public UserResponseModel prepareSuccessView(UserResponseModel response) {
      LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
      response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
      return response;
   }

   @Override
   public UserResponseModel prepareFailView(String error) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, error);
   }
}