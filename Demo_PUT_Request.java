package restassuredDemo;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import org.junit.Before;
import org.junit.Test;
import restassuredDemo.Login.RestUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Demo_PUT_Request {

    public static HashMap map = new HashMap();

    String empName = RestUtils.empName();
    String empSalary = RestUtils.empSal();
    String empAge = RestUtils.empAge();
    int emp_id = 11254;

    @Before
    public void putData()
    {
        map.put("name", empName);
        map.put("salary", empSalary);
        map.put("age", empAge);

        RestAssured.baseURI = "http://localhost:3000/users";
        RestAssured.basePath = "/update/"+emp_id;
    }

    @Test
    public void testPUT() {
        given()
                .contentType("application.json")
                .body(map)
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all();
    }
}
