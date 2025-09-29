package cn.tuyucheng.taketoday.patterns.cqrs.projectors;

import cn.tuyucheng.taketoday.patterns.cqrs.repository.UserReadRepository;
import cn.tuyucheng.taketoday.patterns.domain.*;

import java.util.*;

public class UserProjector {

   UserReadRepository readRepository = new UserReadRepository();

   public UserProjector(UserReadRepository readRepository) {
      this.readRepository = readRepository;
   }

   public void project(User user) {
      UserContact userContact = Optional.ofNullable(readRepository.getUserContact(user.getUserid()))
            .orElse(new UserContact());
      Map<String, Set<Contact>> contactByType = new HashMap<>();
      for (Contact contact : user.getContacts()) {
         Set<Contact> contacts = Optional.ofNullable(contactByType.get(contact.getType()))
               .orElse(new HashSet<>());
         contacts.add(contact);
         contactByType.put(contact.getType(), contacts);
      }
      userContact.setContactByType(contactByType);
      readRepository.addUserContact(user.getUserid(), userContact);

      UserAddress userAddress = Optional.ofNullable(readRepository.getUserAddress(user.getUserid()))
            .orElse(new UserAddress());
      Map<String, Set<Address>> addressByRegion = new HashMap<>();
      for (Address address : user.getAddresses()) {
         Set<Address> addresses = Optional.ofNullable(addressByRegion.get(address.getState()))
               .orElse(new HashSet<>());
         addresses.add(address);
         addressByRegion.put(address.getState(), addresses);
      }
      userAddress.setAddressByRegion(addressByRegion);
      readRepository.addUserAddress(user.getUserid(), userAddress);
   }
}