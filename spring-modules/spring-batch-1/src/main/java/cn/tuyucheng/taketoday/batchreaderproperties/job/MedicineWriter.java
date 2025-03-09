package cn.tuyucheng.taketoday.batchreaderproperties.job;

import cn.tuyucheng.taketoday.batchreaderproperties.ContainsJobParameters;
import cn.tuyucheng.taketoday.batchreaderproperties.model.Medicine;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Slf4j
public class MedicineWriter implements ItemWriter<Medicine>, ContainsJobParameters {

   private ZonedDateTime triggeredDateTime;
   private String traceId;

   @Override
   public void write(Chunk<? extends Medicine> chunk) {
      chunk.forEach((medicine) -> LOGGER.info("Trace = {}. This medicine is expiring {}", traceId, medicine));

      LOGGER.info("Finishing job started at {}", triggeredDateTime);
   }
}