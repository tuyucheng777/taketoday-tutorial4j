package cn.tuyucheng.taketoday.yavi;

import am.ik.yavi.arguments.Arguments1;
import am.ik.yavi.arguments.Arguments2;
import am.ik.yavi.arguments.Arguments2Validator;
import am.ik.yavi.builder.ArgumentsValidatorBuilder;
import am.ik.yavi.constraint.CharSequenceConstraint;
import am.ik.yavi.constraint.base.NumericConstraintBase;
import am.ik.yavi.core.Validated;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ArgumentsValidatorUnitTest {
   record Person(String name, int age) {

      boolean isOlderThan(int check) {
         return this.age() > check;
      }
   }

   @Test
   void givenAConstructorValidator_whenCalledWithInvalidArguments_thenNothingIsConstructed() {
      Arguments2Validator<String, Integer, Person> validator = ArgumentsValidatorBuilder.of(Person::new)
            .builder(b -> b
                  ._string(Arguments1::arg1, "name", CharSequenceConstraint::notBlank)
                  ._integer(Arguments2::arg2, "age", NumericConstraintBase::positiveOrZero)
            )
            .build();

      Validated<Person> result = validator.validate("", -1);
      assertFalse(result.isValid());
      assertEquals(2, result.errors().size());
      assertEquals("name", result.errors().get(0).name());
      assertEquals("charSequence.notBlank", result.errors().get(0).messageKey());
      assertEquals("age", result.errors().get(1).name());
      assertEquals("numeric.positiveOrZero", result.errors().get(1).messageKey());

      assertThrows(NoSuchElementException.class, result::value);
   }

   @Test
   void givenAConstructorValidator_whenCalledWithValidArguments_thenSomethingIsConstructed() {
      Arguments2Validator<String, Integer, Person> validator = ArgumentsValidatorBuilder.of(Person::new)
            .builder(b -> b
                  ._string(Arguments1::arg1, "name", CharSequenceConstraint::notBlank)
                  ._integer(Arguments2::arg2, "age", NumericConstraintBase::positiveOrZero)
            )
            .build();

      Validated<Person> result = validator.validate("Tuyucheng", 42);
      assertTrue(result.isValid());
      Person person = result.value();
      assertEquals("Tuyucheng", person.name());
      assertEquals(42, person.age());
   }

   @Test
   void givenAMethodValidator_whenCalledWithValidArguments_thenSomethingIsDone() {
      Arguments2Validator<Person, Integer, Boolean> validator = ArgumentsValidatorBuilder.of(Person::isOlderThan)
            .builder(b -> b
                  ._integer(Arguments2::arg2, "age", NumericConstraintBase::positiveOrZero)
            )
            .build();

      Person person = new Person("Tuyucheng", 42);

      Validated<Boolean> result = validator.validate(person, 50);
      assertTrue(result.isValid());
      assertEquals(Boolean.FALSE, result.value());
   }

   @Test
   void givenAMethodValidator_whenCalledWithInvalidArguments_thenNothingIsDone() {
      Arguments2Validator<Person, Integer, Boolean> validator = ArgumentsValidatorBuilder.of(Person::isOlderThan)
            .builder(b -> b
                  ._integer(Arguments2::arg2, "age", NumericConstraintBase::positiveOrZero)
            )
            .build();

      Person person = new Person("Tuyucheng", 42);
      Validated<Boolean> result = validator.validate(person, -1);
      assertFalse(result.isValid());
      assertEquals(1, result.errors().size());
      assertEquals("age", result.errors().get(0).name());
      assertEquals("numeric.positiveOrZero", result.errors().get(0).messageKey());

      assertThrows(NoSuchElementException.class, result::value);
   }
}