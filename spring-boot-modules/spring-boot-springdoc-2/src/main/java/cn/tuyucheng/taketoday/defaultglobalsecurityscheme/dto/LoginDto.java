package cn.tuyucheng.taketoday.defaultglobalsecurityscheme.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.util.Objects;

/**
 * LoginDto
 */
@JsonTypeName("Login")
public class LoginDto {

   @JsonProperty("user")
   private String user;

   @JsonProperty("pass")
   private String pass;

   public LoginDto user(String user) {
      this.user = user;
      return this;
   }

   /**
    * Get user
    *
    * @return user
    */
   @Schema(name = "user", requiredMode = RequiredMode.REQUIRED)
   public String getUser() {
      return user;
   }

   public void setUser(String user) {
      this.user = user;
   }

   public LoginDto pass(String pass) {
      this.pass = pass;
      return this;
   }

   /**
    * Get pass
    *
    * @return pass
    */
   @Schema(name = "pass", required = true)
   public String getPass() {
      return pass;
   }

   public void setPass(String pass) {
      this.pass = pass;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      LoginDto login = (LoginDto) o;
      return Objects.equals(this.user, login.user) && Objects.equals(this.pass, login.pass);
   }

   @Override
   public int hashCode() {
      return Objects.hash(user, pass);
   }

   @Override
   public String toString() {
      return "class LoginDto {\n" +
            "    user: " +
            toIndentedString(user) +
            "\n" +
            "    pass: " +
            toIndentedString(pass) +
            "\n" +
            "}";
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces
    * (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString()
            .replace("\n", "\n    ");
   }
}