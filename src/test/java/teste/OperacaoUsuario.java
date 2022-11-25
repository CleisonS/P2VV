package teste;

import dominio.Usuario;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class OperacaoUsuario extends BaseTestes {

    @Test
    public void testMetaDados(){
        //GET
        given()
                .params("page", "2").
        when()
                .get("/users").//
        then()
                .statusCode(HttpStatus.SC_OK)
                .body("page", is(2))
                .body("data", is(notNullValue()));
    }

    @Test
    public void criarUsuario(){
        //POST
        Usuario usuario = new Usuario("Tunico","programado");
                given()
                        .body(usuario).
                when()
                        .post("/users").
                then()
                        .statusCode(HttpStatus.SC_CREATED)
                        .body("name", is("Tunico"));
    }


}
