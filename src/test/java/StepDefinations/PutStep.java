package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

public class PutStep {
    RequestSpecification request;
    Response result;

    public PutStep() {
        RestAssured.baseURI =  "https://gorest.co.in";
        request = RestAssured.given()
                .header("Authorization", "Bearer d0c1080ee68bb0d8bd272203bfe8ce0982b804e165dd223439bf35f4e8bd3a7c")
                .header("Content-Type", "application/json");
    }

    @Given("Update user to specific ID")
    public void updateUserToSpecificID() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Md Abir Abir");
        requestParams.put("email", "abir@khansssss.com");
        requestParams.put("gender", "male");
        requestParams.put("status", "active");

        request.body(requestParams.toString());
        result = request.put( "/public/v2/users/4856");

        System.out.println("***********************************");
        int statusCode = result.getStatusCode();
        Assert.assertEquals(statusCode,200);
        System.out.println(statusCode);
    }

    @And("Response body is")
    public void responseBodyIs() {
        String responseBody = result.getBody().asString();
        System.out.println(responseBody);
    }

    @And("Response Message should {string}")
    public void responseMessageShould(String message) {
        String responseMessage = result.getStatusLine();
        Assert.assertTrue(responseMessage.contains(message));
        System.out.println(responseMessage);
    }

    @And("Name should be {string}")
    public void nameShouldBe(String name) {
        String resName = result.getBody().jsonPath().get("name").toString();
        Assert.assertEquals(resName, name);
    }
}
