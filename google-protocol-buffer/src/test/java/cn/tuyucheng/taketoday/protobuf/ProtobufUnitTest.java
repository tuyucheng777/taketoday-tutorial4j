package cn.tuyucheng.taketoday.protobuf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProtobufUnitTest {
   private final String filePath = "address_book";

   @AfterEach
   void cleanup() throws IOException {
      Files.deleteIfExists(Paths.get(filePath));
   }

   @Test
   void givenGeneratedProtobufClass_whenCreateClass_thenShouldCreateJavaInstance() {
      // when
      String email = "j@tuyucheng.com";
      int id = new Random().nextInt();
      String name = "Michael Program";
      String number = "01234567890";
      AddressBookProtos.Person person =
            AddressBookProtos.Person.newBuilder()
                  .setId(id)
                  .setName(name)
                  .setEmail(email)
                  .addNumbers(number)
                  .build();
      // then
      assertEquals(email, person.getEmail());
      assertEquals(person.getId(), id);
      assertEquals(name, person.getName());
      assertEquals(number, person.getNumbers(0));
   }

   @Test
   void givenAddressBookWithOnePerson_whenSaveAsAFile_shouldLoadFromFileToJavaClass() throws IOException {
      // given
      String email = "j@tuyucheng.com";
      int id = new Random().nextInt();
      String name = "Michael Program";
      String number = "01234567890";
      AddressBookProtos.Person person =
            AddressBookProtos.Person.newBuilder()
                  .setId(id)
                  .setName(name)
                  .setEmail(email)
                  .addNumbers(number)
                  .build();

      // when
      AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook.newBuilder().addPeople(person).build();
      FileOutputStream fos = new FileOutputStream(filePath);
      addressBook.writeTo(fos);
      fos.close();

      // then
      FileInputStream fis = new FileInputStream(filePath);
      AddressBookProtos.AddressBook deserialized =
            AddressBookProtos.AddressBook.newBuilder().mergeFrom(fis).build();
      fis.close();
      assertEquals(email, deserialized.getPeople(0).getEmail());
      assertEquals(deserialized.getPeople(0).getId(), id);
      assertEquals(name, deserialized.getPeople(0).getName());
      assertEquals(number, deserialized.getPeople(0).getNumbers(0));
   }
}