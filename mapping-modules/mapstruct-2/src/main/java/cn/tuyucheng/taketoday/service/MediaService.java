package cn.tuyucheng.taketoday.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.tuyucheng.taketoday.dto.MediaDto;
import cn.tuyucheng.taketoday.entity.Media;
import cn.tuyucheng.taketoday.mapper.MediaMapper;

public class MediaService {

   final Logger logger = LoggerFactory.getLogger(MediaService.class);

   private final MediaMapper mediaMapper;

   public MediaService(MediaMapper mediaMapper) {
      this.mediaMapper = mediaMapper;
   }

   public Media persistMedia(MediaDto mediaDto) {
      Media media = mediaMapper.toEntity(mediaDto);
      logger.info("Persist media: {}", media);
      return media;
   }
}