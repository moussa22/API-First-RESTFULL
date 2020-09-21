package com.isaccof.stepdefs;

import com.isaccof.config.AbstractSpringConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FindAllUsersStepDefinition extends AbstractSpringConfiguration {
    private Long id;
    private String name = null;
    private String email = null;
    RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response = null;


    @When("^the client calls \"([^\"]*)\"$")
    public void the_client_calls(String path) throws Throwable {
        String url = buildUrl(HOST, PORT, path);

        restTemplate = new RestTemplate ();

        response = restTemplate.getForEntity(url,String.class);


    }

    @Then("^the client have success and receives status code of (\\d+)$")
    public void the_client_have_success_and_receives_status_code_of(int arg1) throws Throwable {
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            assertEquals(200, response.getStatusCode().value());
        }
    }



}


