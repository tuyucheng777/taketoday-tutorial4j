package cn.tuyucheng.taketoday.rsocket;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

import java.nio.ByteBuffer;

import static cn.tuyucheng.taketoday.rsocket.support.Constants.DATA_STREAM_NAME;
import static cn.tuyucheng.taketoday.rsocket.support.Constants.TCP_PORT;

public class ReqStreamClient {

   private final RSocket socket;

   public ReqStreamClient() {
      this.socket = RSocketFactory.connect()
            .transport(TcpClientTransport.create("localhost", TCP_PORT))
            .start()
            .block();
   }

   public Flux<Float> getDataStream() {
      return socket
            .requestStream(DefaultPayload.create(DATA_STREAM_NAME))
            .map(Payload::getData)
            .map(ByteBuffer::getFloat)
            .onErrorReturn(null);
   }

   public void dispose() {
      this.socket.dispose();
   }
}