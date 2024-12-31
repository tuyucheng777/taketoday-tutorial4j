package cn.tuyucheng.taketoday.micronaut.httpfilters.filters;

import io.micronaut.core.order.Ordered;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.RequestFilter;
import io.micronaut.http.annotation.ResponseFilter;
import io.micronaut.http.annotation.ServerFilter;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import lombok.extern.slf4j.Slf4j;

import static cn.tuyucheng.taketoday.micronaut.httpfilters.utils.CustomHttpHeaders.CUSTOM_HEADER_KEY;
import static cn.tuyucheng.taketoday.micronaut.httpfilters.utils.CustomHttpHeaders.X_TRACE_HEADER_KEY;

@Slf4j
@ServerFilter(patterns = {"**/endpoint*"})
public class CustomFilter implements Ordered {

   @RequestFilter
   @ExecuteOn(TaskExecutors.BLOCKING)
   public void filterRequest(HttpRequest<?> request) {
      String customRequestHeader = request.getHeaders()
            .get(CUSTOM_HEADER_KEY);
      LOGGER.info("request header: {}", customRequestHeader);
   }

   @ResponseFilter
   public void filterResponse(MutableHttpResponse<?> res) {
      res.getHeaders()
            .add(X_TRACE_HEADER_KEY, "true");
   }

   @Override
   public int getOrder() {
      return 2;
   }
}