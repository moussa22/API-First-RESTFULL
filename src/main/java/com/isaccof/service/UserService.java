package com.isaccof.service;

import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsersRepository repository;

    public UserEntity createUser(UserEntity userEntity){
       // UserEntity userEntity=UserMapper.INSTANCE.mapTo(user);
         return repository.save(userEntity);


    }

   public List<UserEntity>retrieveAllUsers(){

        List<UserEntity> userEntityList=repository.findAll();

        return userEntityList;

    }

    public UserEntity getUserById(Long id){

       return repository.getOne(id);

    }


    public void deleteUserById(UserEntity userEntity) {
        repository.delete(userEntity);


    }
}



