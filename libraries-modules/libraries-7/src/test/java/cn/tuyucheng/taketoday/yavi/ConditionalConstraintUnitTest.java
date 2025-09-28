package cn.tuyucheng.taketoday.yavi;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.constraint.CharSequenceConstraint;
import am.ik.yavi.core.ConstraintGroup;
import am.ik.yavi.core.ConstraintViolations;
import am.ik.yavi.core.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConditionalConstraintUnitTest {
   record Person(String id, String name) {
   }

   @Test
   void givenValidatorConditionalOnAction_whenProvidingCreate_thenIdIsNotRequired() {
      Validator<Person> validator = ValidatorBuilder.of(Person.class)
            .constraint(Person::name, "name", CharSequenceConstraint::notBlank)
            .constraintOnCondition(Action.UPDATE.toCondition(),
                  b -> b.constraint(Person::id, "id", CharSequenceConstraint::notBlank))
            .build();

      ConstraintViolations result = validator.validate(new Person(null, "Tuyucheng"), Action.CREATE);
      assertTrue(result.isValid());
   }

   @Test
   void givenValidatorConditionalOnAction_whenProvidingUpdate_thenIdIsRequired() {
      Validator<Person> validator = ValidatorBuilder.of(Person.class)
            .constraint(Person::name, "name", CharSequenceConstraint::notBlank)
            .constraintOnCondition(Action.UPDATE.toCondition(),
                  b -> b.constraint(Person::id, "id", CharSequenceConstraint::notBlank))
            .build();

      ConstraintViolations result = validator.validate(new Person(null, "Tuyucheng"), Action.UPDATE);
      assertFalse(result.isValid());
      assertEquals(1, result.size());
      assertEquals("id", result.get(0).name());
      assertEquals("charSequence.notBlank", result.get(0).messageKey());
   }

   @Test
   void givenValidatorConditionalOnId_whenProvidingNoId_thenNameIsNotRequired() {
      Validator<Person> validator = ValidatorBuilder.of(Person.class)
            .constraintOnCondition((person, ctx) -> person.id() != null,
                  b -> b.constraint(Person::name, "name", CharSequenceConstraint::notBlank))
            .build();

      ConstraintViolations result = validator.validate(new Person(null, null));
      assertTrue(result.isValid());
   }

   enum Action implements ConstraintGroup {
      CREATE,
      UPDATE,
      DELETE
   }
}