package cn.tuyucheng.taketoday.assertj.ignoring;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
   public Long id;
   public String name;
   public String department;
   public String homeAddress;
   public String workAddress;
   public LocalDate dateOfBirth;
   public Double grossSalary;
   public Double netSalary;

   // Optional: Override equals and hashCode for better comparison in some contexts
   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      Employee employee = (Employee) o;

      if (!Objects.equals(id, employee.id))
         return false;
      if (!Objects.equals(name, employee.name))
         return false;
      if (!Objects.equals(department, employee.department))
         return false;
      if (!Objects.equals(homeAddress, employee.homeAddress))
         return false;
      if (!Objects.equals(workAddress, employee.workAddress))
         return false;
      if (!Objects.equals(dateOfBirth, employee.dateOfBirth))
         return false;
      if (!Objects.equals(grossSalary, employee.grossSalary))
         return false;
      return Objects.equals(netSalary, employee.netSalary);
   }

   @Override
   public int hashCode() {
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (name != null ? name.hashCode() : 0);
      result = 31 * result + (department != null ? department.hashCode() : 0);
      result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
      result = 31 * result + (workAddress != null ? workAddress.hashCode() : 0);
      result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
      result = 31 * result + (grossSalary != null ? grossSalary.hashCode() : 0);
      result = 31 * result + (netSalary != null ? netSalary.hashCode() : 0);
      return result;
   }
}