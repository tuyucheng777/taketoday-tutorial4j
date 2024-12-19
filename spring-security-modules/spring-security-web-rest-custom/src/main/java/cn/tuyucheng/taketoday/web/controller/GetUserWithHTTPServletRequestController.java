package cn.tuyucheng.taketoday.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetUserWithHTTPServletRequestController {

    public GetUserWithHTTPServletRequestController() {
        super();
    }

    @GetMapping(value = "/username4")
    public String currentUserNameSimple(final HttpServletRequest request) {
        final Principal principal = request.getUserPrincipal();
        return principal.getName();
    }
}