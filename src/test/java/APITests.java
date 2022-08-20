import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class APITests {
    RequestSpecification request;

    @BeforeClass
    void initialize(){
        RestAssured.baseURI =  "https://gorest.co.in";
        request = RestAssured.given()
                .header("Authorization", "Bearer d0c1080ee68bb0d8bd272203bfe8ce0982b804e165dd223439bf35f4e8bd3a7c")
                .header("Content-Type", "application/json");
    }

    @Test
    void getRequest() {
       Response result = RestAssured.get( "/public/v2/users");

       System.out.println("Response: " +result.asString());
       System.out.println( "Status Code :"+result.getStatusCode());
       System.out.println("Body : " +result.getBody());
       System.out.println("Time Token :" +result.getTime());
       System.out.println("Header :"+result.getHeader("content-type"));

       int statusCode = result.getStatusCode();
        Assert.assertEquals(statusCode,200);


        System.out.println("******************************");
        String email = result.getBody().jsonPath().get("[0].email").toString();
        Assert.assertEquals(email, "archan_desai@russel.com");

        String name = result.getBody().jsonPath().get("[0].name").toString();
        Assert.assertEquals(name, "Archan Desai");

        String gender = result.getBody().jsonPath().get("[0].gender");
        Assert.assertFalse(gender.isEmpty());

        String status = result.getBody().jsonPath().get("[0].status").toString();
        Assert.assertEquals(status, "inactive");


    }

    @Test
    void PostRequest() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Md Ausssl khan");
        requestParams.put("email", "abul@bsabssusls.com");
        requestParams.put("gender", "male");
        requestParams.put("status", "active");

        request.body(requestParams.toString());
        Response response = request.post("/public/v2/users");

        System.out.println("***********************************");
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        String name = response.getBody().jsonPath().get("name").toString();
        Assert.assertEquals(name, "Md Ausssl khan");

        String email = response.getBody().jsonPath().get("email").toString();
        Assert.assertEquals(email, "abul@bsabssusls.com");

        System.out.println(name);

        int StatusCode = response.getStatusCode(); //Get Status Code
        Assert.assertEquals(StatusCode,201);
        System.out.println("Status code : " + StatusCode);
    }


    @Test
    void Put_Request() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Rahimss Uddins khan");
        requestParams.put("email", "abulss@uddinkhans.com");
        requestParams.put("gender", "male");
        requestParams.put("status", "active");

        request.body(requestParams.toString());
        Response response = request.put("/public/v2/users/4821");

        System.out.println("***********************************");
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        String name = response.getBody().jsonPath().get("name").toString();
        Assert.assertEquals(name, "Rahimss Uddins khan");

        String email = response.getBody().jsonPath().get("email").toString();
        Assert.assertEquals(email, "abulss@uddinkhans.com");

        int StatusCode = response.getStatusCode(); //Get Status Code
        Assert.assertEquals(StatusCode,200);
        System.out.println("Status code : " + StatusCode);
    }

    @Test
    void Delete_Request() {

        JSONObject requestParams = new JSONObject();

        request.body(requestParams.toString());
        Response response = request.delete("/public/v2/users/4815");

        System.out.println("***********************************");
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        int StatusCode = response.getStatusCode(); //Get Status Code
        Assert.assertEquals(StatusCode,204);
        System.out.println("Status code : " + StatusCode);
    }
}
