package kw.kng.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.entity.Movies;
import kw.kng.repo.MoviesRepo;

@Service
public class MoviesServiceImpl implements MoviesService 
{
	
	@Autowired
	private MoviesRepo mrepo;

	@Override
	public String registerMovie(Movies movies)
	{
		System.out.println("Doc id(before save::" + movies.getMId());
		Movies mov=mrepo.save(movies);
		return "Movies obj is saved with value: "+mov.getMId();
	}
	
	
	@Override
	public String registerGroupMovies(List<Movies> movList) 
	{
		
		Iterable<Movies> savedmovList= mrepo.saveAll(movList);
		return "no.of records inserted: " + movList.size();
	}
	
	@Override
	public String registerOrUpdateMovies(Movies movies) 
	{
		Optional<Movies> opt= mrepo.findById(movies.getMId());
		if(opt.isPresent())
		{
			mrepo.save(movies); //this step is for updation. If the Id exist.
			return "Id Value= " + movies.getMId() + " .Movie details are found and updated";
		}
		else 
		{
			return "Movie is saved with id value: " + mrepo.save(movies).getMId();
		}
	}


	@Override
	public List<Movies> findByMovieNameEquals(String moviename)
	{
		return mrepo.findByMovieNameEquals(moviename);
	}


	@Override
	public Iterable<Movies> findByMovieName(String moviename)
	{
		return mrepo.findByMovieName(moviename);
	}


	@Override
	public Iterable<Movies> findByMovieNameStartingWith(String initChars) {
		
		return mrepo.findByMovieNameStartingWith(initChars);
	}


	@Override
	public Iterable<Movies> findByMovieNameEndingWith(String initChars) {
		
		return mrepo.findByMovieNameEndingWith(initChars);
	}


	@Override
	public Iterable<Movies> findByMovieNameContaining(String chars) 
	{	
		return mrepo.findByMovieNameContaining(chars);
	}


	@Override
	public Iterable<Movies> findByMovieNameEqualsIgnoreCase(String chars) 
	{
		
		return mrepo.findByMovieNameEqualsIgnoreCase(chars);
	}


	@Override
	public Iterable<Movies> findByMovieNameContainingIgnoreCase(String chars) 
	{
	
		return mrepo.findByMovieNameContainingIgnoreCase(chars);
	}


	@Override
	public Iterable<Movies> findByMovieNameLike(String chars) 
	{
		
		return mrepo.findByMovieNameLike(chars);
	}
	
	
}
