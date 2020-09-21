package com.isaccof.stepdefs;

import com.isaccof.config.AbstractSpringConfiguration;
import com.isaccof.config.CucumberConfig;
import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
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

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;


public class getUserByIdStepDefinition extends AbstractSpringConfiguration {
  /*  private static final Logger logger = LoggerFactory.getLogger(SaveUserStepDefinition.class);
    private Long id;
    private String name = null;
    private String email = null;
    private RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response = null;
    HttpEntity<?> requestEntity;

    @Given("^the user with user id (\\d+)L and user name \"([^\"]*)\" and user email \"([^\"]*)\"$")
    public void the_user_with_user_id_L_and_user_name_and_user_email(Long id, String name, String email) throws Throwable {
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
        UserEntity userEntity=UserMapper.INSTANCE.mapTo(newUser);
        requestEntity = new HttpEntity<>(userEntity, getDefaultHttpHeaders());

        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);
       // UserEntity userEntity1=restTemplate.postForObject(url,requestEntity,UserEntity.class);
        assertNotNull(response);

        *//*UserEntity userEntity=new UserEntity();
        userEntity.setUserId(id);
        userEntity.setUserName(name);
        userEntity.setUserEmail(email);

        User user=UserMapper.INSTANCE.mapTO(userEntity);

        User user1=restTemplate.postForObject(url,user,User.class);
     *//*   *//*Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", this.name);
        requestMap.put("id", this.id);
        requestMap.put("email", this.email);
        requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);*//*

    }

    @When("^the client calls GET \"([^\"]*)\"$")
    public void the_client_calls_GET(String path) throws Throwable {


        String url = buildUrl(HOST, PORT, path);
        logger.info("url {}", url);
       response = invokeRESTCall(url, HttpMethod.GET,requestEntity);
      //  response = restTemplate.getForEntity(url,String.class);
    }

    *//*@When("^the client calls GET \"([^\"]*)\"$")
    public void the_client_calls_GET(String path) throws Throwable {
        String url = buildUrl(HOST, PORT, path);

        logger.info("url {}", url);
        response = invokeRESTCall(url, HttpMethod.GET,null);
    }*//*

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the response contains customer name \"([^\"]*)\"$")
    public void the_response_contains_customer_name(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/



   /* @Given("^the user saved with user name \"([^\"]*)\" and user id (\\d+)L and user email \"([^\"]*)\"$")
    public void the_user_saved_with_user_name_and_user_id_L_and_user_email(String name, Long id, String email) throws Throwable {
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
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("name", this.name);
        requestMap.put("id", this.id);
        requestMap.put("email", this.email);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);
        // response = invokeRESTCall(url, HttpMethod.GET, requestEntity);
    }
    @When("^the client calls GET \"([^\"]*)\"$")
    public void the_client_calls_GET(String path) throws Throwable {
        String url = buildUrl(HOST, PORT, path,id);

        logger.info("url {}", url);
        response = invokeRESTCall(url, HttpMethod.GET,null);
    }*/



    /*@Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the response contains customer name \"([^\"]*)\"$")
    public void the_response_contains_customer_name(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/


/*
    public String getCompleteEndPoint(String URI){
        System.out.println("Complete URL--->" + (staticURL + PORT + URI));
        return staticURL + PORT + URI;
    }*/


}
