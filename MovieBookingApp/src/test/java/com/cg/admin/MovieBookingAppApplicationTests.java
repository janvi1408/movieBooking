package com.cg.admin;

import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.City;
import com.cg.admin.pojo.Movies;
import com.cg.admin.pojo.Theater;
import com.cg.admin.repo.CityRepo;
import com.cg.admin.repo.MoviesRepo;
import com.cg.admin.repo.TheaterRepo;
import com.cg.admin.services.MovieServiceImpl;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MovieBookingAppApplicationTests {

	@Test
	void contextLoads() {
	}
	@Mock CityRepo crepo;
	@Mock MoviesRepo mrepo;
	@Mock TheaterRepo trepo;
	@InjectMocks
	com.cg.admin.services.MovieService services=new MovieServiceImpl();
	
	@Test
	void getCity()throws InvalidId{
		when(crepo.findById(1002)).thenReturn(Optional.empty());
		assertThrows(InvalidId.class,()->services.getCity(1002));
		
	}
	@Test
	void getMovie()throws InvalidId{
		when(mrepo.findById(1002)).thenReturn(Optional.empty());
		assertThrows(InvalidId.class,()->services.getMovie(1002));
		
	}
	@Test
	void getTheater()throws InvalidId{
		when(trepo.findById(1002)).thenReturn(Optional.empty());
		assertThrows(InvalidId.class,()->services.getTheater(1002));
		
	}
	
	@Test
	void addCity()throws InvalidId{
		List<Integer>l=new ArrayList<Integer>();
		City city=new City(100,l,"");
	when(crepo.save(city)).thenReturn(city);
	assertEquals(city,services.addCity(city));

	}
	


//	@Test
//	void addTheater()throws InvalidId{
//		List<Integer>l=new ArrayList<Integer>();
//		List<Integer>m=new ArrayList<Integer>();
//		Theater t= new Theater(1,l,"inox",m);
//	when(trepo.save(t)).thenReturn(t);
//	assertEquals(t,services.addTheater(t));
//
//	}
	
	@Test
	void addMovies()throws InvalidId{
		List<Integer>l=new ArrayList<Integer>();
		Movies m= new Movies(1,"jawaan",l);
	when(mrepo.save(m)).thenReturn(m);
	assertEquals(m,services.addMovies(m));

	}

//	@Test
//	void getMoviesTestException() throws InvalidId {
//		int movieId = 1;
//		List<Integer> l = new ArrayList<Integer>();
//		
//		Movies movie = new Movies(2,"jawan",l);
//
//		when(mrepo.findById(movieId)).thenReturn(Optional.of(movie));
//
//		assertThrows(InvalidId.class, () -> services.(movieId));
//		
//
//	}
	@Test
	void testRemovesCity() throws InvalidId{
		
		int cityId = 3;
		List<Integer> l = new ArrayList<Integer>();
		
		City city = new City(3,l,"pune");
		
		 when(crepo.findById(cityId)).thenReturn(Optional.of(city));
		
		 assertEquals("SUCCESSFULLY DELETED",services.removeCity(cityId));
	}

	@Test
	void testRemoveTheatre()throws InvalidId {
		int tId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		Theater theatre = new Theater(1,l,"pvr",l);
		
		 when(trepo.findById(tId)).thenReturn(Optional.of(theatre));
		 assertEquals("SUCCESSFULLY DELETED",services.removeTheater(tId));
	}
	@Test
	void testRemoveMovie() throws InvalidId{
		int movieId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		Movies movie = new Movies(1,"jawan",l);
		
		 when(mrepo.findById(movieId)).thenReturn(Optional.of(movie));
		
		 assertEquals("SUCCESSFULLY DELETED",services.removeMovies(movieId));
	}
	@Test
	void testRemoveCity() throws InvalidId{
		
		int cityId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		City city = new City(1,l,"pune");
		
		 when(crepo.findById(cityId)).thenReturn(Optional.of(city));
		
		 assertEquals("SUCCESSFULLY DELETED",services.removeCity(cityId));
	}


}

