package cn.tuyucheng.taketoday.patterns.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class UserContact {

   private Map<String, Set<Contact>> contactByType = new HashMap<>();
}