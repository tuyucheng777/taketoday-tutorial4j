package cn.tuyucheng.taketoday.apache.bval.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = {PasswordValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
   String message() default "Invalid password";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

   int length() default 6;

   int nonAlpha() default 1;
}