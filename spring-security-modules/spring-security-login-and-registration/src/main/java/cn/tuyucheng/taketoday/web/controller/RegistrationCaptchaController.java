package cn.tuyucheng.taketoday.web.controller;

import cn.tuyucheng.taketoday.captcha.CaptchaServiceV3;
import cn.tuyucheng.taketoday.captcha.ICaptchaService;
import cn.tuyucheng.taketoday.persistence.model.User;
import cn.tuyucheng.taketoday.registration.OnRegistrationCompleteEvent;
import cn.tuyucheng.taketoday.service.IUserService;
import cn.tuyucheng.taketoday.web.dto.UserDto;
import cn.tuyucheng.taketoday.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class RegistrationCaptchaController {
   private final Logger LOGGER = LoggerFactory.getLogger(getClass());

   @Autowired
   private IUserService userService;

   @Autowired
   private ICaptchaService captchaService;

   @Autowired
   private ICaptchaService captchaServiceV3;

   @Autowired
   private ApplicationEventPublisher eventPublisher;

   public RegistrationCaptchaController() {
      super();
   }

   // Registration
   @PostMapping("/user/registrationCaptcha")
   public GenericResponse captchaRegisterUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {

      final String response = request.getParameter("g-recaptcha-response");
      captchaService.processResponse(response);

      return registerNewUserHandler(accountDto, request);
   }


   // Registration reCaptchaV3
   @PostMapping("/user/registrationCaptchaV3")
   public GenericResponse captchaV3RegisterUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {

      final String response = request.getParameter("response");
      captchaServiceV3.processResponse(response, CaptchaServiceV3.REGISTER_ACTION);

      return registerNewUserHandler(accountDto, request);
   }

   private GenericResponse registerNewUserHandler(final UserDto accountDto, final HttpServletRequest request) {
      LOGGER.debug("Registering user account with information: {}", accountDto);

      final User registered = userService.registerNewUserAccount(accountDto);
      eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
      return new GenericResponse("success");
   }


   private String getAppUrl(HttpServletRequest request) {
      return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
   }

}
