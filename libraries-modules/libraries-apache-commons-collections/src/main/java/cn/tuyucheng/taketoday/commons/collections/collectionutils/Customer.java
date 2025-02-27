package cn.tuyucheng.taketoday.commons.collections.collectionutils;

public class Customer implements Comparable<Customer> {

   private Integer id;
   private String name;
   private Long phone;
   private String locality;
   private String city;
   private String zip;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Long getPhone() {
      return phone;
   }

   public void setPhone(Long phone) {
      this.phone = phone;
   }

   public String getLocality() {
      return locality;
   }

   public void setLocality(String locality) {
      this.locality = locality;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getZip() {
      return zip;
   }

   public void setZip(String zip) {
      this.zip = zip;
   }

   public Customer(Integer id, String name, Long phone, String locality, String city, String zip) {
      super();
      this.id = id;
      this.name = name;
      this.phone = phone;
      this.locality = locality;
      this.city = city;
      this.zip = zip;
   }

   public Customer(Integer id, String name, Long phone) {
      super();
      this.id = id;
      this.name = name;
      this.phone = phone;
   }

   public Customer(String name) {
      super();
      this.name = name;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
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
      Customer other = (Customer) obj;
      if (name == null) {
         return other.name == null;
      } else return name.equals(other.name);
   }

   public int compareTo(Customer o) {
      return this.name.compareTo(o.getName());
   }

   @Override
   public String toString() {
      return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
   }
}