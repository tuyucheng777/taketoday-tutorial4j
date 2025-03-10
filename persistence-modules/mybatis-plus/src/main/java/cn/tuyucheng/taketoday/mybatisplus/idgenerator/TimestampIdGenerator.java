package cn.tuyucheng.taketoday.mybatisplus.idgenerator;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

@Component
public class TimestampIdGenerator implements IdentifierGenerator {

   @Override
   public Long nextId(Object entity) {
      return System.nanoTime();
   }
}