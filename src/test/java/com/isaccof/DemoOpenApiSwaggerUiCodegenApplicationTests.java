package com.isaccof;

import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import com.isaccof.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoOpenApiSwaggerUiCodegenApplicationTests {

/*	@Autowired
	UserService userService;
	@MockBean
	UsersRepository usersRepository;
	@Test
	public void findAllUsersTest() {

		when(usersRepository.findAll()).thenReturn(Stream.of(new UserEntity(100L,"toto","r@mail.com"),new UserEntity(100L,"tata","r@mail.com")).collect(Collectors.toList()));
		assertEquals(2,userService.retrieveAllUsers().size());
		assertNotEquals(3,userService.retrieveAllUsers().size());
	}
 @Test
	public void createUserTest(){

		User user1=new User();
		user1.setId(10L);
		user1.setName("papa");
		user1.setEmail("t@yahoo.fr");
		UserEntity userEntity= UserMapper.INSTANCE.mapTo(user1);
	   when(usersRepository.save(userEntity)).thenReturn(userEntity);
		assertEquals(userEntity,userService.createUser(userEntity));
		assertNotNull(userService.createUser(userEntity));

	}


@Test
	public void getUserByIdTest(){

		UserEntity userEntity=new UserEntity();
		userEntity.setUserId(1L);
		userEntity.setUserName("toto");
		userEntity.setUserEmail("t@yahoo.fr");

		Mockito.when (usersRepository.getOne(anyLong())).thenReturn(userEntity);

		UserEntity userEntity1=userService.getUserById(2L);
		assertNotNull(userEntity1);

	}

	@Test
	public void getUserByNameTest(){

		UserEntity userEntity=new UserEntity();
		userEntity.setUserId(1L);
		userEntity.setUserName("toto");
		userEntity.setUserEmail("t@yahoo.fr");

		Mockito.when (usersRepository.findByUserName(anyString())).thenReturn(userEntity);

		UserEntity userEntity1=userService.getUserByName("tata");
		assertNotNull(userEntity1);

	}

@Test
	public void deletetUserByIdTest(){

		User user1=new User();
		user1.setId(10L);
		user1.setName("papa");
		user1.setEmail("t@yahoo.fr");
		UserEntity userEntity=UserMapper.INSTANCE.mapTo(user1);
	    userService.deleteById(userEntity.getUserId());

		verify(usersRepository, times(1)).deleteById(userEntity.getUserId());
	}
	@Test
 public void updateUserTest(){

	User user1=new User();
		user1.setId(10L);
		user1.setName("papa");
		user1.setEmail("t@yahoo.fr");
	UserEntity userEntity= UserMapper.INSTANCE.mapTo(user1);
	when(usersRepository.save(userEntity)).thenReturn(userEntity);

	assertNotNull(userEntity);


}*/

}