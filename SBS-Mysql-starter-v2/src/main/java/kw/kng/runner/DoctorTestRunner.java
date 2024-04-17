package kw.kng.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kw.kng.entity.Doctor;
import kw.kng.service.DoctorService;

@Component
public class DoctorTestRunner implements CommandLineRunner {

	@Autowired
	private DoctorService ds;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		
		//-----------------------------------------------------------------------------------------------------------------
		
												// Insertion through runner class.
		//Comment here:
		//------------------
		
		/*
		
		Doctor doc= new Doctor();
		doc.setDocName("Henrique");
		doc.setIncome(95000.0);
		doc.setSpecialization("ENT");
		
		String msg= ds.registerDoctor(doc);
		System.out.println(msg);
		
		*/
		
		//-----------------------------------------------------------------------------------------------------------------
											
											// Fetch Count of Records using `count()` method:
		
		//Comment here:
		//------------------
		
		/*
		try 
		{
			System.out.println("Count of Records::"+ds.fetchDoctorsCount());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		
		
		//-----------------------------------------------------------------------------------------------------------------
		
							// Checks if there exists a record with a given id value. `existsById` method
		
		//Comment here:
		//-------------------
		
		
		//In MySql we started the record from `1` because of `@GeneratedValue(strategy= GenerationType.IDENTITY)`
		//so we check whether there is 1 or not
		
		/*
		try 
		{
			System.out.println("Does id=100 record exits ?? Answer: "+ds.checkDoctorAvailability(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		
		//-----------------------------------------------------------------------------------------------------------------
		
									// Display all doctors present in database

		//Comment here:
		//-------------------
		/*
		
		try 
		{
			Iterable<Doctor> it= ds.showAllDoctors();
			//it.forEach(d->{ System.out.println(d);});  //old way
			it.forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		*/
		
		//-----------------------------------------------------------------------------------------------------------------
		
							// Show all the doctors by id. Using `findAllById` method

		//Comment here:
		//-------------------
		
		/*
		try
		{
			ds.showAllDoctorsByIds(List.of(1,2,100,200,101)).forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		//-----------------------------------------------------------------------------------------------------------------
		
							// Register a group of doctors using `List` and <Iterable>

		//Comment here:
		//-------------------
		/*
		try 
		{
			Doctor d1= new Doctor("Aamir","GP",95000.0);
			Doctor d2= new Doctor("Sharukh","GYNO",90000.0);
			Doctor d3= new Doctor("Salman","Ortho",89000.0);
			
			Doctor d4= new Doctor("Kajol","CARDIO",95000.0);
			Doctor d5= new Doctor("Rani","GYNO",90000.0);
			Doctor d6= new Doctor("Kareena","Ortho",89000.0);
			
			
			List<Doctor> dlist= List.of(d1,d2,d3,d4,d5,d6);
			String msg= ds.registerGroupCustomers(dlist);
			System.out.println(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		//-----------------------------------------------------------------------------------------------------------------
		
							// Check if the doctor exist by id. using `Optional` method.

		//Comment here:
		//-------------------
		
		/*
		try 
		{
			Doctor doctor= ds.showDoctorById(1); //1 --valid, 101 --invalid
			System.out.println(doctor);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()); 
		}
		
		*/
		
		
		/*
		 if the id doesn`t exist it will display `Invalid Doctor Id` message.
		 */
		
		//-----------------------------------------------------------------------------------------------------------------
		
							// Add or Update a Doctor Details.
		
		//Comment here:
		//-------------------
		
		
		/*
		try 
		{
			Doctor doc= new Doctor();
			doc.setDocId(20);
			doc.setDocName("Shobha");
			doc.setIncome(90000.0);
			doc.setSpecialization("GYNO");
			
			System.out.println(ds.registerOrUpdateDoctor(doc));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		//-----------------------------------------------------------------------------------------------------------------
		
								// Deletion by id.
		
		//Comment here:
		//-------------------
		
		
		
		/*
		
		try 
		{
			System.out.println(ds.deleteDocorById(21));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		*/
		
		
		
		
		
		//-----------------------------------------------------------------------------------------------------------------
		
								// Delete Record All by id
		
		//Comment here:
		//----------------------
		
		/*
		try 
		{
			System.out.println(ds.removeDoctorsByIds(List.of(9,10)));
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		*/
		
			
		
		//-----------------------------------------------------------------------------------------------------------------
		
								// Delete Record All

		//Comment here:
		//-------------------
		
		
		/*
		 
		 
		try 
		{
			System.out.println(ds.removeAllDoctors());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		*/
		
		
		
		
		
		
		
		
		
		
	}

}