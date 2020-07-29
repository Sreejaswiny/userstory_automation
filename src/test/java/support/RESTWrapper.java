package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RESTWrapper {

    private String baseurl = "https://skryabin.com/recruit/api/v1/";
    private String loginToken;
    private String CONTENT_TYPE = "Content-Type";
    private String JSON = "application/json";
    private String AUTH = "Authorization";

    public void login(Map<String,String> user){

        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseurl)
                .basePath("login")
                .header("Content-Type","application/json")
                .body(user);
        Response response = request
                .when()
                .post();
        Map<String,Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        loginToken = "Bearer " + result.get("token");
    }
}
