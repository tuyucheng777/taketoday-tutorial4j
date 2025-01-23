package cn.tuyucheng.taketoday.azure.functions;

import cn.tuyucheng.taketoday.azure.functions.entity.Employee;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class EmployeeSalaryHandler {
   @Autowired
   private Function<Employee, Employee> employeeSalaryFunction;

   @Autowired
   private FunctionCatalog functionCatalog;

   @FunctionName("calculateSalary")
   public HttpResponseMessage calculateSalary(
         @HttpTrigger(
               name = "http",
               methods = HttpMethod.POST,
               authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Employee>> employeeHttpRequestMessage,
         ExecutionContext executionContext
   ) {
      Employee employeeRequest = employeeHttpRequestMessage.getBody().get();
      executionContext.getLogger().info("Salary of " + employeeRequest.getName() + " is:" + employeeRequest.getSalary());

      Employee employee = employeeSalaryFunction.apply(employeeRequest);
      executionContext.getLogger().info("Final salary of " + employee.getName() + " is:" + employee.getSalary());
      return employeeHttpRequestMessage.createResponseBuilder(HttpStatus.OK)
            .body(employee)
            .build();
   }

   @FunctionName("calculateSalaryWithSCF")
   public HttpResponseMessage calculateSalaryWithSCF(
         @HttpTrigger(
               name = "http",
               methods = HttpMethod.POST,
               authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<Employee>> employeeHttpRequestMessage,
         ExecutionContext executionContext
   ) {
      Employee employeeRequest = employeeHttpRequestMessage.getBody().get();
      executionContext.getLogger().info("Salary of " + employeeRequest.getName() + " is:" + employeeRequest.getSalary());
      EmployeeSalaryFunctionWrapper employeeSalaryFunctionWrapper = new EmployeeSalaryFunctionWrapper(functionCatalog);
      Function<Employee, Employee> cityBasedSalaryFunction = employeeSalaryFunctionWrapper.getCityBasedSalaryFunction(employeeRequest);
      executionContext.getLogger().info("The class of the cityBasedSalaryFunction:" + cityBasedSalaryFunction.getClass());
      Employee employee = cityBasedSalaryFunction.apply(employeeRequest);
      executionContext.getLogger().info("Final salary of " + employee.getName() + " is:" + employee.getSalary());
      return employeeHttpRequestMessage.createResponseBuilder(HttpStatus.OK)
            .body(employee)
            .build();
   }
}