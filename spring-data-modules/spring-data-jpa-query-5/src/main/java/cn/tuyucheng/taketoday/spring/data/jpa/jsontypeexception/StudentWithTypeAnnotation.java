package cn.tuyucheng.taketoday.spring.data.jpa.jsontypeexception;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import jakarta.persistence.*;

@Entity
@Table(name = "student_json")
@TypeDefs({
      @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class StudentWithTypeAnnotation {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String admitYear;

   @Type(type = "jsonb")
   @Column(columnDefinition = "json")
   private String address;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getAdmitYear() {
      return admitYear;
   }

   public void setAdmitYear(String admitYear) {
      this.admitYear = admitYear;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}