package kw.kng.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kw.kng.entity.EmployeeDateTime;
import kw.kng.service.EmployeeDateTimeService;

@Component
public class DateTimeTestRunner implements CommandLineRunner 
{
	@Autowired
	private EmployeeDateTimeService edts;

	@Override
	public void run(String... args) throws Exception 
	{
		
		//-----------------------------------------------------------------------------------------------------------------
		
									// DATE TIME Test runner class. (MYSQL)
		
									
									// DATE TIME: Insert and save the record first:
		//Comment here:
		//------------------
		
		
		/*
		System.out.println("DATE TIME: Insert and save the record first:");
		
		try 
		{
			EmployeeDateTime emp= new EmployeeDateTime("Majin","Manager",
													   LocalDateTime.of(1979, 10,20,11,34),
													   LocalTime.of(15, 45),
													   LocalDate.of(2020, 10, 30)
													   );
			
			String result= edts.saveEmployeeDateTime(emp);
			System.out.println(emp);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/	
		
	
		//-----------------------------------------------------------------------------------------------------------------
		
		
		/*
		System.out.println("DATE TIME: Fetch all the records:");
		try 
		{
			edts.getAllEmployeeDateTime().forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		*/
	
		
		//-----------------------------------------------------------------------------------------------------------------
		
		/*
		
		System.out.println("DATE TIME: Fetch all the age of all the employees having by designation-> `Clerk`:");

		try 
		{
			edts.showEmployeeDateTimeAgesBydesg("Clerk").forEach(System.out::println);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		*/
		
		//-----------------------------------------------------------------------------------------------------------------
		
		
	}
}
