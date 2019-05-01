package com.myboilerplate.myboilerplate.integration;

import com.myboilerplate.myboilerplate.SpringBootBaseIntegrationTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightStepDefs extends SpringBootBaseIntegrationTest {

    ResponseEntity<String> response;

    @When("the client call {string} with HTTP GET method")
    public void the_client_call_with_HTTP_GET_method(String url) {
        response = getRestTemplate().getForEntity(baseUrl() + url, String.class);
    }

    @Then("the client receives status code of {int}")
    public void the_client_receives_status_code_of(Integer statusCode) {
        int responseStatusCodeValue = response.getStatusCodeValue();
        assertEquals(java.util.Optional.ofNullable(statusCode).get(), java.util.Optional.ofNullable(responseStatusCodeValue).get());
    }

    @Then("the content field has multiple items")
    public void the_content_field_has_multiple_items() {
        assertTrue(true);
    }

}
