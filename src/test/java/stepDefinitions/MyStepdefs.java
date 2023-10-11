package stepDefinitions;

import Resources.APIResources;
import Resources.ApiData;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class MyStepdefs {

    ApiData apiData = new ApiData();
    Utils utils = new Utils();
    RequestSpecification res;
    Response response;

    @Given("Add place payload {string} {string} {string}")
    public void addPlacePayloadWith(String name, String address, String language) throws IOException {
        res = given().spec(utils.getRequestSpecifications()).body(apiData.addPlacePayload(name,address,language));
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithPostHttpRequest(String resource, String method) {
        APIResources apiResources = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("POST")){
            response = res.when().post(apiResources.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            response = res.when().get(apiResources.getResource());
        }
    }

    @Then("the response is success with status code {int}")
    public void theResponseIsSuccessWithStatusCode(int statusCode) {
        Assert.assertEquals(response.getStatusCode(),statusCode);
    }

//    @And("{string} in response body is {string}")
//    public void inResponseBodyIs(String arg0, String arg1) {
//
//    }
}
