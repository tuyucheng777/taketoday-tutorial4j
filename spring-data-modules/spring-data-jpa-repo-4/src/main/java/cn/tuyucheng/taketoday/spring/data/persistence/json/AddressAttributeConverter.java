package cn.tuyucheng.taketoday.spring.data.persistence.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
@Slf4j
public class AddressAttributeConverter implements AttributeConverter<Address, String> {

   private static final ObjectMapper objectMapper = new ObjectMapper();

   @Override
   public String convertToDatabaseColumn(Address address) {
      try {
         return objectMapper.writeValueAsString(address);
      } catch (JsonProcessingException jpe) {
         LOGGER.warn("Cannot convert Address into JSON");
         return null;
      }
   }

   @Override
   public Address convertToEntityAttribute(String value) {
      try {
         return objectMapper.readValue(value, Address.class);
      } catch (JsonProcessingException e) {
         LOGGER.warn("Cannot convert JSON into Address");
         return null;
      }
   }
}