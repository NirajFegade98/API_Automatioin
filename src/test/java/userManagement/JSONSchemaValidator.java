package userManagement;


import core.StatusCode;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JSONSchemaValidator {



    @Test
    public void JsonSchemaValidation()
    {
        File schema = new File("resources/ExpectedSchema.json");
        Response response =
                given()
                        .when()
                        .get("https://reqres.in/api/users");

        response.then()
                .assertThat()
                        .body(JsonSchemaValidator.matchesJsonSchema(schema));

        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);


    }

}
