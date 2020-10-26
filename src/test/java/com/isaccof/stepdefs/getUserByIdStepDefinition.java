package com.isaccof.stepdefs;

import com.isaccof.DemoOpenApiSwaggerUiCodegenApplication;
import com.isaccof.config.AbstractSpringConfiguration;
import com.isaccof.config.CucumberConfig;
import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = DemoOpenApiSwaggerUiCodegenApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class getUserByIdStepDefinition extends AbstractSpringConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(SaveUserStepDefinition.class);
    private Long id;
    private String name = null;
    private String email = null;
    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response = null;
    HttpEntity<?> requestEntity;
    UserEntity userEntity;
    @LocalServerPort
    int port;

    @Given("^user informations id (\\d+)L and user name \"([^\"]*)\" and user email \"([^\"]*)\"$")
    public void user_informations_id_L_and_user_name_and_user_email(Long id, String name, String email) throws Throwable {
        if (logger.isInfoEnabled()) {
            logger.info("Users to be saved with user id {} and user name {} and user email {}", id, name,email);
        }
        this.id = id;
        this.name = name;

        this.email=email;
    }

    @Then("^calls POST \"([^\"]*)\"$")
    public void calls_POST(String path) throws Throwable {
        String url = buildUrl(HOST, PORT, path);

       User newUser=new User();
        newUser.setId(id);
        newUser.setName(name);
        newUser.setEmail(email);
        userEntity=UserMapper.INSTANCE.mapTo(newUser);
        requestEntity = new HttpEntity<>(userEntity, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);
        assertNotNull(response);
       // assertEquals(201,response.getStatusCode());

    }

    @When("^the client calls GET \"([^\"]*)\" with user id as (\\d+)$")
    public void the_client_calls_GET_with_user_id_as(String path, Long id) throws Throwable {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(id));
        String url = buildUrl(HOST, PORT, path, uriVariables);
        logger.info("url {}", url);
        response = invokeRESTCall(url, HttpMethod.GET, null);



    }



}
