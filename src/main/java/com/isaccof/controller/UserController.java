package com.isaccof.controller;

import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){

        UserEntity userEntity= UserMapper.INSTANCE.mapTo(user);

        UserEntity  saveUser=usersRepository.save(userEntity);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();

    }
   @GetMapping("/users")
    public ResponseEntity<List<User>>retrieveAllUsers(){


      List<UserEntity> userEntity=usersRepository.findAll();
      List<User> users=UserMapper.INSTANCE.mapTO(userEntity);

      return ResponseEntity.ok(users);








    }

}
