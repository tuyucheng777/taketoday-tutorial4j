package cn.tuyucheng.taketoday.hexagonal.dto;

public record ArticleDto(Long id, String name, String content, String slug) {
}