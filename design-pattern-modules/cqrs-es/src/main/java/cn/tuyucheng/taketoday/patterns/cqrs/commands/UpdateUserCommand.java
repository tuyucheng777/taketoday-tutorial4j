package cn.tuyucheng.taketoday.patterns.cqrs.commands;

import cn.tuyucheng.taketoday.patterns.domain.Address;
import cn.tuyucheng.taketoday.patterns.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class UpdateUserCommand {

   private String userId;
   private Set<Address> addresses = new HashSet<>();
   private Set<Contact> contacts = new HashSet<>();
}