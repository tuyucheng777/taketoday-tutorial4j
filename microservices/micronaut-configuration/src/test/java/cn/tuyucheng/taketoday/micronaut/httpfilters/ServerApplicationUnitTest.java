package cn.tuyucheng.taketoday.micronaut.httpfilters;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static cn.tuyucheng.taketoday.micronaut.httpfilters.utils.CustomHttpHeaders.*;
import static org.hamcrest.Matchers.*;

@MicronautTest
class ServerApplicationUnitTest {

   private static final String FILTERED_ENDPOINTS_PATH = "micronaut-configuration-tutorials/filters-annotations";

   @Test
   public void givenFilterForPrivilegedUsers_whenPrivilegedEndpointUsed_thenResponseContainsTag(RequestSpecification spec) {
      spec.given()
            .basePath(FILTERED_ENDPOINTS_PATH)
            .when()
            .get("/endpoint1")
            .then()
            .statusCode(200)
            .body(is("Endpoint 1"))
            .header(PRIVILEGED_USER_HEADER_KEY, "true");
   }

   @Test
   public void givenFilterForPrivilegedUsers_whenNonPrivilegedEndpointUsed_thenResponseNotContainsTag(RequestSpecification spec) {
      spec.given()
            .basePath(FILTERED_ENDPOINTS_PATH)
            .when()
            .get("/endpoint2")
            .then()
            .statusCode(200)
            .body(is("Endpoint 2"))
            .header(PRIVILEGED_USER_HEADER_KEY, emptyOrNullString());
   }

   @Test
   public void givenFilteredPath_whenRequestFiltered1_thenFilteredResponseReturned(RequestSpecification spec) {
      spec.given()
            .basePath(FILTERED_ENDPOINTS_PATH)
            .header(CUSTOM_HEADER_KEY, "custom-value")
            .when()
            .get("/endpoint1")
            .then()
            .statusCode(200)
            .body(is("Endpoint 1"))
            .header(X_TRACE_HEADER_KEY, "true");
   }

   @Test
   public void givenFilteredPath_whenRequestFiltered2_thenFilteredResponseReturned(RequestSpecification spec) {
      spec.given()
            .basePath(FILTERED_ENDPOINTS_PATH)
            .when()
            .get("/endpoint2")
            .then()
            .statusCode(200)
            .body(is("Endpoint 2"))
            .header(X_TRACE_HEADER_KEY, "true");
   }

   @Test
   public void givenFilterWithContinuation_whenRequestIDNotInRequest_thenNewUUIDValuePassedInResponse(RequestSpecification spec) {
      spec.given()
            .basePath(FILTERED_ENDPOINTS_PATH)
            .when()
            .get("/endpoint1")
            .then()
            .statusCode(200)
            .body(is("Endpoint 1"))
            .header(REQUEST_ID_HEADER_KEY, matchesPattern("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"));
   }

   @Test
   public void givenFilterWithContinuation_whenRequestIDInRequest_thenSameValuePassedInResponse(RequestSpecification spec) {
      UUID requestId = UUID.randomUUID();

      spec.given()
            .basePath(FILTERED_ENDPOINTS_PATH)
            .header(REQUEST_ID_HEADER_KEY, requestId)
            .when()
            .get("/endpoint1")
            .then()
            .statusCode(200)
            .body(is("Endpoint 1"))
            .header(REQUEST_ID_HEADER_KEY, requestId.toString());
   }
}