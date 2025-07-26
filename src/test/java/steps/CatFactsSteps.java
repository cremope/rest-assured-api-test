package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CatFactsSteps {

    private Response response;
    private int limit = 0;
    private String endpointBreeds = "https://catfact.ninja/breeds";

    @Given("that the Cat Facts API is available")
    public void catFactsApiAvailable() {
        CommonSteps.response = given()
                .when()
                .get(endpointBreeds);

        if (CommonSteps.response.statusCode() != 200) {
            throw new RuntimeException("API offline. Status: " + CommonSteps.response.statusCode());
        }
    }

    @When("send a request to the GET endpoint to breeds without a value specified in the parameter limit")
    public void getBreedsWithoutLimit() {
        CommonSteps.response = given()
                .when()
                .get(endpointBreeds);
    }

    @When("send a request on the GET endpoint to breeds with the value {int} in the parameter limit")
    public void getBreedsWithLimit(int limit) {
        this.limit = limit;
        CommonSteps.response = given()
                .queryParam("limit", limit)
                .when()
                .get(endpointBreeds);
    }

    @When("send a request on the GET endpoint to breeds with a value greater than {int} in the parameter limit")
    public void getBreedsWithLimitGreaterThan(int min) {
        this.limit = min + 1;
        CommonSteps.response = given()
                .queryParam("limit", this.limit)
                .when()
                .get(endpointBreeds);
    }

    @When("send a POST request to breeds")
    public void sendInvalidMethod() {
        CommonSteps.response = given()
                .when()
                .post(endpointBreeds);
    }

    @And("response should contain a list of breeds")
    public void responseShouldContainBreeds() {
        CommonSteps.response.then().body("data.size()", greaterThan(0));
        System.out.println("Passed - response contains list of breeds greater than 0");
    }

    @And("response must contain a list of breeds with {int} cat breed")
    public void responseShouldContainExactly(int expectedCount) {
        CommonSteps.response.then().body("data.size()", equalTo(expectedCount));
        System.out.println("Passed - response contains list of breeds with "+expectedCount+" cat breed");

    }

    @And("response must contain a list of breeds with the quantity specified in the parameter limit")
    public void responseShouldMatchLimit() {
        CommonSteps.response.then().body("data.size()", equalTo(limit));
        System.out.println("Passed - response contains list of breeds with the quantity specified in the parameter limit");
    }

}
