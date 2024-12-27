package cn.tuyucheng.taketoday.ibmmq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.jms.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class JMSReadWriteUnitTest {
   @Mock
   private QueueConnectionFactory factory;
   @Mock
   private QueueConnection connection;
   @Mock
   private QueueSession session;
   @Mock
   private Queue queue;
   @Mock
   private QueueSender sender;
   @Mock
   private QueueReceiver receiver;
   @Mock
   private TextMessage textMessage;
   @InjectMocks
   private MessageSender messageSender;
   @InjectMocks
   private MessageReceiver messageReceiver;

   @BeforeEach
   public void setup() throws JMSException {
      MockitoAnnotations.openMocks(this);
      when(factory.createQueueConnection()).thenReturn(connection);
      when(connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(session);
      when(session.createQueue("QUEUE1")).thenReturn(queue);
      when(session.createSender(queue)).thenReturn(sender);
      when(session.createReceiver(queue)).thenReturn(receiver);
      when(session.createTextMessage()).thenReturn(textMessage);
   }

   @Test
   public void whenSendMessage_thenMessageIsSentSuccessfully() throws JMSException {
      String messageText = "Hello Taketoday! Nice to meet you!";
      doNothing().when(sender).send(any(TextMessage.class));

      messageSender.sendMessage(messageText);

      verify(sender).send(any(TextMessage.class));
      verify(textMessage).setText(messageText);
   }

   @Test
   public void whenReceiveMessage_thenMessageIsReceivedSuccessfully() throws JMSException {
      when(receiver.receive(anyLong())).thenReturn(textMessage);
      when(textMessage.getText()).thenReturn("Hello Taketoday! Nice to meet you!");

      messageReceiver.receiveMessage();

      verify(receiver).receive(anyLong());
      verify(textMessage).getText();
   }
}