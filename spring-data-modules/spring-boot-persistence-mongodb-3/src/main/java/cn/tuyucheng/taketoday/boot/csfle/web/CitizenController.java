package cn.tuyucheng.taketoday.boot.csfle.web;

import cn.tuyucheng.taketoday.boot.csfle.data.Citizen;
import cn.tuyucheng.taketoday.boot.csfle.service.CitizenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

   private final CitizenService service;

   public CitizenController(CitizenService service) {
      this.service = service;
   }

   @GetMapping
   public List<Citizen> get() {
      return service.findAll();
   }

   @GetMapping("by")
   public Citizen getBy(@RequestParam String email) {
      return service.findByEmail(email);
   }

   @PostMapping
   public Object post(@RequestBody Citizen citizen) {
      return service.save(citizen);
   }
}