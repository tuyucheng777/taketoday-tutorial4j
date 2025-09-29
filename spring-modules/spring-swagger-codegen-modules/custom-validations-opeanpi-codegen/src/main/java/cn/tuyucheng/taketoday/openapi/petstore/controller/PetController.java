package cn.tuyucheng.taketoday.openapi.petstore.controller;

import cn.tuyucheng.taketoday.openapi.api.PetsApi;
import cn.tuyucheng.taketoday.openapi.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class PetController implements PetsApi {

   public ResponseEntity<List<Pet>> findPetsByName(String name) {
      return ResponseEntity.ok(Arrays.asList(new Pet().id(1L).name(name)));
   }
}