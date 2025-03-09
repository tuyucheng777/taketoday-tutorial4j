package cn.tuyucheng.taketoday.healthapp.service;

import org.springframework.stereotype.Component;

@Component
public class DefaultGeoLocationService implements GeoLocationService {

   @Override
   public String getRegion(double latitude, double longitude) {
      return "EU";
   }
}
