package userManagement;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.PutRequestBody;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PutUsers {

    @Test
    public void putUsersWithPojo()
    {
        PutRequestBody putRequestBody = new PutRequestBody();
        putRequestBody.setJob("developer");
        putRequestBody.setName("Niraj");
        Response response =
                given().
                        body(putRequestBody)
                        .when()
                        .put("https://reqres.in/api/users/2");

        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);


    }


}
