package cn.tuyucheng.taketoday.kogito.boundary;

import java.util.stream.Stream;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import cn.tuyucheng.taketoday.kogito.boundary.model.LoanApplicationDto;
import cn.tuyucheng.taketoday.kogito.boundary.model.LoanApplicationsInputDto;
import cn.tuyucheng.taketoday.kogito.rules.LoanApplicationService;
import cn.tuyucheng.taketoday.kogito.rules.model.LoanApplication;

@Path("/applications-custom")
public class LoanApplicationResource {

   @Inject
   LoanApplicationDtoMapper mapper;
   @Inject
   LoanApplicationService service;

   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Stream<LoanApplicationDto> evaluateCredit(LoanApplicationsInputDto input) {
      var applications = Stream.of(input.applications())
            .map(mapper::map)
            .toArray(LoanApplication[]::new);
      return service.evaluate(applications)
            .map(mapper::map);
   }
}