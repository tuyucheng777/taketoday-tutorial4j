package cn.tuyucheng.taketoday.exceptions.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IllegalState {

   private static Logger LOGGER = LoggerFactory.getLogger(IllegalState.class);

   public static void main(String[] args) {

      List<Integer> intList = new ArrayList<>();

      for (int i = 0; i < 10; i++) {
         intList.add(i);
      }

      Iterator<Integer> intListIterator = intList.iterator(); // Initialized with index at -1

      try {
         intListIterator.remove(); // IllegalStateException
      } catch (IllegalStateException e) {
         LOGGER.error("IllegalStateException caught!");
      }

   }

}
