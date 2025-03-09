package cn.tuyucheng.taketoday.spring.cloud.bootstrap.svcrating.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

   @Autowired
   private RatingService ratingService;

   @GetMapping
   public List<Rating> findRatingsByBookId(@RequestParam(required = false, name = "bookId") Optional<Long> bookId) {
      return bookId.map(ratingService::findRatingsByBookId)
            .orElseGet(ratingService::findAllRatings);
   }

   @PostMapping
   public Rating createRating(@RequestBody Rating rating) {
      return ratingService.createRating(rating);
   }

   @DeleteMapping("/{ratingId}")
   public void deleteRating(@PathVariable("ratingId") Long ratingId) {
      ratingService.deleteRating(ratingId);
   }

   @PutMapping("/{ratingId}")
   public Rating updateRating(@RequestBody Rating rating, @PathVariable("ratingId") Long ratingId) {
      return ratingService.updateRating(rating, ratingId);
   }

   @PatchMapping("/{ratingId}")
   public Rating updateRating(@RequestBody Map<String, String> updates, @PathVariable("ratingId") Long ratingId) {
      return ratingService.updateRating(updates, ratingId);
   }
}