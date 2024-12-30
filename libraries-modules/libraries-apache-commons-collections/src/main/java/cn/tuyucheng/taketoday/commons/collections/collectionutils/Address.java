package cn.tuyucheng.taketoday.commons.collections.collectionutils;

public class Address {

   private String locality;
   private String city;
   private String zip;

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

   @Override
   public String toString() {
      return "Address [locality=" + locality + ", city=" + city + ", zip=" + zip + "]";
   }

   public Address(String locality, String city, String zip) {
      super();
      this.locality = locality;
      this.city = city;
      this.zip = zip;
   }
}