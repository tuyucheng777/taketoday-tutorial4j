package cn.tuyucheng.taketoday.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetUserWithPrincipalController {

    public GetUserWithPrincipalController() {
        super();
    }

    @GetMapping(value = "/username2")
    public String currentUserName(final Principal principal) {
        return principal.getName();
    }
}