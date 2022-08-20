package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

public class DeleteStep {
    RequestSpecification request;
    Response result;

    public DeleteStep() {
        RestAssured.baseURI =  "https://gorest.co.in";
        request = RestAssured.given()
                .header("Authorization", "Bearer d0c1080ee68bb0d8bd272203bfe8ce0982b804e165dd223439bf35f4e8bd3a7c")
                .header("Content-Type", "application/json");
    }
    @Given("Delete user to specific ID")
    public void updateUserToSpecificID() {

        result = request.delete( "/public/v2/users/3794");

        System.out.println("***********************************");
        int statusCode = result.getStatusCode();
        Assert.assertEquals(statusCode,204);
        System.out.println(statusCode);
    }
    @And("Response Message should Return {string}")
    public void responseMessageShould(String message) {
        String responseMessage = result.getStatusLine();
        Assert.assertTrue(responseMessage.contains(message));
        System.out.println(responseMessage);
    }

}
