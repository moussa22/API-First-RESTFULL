package com.isaccof.repository;

import com.isaccof.customer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsersRepository  extends JpaRepository<UserEntity,Long> {

   public UserEntity findByUserName(String userName);
}
