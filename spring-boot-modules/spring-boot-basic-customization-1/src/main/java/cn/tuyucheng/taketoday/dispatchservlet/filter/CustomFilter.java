package cn.tuyucheng.taketoday.dispatchservlet.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomFilter implements Filter {

   Logger logger = LoggerFactory.getLogger(CustomFilter.class);

   @Override
   public void init(FilterConfig filterConfig) {
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      logger.info("CustomFilter is invoked");
      chain.doFilter(request, response);
   }

   @Override
   public void destroy() {
   }
}