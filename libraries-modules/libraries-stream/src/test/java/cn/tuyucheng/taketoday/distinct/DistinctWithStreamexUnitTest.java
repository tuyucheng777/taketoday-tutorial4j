package cn.tuyucheng.taketoday.distinct;

import one.util.streamex.StreamEx;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DistinctWithStreamexUnitTest {
   List<Person> personList;

   @Before
   public void init() {
      personList = PersonDataGenerator.getPersonListWithFakeValues();
   }

   @Test
   public void whenFilterListByName_thenSizeShouldBe4() {
      List<Person> personListFiltered = StreamEx.of(personList).distinct(Person::getName).toList();
      assertEquals(4, personListFiltered.size());
   }

   @Test
   public void whenFilterListByAge_thenSizeShouldBe2() {
      List<Person> personListFiltered = StreamEx.of(personList).distinct(Person::getAge).toList();
      assertEquals(2, personListFiltered.size());
   }
}