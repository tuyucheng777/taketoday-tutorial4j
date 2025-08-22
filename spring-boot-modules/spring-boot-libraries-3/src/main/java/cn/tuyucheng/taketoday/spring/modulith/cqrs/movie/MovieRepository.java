package cn.tuyucheng.taketoday.spring.modulith.cqrs.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

interface MovieRepository extends JpaRepository<Movie, Long> {

   List<UpcomingMovies> findUpcomingMoviesByStartTimeBetween(Instant start, Instant end);

   default Optional<AvailableMovieSeats> findAvailableSeatsByMovieId(Long movieId) {
      return findById(movieId).map(movie -> new AvailableMovieSeats(movie.title(), movie.screenRoom(), movie.startTime(), movie.freeSeats()));
   }
}