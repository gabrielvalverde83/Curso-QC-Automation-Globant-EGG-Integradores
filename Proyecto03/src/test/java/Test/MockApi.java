package Test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MockApi {

    @Test
    public void getExample() {
        Response response;
        response = given().get("http://5d6fd3a8482b530014d2e8da.mockapi.io/mock/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //mi mockapi
    @Test
    public void getExample2() {
        Response response;
        response = given().get("https://654c020b77200d6ba85870b5.mockapi.io/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    //post mi mockapi
    @Test
    public void postExample() {
        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("first_name", "Gabrielito");
        user.put("last_name", "Valverde");
        response = given().contentType("application/json").body(user).when().post("https://654c020b77200d6ba85870b5.mockapi.io/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 201);     //201 es que se creo el usuario
    }


    //porque mierda me da error este, será porque tiene mas campos?
    @Ignore
    @Test
    public void postExample3() {
        Response response;
        Map<String, String> user = new HashMap<>();
        user.put("first_name", "Josh");
        user.put("last_name", "Some");
        /*user.put("email", "some@email.com");
        user.put("country", "US");
        user.put("telephone", "5465454");
        user.put("active", "true");
        user.put("job_title", "QA");
        user.put("id", "10");
        user.put("telephone_name", "54545454");
        user.put("email_name", "lo@lolo.com");
        user.put("country_name", "Argentina");
        user.put("las_name", "Fer");

         */
        response = given().contentType("application/json").body(user).when().post("http://5d6fd3a8482b530014d2e8da.mockapi.io/mock/api/v1/users");
        Assert.assertEquals(response.getStatusCode(), 201);


    }


}
