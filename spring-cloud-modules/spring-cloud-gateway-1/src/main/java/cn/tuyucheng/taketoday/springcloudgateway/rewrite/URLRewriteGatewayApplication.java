/**
 *
 */
package cn.tuyucheng.taketoday.springcloudgateway.rewrite;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Tuyucheng
 *
 */
@SpringBootApplication
public class URLRewriteGatewayApplication {

   static void main(String[] args) {
      new SpringApplicationBuilder(URLRewriteGatewayApplication.class)
            .profiles("url-rewrite")
            .run(args);
   }
}