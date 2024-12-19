package cn.tuyucheng.taketoday.paging;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@NamedEntityGraph(name = "Student.school", attributeNodes = @NamedAttributeNode("school"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Student {

   @Id
   @Column(name = "student_id")
   private String id;

   @Column(name = "first_name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "school_id", referencedColumnName = "school_id")
   private School school;
}