package restassuredDemo;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Demo_GET_Request {

    String baseUrl = "https://reqres.in/api/users?page=2";

    @Test
    public void test_01() {
        //specify baseurl
        Response response = get(baseUrl);

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("responseBody is :" + statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test_02() {
        given().get(baseUrl)
                .then().statusCode(200).body("data.id[0]", equalTo(7));
    }
}

