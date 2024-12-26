package cn.tuyucheng.taketoday.spring.data.persistence.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {

   private String postCode;

   private String city;
}