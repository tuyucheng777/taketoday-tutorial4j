package cn.tuyucheng.taketoday.asyncvsflux;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AsyncFilter implements Filter {

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      try {
         Thread.sleep(200);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      filterChain.doFilter(servletRequest, servletResponse);
   }

   @Override
   public void destroy() {
   }
}