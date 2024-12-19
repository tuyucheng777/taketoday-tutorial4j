package cn.tuyucheng.taketoday.boot.jackson.app;

import org.springframework.context.annotation.Import;

import cn.tuyucheng.taketoday.boot.jackson.config.CoffeeHttpConverterConfiguration;

@Import(CoffeeHttpConverterConfiguration.class)
public class CoffeeHttpConverterIntegrationTest extends AbstractCoffeeIntegrationTest {
}