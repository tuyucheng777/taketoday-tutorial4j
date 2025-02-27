package cn.tuyucheng.taketoday.tomcat;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/my-servlet/*")
public class MyFilter implements Filter {

   @Override
   public void init(FilterConfig filterConfig) {

   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      System.out.println("Filtering stuff...");
      HttpServletResponse httpResponse = (HttpServletResponse) response;
      httpResponse.addHeader("myHeader", "myHeaderValue");
      chain.doFilter(request, httpResponse);
   }

   @Override
   public void destroy() {

   }
}