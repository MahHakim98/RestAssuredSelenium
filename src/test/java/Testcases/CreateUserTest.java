package Testcases;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.Selenium.utilities.ConfigManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.Selenium.utilities.ErrorHandler;

public class CreateUserTest {
    private String baseUrl;

    @Test
    public void createUser() {
        String requestPayload = "{ \"name\": \"Testing\", \"job\": \"TesterxD\" }";

        try {
            // Send POST request to create the user
            Response response = RestAssured.given()
                    .baseUri(new ConfigManager().getBaseUrl())
                    .contentType("application/json")
                    .body(requestPayload)
                    .post("/api/users");

            // Log the response body to the console
            System.out.println("Response Body: " + response.getBody().asString());

            // Validate the response status and user creation
            Assert.assertEquals(response.getStatusCode(), 201, "User creation failed");
            Assert.assertNotNull(response.jsonPath().getString("id"), "User ID is missing");

        } catch (Exception e) {
            // Use the ErrorHandler utility to log the error
            ErrorHandler.handleError(e);
            Assert.fail("Test failed due to an exception");
        }
    }
}
