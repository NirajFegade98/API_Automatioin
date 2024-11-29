package userManagement;

import core.StatusCode;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import pojo.CityRequest;
import pojo.PostRequestBody;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.testng.AssertJUnit.assertEquals;

public class postUsers {

    private static FileInputStream fileInputStreamMethod(){
        FileInputStream fileInputStream;

        try{
            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/resources/testData/postRequestBody.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fileInputStream;
    }

    @Test
    public void validatePostWithString() {
        Response res =
                given()
                        .body("{\"name\":\"morpheus\",\"job\":\"leader\"}")
                        .when()
                        .post("https://reqres.in/api/users");

        assertEquals(res.getStatusCode(), StatusCode.CREATED.code);

        System.out.println("validatePostWithString executed successfully");
        System.out.println(res.body().asString());

    }


    @Test
    public void validatePostWithJson() throws IOException {
        Response res =
                given()
                        .body(IOUtils.toString(fileInputStreamMethod()))
                        .when()
                        .post("https://reqres.in/api/users");
        assertEquals(res.getStatusCode(), StatusCode.CREATED.code);

        System.out.println("validatePostWithJSON executed successfully");
        System.out.println(res.body().asString());
    }

    @Test
    public void validatePostWithPOJO() throws IOException {

        PostRequestBody postRequest = new PostRequestBody();
        postRequest.setName("John Doe");
        postRequest.setJob("Developer");
        List<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("react");
        postRequest.setLanguages(languages);
        Response res =
                given()
                        .body(postRequest)
                        .when()
                        .post("https://reqres.in/api/users");
        assertEquals(res.getStatusCode(), StatusCode.CREATED.code);

        System.out.println("validatePostWithPOJO executed successfully");
        System.out.println(res.body().asString());
    }

    @Test
    public void validatePostWithPOJOCity() throws IOException {


        CityRequest cityRequest1 = new CityRequest();
        cityRequest1.setName("city1");
        cityRequest1.setTemperature("40");
        CityRequest cityRequest2 = new CityRequest();
        cityRequest2.setName("city2");
        cityRequest2.setTemperature("36");
        List<CityRequest> cityRequests = new ArrayList<>();
        cityRequests.add(cityRequest1);
        cityRequests.add(cityRequest2);

        PostRequestBody postRequest = new PostRequestBody();
        postRequest.setName("John Doe");
        postRequest.setJob("Developer");


        List<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("react");


        postRequest.setLanguages(languages);
        postRequest.setCityRequests(cityRequests);
        Response res =
                given()
                        .body(postRequest)
                        .when()
                        .post("https://reqres.in/api/users");
        assertEquals(res.getStatusCode(), StatusCode.CREATED.code);

        System.out.println("validatePostWithPOJOCity executed successfully");
        System.out.println(res.body().asString());
    }

    @Test
    public void validatePostWithPOJOObjectDesrialize() throws IOException {


        CityRequest cityRequest1 = new CityRequest();
        cityRequest1.setName("city1");
        cityRequest1.setTemperature("40");
        CityRequest cityRequest2 = new CityRequest();
        cityRequest2.setName("city2");
        cityRequest2.setTemperature("36");
        List<CityRequest> cityRequests = new ArrayList<>();
        cityRequests.add(cityRequest1);
        cityRequests.add(cityRequest2);

        PostRequestBody postRequest = new PostRequestBody();
        postRequest.setName("John Doe");
        postRequest.setJob("Developer");


        List<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("react");


        postRequest.setLanguages(languages);
        postRequest.setCityRequests(cityRequests);
        Response res =
                given()
                        .contentType("application/json")
                        .body(postRequest)
                        .when()
                        .post("https://reqres.in/api/users");
        assertEquals(res.getStatusCode(), StatusCode.CREATED.code);

        PostRequestBody postResponseBody = res.as(PostRequestBody.class);
        for(int i=0; i<cityRequests.size();i++)
        {
            //System.out.println(postResponseBody.getCityRequests().get(i).getName());
            //System.out.println(postResponseBody.getCityRequests().get(i).getTemperature());

            assertEquals(postResponseBody.getCityRequests().get(i).getName(), cityRequests.get(i).getName());
            assertEquals(postResponseBody.getCityRequests().get(i).getTemperature(), cityRequests.get(i).getTemperature());
        }

        System.out.println(postResponseBody.getLanguages());

        System.out.println("validatePostWithPOJOObjectDesrialize executed successfully");
        System.out.println(res.body().asString());
    }


}
