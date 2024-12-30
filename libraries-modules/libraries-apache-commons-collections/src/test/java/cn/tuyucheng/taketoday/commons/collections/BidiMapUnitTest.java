package cn.tuyucheng.taketoday.commons.collections;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BidiMapUnitTest {

   @Test
   public void givenKeyValue_whenPut_thenAddEntryToMap() {
      BidiMap<String, String> map = new DualHashBidiMap<>();
      map.put("key1", "value1");
      map.put("key2", "value2");
      assertEquals(2, map.size());
   }

   @Test
   public void whenInverseBidiMap_thenInverseKeyValue() {
      BidiMap<String, String> map = new DualHashBidiMap<>();
      map.put("key1", "value1");
      map.put("key2", "value2");
      BidiMap<String, String> rMap = map.inverseBidiMap();
      assertTrue(rMap.containsKey("value1") && rMap.containsKey("value2"));
   }

   @Test
   public void givenValue_whenRemoveValue_thenRemoveMatchingMapEntry() {
      BidiMap<String, String> map = new DualHashBidiMap<>();
      map.put("key1", "value1");
      map.put("key2", "value2");
      map.removeValue("value2");
      assertFalse(map.containsKey("key2"));
   }

   @Test
   public void givenValue_whenGetKey_thenMappedKey() {
      BidiMap<String, String> map = new DualHashBidiMap<>();
      map.put("key1", "value1");
      assertEquals("key1", map.getKey("value1"));
   }

   @Test
   public void givenKeyValue_whenAddValue_thenReplaceFirstKey() {
      BidiMap<String, String> map = new DualHashBidiMap<>();
      map.put("key1", "value1");
      map.put("key2", "value1");
      assertEquals(1, map.size());
      assertFalse(map.containsKey("key1"));
   }
}