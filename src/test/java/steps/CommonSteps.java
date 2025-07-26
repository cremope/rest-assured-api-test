package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class CommonSteps {
    public static Response response;

    @Then("endpoint will return a status code {int}")
    public void validateStatusCode(int expectedStatus) {
        response.then().statusCode(expectedStatus);
    }

    @And("response must contain a message indicating that the method is not allowed or reporting that it was not found")
    public void validateMethodNotAllowedMessage() {
        String body = CommonSteps.response.getBody().asString().toLowerCase();

        boolean hasNoValue = body.contains("{}");
        boolean hasMethodNotAllowed = body.contains("method not allowed");
        boolean hasNotFound = body.contains("not found");

        if (!(hasMethodNotAllowed || hasNotFound || hasNoValue)) {
            throw new AssertionError("Expected error message not found in response");
        }
        System.out.println("Passed - Method not allowed or not found");
    }
}