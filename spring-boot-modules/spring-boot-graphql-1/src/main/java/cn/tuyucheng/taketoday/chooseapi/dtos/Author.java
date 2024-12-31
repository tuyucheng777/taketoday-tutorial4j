package cn.tuyucheng.taketoday.chooseapi.dtos;

public record Author(String firstName, String lastName) {

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Author author = (Author) o;
      return firstName.equals(author.firstName) && lastName.equals(author.lastName);
   }
}