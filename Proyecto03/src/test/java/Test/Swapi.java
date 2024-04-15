package Test;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;


import static io.restassured.RestAssured.given;

public class Swapi {

    private String url = "https://swapi.dev/api/";
    private String endpoint = "people/2/";

    //private String endpoint2 = "films/2/";        //lo seteaba, luego lo busco del JSON

    private String urlEndpoint2 = grabEndpoint2();  //busca en endpoint2



    private Response response;

    //*********************************************************************************//
    public String grabEndpoint2() {
        String endpoint2;
        response = given().get(url + endpoint);
        ArrayList<String> jsonSaveArrayFilms = response.jsonPath().get("films");
        endpoint2 = jsonSaveArrayFilms.get(1);
        return endpoint2;
    }

    //*********************************************************************************//
    //First point

    @Test
    public void succesResponse() {
        response = given().get(url + endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void skinColor() {
        response = given().get(url + endpoint);
        JsonPath jsonSave = response.jsonPath();
        Assert.assertEquals(jsonSave.get("skin_color"), "gold");

        //lo puedo hacer de esta forma tambien
        String jsonSaveString = response.jsonPath().get("skin_color");
        Assert.assertEquals(jsonSaveString, "gold");
    }

    @Test
    public void amountFilms() {
        response = given().get(url + endpoint);
        JsonPath jsonSave = response.jsonPath();
        Assert.assertEquals(jsonSave.getList("films").size(), 6);
    }


    //*********************************************************************************//
    //Second point

    @Test
    public void releaseDate() {
        response = given().get(urlEndpoint2);
        String expectedFormatDate = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        //String expectedFormatDate = "\\d{4}-\\d{2}-\\d{2}";
        String releaseDate = response.jsonPath().get("release_date");
        Assert.assertTrue(releaseDate.matches(expectedFormatDate));
    }

    @Test
    public void searchIfArePresent() {
        response = given().get(urlEndpoint2);
        JsonPath jsonSave = response.jsonPath();
        Assert.assertTrue(jsonSave.getList("characters").size() > 1);
        Assert.assertTrue(jsonSave.getList("planets").size() > 1);
        Assert.assertTrue(jsonSave.getList("starships").size() > 1);
        Assert.assertTrue(jsonSave.getList("vehicles ").size() > 1);
        Assert.assertTrue(jsonSave.getList("species").size() > 1);
    }
}