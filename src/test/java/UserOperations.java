import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import  java.util.*;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
public class UserOperations {

    public static String baseUrl = "https://petstore.swagger.io/v2/swagger.json";

    @Test
    public void testMetaDados(){
        when().
                get("https://reqres.in/api/users?page=2").
        then().
                statusCode(200)
                .body("page", is(2));

    }
}
