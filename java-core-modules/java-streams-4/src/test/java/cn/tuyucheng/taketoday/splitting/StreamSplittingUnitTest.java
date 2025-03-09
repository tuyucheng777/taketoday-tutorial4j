package cn.tuyucheng.taketoday.splitting;

import com.google.common.collect.Lists;
import org.junit.Test;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamSplittingUnitTest {
   private final static List<Article> articles = Lists.newArrayList(
         new Article("Taketoday", true),
         new Article("Taketoday", false),
         new Article("Programming Daily", false),
         new Article("The Code", false)
   );

   @Test
   public void givenListOfArticles_shouldSplitListInTwoCategories_usingPartitioningBy() {
      Map<Boolean, List<Article>> groupedArticles = articles.stream().collect(Collectors.partitioningBy(a -> a.getTarget().equals("Taketoday")));

      assertThat(groupedArticles.get(true)).containsExactly(
            new Article("Taketoday", true),
            new Article("Taketoday", false));
      assertThat(groupedArticles.get(false)).containsExactly(
            new Article("Programming Daily", false),
            new Article("The Code", false));
   }

   @Test
   public void givenListOfArticles_shouldSplitListInMultipleCategories_usingGroupingBy() {
      Map<String, List<Article>> groupedArticles = articles.stream().collect(Collectors.groupingBy(Article::getTarget));

      assertThat(groupedArticles.get("Taketoday")).hasSize(2);
      assertThat(groupedArticles.get("Programming Daily")).hasSize(1);
      assertThat(groupedArticles.get("The Code")).hasSize(1);

      assertThat(groupedArticles.get("Taketoday")).containsExactly(
            new Article("Taketoday", true),
            new Article("Taketoday", false));
      assertThat(groupedArticles.get("Programming Daily")).containsExactly(new Article("Programming Daily", false));
      assertThat(groupedArticles.get("The Code")).containsExactly(new Article("The Code", false));
   }

   @Test
   public void givenListOfArticles_shouldSplitListInTwoCategories_usingTeeing() {
      List<Long> countedArticles = articles.stream().collect(Collectors.teeing(
            Collectors.filtering(article -> article.getTarget().equals("Taketoday"), Collectors.counting()),
            Collectors.filtering(article -> !article.getTarget().equals("Taketoday"), Collectors.counting()),
            List::of));

      assertThat(countedArticles.get(0)).isEqualTo(2);
      assertThat(countedArticles.get(1)).isEqualTo(2);
   }

   @Test
   public void givenListOfArticles_shouldSplitListInTwoOVerlappingCategories_usingTeeing() {
      List<List<Article>> groupedArticles = articles.stream().collect(Collectors.teeing(
            Collectors.filtering(article -> article.getTarget().equals("Taketoday"), Collectors.toList()),
            Collectors.filtering(Article::isFeatured, Collectors.toList()),
            List::of));

      assertThat(groupedArticles.get(0)).hasSize(2);
      assertThat(groupedArticles.get(1)).hasSize(1);

      assertThat(groupedArticles.get(0)).containsExactly(
            new Article("Taketoday", true),
            new Article("Taketoday", false));
      assertThat(groupedArticles.get(1)).containsExactly(new Article("Taketoday", true));
   }

   @Test
   public void givenListOfArticles_shouldSplitStreamInMultipleCategories_usingRxJava() {
      Observable<Article> observableArticles = Observable.from(articles);

      Observable<Article> taketodayObservable = observableArticles.filter(article -> article.getTarget().equals("Taketoday"));
      Observable<Article> featuredObservable = observableArticles.filter(Article::isFeatured);
      List<Article> taketodayArticles = new ArrayList<>();
      List<Article> featuredArticles = new ArrayList<>();
      taketodayObservable.subscribe(taketodayArticles::add);
      featuredObservable.subscribe(featuredArticles::add);

      assertThat(taketodayArticles).hasSize(2);
      assertThat(featuredArticles).hasSize(1);

      assertThat(taketodayArticles).containsExactly(
            new Article("Taketoday", true),
            new Article("Taketoday", false));
      assertThat(featuredArticles).containsExactly(new Article("Taketoday", true));
   }
}