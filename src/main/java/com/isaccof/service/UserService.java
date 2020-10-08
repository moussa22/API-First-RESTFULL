package com.isaccof.service;

import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static  List<UserEntity> userEntityList;
    @Autowired
    private UsersRepository repository;

    public UserEntity createUser(UserEntity userEntity){
         return repository.save(userEntity);


    }

    public UserEntity updateUser(UserEntity userEntity){
        return repository.save(userEntity);


    }

   public List<UserEntity>retrieveAllUsers(){

         userEntityList=repository.findAll();

        return userEntityList;

    }

    public UserEntity getUserById(Long id){

        return repository.getOne(id);

    }

    public UserEntity getUserByName(String userName){

        return repository.findByUserName(userName);

    }

    public boolean isUserExist(UserEntity userEntity) {
        return repository.findByUserName(userEntity.getUserName())!=null;
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAllUsers() {

        userEntityList.clear();
    }


}




