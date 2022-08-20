package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetStep {
    RequestSpecification request;
    Response result;

    public GetStep() {
        RestAssured.baseURI =  "https://gorest.co.in";
        request = RestAssured.given()
                .header("Authorization", "Bearer d0c1080ee68bb0d8bd272203bfe8ce0982b804e165dd223439bf35f4e8bd3a7c")
                .header("Content-Type", "application/json");
    }

    @Given("user wants to get all information")
    public void user_wants_to_get_all_information() {
        result = request.get( "/public/v2/users");
    }

    @And("response {int} should be received")
    public void responseShouldBeReceived(int status) {

        System.out.println("Response: " +result.asString());
        System.out.println( "Status Code :"+result.getStatusCode());
        System.out.println("Body : " +result.getBody());
        System.out.println("Time Token :" +result.getTime());
        System.out.println("Header :"+result.getHeader("content-type"));

        int statusCode = result.getStatusCode();
        Assert.assertEquals(statusCode,status);
    }

    @And("name should be {string}")
    public void nameShouldBe(String n) {
        String name = result.getBody().jsonPath().get("[0].name").toString();
        Assert.assertEquals(name, n);
    }

    @And("email should be {string}")
    public void emailShouldBe(String e) {
        String email = result.getBody().jsonPath().get("[0].email").toString();
        Assert.assertEquals(email, e);
    }

    @Then("gender should be {string}")
    public void genderShouldBe(String g) {
        String gender = result.getBody().jsonPath().get("[0].gender").toString();
        Assert.assertEquals(gender, g);
    }
}
