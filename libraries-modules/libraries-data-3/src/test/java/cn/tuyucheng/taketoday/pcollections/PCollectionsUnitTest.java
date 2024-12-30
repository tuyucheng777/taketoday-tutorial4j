package cn.tuyucheng.taketoday.pcollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.pcollections.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PCollectionsUnitTest {

   @Test
   public void whenEmpty_thenCreateEmptyHashPMap() {
      HashPMap<String, String> pmap = HashTreePMap.empty();
      assertEquals(0, pmap.size());
   }

   @Test
   public void givenKeyValue_whenSingleton_thenCreateNonEmptyHashPMap() {
      HashPMap<String, String> pmap1 = HashTreePMap.singleton("key1", "value1");
      assertEquals(1, pmap1.size());
   }

   @Test
   public void givenExistingHashMap_whenFrom_thenCreateHashPMap() {
      Map<String, String> map = new HashMap<>();
      map.put("mkey1", "mval1");
      map.put("mkey2", "mval2");

      HashPMap<String, String> pmap2 = HashTreePMap.from(map);
      assertEquals(2, pmap2.size());
   }

   @Test
   public void whenHashPMapMethods_thenPerformOperations() {
      HashPMap<String, String> pmap = HashTreePMap.empty();
      HashPMap<String, String> pmap0 = pmap.plus("key1", "value1");

      Map<String, String> map = new HashMap<>();
      map.put("key2", "val2");
      map.put("key3", "val3");

      HashPMap<String, String> pmap1 = pmap0.plusAll(map);
      HashPMap<String, String> pmap2 = pmap1.minus("key1");
      HashPMap<String, String> pmap3 = pmap2.minusAll(map.keySet());

      assertEquals(1, pmap0.size());
      assertEquals(3, pmap1.size());
      Assertions.assertFalse(pmap2.containsKey("key1"));
      assertEquals(0, pmap3.size());
   }

   @Test
   public void whenTreePVectorMethods_thenPerformOperations() {
      TreePVector<String> pVector = TreePVector.empty();

      TreePVector<String> pV1 = pVector.plus("e1");
      TreePVector<String> pV2 = pV1.plusAll(Arrays.asList("e2", "e3", "e4"));

      assertEquals(1, pV1.size());
      assertEquals(4, pV2.size());

      TreePVector<String> pV3 = pV2.minus("e1");
      TreePVector<String> pV4 = pV3.minusAll(Arrays.asList("e2", "e3", "e4"));

      assertEquals(3, pV3.size());
      assertEquals(0, pV4.size());

      TreePVector<String> pSub = pV2.subList(0, 2);
      Assertions.assertTrue(pSub.contains("e1") && pSub.contains("e2"));

      PVector<String> pVW = pV2.with(0, "e10");
      assertEquals("e10", pVW.get(0));
   }

   @Test
   public void whenMapPSetMethods_thenPerformOperations() {
      MapPSet pSet = HashTreePSet.empty().plusAll(Arrays.asList("e1", "e2", "e3", "e4"));
      assertEquals(4, pSet.size());

      MapPSet pSet1 = pSet.minus("e4");
      Assertions.assertFalse(pSet1.contains("e4"));
   }
}