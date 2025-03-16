package cn.tuyucheng.taketoday.spring.data.noconverterfound.models;

public interface IEmployeeFullName {
   String getFirstName();

   String getLastName();

   default String fullName() {
      return getFirstName().concat(" ")
            .concat(getLastName());
   }
}
