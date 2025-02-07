package cn.tuyucheng.taketoday.customurlconnection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class CustomURLConnection extends URLConnection {
   private final String simulatedData = "This is the simulated data from the resource.";
   private URL url;
   private boolean connected = false;
   private String headerValue = "SimulatedHeaderValue";

   protected CustomURLConnection(URL url) {
      super(url);
      this.url = url;
   }

   @Override
   public void connect() throws IOException {
      connected = true;
      System.out.println("Connection established to: " + url);
   }

   @Override
   public InputStream getInputStream() throws IOException {
      if (!connected) {
         connect();
      }
      return new ByteArrayInputStream(simulatedData.getBytes());
   }

   @Override
   public OutputStream getOutputStream() throws IOException {
      ByteArrayOutputStream simulatedOutput = new ByteArrayOutputStream();
      return simulatedOutput;
   }

   @Override
   public int getContentLength() {
      return simulatedData.length();
   }

   @Override
   public String getHeaderField(String name) {
      if ("SimulatedHeader".equalsIgnoreCase(name)) { // Example header name
         return headerValue;
      } else {
         return null; // Header not found
      }
   }
}