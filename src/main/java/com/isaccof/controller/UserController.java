package com.isaccof.controller;

import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import com.isaccof.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
@Autowired
 private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){

        UserEntity userEntity= UserMapper.INSTANCE.mapTo(user);

        UserEntity  saveUser=userService.createUser(userEntity);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();

    }
   @GetMapping("/users")
    public ResponseEntity<List<User>>findAllUsers(){

      List<UserEntity> userEntity=userService.retrieveAllUsers();
      List<User> users=UserMapper.INSTANCE.mapTO(userEntity);

      return ResponseEntity.ok(users);

  }
    @GetMapping(value = "users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id, Model model){

        UserEntity userEntity=userService.getUserById(id);
        User user=UserMapper.INSTANCE.mapTO(userEntity);
        return ResponseEntity.accepted().body(user);

    }

    @GetMapping(value = "users/byName")
    public ResponseEntity<User> getUserById(@PathVariable("name") String userName, Model model){

        UserEntity userEntity=userService.getUserByName(userName);
        User user=UserMapper.INSTANCE.mapTO(userEntity);
        return ResponseEntity.accepted().body(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        UserEntity userEntity = UserMapper.INSTANCE.mapTo(user);
        userEntity.setUserId(id);
        userService.createUser(userEntity);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

}
