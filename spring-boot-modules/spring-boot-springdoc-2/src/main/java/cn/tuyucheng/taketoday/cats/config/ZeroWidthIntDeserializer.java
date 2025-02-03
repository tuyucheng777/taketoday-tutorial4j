package cn.tuyucheng.taketoday.cats.config;

import cn.tuyucheng.taketoday.cats.utils.RegexUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ZeroWidthIntDeserializer extends JsonDeserializer<Integer> {

   @Override
   public Integer deserialize(JsonParser parser, DeserializationContext context) throws IOException {
      return Integer.valueOf(RegexUtils.removeZeroWidthChars(parser.getText()));
   }
}