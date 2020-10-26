package com.isaccof;

import com.isaccof.repository.UserEntity;

import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;


public class SpringBootRestTestClient {


 
    public static final String REST_SERVICE_URI = "http://localhost:8083/api/v1";
     
    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/users", List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Email="+map.get("email"));
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
     
   /* *//* GET *//*
    private static void getUser(){
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = restTemplate.getForObject(REST_SERVICE_URI+"/users/1", UserEntity.class);
        System.out.println(userEntity);
    }
     
    *//* POST *//*
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        UserEntity userEntity = new UserEntity(10L,"TOTO","t@yahoo.fr");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/save", userEntity, UserEntity.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    *//* PUT *//*
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        UserEntity user  = new UserEntity(100L,"tata","t@yahoo.fr");
        restTemplate.put(REST_SERVICE_URI+"/1", user);
        System.out.println(user);
    }
 
    *//* DELETE *//*
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/3");
    }
 
 
    *//* DELETE *//*
    private static void deleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
    }*/
 
    public static void main(String args[]){
        listAllUsers();
       /* getUser();
        createUser();
        listAllUsers();
        updateUser();
        listAllUsers();
        deleteUser();
        listAllUsers();
        deleteAllUsers();
        listAllUsers();*/
    }
}