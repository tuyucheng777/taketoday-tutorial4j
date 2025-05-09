package cn.tuyucheng.taketoday.web.controller;

import cn.tuyucheng.taketoday.web.dto.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Controller
@RequestMapping(value = "/auth/foos")
public class FooController {

   @Autowired
   private ApplicationEventPublisher eventPublisher;

   public FooController() {
      super();
   }

   // API

   // read - single

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   @ResponseBody
   public Foo findById(@PathVariable("id") final Long id, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
      return new Foo(randomAlphabetic(6));
   }

   // read - multiple

   @RequestMapping(method = RequestMethod.GET)
   @ResponseBody
   public List<Foo> findAll() {
      return Arrays.asList(new Foo(randomAlphabetic(6)));
   }

   // write - just for test
   @RequestMapping(method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody
   public Foo create(@RequestBody final Foo foo) {
      return foo;
   }
}