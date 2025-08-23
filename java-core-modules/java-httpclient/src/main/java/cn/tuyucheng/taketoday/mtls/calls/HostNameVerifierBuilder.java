package cn.tuyucheng.taketoday.mtls.calls;

import javax.net.ssl.HostnameVerifier;

public class HostNameVerifierBuilder {

   static HostnameVerifier allHostsValid = (hostname, session) -> true;

   public static HostnameVerifier getAllHostsValid() {
      return allHostsValid;
   }
}