package cn.tuyucheng.taketoday.tutorials.openapi.generatehttpclients.service;

import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.tutorials.openapi.generatehttpclients.api.WeatherApi;
import cn.tuyucheng.taketoday.tutorials.openapi.generatehttpclients.api.model.WeatherResponse;

@Service
public class GetWeatherService {

   private final WeatherApi weatherApi;

   public GetWeatherService(WeatherApi weatherApi) {
      this.weatherApi = weatherApi;
   }

   public WeatherResponse getCurrentWeather(String city, String units) {
      var response = weatherApi.getCurrentWeather(city, units);

      if (response.getStatusCodeValue() < 399) {
         return response.getBody();
      }

      throw new RuntimeException("Failed to get current weather for " + city);
   }
}