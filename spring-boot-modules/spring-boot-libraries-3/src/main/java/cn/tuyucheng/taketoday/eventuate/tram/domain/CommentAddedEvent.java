package cn.tuyucheng.taketoday.eventuate.tram.domain;

import io.eventuate.tram.events.common.DomainEvent;

record CommentAddedEvent(Long id, String articleSlug) implements DomainEvent {
}