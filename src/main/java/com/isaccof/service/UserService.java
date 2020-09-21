package com.isaccof.service;

import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository repository;

    public UserEntity createUser(UserEntity userEntity){
         return repository.save(userEntity);


    }

    public UserEntity updateUser(UserEntity userEntity){
        return repository.save(userEntity);


    }

   public List<UserEntity>retrieveAllUsers(){

        List<UserEntity> userEntityList=repository.findAll();

        return userEntityList;

    }

    public UserEntity getUserById(Long id){

        return repository.getOne(id);

    }

    public UserEntity getUserByName(String userName){

        return repository.findByUserName(userName);

    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}



