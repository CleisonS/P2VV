package teste;

import dominio.Usuario;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class OperacaoUsuario {
    @BeforeAll
    public static void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);//log de falhas.
        baseURI = "https://reqres.in";//
       basePath = "/api";
    }
    @Test
    public void testMetaDados(){
        //GET
        given().
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
        Usuario usuario = new Usuario("Tunico","programado");
                given().
                        contentType(ContentType.JSON).
                       body(usuario).
                when().
                        post("/users").
                then().
                        statusCode(HttpStatus.SC_CREATED).
                        body("name", is("Tunico"));
    }
}
