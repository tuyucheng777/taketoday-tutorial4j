package cn.tuyucheng.taketoday.nullaway;

public class Person {
   int age;
   String name;
   String email;

   public Person(int age, String name, String email) {
      super();
      this.age = age;
      this.name = name;
      this.email = email;
   }

   public int getAge() {
      return age;
   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return "Person [age=" +
            age +
            ", name=" +
            name +
            ", email=" +
            email +
            "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Person other = (Person) obj;
      if (email == null) {
         return other.email == null;
      } else return email.equals(other.email);
   }
}