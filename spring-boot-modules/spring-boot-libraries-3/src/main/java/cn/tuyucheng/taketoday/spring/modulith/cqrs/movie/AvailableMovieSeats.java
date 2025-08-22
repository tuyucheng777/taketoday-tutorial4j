package cn.tuyucheng.taketoday.spring.modulith.cqrs.movie;

import org.jmolecules.architecture.cqrs.QueryModel;

import java.time.Instant;
import java.util.List;

@QueryModel
record AvailableMovieSeats(String title, String screenRoom, Instant startTime, List<String> freeSeats) {
}