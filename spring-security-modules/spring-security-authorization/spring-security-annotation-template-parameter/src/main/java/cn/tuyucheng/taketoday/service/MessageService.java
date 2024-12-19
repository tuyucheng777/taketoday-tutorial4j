package cn.tuyucheng.taketoday.service;

import cn.tuyucheng.taketoday.annotation.CustomHasAnyRole;
import cn.tuyucheng.taketoday.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

   private final List<Message> messages;

   public MessageService() {
      messages = new ArrayList<>();
      messages.add(new Message(1, "Message 1"));
   }

   @CustomHasAnyRole({"'USER'", "'ADMIN'"})
   public Message readMessage(Integer id) {
      return messages.get(0);
   }

   @CustomHasAnyRole("'ADMIN'")
   public String writeMessage(Message message) {
      return "Message Written";
   }

   @CustomHasAnyRole({"'ADMIN'"})
   public String deleteMessage(Integer id) {
      return "Message Deleted";
   }
}