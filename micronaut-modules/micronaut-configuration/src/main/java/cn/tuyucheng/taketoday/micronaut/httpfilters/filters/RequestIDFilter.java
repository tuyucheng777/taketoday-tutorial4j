package cn.tuyucheng.taketoday.micronaut.httpfilters.filters;

import io.micronaut.core.annotation.Order;
import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.RequestFilter;
import io.micronaut.http.annotation.ServerFilter;
import io.micronaut.http.filter.FilterContinuation;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

import static cn.tuyucheng.taketoday.micronaut.httpfilters.utils.CustomHttpHeaders.REQUEST_ID_HEADER_KEY;

@Slf4j
@ServerFilter(patterns = {"**/endpoint*"})
@Order(1)
public class RequestIDFilter implements Ordered {

   @RequestFilter
   @ExecuteOn(TaskExecutors.BLOCKING)
   public void filterRequest(HttpRequest<?> request, FilterContinuation<MutableHttpResponse<?>> continuation) {
      String requestIdHeader = request.getHeaders()
            .get(REQUEST_ID_HEADER_KEY);
      if (requestIdHeader == null || requestIdHeader.trim()
            .isEmpty()) {
         requestIdHeader = UUID.randomUUID()
               .toString();
         LOGGER.info("request ID not received. Created and will return one with value: [{}]", requestIdHeader);
      } else {
         LOGGER.info("request ID received. Request ID: [{}]", requestIdHeader);
      }

      MutableHttpResponse<?> res = continuation.proceed();

      res.getHeaders()
            .add(REQUEST_ID_HEADER_KEY, requestIdHeader);
   }
}