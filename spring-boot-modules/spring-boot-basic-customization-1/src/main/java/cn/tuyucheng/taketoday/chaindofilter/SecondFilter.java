package cn.tuyucheng.taketoday.chaindofilter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Order(2)
@Component
public class SecondFilter implements Filter {

    private final Logger LOG = LoggerFactory.getLogger(SecondFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("Processing the Second Filter");
        chain.doFilter(request, response);
    }
}