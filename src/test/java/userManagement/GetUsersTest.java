package userManagement;

import core.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExtentReport;
import utils.JsonReader;
import utils.PropertyReader;

import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;


public class GetUsersTest extends BaseTest {

    @Test
    public void getUserData() {
        ExtentReport.extentlog = ExtentReport.extentreport.createTest("getUserData", "Validate 200 status code");
        given().
                when().get("https://reqres.in/api/users?page=2").
                then().
                assertThat().
                statusCode(200);
    }

//    @SuppressWarnings("deprecation")
//    @Test
//    public void validateResponseBody() {
//
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
//        given().
//                when()
//                .get("/todos/2")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(not(isEmptyString()))
//                .body("title", equalTo("quis ut nam facilis et officia qui"))
//                .body("userId", equalTo(1));
//    }
//
//    @SuppressWarnings("deprecation")
//    @Test
//    public void validateHasitems() {
//
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
//
//        Response response = given().
//                when()
//                .get("/comments")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(not(isEmptyString()))
//                .extract().response();
//
//        assertThat(response.jsonPath().getList("name"), hasItems("id labore ex et quam laborum", "quo vero reiciendis velit similique earum"));
//    }
//
//    @SuppressWarnings("deprecation")
//    @Test
//    public void validateHasSize() {
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
//
//        Response response = given()
//                .when()
//                .get("/comments")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(not(isEmptyString()))
//                .extract().response();
//
//        assertThat(response.jsonPath().getList(""), hasSize(500));
//    }
//
//    @SuppressWarnings("deprecation")
//    @Test
//    public void validatehasItemInList() {
//        RestAssured.baseURI = "https://reqres.in/";
//
//        Response response = given()
//                .when()
//                .get("/api/unknown")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(not(isEmptyString()))
//                .extract().response();
//
//        assertThat(response.jsonPath().getList("data.name"), hasItems("cerulean"));
//    }
//
//    @SuppressWarnings("deprecation")
//    @Test
//    public void containsMatch() {
//        RestAssured.baseURI = "https://reqres.in/";
//
//        Response response = given()
//                .when()
//                .get("/api/unknown")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(not(isEmptyString()))
//                .extract().response();
//
//        List<String> expectedNames = Arrays.asList("cerulean", "fuchsia rose", "true red", "aqua sky", "tigerlily", "blue turquoise");
//        assertThat(response.jsonPath().getList("data.name"), contains(expectedNames.toArray(new String[0])));
//
//    }
//
//    //validate every field in a single section
//    @Test
//    @SuppressWarnings("deprecation")
//    public void validateEachField() {
//        RestAssured.baseURI = "https://reqres.in/";
//
//        Response response = given()
//                .when()
//                .get("/api/unknown")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .body(not(isEmptyString()))
//                .extract().response();
//
//        response.then().body("data[1].name", equalTo("fuchsia rose"));
//        response.then().body("data[1].year", equalTo(2001));
//        response.then().body("data[1].color", equalTo("#C74375"));
//        response.then().body("data[1].pantone_value", equalTo("17-2031"));
//
//
//    }
//
//    //Automate Query Parameter
//    @Test
//    @SuppressWarnings("deprecation")
//    public void testQueryParam() {
//        RestAssured.baseURI = "https://reqres.in/";
//
//        Response response =
//                given()
//                        .queryParam("page", 2)
//                        .when()
//                        .get("/api/users")
//                        .then()
//                        .assertThat()
//                        .statusCode(200)
//                        .body(not(isEmptyString()))
//                        .extract().response();
//
//
//    }
//
//    //            Automate path parameter
//    @Test
//    @SuppressWarnings("deprecation")
//    public void testPathParam() {
//        RestAssured.baseURI = "http://ergast.com/";
//
//        Response res =
//                given()
//                        .pathParams("season", 2008)
//                        .when()
//                        .get("/api/f1/{season}")
//                        .then()
//                        .assertThat()
//                        .statusCode(200)
//                        .body(not(isEmptyString()))
//                        .extract()
//                        .response();
//        System.out.println(res.body().asString());
//
//    }
//    //print response body
//    //System.out.println(response.body().asString());
//
//
//    //Automate Form param
////            @Test
////            public void testFormParam () {
////
////                RestAssured.baseURI = "https://reqres.in/api/users";
////
////                Response response =
////                        given()
////                                .header("Content-Type","application/x-www-form-urlencoded")
////                                .formParam("name", "John Doe")
////                                .formParam("job", "Developer")
////                                .when()
////                                .post()
////                                .then()
////                                .statusCode(201)
////                                .extract().response();
////                response.then().log().all();
////
////                response.then().body("name", equalTo("John Doe"));
////                response.then().body("job", equalTo("Developer"));
////
////            }
//
//    //get all objects of another API
//    @Test
//    @SuppressWarnings("deprecation")
//    public void getAllObjects() {
//
//        RestAssured.baseURI = "https://api.restful-api.dev/";
//
//
//        Response response =
//                given()
//                        .when()
//                        .get("/objects")
//                        .then()
//                        .body(not(isEmptyString()))
//                        .statusCode(200)
//                        .extract().response();
//
//        System.out.println(response.asString());
//
//
//    }
//
//
//    //get object by ID 's of another API
//    @Test
//    @SuppressWarnings("deprecation")
//    public void getOneObjects() {
//
//        RestAssured.baseURI = "https://api.restful-api.dev/";
//
//
//        Response response =
//                given()
//                        .queryParam("id", 3)
//                        .queryParam("id", 5)
//                        .queryParam("id", 10)
//                        .when()
//                        .get("/objects")
//                        .then()
//                        .body(not(isEmptyString()))
//                        .statusCode(200)
//                        .extract().response();
//
//        assertThat(response.jsonPath().getList("name"), hasItems("Apple iPhone 12 Pro Max"));
//        System.out.println(response.asString());
//
//
//    }
//
//    @Test
//    public void automateHeader() {
//
//        RestAssured.baseURI = "https://api.thecatapi.com/";
//
//
//        Response response =
//                given()
//                        .header("content-type", "application/json")
//                        .header("x-api-key", "live_Kg49xHOChq1RU0L6JRl6WrAqjEfKtRAZaj42aFdXHyQu0BujNYAsj58Q5oE38uke")
//                        .queryParam("order", "ASC")
//                        .queryParam("page", 1)
//                        .queryParam("limit", 5)
//                        .when()
//                        .get("/v1/images/search")
//                        .then()
//                        .assertThat()
//                        .statusCode(200)
//                        .extract().response();
//        Headers headers = response.getHeaders();
//
//        for (Header h : headers) {
//            if (h.getName().contains("content-type")) {
//                System.out.println(h.getName() + " " + h.getValue());
//
//            }
//        }
//    }
//
//
//    @Test
//    public void automatetwoheader() {
//        RestAssured.baseURI = "https://api.thecatapi.com";
//
//        Response response =
//                given()
//                        .header("Content-Type", "application/json")
//                        .header("x-api-key", "live_Kg49xHOChq1RU0L6JRl6WrAqjEfKtRAZaj42aFdXHyQu0BujNYAsj58Q5oE38uke")
//                        .when()
//                        .get("/v1/images/search")
//                        .then()
//                        .statusCode(200)
//                        .extract().response();
//
//        System.out.println("automateheader testcase passed successfully" + response.body().asString());
//    }
//
    @Test
    public void automateHeaderWithMap() {
        ExtentReport.extentlog = ExtentReport.extentreport.createTest("automateHeaderWithMap", "Testcase passed successfully");
        RestAssured.baseURI = "https://api.thecatapi.com";

        Map<String, String> headerMap = new HashMap<>();

        headerMap.put("Content-Type", "application/json");
        headerMap.put("x-api-key", "live_Kg49xHOChq1RU0L6JRl6WrAqjEfKtRAZaj42aFdXHyQu0BujNYAsj58Q5oE38uke");

        Response res =
                given()
                        .headers(headerMap)
                        .when()
                        .get("/v1/images/search")
                        .then()
                        .statusCode(200)
                        .extract().response();

    }
//
//    @Test
//    public void automateResponseHeader() {
//        RestAssured.baseURI = "https://api.thecatapi.com";
//
//        Response res =
//                given()
//                        .when()
//                        .get("/v1/images/search")
//                        .then()
//                        .extract().response();
//        Headers headers = res.getHeaders();
//
///*       for(Header h : headers)
//       {
//           System.out.println(h.getName()+" " +h.getValue());
//       }*/
//
//        for (Header h : headers) {
//            if (h.getName().contains("authenticated")) {
//                System.out.println(h.getValue());
//                assertEquals(h.getValue(), "false");
//            }
//        }
//    }
//
//    //Cookies
//    @Test
//    public void automateCookie() {
//        RestAssured.baseURI = "https://api.thecatapi.com";
//
//        Response res =
//                given()
//                        .cookie("Test", "testing")
//                        .when()
//                        .get("/v1/images/search")
//                        .then()
//                        .statusCode(200)
//                        .extract().response();
//
//    }
//
//    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 2);
//        map.put(3, 4);
//
//        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
//            System.out.println(m.getKey() + " " + m.getValue());
//        }
//    }
//
//    //Automate Authentication and authorization
//    @Test
//    public void validateBasicAuth() {
//        Response response =
//                given()
//                        .auth()
//                        .basic("postman", "password")
//                        .when()
//                        .get("https://postman-echo.com/basic-auth/");
//
//        System.out.println(response.body().asString());
//
//    }
//
//    @Test
//    public void validateDigestAuth() {
//        Response response =
//                given()
//                        .auth()
//                        .digest("postman", "password")
//                        .when()
//                        .get("https://postman-echo.com/basic-auth/");
//
//        System.out.println(response.body().asString());
//
//    }


    @Test
    public void useDeleteMethod()
    {
        ExtentReport.extentlog = ExtentReport.extentreport.createTest("useDeleteMethod", "Validated 204 status code");
        Response res =
                given()
                        .when()
                        .delete("https://reqres.in/api/users/2");

        int actualStatusCode = res.statusCode();
        assertEquals(actualStatusCode, 204);
    }


//    @Test
//    public void validateTestDatawithJson() throws IOException, ParseException {
//        String userName = JsonReader.getTestData("username");
//        String password = JsonReader.getTestData("password");
//        System.out.println(userName + " : " + password);
//        Response response =
//                given()
//                        .auth()
//                        .basic(userName, password)
//                        .when()
//                        .get("https://postman-echo.com/basic-auth/");
//
//        System.out.println("validateTestDatawithJson executed successfully");
//
//    }
//
//    @Test
//    public void validateTestDatawithconfig() throws IOException, ParseException {
//
//        String serverAddress = PropertyReader.propertyReader("config.properties", "server");
//        Response response =
//                given()
//                        .when()
//                        .get(serverAddress);
//
//        System.out.println("validateTestDatawithconfig executed successfully");
//
//    }


}





