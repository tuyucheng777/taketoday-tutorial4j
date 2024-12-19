package cn.tuyucheng.taketoday.paging;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "school")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class School {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "school_id")
   private Integer id;

   private String name;
}