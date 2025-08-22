package cn.tuyucheng.taketoday.eventuate.tram;

import cn.tuyucheng.taketoday.eventuate.tram.domain.Comment;
import cn.tuyucheng.taketoday.eventuate.tram.domain.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentsController {

   private final CommentService commentService;

   public CommentsController(CommentService service) {
      this.commentService = service;
   }

   @PostMapping("/api/articles/{slug}/comments")
   public ResponseEntity<Long> addComment(@RequestBody AddCommentDto dto, @PathVariable String slug) {
      Comment comment = new Comment(dto.text(), slug, dto.commentAuthor());
      long id = commentService.save(comment);
      return ResponseEntity.status(HttpStatus.CREATED)
            .body(id);
   }

   record AddCommentDto(String text, String commentAuthor) {
   }
}