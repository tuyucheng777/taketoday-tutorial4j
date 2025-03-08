package cn.tuyucheng.taketoday.algorithms.mergeintervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.max;

public class MergeOverlappingIntervals {

   public List<Interval> doMerge(List<Interval> intervals) {
      intervals.sort(Comparator.comparingInt(interval -> interval.start));
      ArrayList<Interval> merged = new ArrayList<>();
      merged.add(intervals.get(0));

      intervals.forEach(interval -> {
         Interval lastMerged = merged.get(merged.size() - 1);
         if (interval.start <= lastMerged.end) {
            lastMerged.setEnd(max(interval.end, lastMerged.end));
         } else {
            merged.add(interval);
         }
      });

      return merged;
   }
}