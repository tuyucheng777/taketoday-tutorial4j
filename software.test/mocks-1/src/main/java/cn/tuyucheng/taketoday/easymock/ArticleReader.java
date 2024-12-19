package cn.tuyucheng.taketoday.easymock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArticleReader {

   private List<TuyuchengArticle> articles;
   private Iterator<TuyuchengArticle> articleIter;

   public ArticleReader() {
      this(new ArrayList<>());
   }

   public ArticleReader(List<TuyuchengArticle> articles) {
      this.articles = articles;
      this.articleIter = this.articles.iterator();
   }

   public List<TuyuchengArticle> ofTopic(String topic) {
      return articles
            .stream()
            .filter(article -> article
                  .title()
                  .contains(topic))
            .collect(toList());
   }

   public TuyuchengArticle next() {
      return this.articleIter.next();
   }
}