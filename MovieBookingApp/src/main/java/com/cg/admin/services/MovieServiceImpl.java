package com.cg.admin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.admin.exception.InvalidId;
import com.cg.admin.pojo.City;
import com.cg.admin.pojo.Movies;
import com.cg.admin.pojo.Theater;
import com.cg.admin.repo.CityRepo;
import com.cg.admin.repo.MoviesRepo;
import com.cg.admin.repo.TheaterRepo;
@Component
public class MovieServiceImpl implements MovieService{

	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private MoviesRepo moviesRepo;
	@Autowired
	private TheaterRepo theaterRepo;
//	cityRepo.findById(city.getCid()).get()
	@Override
	public City addCity(City city) {
		cityRepo.save(city); 
		List<Integer>theaters=city.getTheaters();
		for(Integer i:theaters) {
		Theater theater=theaterRepo.findById(i).get();
		List<Integer>getCity=theater.getCity();
		getCity.add(city.getCid());
		theaterRepo.save(theater);
		}
		return cityRepo.save(city); 
	}

	@Override
	public String removeCity(int cid)throws InvalidId {
		City city=cityRepo.findById(cid).get();
		List<Integer> theater=cityRepo.findById(cid).orElseThrow(()->new InvalidId("Invalid Id")).getTheaters();
		for(int i:theater) {
			List<Integer> movie=theaterRepo.findById(i).get().getMovies();
			for(Integer j:movie) {
			List<Integer> movieTheater=	moviesRepo.findById(j).get().getTheater();
		moviesRepo.deleteById(j);
			}
			theaterRepo.deleteById(i);
		}
	
	cityRepo.delete(city);
	
	return "SUCCESSFULLY DELETED";
	}

	@Override
	public Theater addTheater(Theater theater) {
		
	List<Integer>movies=theaterRepo.findById(theater.getTid()).get().getMovies();
	List<Integer>city=theaterRepo.findById(theater.getTid()).get().getCity();	
	for(Integer i:movies) {
		Movies m=moviesRepo.findById(i).get();
		List<Integer>theaterId=m.getTheater();
		theaterId.add(i);
		moviesRepo.save(m);
		
		
	}
	for(Integer i:city) {
		City c=cityRepo.findById(i).get();
		List<Integer>theaterId=c.getTheaters();
		theaterId.add(i);
		cityRepo.save(c);
		
		
	}
	return theaterRepo.save(theater);
		
	}

	@Override
	public String removeTheater(int tid)throws InvalidId{
		Theater theater=theaterRepo.findById(tid).get();
		List<Integer>movies=theaterRepo.findById(tid).orElseThrow(()->new InvalidId("Invalid Id")).getMovies();
		for(Integer i:movies) {
			Movies m=moviesRepo.findById(i).get();
			List<Integer>theaterId=m.getTheater();
			theaterId.remove(i);
			moviesRepo.save(m);
		}
		List<Integer>city=theaterRepo.findById(tid).get().getCity();
		for(Integer i:city) {
			City c=cityRepo.findById(i).get();
			List<Integer>theaterId=c.getTheaters();
			theaterId.remove(i);
			cityRepo.save(c);
		}
		
	theaterRepo.delete(theater);
	theaterRepo.save(theater);
	return "SUCCESSFULLY DELETED";
	
	}

	@Override
	public Movies addMovies(Movies movies) {
	moviesRepo.save(movies);
	List<Integer> theater=movies.getTheater();
	for(int i:theater) {
	Theater t=theaterRepo.findById(i).get();
	List<Integer> allMovies=t.getMovies();
   allMovies.add(movies.getMid());
   theaterRepo.save(t);
	}
	
	return moviesRepo.save(movies);
	
	}

	@Override
	public String removeMovies(int mid)throws InvalidId{
		Movies movie=moviesRepo.findById(mid).get();
		List<Integer>theater=movie.getTheater();
		for(int i:theater) {
			Theater t=theaterRepo.findById(i).get();
			t.getMovies().remove(i);
			theaterRepo.save(t);
		}
	moviesRepo.delete(movie);
	
	return "SUCCESSFULLY DELETED";
	}

	@Override
	public City getCity(int cid) throws InvalidId {
	City city=cityRepo.findById(cid).orElseThrow(()-> new InvalidId("Invalid Id"));
	return city;
	
	}

	@Override
	public Theater getTheater(int tid) throws InvalidId {
		Theater theater= theaterRepo.findById(tid).orElseThrow(()-> new InvalidId("Invalid Id"));
		return theater;
	}

	@Override
	public Movies getMovie(int mid) throws InvalidId {
		Movies movies=moviesRepo.findById(mid).orElseThrow(()-> new InvalidId("Invalid Id"));
		return movies;
	}

}
