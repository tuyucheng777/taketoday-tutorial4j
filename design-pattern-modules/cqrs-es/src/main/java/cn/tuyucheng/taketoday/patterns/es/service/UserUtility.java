package cn.tuyucheng.taketoday.patterns.es.service;

import cn.tuyucheng.taketoday.patterns.domain.Address;
import cn.tuyucheng.taketoday.patterns.domain.Contact;
import cn.tuyucheng.taketoday.patterns.domain.User;
import cn.tuyucheng.taketoday.patterns.es.events.*;
import cn.tuyucheng.taketoday.patterns.es.repository.EventStore;

import java.util.List;

public class UserUtility {

   public static User recreateUserState(EventStore store, String userId) {
      User user = null;

      List<Event> events = store.getEvents(userId);
      for (Event event : events) {
         if (event instanceof UserCreatedEvent e) {
            user = new User(e.getUserId(), e.getFirstName(), e.getLastName());
         }
         if (event instanceof UserAddressAddedEvent e) {
            Address address = new Address(e.getCity(), e.getState(), e.getPostCode());
            if (user != null)
               user.getAddresses()
                     .add(address);
         }
         if (event instanceof UserAddressRemovedEvent e) {
            Address address = new Address(e.getCity(), e.getState(), e.getPostCode());
            if (user != null)
               user.getAddresses()
                     .remove(address);
         }
         if (event instanceof UserContactAddedEvent e) {
            Contact contact = new Contact(e.getContactType(), e.getContactDetails());
            if (user != null)
               user.getContacts()
                     .add(contact);
         }
         if (event instanceof UserContactRemovedEvent e) {
            Contact contact = new Contact(e.getContactType(), e.getContactDetails());
            if (user != null)
               user.getContacts()
                     .remove(contact);
         }
      }

      return user;
   }
}