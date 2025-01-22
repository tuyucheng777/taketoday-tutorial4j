package cn.tuyucheng.taketoday.webflux.rsocket.server;

import cn.tuyucheng.taketoday.webflux.rsocket.model.MarketData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

@Slf4j
@Component
public class MarketDataRepository {

   private static final int BOUND = 100;

   private Random random = new Random();

   public Flux<MarketData> getAll(String stock) {
      return Flux.fromStream(Stream.generate(() -> getMarketDataResponse(stock)))
            .log()
            .delayElements(Duration.ofSeconds(1));
   }

   public Mono<MarketData> getOne(String stock) {
      return Mono.just(getMarketDataResponse(stock));
   }

   public void add(MarketData marketData) {
      LOGGER.info("New market data: {}", marketData);
   }

   private MarketData getMarketDataResponse(String stock) {
      return new MarketData(stock, random.nextInt(BOUND));
   }
}