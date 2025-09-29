package cn.tuyucheng.taketoday.server.rest;

import cn.tuyucheng.taketoday.server.model.Employee;
import cn.tuyucheng.taketoday.server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/employees")
public class EmployeeResource {

   @Autowired
   private EmployeeRepository employeeRepository;

   @GET
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<Employee> getAllEmployees() {
      return employeeRepository.getAllEmployees();
   }

   @GET
   @Path("/{id}")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public Employee getEmployee(@PathParam("id") int id) {
      return employeeRepository.getEmployee(id);
   }

   @PUT
   @Path("/{id}")
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public Response updateEmployee(Employee employee, @PathParam("id") int id) {
      employeeRepository.updateEmployee(employee, id);
      return Response.status(Response.Status.OK.getStatusCode()).build();
   }

   @DELETE
   @Path("/{id}")
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public Response deleteEmployee(@PathParam("id") int id) {
      employeeRepository.deleteEmployee(id);
      return Response.status(Response.Status.OK.getStatusCode()).build();
   }

   @POST
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public Response addEmployee(Employee employee, @Context UriInfo uriInfo) {
      employeeRepository.addEmployee(new Employee(employee.getId(), employee.getFirstName()));
      return Response.status(Response.Status.CREATED.getStatusCode()).header("Location", String.format("%s/%s", uriInfo.getAbsolutePath().toString(), employee.getId())).build();
   }
}