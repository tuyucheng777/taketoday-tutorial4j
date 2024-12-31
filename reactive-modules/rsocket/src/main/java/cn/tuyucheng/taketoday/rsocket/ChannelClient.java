package cn.tuyucheng.taketoday.rsocket;

import cn.tuyucheng.taketoday.rsocket.support.GameController;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import reactor.core.publisher.Flux;

import static cn.tuyucheng.taketoday.rsocket.support.Constants.TCP_PORT;

public class ChannelClient {

   private final RSocket socket;
   private final GameController gameController;

   public ChannelClient() {
      this.socket = RSocketFactory.connect()
            .transport(TcpClientTransport.create("localhost", TCP_PORT))
            .start()
            .block();

      this.gameController = new GameController("Client Player");
   }

   public void playGame() {
      socket.requestChannel(Flux.from(gameController))
            .doOnNext(gameController::processPayload)
            .blockLast();
   }

   public void dispose() {
      this.socket.dispose();
   }
}