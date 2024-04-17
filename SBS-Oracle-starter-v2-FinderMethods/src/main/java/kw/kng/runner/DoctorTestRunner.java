package kw.kng.runner;

import java.util.Arrays;
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
		doc.setDocName("Ajit");
		doc.setIncome(95000.0);
		doc.setSpecialization("GP");
		
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
		
		/*
		
		try 
		{
			System.out.println("Does id=100 record exits ?? Answer: "+ds.checkDoctorAvailability(100));
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
					Doctor doctor= ds.showDoctorById(101); //1 --Invalid, 101 --valid
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
					doc.setDocId(113);
					doc.setDocName("Karishma");
					doc.setIncome(90000.0);
					doc.setSpecialization("ENT");
					
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
					System.out.println(ds.deleteDocorById(106));
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
					System.out.println(ds.removeDoctorsByIds(List.of(105,104)));
					
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
				
		//-----------------------------------------------------------------------------------------------------------------
		
					// SORTING ->  Ascending or Descending order -> on the basis of attributes from entity class
			
			//Comment here:
			//-------------------
			
			//ds.showDoctorsBySorting(true, "docName").forEach(System.out::println);
			//ds.showDoctorsBySorting(true, "income", "docName").forEach(System.out::println);
			
			
			
			//false- Descending Order, true-Ascending Order

		//-----------------------------------------------------------------------------------------------------------------

						// PAGING -> Ascending or Descending order -> on the basis of attributes from entity class
				
				//Comment here:
				//-------------------
				
				/*
				
				System.out.println("----------findAll(Pageable pageable)--------");
				
				try 
				{
				Page<Doctor> page=ds.showDoctorsInfoByPageNo(2, 3, false, "income","docName");
				System.out.println("Page Number:: " + page.getNumber());
				System.out.println("Page Count:: " + page.getTotalPages());
				System.out.println("Is it First Page:: " + page.isFirst());
				System.out.println("Is it Last Page:: " + page.isLast());
				System.out.println("Page Size:: " + page.getSize());
				System.out.println("Page Elements count:: "+ page.getNumberOfElements());
				
				if(!page.isEmpty()) 
				{
				List<Doctor> list=page.getContent();
				list.forEach(System.out::println);
				}
				else
				{
				System.out.println("No Pages found");
				}
				}
				catch(Exception e)
				{
				e.printStackTrace();
				}
				
				*/


		//-----------------------------------------------------------------------------------------------------------------

					// JPARepo -> Delete By Ids in Batch
			//Comment here:
			//-------------------
			
			
			
			/*
			 	System.out.println(ds.deleteDoctorsByIdsInBatch(Arrays.asList(113, null)));
			*/
			
			
			//This will not throw exception becoz of Arrays. While in List.of(-,-) does not allow null elements.

		
		//-----------------------------------------------------------------------------------------------------------------
		
		// Custom Finder Methods

		//Comment here:
		//-------------------
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" INCOME >= AND <= ");
		Iterable<Doctor> it1=ds.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(90000.0, 95000.0);
		it1.forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" INCOME >= AND <=  ORDER BY INCOME DESC");
		ds.findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeDesc(90000.0, 95000.0).forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" INCOME >= AND <=  ORDER BY INCOME ASC");
		ds.findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeAsc(90000.0, 95000.0).forEach(System.out::println);
		
		
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" SPECIALIZATION  IN OR INCOME BETWEEN ");
		ds.findBySpecializationInOrIncomeBetween(List.of("GYNO","CARDIO"), 89000.0, 95000.0).forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" SPECIALIZATION  IN AND INCOME BETWEEN ");
		ds.findBySpecializationInAndIncomeBetween(List.of("GYNO","CARDIO"), 89000.0, 95000.0).forEach(System.out::println);
		
		
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println(" SPECIALIZATION  IN OR INCOME BETWEEN  ORDER BY INCOME DESC ORDER BY SPECIALIZATION ASC");
		ds.findBySpecializationInAndIncomeBetweenOrderByIncomeDescSpecializationAsc(List.of("GYNO","CARDIO"), 89000.0, 95000.0).forEach(System.out::println);
		
		
		
		System.out.println("----------------------------------------------------------------------------------------------------");




	}

}
