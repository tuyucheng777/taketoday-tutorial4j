package cn.tuyucheng.taketoday.spring.modulith.externalization;

import org.springframework.modulith.events.Externalized;

@Externalized("tuyucheng.article.published::#{slug()}")
public record ArticlePublishedEvent(String slug, String title) {
}