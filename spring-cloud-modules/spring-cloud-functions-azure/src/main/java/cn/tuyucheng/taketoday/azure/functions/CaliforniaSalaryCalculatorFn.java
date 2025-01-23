package cn.tuyucheng.taketoday.azure.functions;

import cn.tuyucheng.taketoday.azure.functions.entity.Employee;

import java.util.function.Function;

public class CaliforniaSalaryCalculatorFn implements Function<Employee, Employee> {
   @Override
   public Employee apply(Employee employee) {
      Integer finalSalary = employee.getSalary() + 3000;
      employee.setSalary(finalSalary);
      return employee;
   }
}