package unit;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class UnitTesting {

    @Test
    public void post() {
        JSONObject unit = new JSONObject();

        unit.put("name", "Flora");
        unit.put("job", "Teacher");

        System.out.println(unit.toJSONString());

        given().
                body(unit.toJSONString()).
        when().
                post ("https://reqres.in/api/users").
        then().
            statusCode(201);
    }
    
    @Test
    public void put() {
        JSONObject unit = new JSONObject();

        unit.put("name", "Lena");
        unit.put("job", "Secretary");

        System.out.println(unit.toJSONString());

        given().
                body(unit.toJSONString()).
        when().
                patch ("https://reqres.in/api/users/2").
        then().
            statusCode(200);
    }
    
    @Test
    public void get() {

        when().
                get ("https://reqres.in/api/users/2").
        then().
            statusCode(200).log().all();
    }
    
    @Test
    public void delete() {

        when().
                delete ("https://reqres.in/api/users/2").
        then().
            statusCode(204).log().all();
    }

}