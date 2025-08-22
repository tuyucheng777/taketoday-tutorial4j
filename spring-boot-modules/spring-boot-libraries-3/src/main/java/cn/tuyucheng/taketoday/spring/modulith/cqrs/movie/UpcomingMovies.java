package cn.tuyucheng.taketoday.spring.modulith.cqrs.movie;

import org.jmolecules.architecture.cqrs.QueryModel;

import java.time.Instant;

@QueryModel
record UpcomingMovies(Long id, String title, Instant startTime) {
}