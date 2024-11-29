package userManagement;

import core.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.PatchReqBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PatchUsers
{


    @Test
    public void validatePatchUserWithPOJO()
    {
        String job = "QA Analyst";
        PatchReqBody patchReqBody = new PatchReqBody();
        patchReqBody.setJob(job);

        Response response =
                given()
                        .contentType("application/json")
                        .body(patchReqBody)
                        .when()
                        .patch("https://reqres.in/api/users/2");
        PatchReqBody responsebody = response.as(PatchReqBody.class);
        System.out.println(responsebody.getJob());
        assertEquals(responsebody.getJob(),job);
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.body().asString());
    }


}
