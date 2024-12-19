package cn.tuyucheng.taketoday.boot.keycloak.client;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class UiController {
   @GetMapping("/")
   public String getIndex(Model model, Authentication auth) {
      model.addAttribute(
            "name",
            auth instanceof OAuth2AuthenticationToken oauth && oauth.getPrincipal() instanceof OidcUser oidc ?
                  oidc.getPreferredUsername() :
                  "");
      model.addAttribute("isAuthenticated", auth != null && auth.isAuthenticated());
      model.addAttribute("isNice", auth != null && auth.getAuthorities().stream().anyMatch(authority -> Objects.equals("NICE", authority.getAuthority())));
      return "index.html";
   }

   @GetMapping("/nice")
   public String getNice(Model model, Authentication auth) {
      return "nice.html";
   }
}