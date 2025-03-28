package cn.tuyucheng.taketoday.map.concurrenthashmap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationErrorUnitTest {

   @Test(expected = ConcurrentModificationException.class)
   public void whenRemoveAndAddOnHashMap_thenConcurrentModificationError() {
      Map<Integer, String> map = new HashMap<>();
      map.put(1, "taketoday");
      map.put(2, "HashMap");
      Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
      Iterator<Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
      while (iterator.hasNext()) {
         synchronizedMap.put(3, "Modification");
         iterator.next();
      }
   }

   @Test(expected = ConcurrentModificationException.class)
   public void whenRemoveAndAddOnTreeMap_thenConcurrentModificationError() {
      Map<Integer, String> map = new TreeMap<>();
      map.put(1, "taketoday");
      map.put(2, "HashMap");
      Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
      Iterator<Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
      while (iterator.hasNext()) {
         synchronizedMap.put(3, "Modification");
         iterator.next();
      }
   }

   @Test(expected = ConcurrentModificationException.class)
   public void whenRemoveAndAddOnLinkedHashMap_thenConcurrentModificationError() {
      Map<Integer, String> map = new LinkedHashMap<>();
      map.put(1, "taketoday");
      map.put(2, "HashMap");
      Map<Integer, String> synchronizedMap = Collections.synchronizedMap(map);
      Iterator<Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
      while (iterator.hasNext()) {
         synchronizedMap.put(3, "Modification");
         iterator.next();
      }
   }

   @Test
   public void whenRemoveAndAddOnConcurrentHashMap_thenNoError() {
      Map<Integer, String> map = new ConcurrentHashMap<>();
      map.put(1, "taketoday");
      map.put(2, "HashMap");
      Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
      while (iterator.hasNext()) {
         map.put(3, "Modification");
         iterator.next();
      }

      Assert.assertEquals(3, map.size());
   }
}