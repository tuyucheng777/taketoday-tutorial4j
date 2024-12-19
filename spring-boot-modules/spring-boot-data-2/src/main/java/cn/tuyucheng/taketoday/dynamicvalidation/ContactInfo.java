package cn.tuyucheng.taketoday.dynamicvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = {ContactInfoValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactInfo {
   String message() default "Invalid value";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}