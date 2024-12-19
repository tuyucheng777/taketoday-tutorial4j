package cn.tuyucheng.taketoday.web;

import cn.tuyucheng.taketoday.entity.Deposit;
import cn.tuyucheng.taketoday.repository.DepositRepository;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/deposits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DepositResource {

   @Inject
   DepositRepository repository;

   @GET
   public Uni<Response> getAllDeposits() {
      return Deposit.listAll()
            .map(deposits -> Response.ok(deposits)
                  .build());
   }

   @POST
   public Uni<Response> createDeposit(Deposit deposit) {
      return deposit.persistAndFlush()
            .map(v -> Response.status(Response.Status.CREATED)
                  .build());
   }

   @GET
   @Path("stream")
   public Multi<Deposit> streamDeposits() {
      return repository.streamAll();
   }
}