package cn.tuyucheng.taketoday.examples.guice.binding;

import cn.tuyucheng.taketoday.examples.guice.*;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicModule extends AbstractModule {

   @Override
   protected void configure() {
      try {
         bind(Communication.class).toConstructor(Communication.class.getConstructor(Boolean.TYPE));
      } catch (NoSuchMethodException | SecurityException ex) {
         Logger.getLogger(BasicModule.class.getName()).log(Level.SEVERE, null, ex);
      }
      bind(DefaultCommunicator.class).annotatedWith(Names.named("AnotherCommunicator")).to(DefaultCommunicator.class).asEagerSingleton();

      bind(CommunicationMode.class).annotatedWith(Names.named("IMComms")).to(IMCommunicationMode.class);
      bind(CommunicationMode.class).annotatedWith(Names.named("EmailComms")).to(EmailCommunicationMode.class);
      bind(CommunicationMode.class).annotatedWith(Names.named("SMSComms")).to(SMSCommunicationMode.class);
   }
}