package cn.tuyucheng.taketoday.security.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompromisedPasswordValidator.class)
public @interface NotCompromised {

   String message() default "The provided password is compromised and cannot be used.";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}