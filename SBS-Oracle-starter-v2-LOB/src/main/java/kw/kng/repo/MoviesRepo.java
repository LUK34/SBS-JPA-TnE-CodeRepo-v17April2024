package kw.kng.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kw.kng.entity.Movies;

public interface MoviesRepo extends JpaRepository<Movies, Integer> 
{
	//select mid,movieName,year,ratings from Movies where movieName=?
	public List<Movies> findByMovieNameEquals(String moviename);
	
	//select mid,movieName,year,ratings from Movies where movieName=?
	public Iterable<Movies> findByMovieName(String moviename);
	
	//select mid,movieName,year,ratings from Movies where movieName like 'I%'
	public Iterable<Movies> findByMovieNameStartingWith(String initChars);
	
	//select mid,movieName,year,ratings from Movies where movieName like '%lk'
	public Iterable<Movies> findByMovieNameEndingWith(String initChars);
	
	//select mid, movieName,year, ratings from Movies where movieName like '%on%'
	public Iterable<Movies> findByMovieNameContaining(String chars);
	
	//select mid, movieName,year, ratings from Movies where movieName like 'AVENGERS'
	public Iterable<Movies> findByMovieNameEqualsIgnoreCase(String chars);
	
	//select mid, movieName,year, ratings from Movies where movieName like '%GERS%'
	public Iterable<Movies> findByMovieNameContainingIgnoreCase(String chars);
	
	//select mid, movieName, year, ratings from Movies where movieName like 'A%'
	//select mid, movieName, year, ratings from Movies where movieName like '%ON%'
	//select mid, movieName, year, ratings from Movies where movieName like '%GERS'
	public Iterable<Movies> findByMovieNameLike(String chars);
	
	
	

}
