package kw.kng.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kw.kng.entity.Movies;
import kw.kng.service.MoviesService;

@Component
public class MovieTestRunner implements CommandLineRunner {
	
	@Autowired
	private MoviesService ms;

	@Override
	public void run(String... args) throws Exception 
	{
		//-----------------------------------------------------------------------------------------------------------------
		
							// Insertion Movies through runner class.
		//Comment here:
		//------------------
		
		
		/*
		Movies mov= new Movies();
		mov.setMovieName("Avatar");
		mov.setYear("2008");
		mov.setRatings(4.25);
	
		
		String msg= ms.registerMovie(mov);
		System.out.println(msg);
		*/
		
		//-----------------------------------------------------------------------------------------------------------------
		
				// Register a group of Movies using `List` and <Iterable>
		
		//Comment here:
		//-------------------
		/*
		try 
		{
		Movies m1= new Movies("Thor","2010",3.25);
		Movies m2= new Movies("Captain America: First Avengers", "2010",4.25);
		Movies m3= new Movies("Iron Man","2008",3.9);
		
		Movies m4= new Movies("Incredible Hulk","2008",3.0);
		Movies m5= new Movies("Avengers","2012",4.78);
		Movies m6= new Movies("Iron Man 2","2010",3.01);
		
		
		List<Movies> mlist= List.of(m1,m2,m3,m4,m5,m6);
		String msg1= ms.registerGroupMovies(mlist);
		System.out.println(msg1);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		*/
		//-----------------------------------------------------------------------------------------------------------------
		
				// Add or Update a Movie Details.
		
		//Comment here:
		//-------------------
		
		
		/*
		try 
		{
		Movies mov1= new Movies();
		mov1.setMId(5);
		mov1.setMovieName("Incredible Hulk");
		mov1.setYear("2008");
		mov1.setRatings(3.00);
		
		System.out.println(ms.registerOrUpdateMovies(mov1));
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
		 */

		//-----------------------------------------------------------------------------------------------------------------
		
						// FINDER Methods:

		//Comment here:
		//-------------------

		/*
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>Equals");
		ms.findByMovieNameEquals("Thor").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>");
		ms.findByMovieName("Thor").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>StartingWith");
		ms.findByMovieNameStartingWith("Ir").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>EndingWith");
		ms.findByMovieNameEndingWith("lk").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>Containing");
		ms.findByMovieNameContaining("on").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>EqualsIgnoreCase");
		ms.findByMovieNameEqualsIgnoreCase("AVENGERS").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>ContainingIgnoreCase");
		ms.findByMovieNameContainingIgnoreCase("GERS").forEach(System.out::println);
		
		
		System.out.println("------------------------------------------------");
		System.out.println("findBy<Attribute_Name>Like");
		ms.findByMovieNameLike("Iron%").forEach(System.out::println);
		System.out.println("-------");
		ms.findByMovieNameLike("%or").forEach(System.out::println);
		System.out.println("-------");
		ms.findByMovieNameLike("%ven%").forEach(System.out::println);
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
