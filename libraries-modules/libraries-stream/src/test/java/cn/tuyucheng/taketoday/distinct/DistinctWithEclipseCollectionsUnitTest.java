package cn.tuyucheng.taketoday.distinct;

import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.utility.ListIterate;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DistinctWithEclipseCollectionsUnitTest {
   List<Person> personList;

   @Before
   public void init() {
      personList = PersonDataGenerator.getPersonListWithFakeValues();
   }

   @Test
   public void whenFilterListByName_thenSizeShouldBe4() {
      List<Person> personListFiltered = ListIterate.distinct(personList, HashingStrategies.fromFunction(Person::getName));
      assertEquals(4, personListFiltered.size());
   }

   @Test
   public void whenFilterListByAge_thenSizeShouldBe2() {
      List<Person> personListFiltered = ListIterate.distinct(personList, HashingStrategies.fromIntFunction(Person::getAge));
      assertEquals(2, personListFiltered.size());
   }
}