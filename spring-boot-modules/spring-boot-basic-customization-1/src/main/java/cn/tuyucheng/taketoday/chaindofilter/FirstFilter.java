package cn.tuyucheng.taketoday.chaindofilter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Order(1)
@Component
public class FirstFilter implements Filter {

    private final Logger LOG = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        LOG.info("Processing the First Filter");
        chain.doFilter(request, response);
    }
}