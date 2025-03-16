package cn.tuyucheng.taketoday.spring.data.persistence.json;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "student")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class StudentEntity {

   @Id
   @Column(name = "student_id", length = 8)
   private String id;

   @Column(name = "admit_year", length = 4)
   private String admitYear;

   @Type(JsonBinaryType.class)
   @JdbcTypeCode(SqlTypes.JSON)
   @Column(name = "address", columnDefinition = "jsonb")
   private Address address;

}