package cn.tuyucheng.taketoday.airag.controller;

import cn.tuyucheng.taketoday.airag.service.ChatBotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ChatBotController {
   @Autowired
   private ChatBotService chatBotService;

   @GetMapping("/chat")
   public Map<Object, Object> chat(@RequestParam(name = "query") String query) {
      return Map.of("answer", chatBotService.chat(query));
   }
}