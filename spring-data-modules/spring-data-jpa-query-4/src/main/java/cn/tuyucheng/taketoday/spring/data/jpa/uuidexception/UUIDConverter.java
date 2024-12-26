package cn.tuyucheng.taketoday.spring.data.jpa.uuidexception;

import jakarta.persistence.AttributeConverter;
import java.util.UUID;

public class UUIDConverter implements AttributeConverter<UUID, String> {

   @Override
   public String convertToDatabaseColumn(UUID uuid) {
      return uuid != null ? uuid.toString() : null;
   }

   @Override
   public UUID convertToEntityAttribute(String dbData) {
      return dbData != null ? UUID.fromString(dbData) : null;
   }
}