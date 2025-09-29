package cn.tuyucheng.taketoday.verticalslices.events;

public record ArticleCreatedEvent(String slug, String name, String category) {
}