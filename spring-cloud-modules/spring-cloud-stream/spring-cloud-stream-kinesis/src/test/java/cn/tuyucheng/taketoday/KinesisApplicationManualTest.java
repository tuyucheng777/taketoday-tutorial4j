package cn.tuyucheng.taketoday;

import cn.tuyucheng.taketoday.kclkpl.KinesisKPLApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Manual Test - this test needs correct AWS Access Key and Secret to build the Amazon Kinesis and complete successfully
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KinesisKPLApplication.class)
public class KinesisApplicationManualTest {
   @Test
   public void whenSpringContextIsBootstrapped_thenNoExceptions() {
   }
}