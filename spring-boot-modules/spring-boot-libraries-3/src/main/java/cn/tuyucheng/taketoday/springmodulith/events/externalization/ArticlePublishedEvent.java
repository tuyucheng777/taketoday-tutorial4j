package cn.tuyucheng.taketoday.springmodulith.events.externalization;

import org.springframework.modulith.events.Externalized;

@Externalized("taketoday.article.published::#{slug()}")
public record ArticlePublishedEvent(String slug, String title) {
}