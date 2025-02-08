package cn.tuyucheng.taketoday.exceptions.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MalformedURL {

   private static Logger LOGGER = LoggerFactory.getLogger(MalformedURL.class);

   public static void main(String[] args) {

      URL taketodayURL = null;

      try {
         taketodayURL = new URI("malformedurl").toURL();
      } catch (MalformedURLException | URISyntaxException e) {
         LOGGER.error("MalformedURLException caught!");
      }

   }

}
