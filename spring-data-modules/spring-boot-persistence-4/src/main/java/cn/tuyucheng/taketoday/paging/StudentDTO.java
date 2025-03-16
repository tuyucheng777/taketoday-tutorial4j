package cn.tuyucheng.taketoday.paging;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class StudentDTO {

   private String id;

   private String firstName;

   private String lastName;

}
