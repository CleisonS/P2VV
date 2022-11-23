import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import  java.util.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;

public class UserOperations {

   // public static String baseUrl = "https://petstore.swagger.io/v2/swagger.json";

    @Test
    public void testMetaDados(){
        when().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(HttpStatus.SC_OK)
                .body("page", is(2))
                .body("data", is(notNullValue()));

    }

    @Test
    public void criarUsuario(){
        given().log().all().
                contentType(ContentType.JSON).
               body("{\"name\": \"Tunico\", \"job\": \"progamador\" }").
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(HttpStatus.SC_CREATED).
                body("name", is("Tunico"));
    }
}
