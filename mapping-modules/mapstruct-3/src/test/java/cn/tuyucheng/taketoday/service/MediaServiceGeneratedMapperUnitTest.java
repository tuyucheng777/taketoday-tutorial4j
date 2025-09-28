package cn.tuyucheng.taketoday.service;

import cn.tuyucheng.taketoday.dto.MediaDto;
import cn.tuyucheng.taketoday.entity.Media;
import cn.tuyucheng.taketoday.mapper.MediaMapper;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;

public class MediaServiceGeneratedMapperUnitTest {

   @Test
   public void whenGeneratedMapperIsUsed_thenActualValuesAreMapped() {
      MediaService mediaService = new MediaService(Mappers.getMapper(MediaMapper.class));
      MediaDto mediaDto = new MediaDto(1L, "title 1");
      Media persisted = mediaService.persistMedia(mediaDto);
      assertEquals(mediaDto.getId(), persisted.getId());
      assertEquals(mediaDto.getTitle(), persisted.getTitle());
   }
}