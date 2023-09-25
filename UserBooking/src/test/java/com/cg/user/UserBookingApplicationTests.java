package com.cg.user;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;

import com.cg.user.dao.UserRepo;
import com.cg.user.exception.InvalidId;
import com.cg.user.pojo.User;
import com.cg.user.service.UserService;
import com.cg.user.service.UserServiceImpl;

@SpringBootTest
class UserBookingApplicationTests {
@Mock
UserRepo userRepo;
@InjectMocks
private UserService service=new UserServiceImpl();
	@Test
	void contextLoads() {
	}
	@Test
	void createUser() {
		User user=new User(1,"janvi");
	when(userRepo.save(user)).thenReturn(user);
	assertEquals(user,service.create(user));
	}

	
	

}
