package com.isaccof.controller;

import com.isaccof.customer.model.User;
import com.isaccof.jwt.JwtProvider;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import com.isaccof.service.UserService;
import com.isaccof.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    /*@Autowired
    BCryptPasswordEncoder passwordEncoder;*/

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/save")
   // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        logger.info("Create user: { }", user);
        // UserEntity userEntity1=UserMapper.INSTANCE.mapTo(user);
        UserEntity userEntity = UserMapper.INSTANCE.mapTo(user);
        if (userService.isUserExist(userEntity)) {
            logger.error("Unable to create. A User with name {} already exist", userEntity.getUserName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
                    userEntity.getUserName() + " already exist."), HttpStatus.CONFLICT);
        }
       //  passwordEncoder.encode(userEntity.getPassword());
        UserEntity saveUser = userService.createUser(userEntity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {

        List<UserEntity> userEntity = userService.retrieveAllUsers();
        List<User> users = UserMapper.INSTANCE.mapTO(userEntity);
        if (users.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id, Model model) {
        logger.info("Fetch user by id" + id);
        UserEntity userEntity = userService.getUserById(id);
        User user = UserMapper.INSTANCE.mapTO(userEntity);

        if (user == null) {
            logger.error("User With id { } not fund.", id);

            return new ResponseEntity(new CustomErrorType("User with id" + id + "not found"), HttpStatus.NOT_FOUND);
        }
        // return ResponseEntity.accepted().body(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @RequestMapping(value = "/users/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByName(@PathVariable("name") String userName) {

        UserEntity userEntity = userService.getUserByName(userName);
        User user = UserMapper.INSTANCE.mapTO(userEntity);
        return ResponseEntity.accepted().body(user);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        logger.info("Fetch user by id" + id);
        UserEntity userEntity = userService.getUserById(id);
        User user = UserMapper.INSTANCE.mapTO(userEntity);

        if (user == null) {
            logger.error("Unable to delete.User With id { } not fund.", id);

            return new ResponseEntity(new CustomErrorType("Unable to delete .User with id" + id + "not found"), HttpStatus.NOT_FOUND);
        }

        userService.deleteById(id);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        UserEntity userEntity = UserMapper.INSTANCE.mapTo(user);
        UserEntity currenteUser = userService.getUserById(id);
        if (currenteUser == null) {
            logger.error("Unable to upate. User with id { } not found", id);

            return new ResponseEntity(new CustomErrorType("nable to upate. User with id { } not found"), HttpStatus.NOT_FOUND);
        }
        currenteUser.setUserId(userEntity.getUserId());
        currenteUser.setUserName(userEntity.getUserName());
        currenteUser.setUserEmail(userEntity.getUserEmail());
        //  userEntity.setUserId(id);

        userService.createUser(currenteUser);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");

        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

    }

  /*  @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getUsername(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getUserName());
        return new AuthResponse(token);
    }*/

   /* @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setUserName(registrationRequest.getUsername());
        userService.createUser(u);



        return "OK";
    }*/

}
