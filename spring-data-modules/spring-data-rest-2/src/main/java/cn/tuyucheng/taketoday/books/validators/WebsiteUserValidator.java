package cn.tuyucheng.taketoday.books.validators;

import cn.tuyucheng.taketoday.books.models.WebsiteUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateWebsiteUserValidator")
public class WebsiteUserValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return WebsiteUser.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors errors) {
      WebsiteUser user = (WebsiteUser) obj;
      if (checkInputString(user.getName())) {
         errors.rejectValue("name", "name.empty");
      }

      if (checkInputString(user.getEmail())) {
         errors.rejectValue("email", "email.empty");
      }
   }

   private boolean checkInputString(String input) {
      return (input == null || input.trim().length() == 0);
   }
}