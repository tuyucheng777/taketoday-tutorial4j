package cn.tuyucheng.taketoday.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.tuyucheng.taketoday.mapper.MediaMapper;
import cn.tuyucheng.taketoday.service.MediaService;

@Configuration
public class Config {

   @Bean
   public MediaService mediaService(MediaMapper mediaMapper) {
      return new MediaService(mediaMapper);
   }
}