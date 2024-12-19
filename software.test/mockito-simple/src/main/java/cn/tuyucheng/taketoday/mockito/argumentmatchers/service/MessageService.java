package cn.tuyucheng.taketoday.mockito.argumentmatchers.service;

import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.mockito.argumentmatchers.Message;

@Service
public class MessageService {

   public Message deliverMessage(Message message) {

      return message;
   }
}
