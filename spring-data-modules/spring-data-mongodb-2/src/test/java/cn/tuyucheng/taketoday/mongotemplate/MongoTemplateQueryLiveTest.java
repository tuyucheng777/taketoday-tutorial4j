package cn.tuyucheng.taketoday.mongotemplate;

import cn.tuyucheng.taketoday.config.MongoConfig;
import cn.tuyucheng.taketoday.model.EmailAddress;
import cn.tuyucheng.taketoday.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This test requires:
 * * mongodb instance running on the environment
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class MongoTemplateQueryLiveTest {

   @Autowired
   private MongoTemplate mongoTemplate;

   @Before
   public void testSetup() {
      if (!mongoTemplate.collectionExists(User.class)) {
         mongoTemplate.createCollection(User.class);
      }
   }

   @After
   public void tearDown() {
      mongoTemplate.dropCollection(User.class);
   }

   @Test
   public void whenSavingUserWithEmailAddress_thenUserandEmailAddressSaved() {
      final User user = new User();
      user.setName("Brendan");
      final EmailAddress emailAddress = new EmailAddress();
      emailAddress.setValue("b@gmail.com");
      user.setEmailAddress(emailAddress);
      mongoTemplate.insert(user);

      assertThat(mongoTemplate.findOne(Query.query(Criteria.where("name").is("Brendan")), User.class).getEmailAddress().getValue(), is("b@gmail.com"));
   }
}