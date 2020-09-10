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
    /*@Autowired
    UsersRepository usersRepository;*/
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

   /* @DeleteMapping(value = "users/{id}")
    public ResponseEntity<Void> deletetUserById(@PathVariable("id") long id){

       usersRepository.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);


    }*/

   /* @PutMapping(value="users/{id}")
    public ResponseEntity<User> updateUsers(@RequestBody User user, @PathVariable long id) {

        Optional<UserEntity> userOptional = usersRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setId(id);

        UserEntity userEntity=UserMapper.INSTANCE.mapTo(user);

        usersRepository.save(userEntity);

        return ResponseEntity.noContent().build();
    }*/

}
