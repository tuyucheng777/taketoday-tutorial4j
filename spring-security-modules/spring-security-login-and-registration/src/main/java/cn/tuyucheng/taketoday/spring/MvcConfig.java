package cn.tuyucheng.taketoday.spring;

import cn.tuyucheng.taketoday.validation.EmailValidator;
import cn.tuyucheng.taketoday.validation.PasswordMatchesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = {"cn.tuyucheng.taketoday.web"})
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

   public MvcConfig() {
      super();
   }

   @Autowired
   private MessageSource messageSource;

   @Override
   public void addViewControllers(final ViewControllerRegistry registry) {
      registry.addViewController("/").setViewName("forward:/login");
      registry.addViewController("/loginRememberMe");
      registry.addViewController("/customLogin");
      registry.addViewController("/registration.html");
      registry.addViewController("/registrationCaptcha.html");
      registry.addViewController("/registrationReCaptchaV3.html");
      registry.addViewController("/logout.html");
      registry.addViewController("/homepage.html");
      registry.addViewController("/expiredAccount.html");
      registry.addViewController("/emailError.html");
      registry.addViewController("/home.html");
      registry.addViewController("/invalidSession.html");
      registry.addViewController("/admin.html");
      registry.addViewController("/successRegister.html");
      registry.addViewController("/forgetPassword.html");
      registry.addViewController("/updatePassword.html");
      registry.addViewController("/changePassword.html");
      registry.addViewController("/users.html");
      registry.addViewController("/qrcode.html");
   }

   @Override
   public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
   }

   @Override
   public void addResourceHandlers(final ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/resources/**").addResourceLocations("/", "/resources/");
   }

   @Override
   public void addInterceptors(final InterceptorRegistry registry) {
      final LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
      localeChangeInterceptor.setParamName("lang");
      registry.addInterceptor(localeChangeInterceptor);
   }

   // beans

   @Bean
   public LocaleResolver localeResolver() {
      final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
      cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
      return cookieLocaleResolver;
   }

   @Bean
   public EmailValidator usernameValidator() {
      return new EmailValidator();
   }

   @Bean
   public PasswordMatchesValidator passwordMatchesValidator() {
      return new PasswordMatchesValidator();
   }

   @Bean
   @ConditionalOnMissingBean(RequestContextListener.class)
   public RequestContextListener requestContextListener() {
      return new RequestContextListener();
   }

   @Override
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource);
      return validator;
   }

   @Bean
   WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
      return (factory) -> factory.setRegisterDefaultServlet(true);
   }
}