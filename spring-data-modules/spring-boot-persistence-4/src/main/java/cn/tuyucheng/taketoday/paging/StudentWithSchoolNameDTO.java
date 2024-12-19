package cn.tuyucheng.taketoday.paging;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class StudentWithSchoolNameDTO {

   private String id;

   private String firstName;

   private String lastName;

   private String schoolName;
}