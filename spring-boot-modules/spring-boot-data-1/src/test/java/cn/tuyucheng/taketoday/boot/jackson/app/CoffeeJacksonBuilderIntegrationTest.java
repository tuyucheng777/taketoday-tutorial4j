package cn.tuyucheng.taketoday.boot.jackson.app;

import org.springframework.context.annotation.Import;

import cn.tuyucheng.taketoday.boot.jackson.config.CoffeeJacksonBuilderConfig;

@Import(CoffeeJacksonBuilderConfig.class)
public class CoffeeJacksonBuilderIntegrationTest extends AbstractCoffeeIntegrationTest {
}