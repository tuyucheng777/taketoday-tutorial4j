package cn.tuyucheng.taketoday.jwt.auth0;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTDecode {

   private static final String SECRET = "tuyucheng";
   private static final String ISSUER = "Tuyucheng";
   private static final String SUBJECT = "Tuyucheng Details";
   private static final long TOKEN_VALIDITY_IN_MILLIS = 500L;

   private static Algorithm algorithm;
   private static JWTVerifier verifier;

   public static void initialize() {
      algorithm = Algorithm.HMAC256(SECRET);

      verifier = JWT.require(algorithm)
            .withIssuer(ISSUER)
            .build();
   }

   private static String createJWT() {
      return JWT.create()
            .withIssuer(ISSUER)
            .withSubject(SUBJECT)
            .withIssuedAt(new Date())
            .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_VALIDITY_IN_MILLIS))
            .sign(algorithm);
   }

   private static DecodedJWT verifyJWT(String jwtToken) {
      try {
         return verifier.verify(jwtToken);
      } catch (JWTVerificationException e) {
         System.out.println(e.getMessage());
      }
      return null;
   }

   private static DecodedJWT decodedJWT(String jwtToken) {
      try {
         return JWT.decode(jwtToken);
      } catch (JWTDecodeException e) {
         System.out.println(e.getMessage());
      }
      return null;
   }

   private static boolean isJWTExpired(DecodedJWT decodedJWT) {
      Date expiresAt = decodedJWT.getExpiresAt();
      return expiresAt.before(new Date());
   }

   static void main() throws InterruptedException {
      initialize();

      String jwtToken = createJWT();
      System.out.println("Created JWT : " + jwtToken);

      Thread.sleep(1000L);

      DecodedJWT decodedJWT = verifyJWT(jwtToken);
      if (decodedJWT == null) {
         System.out.println("JWT Verification Failed");
      }

      decodedJWT = decodedJWT(jwtToken);
      if (decodedJWT != null) {
         System.out.println("Token Issued At : " + decodedJWT.getIssuedAt());
         System.out.println("Token Expires At : " + decodedJWT.getExpiresAt());

         Boolean isExpired = isJWTExpired(decodedJWT);
         System.out.println("Is Expired : " + isExpired);
      }
   }
}