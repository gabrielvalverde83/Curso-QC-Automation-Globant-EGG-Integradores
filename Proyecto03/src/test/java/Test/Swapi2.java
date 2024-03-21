package Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Swapi2 {

    @Test
    public void GetJsonDetail() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://swapi.dev/api/people/2/";

        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();

        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "");

        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

    @Test
    public void succesResponse(){
        RestAssured.baseURI = "https://swapi.dev/api/people/2/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("");

        Assert.assertEquals(response.getStatusCode(), 200);

        //se puede hacer tambien
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void skinColor() {

        RestAssured.baseURI = "https://swapi.dev/api/people/2/";
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "");

        //ResponseBody body = response.getBody();

        JsonPath jsonSave = response.jsonPath();

        String jsonSaveAsString = jsonSave.get("skin_color");

        Assert.assertEquals(jsonSaveAsString, "gold", "esta bien");


    }
    /*
    @Ignore //este no me anda
    @Test
    public void postMockapi() {

        RestAssured.baseURI = "https://654c020b77200d6ba85870b5.mockapi.io/api/v1/users";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("first_name", "Gabrielito");
        requestParams.put("last_name", "Valverde");

        Response response = request.request(Method.GET, "");


        System.out.println("Response=>" + response.prettyPrint());


    }

     */





}