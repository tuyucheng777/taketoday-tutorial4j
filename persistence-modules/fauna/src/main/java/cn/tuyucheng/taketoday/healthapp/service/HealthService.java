package cn.tuyucheng.taketoday.healthapp.service;

import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

import cn.tuyucheng.taketoday.healthapp.domain.HealthData;

public interface HealthService {
   void process(HealthData healthData) throws MalformedURLException, InterruptedException, ExecutionException;
}
