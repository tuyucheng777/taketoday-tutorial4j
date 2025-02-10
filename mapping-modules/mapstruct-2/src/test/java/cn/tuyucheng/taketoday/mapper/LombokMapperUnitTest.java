package cn.tuyucheng.taketoday.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import cn.tuyucheng.taketoday.dto.SimpleSource;
import cn.tuyucheng.taketoday.entity.LombokDestination;
import cn.tuyucheng.taketoday.entity.SimpleDestination;

public class LombokMapperUnitTest {

   private final LombokMapper lombokMapper = Mappers.getMapper(LombokMapper.class);

   @Test
   void whenDestinationIsMapped_thenIsSuccessful() {
      SimpleSource simpleSource = new SimpleSource();
      simpleSource.setName("file");
      simpleSource.setDescription("A text file.");

      SimpleDestination simpleDestination = lombokMapper.sourceToDestination(simpleSource);
      Assertions.assertNotNull(simpleDestination);
      Assertions.assertEquals(simpleSource.getName(), simpleDestination.getName());
      Assertions.assertEquals(simpleSource.getDescription(), simpleDestination.getDescription());

      LombokDestination lombokDestination = lombokMapper.sourceToLombokDestination(simpleSource);
      Assertions.assertNotNull(lombokDestination);
      Assertions.assertEquals(simpleSource.getName(), lombokDestination.getName());
      Assertions.assertEquals(simpleSource.getDescription(), lombokDestination.getDescription());
   }
}