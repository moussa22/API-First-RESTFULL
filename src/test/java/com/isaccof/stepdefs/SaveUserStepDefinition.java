package com.isaccof.stepdefs;

import com.isaccof.config.AbstractSpringConfiguration;
import com.isaccof.repository.UserEntity;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class SaveUserStepDefinition  extends AbstractSpringConfiguration{
   // public static final String REST_SERVICE_URI = "http://localhost:8084/api/v1";
    private static final Logger logger = LoggerFactory.getLogger(SaveUserStepDefinition.class);
    private Long id;
    private String name = null;
    private String email = null;
    RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> response = null;
    @LocalServerPort
    public static final String port = "8084";
    public String postUrl = "http://localhost:";

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

     /*   System.out.println("Testing create User API----------");
      //  RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = new UserEntity(this.id,this.name,this.email);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/save", userEntity, UserEntity.class);
        assertNotNull(uri);*/
      /*  if (logger.isInfoEnabled()) {
            logger.info("path {}", path);
        }
        String url=postUrl + ":"+ port +"/save";

        UserEntity newUserEntity=new UserEntity();
        newUserEntity.setUserId(this.id);
        newUserEntity.setUserName(this.name);
        newUserEntity.setUserEmail(this.email);

        UserEntity userEntity=restTemplate.getForObject()*/
        String url = buildUrl(HOST, PORT, path);
        Map<String, Object> requestMap = new HashMap<>();
       requestMap.put("name", this.name);
        requestMap.put("id", this.id);
        requestMap.put("email", this.email);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        response = invokeRESTCall(url, HttpMethod.POST, requestEntity);
        assertNotNull(response);
       // response = restTemplate.exchange(url,HttpMethod.POST,requestEntity,String.class);


        /*restTemplate = new RestTemplate ();
        response = restTemplate.postForEntity(url, requestEntity, String.class);
        response = restTemplate.getForEntity(url,String.class);*/

    }


   /*@Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        if (response != null && response.getStatusCode().is2xxSuccessful()) {
            assertEquals(statusCode, response.getStatusCode().value());
        }
    }*/

}




