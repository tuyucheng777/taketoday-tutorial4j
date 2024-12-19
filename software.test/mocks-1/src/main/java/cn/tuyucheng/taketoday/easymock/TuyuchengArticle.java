package cn.tuyucheng.taketoday.easymock;

public class TuyuchengArticle {

   public static TuyuchengArticle simpleArticle(String title, String content) {
      return new TuyuchengArticle(title, content);
   }

   private String title;
   private String content;

   private TuyuchengArticle(String title, String content) {
      this.title = title;
      this.content = content;
   }

   public String title() {
      return this.title;
   }

   public String content() {
      return this.content;
   }
}