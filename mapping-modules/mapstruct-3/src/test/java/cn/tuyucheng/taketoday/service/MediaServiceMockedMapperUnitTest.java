package cn.tuyucheng.taketoday.service;

import cn.tuyucheng.taketoday.dto.MediaDto;
import cn.tuyucheng.taketoday.entity.Media;
import cn.tuyucheng.taketoday.mapper.MediaMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MediaServiceMockedMapperUnitTest {

   @Test
   public void whenMockedMapperIsUsed_thenMockedValuesAreMapped() {
      MediaMapper mockMediaMapper = mock(MediaMapper.class);
      Media mockedMedia = new Media(5L, "Title 5");
      when(mockMediaMapper.toEntity(any())).thenReturn(mockedMedia);

      MediaService mediaService = new MediaService(mockMediaMapper);
      MediaDto mediaDto = new MediaDto(1L, "title 1");
      Media persisted = mediaService.persistMedia(mediaDto);

      verify(mockMediaMapper).toEntity(mediaDto);
      assertEquals(mockedMedia.getId(), persisted.getId());
      assertEquals(mockedMedia.getTitle(), persisted.getTitle());
   }
}