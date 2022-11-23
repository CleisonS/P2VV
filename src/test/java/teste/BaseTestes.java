package teste;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class BaseTestes {

    @BeforeAll
    public static void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
        baseURI = "https://reqres.in";//
        basePath = "/api";

        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
