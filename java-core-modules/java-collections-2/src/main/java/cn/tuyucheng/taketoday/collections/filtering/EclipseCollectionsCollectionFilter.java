package cn.tuyucheng.taketoday.collections.filtering;

import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.utility.Iterate;

import java.util.Collection;

public class EclipseCollectionsCollectionFilter {

   static public Collection<Integer> findEvenNumbers(Collection<Integer> baseCollection) {
      Predicate<Integer> eclipsePredicate = item -> item % 2 == 0;

      return Lists.mutable.ofAll(baseCollection)
            .select(eclipsePredicate);
   }

   static public Collection<Integer> findEvenNumbersUsingIterate(Collection<Integer> baseCollection) {
      Predicate<Integer> eclipsePredicate = new Predicate<Integer>() {
         private static final long serialVersionUID = 1L;

         @Override
         public boolean accept(Integer arg0) {
            return arg0 % 2 == 0;
         }
      };

      return Iterate.select(baseCollection, eclipsePredicate);
   }
}