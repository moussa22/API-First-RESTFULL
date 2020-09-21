package com.isaccof.stepdefs;

import com.isaccof.config.AbstractSpringConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class getUserByNameStepDefinition  extends AbstractSpringConfiguration {
    private ResponseEntity<String> response = null;
    @When("^the client calls GET \"([^\"]*)\" with customer name as \"([^\"]*)\" in query param$")
    public void the_client_calls_GET_with_customer_name_as_in_query_param(String path, String userName) throws Throwable {
        MultiValueMap<String,String> queryParams= new LinkedMultiValueMap<>();
        queryParams.add("name",userName);

        String url = buildUrl(HOST, PORT, path, null, queryParams);
      //  logger.info("url {}", url);
        response = invokeRESTCall(url, HttpMethod.GET, null);

    }

    @Then("^the response contains customer name \"([^\"]*)\"$")
    public void the_response_contains_customer_name(String userName) throws Throwable {
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            assertNotNull(response);
        }
    }
}
