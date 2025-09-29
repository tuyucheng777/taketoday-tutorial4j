package cn.tuyucheng.taketoday.hexagonal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyucheng.taketoday.hexagonal.service.CommentService;

@RestController
@RequestMapping("comments")
public class CommentController {

   private final CommentService service;

   public CommentController(CommentService service) {
      this.service = service;
   }
}