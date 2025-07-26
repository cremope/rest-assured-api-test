package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.greaterThan;

public class JsonPlaceholderSteps {

    private String endpointPosts = "https://jsonplaceholder.typicode.com/posts";

    @Given("that the JSONPlaceholder API is available")
    public void jsonPlaceholderApiIsAvailable() {
        CommonSteps.response = given()
                .when()
                .get(endpointPosts);

        if (CommonSteps.response.statusCode() != 200) {
            throw new RuntimeException("API offline. Status: " + CommonSteps.response.statusCode());
        }
    }

    @When("send a request to the POST endpoint to posts")
    public void sendPosts() {
        CommonSteps.response = given()
                .when()
                .get(endpointPosts);
    }

    @When("send a PUT request to posts")
    public void sendInvalidMethod() {
        CommonSteps.response = given()
                .when()
                .put(endpointPosts);
    }

    @And("response should contain a list of posts")
    public void responseShouldContainPosts() {
        CommonSteps.response.then().body("data.size()", greaterThan(0));
        System.out.println("Passed - response contains list of posts greater than 0");
    }

}
