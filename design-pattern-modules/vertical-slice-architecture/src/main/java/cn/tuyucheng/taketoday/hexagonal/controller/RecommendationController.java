package cn.tuyucheng.taketoday.hexagonal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tuyucheng.taketoday.hexagonal.service.RecommendationService;

@RestController
@RequestMapping("recommendations")
public class RecommendationController {

   private final RecommendationService service;

   public RecommendationController(RecommendationService service) {
      this.service = service;
   }
}