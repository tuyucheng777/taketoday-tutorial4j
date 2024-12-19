package cn.tuyucheng.taketoday.boot.jackson.app;

import org.springframework.context.annotation.Import;

import cn.tuyucheng.taketoday.boot.jackson.config.CoffeeCustomizerConfig;

@Import(CoffeeCustomizerConfig.class)
public class CoffeeCustomizerIntegrationTest extends AbstractCoffeeIntegrationTest {
}