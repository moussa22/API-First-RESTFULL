package com.isaccof.mapper;

import com.isaccof.customer.model.User;
import com.isaccof.repository.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    public static UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    @Mappings({
            @Mapping(target = "userId", source = "id"),
            @Mapping(target = "userName",source ="name" ),
            @Mapping(target = "userEmail" ,source ="email"),
    })
    UserEntity mapTo(User user);
    @InheritInverseConfiguration
    User mapTO(UserEntity userEntity);
    List<User> mapTO(List<UserEntity> userEntity);

    User mapTO(Optional<UserEntity> userEntity);
}




