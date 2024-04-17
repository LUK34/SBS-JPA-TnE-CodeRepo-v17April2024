package kw.kng.service;

import java.util.List;

import kw.kng.entity.Movies;

public interface MoviesService 
{

	String registerMovie(Movies movies);
	String registerGroupMovies(List<Movies> movList);
	String registerOrUpdateMovies(Movies movies);

	
	List<Movies> findByMovieNameEquals(String moviename);
	Iterable<Movies> findByMovieName(String moviename);
	Iterable<Movies> findByMovieNameStartingWith(String initChars);
	Iterable<Movies> findByMovieNameEndingWith(String initChars);
	Iterable<Movies> findByMovieNameContaining(String chars);
	Iterable<Movies> findByMovieNameEqualsIgnoreCase(String chars);
	Iterable<Movies> findByMovieNameContainingIgnoreCase(String chars);
	Iterable<Movies> findByMovieNameLike(String chars);
}
