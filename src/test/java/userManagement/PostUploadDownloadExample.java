package userManagement;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostUploadDownloadExample {

    @Test
    public void FileUploadExample(){
        File file = new File("");

        Response res =
                 given()
                        .multiPart("file", file)
                        .when()
                        .post(" ");

        System.out.println("File added successfully");
    }


}
