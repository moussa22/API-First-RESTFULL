package com.isaccof.repository;

import com.isaccof.customer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UsersRepository  extends JpaRepository<UserEntity,Long> {

   @Query("SELECT u FROM UserEntity u WHERE u.userName=:userName")
   public UserEntity findByUserName(@Param("userName") String userName);
}
