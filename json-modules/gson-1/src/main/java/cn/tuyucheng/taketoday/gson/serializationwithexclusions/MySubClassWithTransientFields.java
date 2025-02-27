package cn.tuyucheng.taketoday.gson.serializationwithexclusions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MySubClassWithTransientFields {

   private long id;
   private String description;
   private transient String otherVerboseInfo;
}