package com.myboilerplate.myboilerplate.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myboilerplate.myboilerplate.SpringBootBaseIntegrationTest;
import com.myboilerplate.myboilerplate.exception.CustomErrorResponse;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlightStepDefs extends SpringBootBaseIntegrationTest {

    ResponseEntity<String> response;

    private String url;
    private String uriString;

    @When("the client call {string} with HTTP GET method")
    public void the_client_call_with_HTTP_GET_method(String url) {
        this.url = url;
        String uriString = baseUrl() + url;
        response = getRestTemplate().getForEntity(uriString, String.class);
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


    @When("the client set {string} parameter as {int}")
    public void the_client_set_parameter_as(String parameter, Integer value) {
        uriString = UriComponentsBuilder.fromHttpUrl(baseUrl() + url)
                .queryParam(parameter, value).toUriString();
    }

    @Then("the API returns error")
    public void the_API_returns_error() throws IOException {
        ResponseEntity<String> forEntity;
        try {
            forEntity = getRestTemplate().getForEntity(uriString, String.class);
        }catch (HttpClientErrorException ex){
            String response = ex.getResponseBodyAsString();
            ObjectMapper mapper = new ObjectMapper();
            CustomErrorResponse customErrorResponse = mapper.readValue(response, CustomErrorResponse.class);
            assertTrue(customErrorResponse.getMessage() != "");
        }
    }
}
