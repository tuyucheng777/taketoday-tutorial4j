package cn.tuyucheng.taketoday.boot.atlassearch.web;

import cn.tuyucheng.taketoday.boot.atlassearch.service.MovieAtlasSearchService;
import com.mongodb.client.model.search.SearchScore;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.mongodb.client.model.search.SearchPath.fieldPath;

@RestController
@RequestMapping("/movies")
public class MovieAtlasSearchController {

   @Autowired
   private MovieAtlasSearchService service;

   @GetMapping("with/{keywords}")
   Collection<Document> getMoviesWithKeywords(@PathVariable String keywords) {
      return service.moviesByKeywords(keywords);
   }

   @GetMapping("90s/with/{keywords}/count")
   Document getCount90sMoviesWithKeywords(@PathVariable String keywords) {
      return service.countLate90sMovies(keywords);
   }

   @GetMapping("90s/{skip}/{limit}/with/{keywords}")
   Document getMoviesUsingScoreBoost(@PathVariable int skip, @PathVariable int limit, @PathVariable String keywords) {
      return service.late90sMovies(skip, limit, keywords, SearchScore.boost(fieldPath("imdb.votes")));
   }

   @PostMapping("90s/{skip}/{limit}/with/{keywords}")
   Document getMoviesUsingScoringFunction(@RequestBody String jsonFunction, @PathVariable int skip, @PathVariable int limit, @PathVariable String keywords) {
      return service.late90sMovies(skip, limit, keywords, SearchScore.of(new Document("function", Document.parse(jsonFunction))));
   }

   @GetMapping("by-genre/{genre}")
   Document getMoviesWithFacets(@PathVariable String genre) {
      return service.genresThroughTheDecades(genre);
   }
}