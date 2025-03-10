package cn.tuyucheng.taketoday.mongodb.events;

import cn.tuyucheng.taketoday.mongodb.models.User;
import cn.tuyucheng.taketoday.mongodb.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class UserModelListener extends AbstractMongoEventListener<User> {

   private SequenceGeneratorService sequenceGenerator;

   @Autowired
   public UserModelListener(SequenceGeneratorService sequenceGenerator) {
      this.sequenceGenerator = sequenceGenerator;
   }

   @Override
   public void onBeforeConvert(BeforeConvertEvent<User> event) {
      if (event.getSource().getId().intValue() < 1) {
         event.getSource().setId(BigInteger.valueOf(sequenceGenerator.generateSequence(User.SEQUENCE_NAME)));
      }
   }
}