package cn.tuyucheng.taketoday.spring.cloud.aws.sns;

import cn.tuyucheng.taketoday.spring.cloud.aws.SpringCloudAwsTestUtil;
import cn.tuyucheng.taketoday.spring.cloud.aws.sqs.Greeting;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.CreateTopicResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * To run this Live Test, we need to have an AWS account and have API keys generated for programmatic access.
 * <p>
 * Check the README file in this module for more information.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
public class SpringCloudSNSLiveTest {

   @Autowired
   private SNSMessageSender snsMessageSender;

   private static String topicName;
   private static String topicArn;

   @BeforeClass
   public static void setupAwsResources() {
      topicName = UUID.randomUUID().toString();

      AmazonSNS amazonSNS = SpringCloudAwsTestUtil.amazonSNS();

      CreateTopicResult result = amazonSNS.createTopic(topicName);
      topicArn = result.getTopicArn();
   }

   @Test
   public void whenMessagePublished_thenSuccess() {
      String subject = "Test Message";
      String message = "Hello World";
      snsMessageSender.send(topicName, message, subject);
   }

   @Test
   public void whenConvertedMessagePublished_thenSuccess() {
      String subject = "Test Message";
      Greeting message = new Greeting("Helo", "World");
      snsMessageSender.send(topicName, message, subject);
   }

   @AfterClass
   public static void cleanupAwsResources() {
      AmazonSNS amazonSNS = SpringCloudAwsTestUtil.amazonSNS();
      amazonSNS.deleteTopic(topicArn);
   }
}