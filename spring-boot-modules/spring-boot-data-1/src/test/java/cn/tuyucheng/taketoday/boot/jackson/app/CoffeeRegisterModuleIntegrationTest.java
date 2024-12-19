package cn.tuyucheng.taketoday.boot.jackson.app;

import org.springframework.context.annotation.Import;

import cn.tuyucheng.taketoday.boot.jackson.config.CoffeeRegisterModuleConfig;

@Import(CoffeeRegisterModuleConfig.class)
public class CoffeeRegisterModuleIntegrationTest extends AbstractCoffeeIntegrationTest {
}