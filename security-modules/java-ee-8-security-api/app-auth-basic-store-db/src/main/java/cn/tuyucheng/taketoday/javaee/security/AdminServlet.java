package cn.tuyucheng.taketoday.javaee.security;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"admin_role"}))
public class AdminServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      response.getWriter().append("User :").append(request.getUserPrincipal().getName()).append("\n");
      response.getWriter().append("User in Role user_role :").append(String.valueOf(request.isUserInRole("user_role"))).append("\n");
      response.getWriter().append("User in Role admin_role :").append(String.valueOf(request.isUserInRole("admin_role")));
   }
}