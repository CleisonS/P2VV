import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class OperacaoUsuario {

    @BeforeAll
    public static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();//log de respostas caso as validações falhem
        baseURI = "https://reqres.in";//
       basePath = "/api";
    }

    @Test
    public void testMetaDados(){
        //GET
        given().
                //param("page","2").
                params("page", "2").
        when().
                get("/users").//
        then().
                statusCode(HttpStatus.SC_OK)
                .body("page", is(2))
                .body("data", is(notNullValue()));

    }

    @Test
    public void criarUsuario(){
        //POST
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
