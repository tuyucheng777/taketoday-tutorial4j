package cn.tuyucheng.taketoday.boot.jackson.app;

import org.springframework.context.annotation.Import;

import cn.tuyucheng.taketoday.boot.jackson.config.CoffeeObjectMapperConfig;

@Import(CoffeeObjectMapperConfig.class)
public class CoffeeObjectMapperIntegrationTest extends AbstractCoffeeIntegrationTest {
}