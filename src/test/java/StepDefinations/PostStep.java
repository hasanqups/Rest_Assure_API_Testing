package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

public class PostStep {
    RequestSpecification request;
    Response result;

    public PostStep() {
        RestAssured.baseURI =  "https://gorest.co.in";
        request = RestAssured.given()
                .header("Authorization", "Bearer d0c1080ee68bb0d8bd272203bfe8ce0982b804e165dd223439bf35f4e8bd3a7c")
                .header("Content-Type", "application/json");
    }

    @Given("Post user into Go Rest API")
    public void user_wants_to_get_all_information() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Md Mojibur khan");
        requestParams.put("email", "mojibur@khanss.com");
        requestParams.put("gender", "male");
        requestParams.put("status", "active");

        request.body(requestParams.toString());
        result = request.post( "/public/v2/users");

        System.out.println("***********************************");
        int statusCode = result.getStatusCode();
        Assert.assertEquals(statusCode,201);
    }

    @And("Response body")
    public void responeBody() {
        String responseBody=result.getBody().asString();
        System.out.println("Response Body is:" +responseBody);
    }

    @And("Response Message should be {string}")
    public void responseMessageShouldBe(String message) {
        String responseMessage = result.getStatusLine();
        Assert.assertTrue(responseMessage.contains(message));
    }

    @And("Name should be string {string}")
    public void nameShouldBeString(String fname) {
        String responseName = result.getBody().jsonPath().get("name");
        Assert.assertEquals(responseName, fname);
        System.out.println(responseName);
    }

    @Then("Email shoud be String {string}")
    public void emailShoudBeString(String email) {
        String responseEmail = result.getBody().jsonPath().get("email");
        Assert.assertEquals(responseEmail, email);
        System.out.println(responseEmail);
    }
}
