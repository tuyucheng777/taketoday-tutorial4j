package cn.tuyucheng.taketoday.jwt.replace_deprecated_jwt_parser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class DeprecatedParser {

   static void main() {
      SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

      String token = Jwts.builder()
            .setSubject("tuyucheng")
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
            .signWith(key)
            .compact();

      JwtParser parser = Jwts.parser()
            .setSigningKey(key);

      Claims claims = parser.parseClaimsJws(token)
            .getBody();

      System.out.println("Claims: " + claims);
   }
}