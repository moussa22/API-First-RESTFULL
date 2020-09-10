package com.isaccof;

import com.isaccof.customer.model.User;
import com.isaccof.mapper.UserMapper;
import com.isaccof.repository.UserEntity;
import com.isaccof.repository.UsersRepository;
import com.isaccof.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoOpenApiSwaggerUiCodegenApplicationTests {

	@Autowired
	UserService userService;
	@MockBean
	UsersRepository usersRepository;
	@Test
	public void findAllUsersTest() {

		when(usersRepository.findAll()).thenReturn(Stream.of(new UserEntity(100L,"toto","r@mail.com"),new UserEntity(100L,"tata","r@mail.com")).collect(Collectors.toList()));
		assertEquals(2,userService.retrieveAllUsers().size());
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

	}

@Test
	public void getUserByIdTest(){
		Long id=10L;
	User user1=new User();
	user1.setId(10L);
	user1.setName("papa");
	user1.setEmail("t@yahoo.fr");
	UserEntity userEntity= UserMapper.INSTANCE.mapTo(user1);
	assertEquals(userEntity.getUserId(),new Long(10l));
	assertNotNull(userEntity.getUserId());

	}
@Test
	public void deletetUserByIdTest(){

		User user1=new User();
		user1.setId(10L);
		user1.setName("papa");
		user1.setEmail("t@yahoo.fr");
		UserEntity userEntity=UserMapper.INSTANCE.mapTo(user1);
	    userService.deleteUserById(userEntity);

		verify(usersRepository, times(1)).delete(userEntity);
	}


}
