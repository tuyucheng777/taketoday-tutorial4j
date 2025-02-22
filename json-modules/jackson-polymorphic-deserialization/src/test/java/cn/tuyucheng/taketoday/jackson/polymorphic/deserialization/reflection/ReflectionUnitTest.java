package cn.tuyucheng.taketoday.jackson.polymorphic.deserialization.reflection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReflectionUnitTest {

   @Test
   public void whenDeserializingPolymorphic_thenCorrect() throws JsonProcessingException {
      String json = "{\"type\":\"ELECTRIC_VEHICLE\",\"autonomy\":\"500\",\"chargingTime\":\"200\"}";
      ObjectMapper objectMapper = getCustomObjectMapper();

      Vehicle vehicle = objectMapper.readValue(json, Vehicle.class);

      assertEquals(Vehicle.ElectricVehicle.class, vehicle.getClass());
   }

   private ObjectMapper getCustomObjectMapper() {

      ObjectMapper objectMapper = new ObjectMapper();

      Reflections reflections = new Reflections("cn.tuyucheng.taketoday.jackson.polymorphic.deserialization.reflection");
      Set<Class<?>> subtypes = reflections.getTypesAnnotatedWith(VehicleSubType.class);

      for (Class<?> subType : subtypes) {
         VehicleSubType annotation = subType.getAnnotation(VehicleSubType.class);
         if (annotation != null) {
            String typeName = annotation.value();
            objectMapper.registerSubtypes(new NamedType(subType, typeName));
         }
      }

      return objectMapper;
   }
}
