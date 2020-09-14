package com.isaccof.stepdefs;

import com.isaccof.config.AbstractSpringConfiguration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;


public class SaveUserStepDefinition extends AbstractSpringConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(SaveUserStepDefinition.class);
    private Long id;
    private String name = null;
    private String email = null;

    private ResponseEntity<String> response = null;

     @Given("^the user with user id (\\d+)L and user name \"([^\"]*)\" and user email \"([^\"]*)\"$")    public void the_user_with_user_id_and_user_name_and_user_email(Long id, String name, String email) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("Users to be saved with user id {} and user name {} and user email {}", id, name,email);
        }
        this.id = id;
        this.name = name;
        this.email=email;
    }

    @When("^the client calls \"([^\"]*)\" with the given details$")
    public void the_client_calls_with_the_given_details(String path) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("path {}", path);
        }
        String url = buildUrl(HOST, PORT, path);
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", this.name);
        requestMap.put("id", this.id);
        requestMap.put("email", this.email);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            assertEquals(statusCode, response.getStatusCode().value());
        }
    }

    @Then("^the response contains user name \"([^\"]*)\"$")
    public void the_response_contains_user_name(String name) throws Throwable {
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            Map<String, String> responseMap = mapper.readValue(responseBody, Map.class);
            System.out.println(responseMap);
            assertEquals(name, responseMap.get("name"));
        }
    }


}
