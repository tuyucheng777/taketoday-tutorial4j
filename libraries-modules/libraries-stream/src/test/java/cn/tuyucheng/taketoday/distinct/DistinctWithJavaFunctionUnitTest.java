package cn.tuyucheng.taketoday.distinct;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static cn.tuyucheng.taketoday.distinct.DistinctWithJavaFunction.distinctByKey;
import static org.junit.Assert.assertEquals;

public class DistinctWithJavaFunctionUnitTest {
   List<Person> personList;

   @Before
   public void init() {
      personList = PersonDataGenerator.getPersonListWithFakeValues();
   }

   @Test
   public void whenFilterListByName_thenSizeShouldBe4() {
      List<Person> personListFiltered = personList.stream().filter(distinctByKey(Person::getName)).toList();
      assertEquals(4, personListFiltered.size());
   }

   @Test
   public void whenFilterListByAge_thenSizeShouldBe2() {
      List<Person> personListFiltered = personList.stream().filter(distinctByKey(Person::getAge)).toList();
      assertEquals(2, personListFiltered.size());
   }

   @Test
   public void whenFilterListWithDefaultDistinct_thenSizeShouldBe5() {
      List<Person> personListFiltered = personList.stream().distinct().toList();
      assertEquals(5, personListFiltered.size());
   }
}