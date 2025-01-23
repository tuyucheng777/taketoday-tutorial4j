package cn.tuyucheng.taketoday.azure.functions;

import cn.tuyucheng.taketoday.azure.functions.entity.Employee;
import org.springframework.cloud.function.context.FunctionCatalog;

import java.util.function.Function;


public class EmployeeSalaryFunctionWrapper {

   private final FunctionCatalog functionCatalog;

   public EmployeeSalaryFunctionWrapper(FunctionCatalog functionCatalog) {
      this.functionCatalog = functionCatalog;
   }

   public Function<Employee, Employee> getCityBasedSalaryFunction(Employee employee) {
      Function<Employee, Employee> salaryCalculatorFunction;
      switch (employee.getCity()) {
         case "Chicago" -> salaryCalculatorFunction = functionCatalog.lookup("chicagoSalaryCalculatorFn");
         case "California" ->
               salaryCalculatorFunction = functionCatalog.lookup("californiaSalaryCalculatorFn|defaultSalaryCalculatorFn");
         case "New York" -> salaryCalculatorFunction = functionCatalog.lookup("newYorkSalaryCalculatorFn");
         default -> salaryCalculatorFunction = functionCatalog.lookup("defaultSalaryCalculatorFn");
      }
      return salaryCalculatorFunction;
   }
}