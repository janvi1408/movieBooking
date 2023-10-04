package com.cg.ad;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBeans;
import static org.junit.jupiter.api.Assertions.*;
import com.cg.ad.dao.AdDao;
import com.cg.ad.exception.InvalidIdException;
import com.cg.ad.pojo.Ad;
import com.cg.ad.service.AdService;
import com.cg.ad.service.AdServicesImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdsApplicationTests {

	@Mock AdDao repo;
	@InjectMocks  AdService service = new AdServicesImpl();
	@Test
	public void testGetByIdFailureInvalidIdExcpetion() {
		when(repo.findById(7)).thenReturn(Optional.empty());
		assertThrows(InvalidIdException.class,()->service.delete(7));
		
	}
	@Test
	public void testGetByIdSuccessful() throws InvalidIdException {
		Ad a= new Ad(1,2,"sell","shopping");
		when(repo.findById(1)).thenReturn(Optional.of(a));
		assertEquals("SUCCESSFULLY DELETED",service.delete(1));
		
	}
	@Test
	public void testUpdateFailureInvalidIdExcpetion() {
		when(repo.findById(7)).thenReturn(Optional.empty());
		assertThrows(InvalidIdException.class,()->service.update(7,"buy"));
		
	}
	@Test
	public void testUpdateSuccessful() throws InvalidIdException {
		Ad a= new Ad(1,2,"sell","shopping");
		Ad a1= new Ad(1,2,"buy","shopping");
		when(repo.findById(1)).thenReturn(Optional.of(a1));
		when(repo.save(a1)).thenReturn(a1);
		assertEquals(a1,service.update(1, "buy"));
		
	}

}
