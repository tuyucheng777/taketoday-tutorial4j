package cn.tuyucheng.taketoday.healthapp.domain;

import java.time.ZonedDateTime;

public record HealthData(

      String userId,

      float temperature,
      float pulseRate,
      int bpSystolic,
      int bpDiastolic,

      double latitude,
      double longitude,
      ZonedDateTime timestamp) {
}
