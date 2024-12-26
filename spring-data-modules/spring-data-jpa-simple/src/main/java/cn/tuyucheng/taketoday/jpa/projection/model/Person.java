package cn.tuyucheng.taketoday.jpa.projection.model;

import cn.tuyucheng.taketoday.jpa.projection.view.PersonDto;
import jakarta.persistence.*;

@Entity
@NamedNativeQuery(name = "person_native_query_dto", query = "SELECT p.first_name, p.last_name From Person p where p.first_name LIKE :firstNameLike", resultSetMapping = "person_query_dto")
@SqlResultSetMapping(name = "person_query_dto", classes = @ConstructorResult(targetClass = PersonDto.class, columns = {@ColumnResult(name = "first_name", type = String.class), @ColumnResult(name = "last_name", type = String.class),}))
public class Person {
   @Id
   private Long id;
   private String firstName;
   private String lastName;
   @OneToOne(mappedBy = "person")
   private Address address;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }
}