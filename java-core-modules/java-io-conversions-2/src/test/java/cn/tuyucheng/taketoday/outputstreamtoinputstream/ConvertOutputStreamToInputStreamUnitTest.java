package cn.tuyucheng.taketoday.outputstreamtoinputstream;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertOutputStreamToInputStreamUnitTest {

   @Test
   void whenUsingByteArray_thenGetExpectedInputStream() throws IOException {
      String content = "I'm an important message.";
      try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
         out.write(content.getBytes());
         try (ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray())) {
            String inContent = new String(in.readAllBytes());

            assertEquals(content, inContent);
         }
      }
   }

   @Test
   void whenUsingPipeStream_thenGetExpectedInputStream() throws IOException {
      String content = "I'm going through the pipe.";

      ByteArrayOutputStream originOut = new ByteArrayOutputStream();
      originOut.write(content.getBytes());

      // connect the pipe
      PipedInputStream in = new PipedInputStream();
      PipedOutputStream out = new PipedOutputStream(in);

      try (in) {
         new Thread(() -> {
            try (out) {
               originOut.writeTo(out);
            } catch (IOException iox) {
               // handle IOExceptions
            }
         }).start();

         String inContent = new String(in.readAllBytes());
         assertEquals(content, inContent);
      }
   }

}