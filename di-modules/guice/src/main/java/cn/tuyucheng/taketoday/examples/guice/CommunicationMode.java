package cn.tuyucheng.taketoday.examples.guice;

import cn.tuyucheng.taketoday.examples.guice.constant.CommunicationModel;

public interface CommunicationMode {

   CommunicationModel getMode();

   boolean sendMessage(String message);
}