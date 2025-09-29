package cn.tuyucheng.taketoday.javaee.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user")
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"user_role"}))
public class UserServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append("User :").append(request.getUserPrincipal().getName()).append("\n");
      response.getWriter().append("User in Role user_role :").append(String.valueOf(request.isUserInRole("user_role"))).append("\n");
      response.getWriter().append("User in Role admin_role :").append(String.valueOf(request.isUserInRole("admin_role")));
   }
}