package kw.kng.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kw.kng.entity.Doctor;
import kw.kng.views.IDoctorResultView;
import kw.kng.views.IDoctorResultView2;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> 
{
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange, double endRange);
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeDesc(double startRange, double endRange);
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeAsc(double startRange, double endRange);
	
	
	
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials, double start, double end);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetween(List<String> specials, double start, double end);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetweenOrderByIncomeDescSpecializationAsc(List<String> specials, double start, double end);
	
	
	//DYNAMIC SCALAR PROJECTION:
	public <T extends IDoctorResultView> Iterable<T> findByIncomeBetween(double start, double end,Class<T> clazz);
	public List <IDoctorResultView2> findByIncomeBetween(double start, double end);
	
	
	//QUERY METHODS: Positional Paramaeter, Ordinal Parameter, named Parameter -> we will be using HQL
	
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		
	//@Query("select doc from Doctor doc WHERE doc.income>=? and doc.income<=?") //This is positional parameter -> Legacy approach. Tried running this but not working. need to used ordinal para
	//@Query("select doc from Doctor doc WHERE doc.income>=?1 and doc.income<=?2") //This is ordinal parameter -> Working
	@Query("select doc from Doctor doc WHERE doc.income >=:start AND doc.income <=:end") //This is named parameter -> Working
	public List<Doctor> searchDoctorsByIncomeRange(double start, double end);
	
	
	
	@Query("select doc from Doctor doc where doc.docName=:name")
	public Optional<Doctor> showDoctorInfoByName(String name);
	
	@Query("select doc.docId, doc.docName from Doctor doc where doc.docName=:name")
	public Object showDoctorDataByName(String name);
	
	@Query("select doc.specialization from Doctor doc where doc.docName=:name")
	public String showSpecializationByName(String name);
	
	
	
	@Query("Select count(distinct docName) from Doctor")
	public int fetchDoctorNameCount();
	
	@Query("Select count(*),max(income),min(income),avg(income),sum(income) from Doctor")
	public Object fetchAggregateData();
	
// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	

}


/*
	//DYNAMIC SCALAR PROJECTION:
	-------------------------
	
In JPA (Java Persistence API), dynamic scalar projection is a feature that allows you to select specific columns from a query rather than retrieving entire entity objects. 
This can be particularly useful when you only need a subset of the data from a table, which can improve the performance of your application by reducing the amount of data transferred from the database.

How It Works:
-------------------
Dynamic scalar projection in JPA is typically achieved using the createQuery() method of the EntityManager or 
through the @Query annotation in a repository interface if you're using Spring Data JPA. You specify only the fields you are interested in,
and the result can be returned in various formats such as a tuple, an array of objects, or a custom DTO (Data Transfer Object).


Advantages of Dynamic Scalar Projection:
----------------------------------------------
Performance: Less data is transferred from the database, which can improve retrieval speed, especially for large datasets.
Flexibility: Allows fetching only the necessary data, which can be particularly useful for reports or views where full entities are not required.
Resource Efficiency: Reduces memory usage on both the database server and the application server since less data is loaded into memory.
Dynamic scalar projection is a powerful tool in JPA for optimizing database interactions in Java applications, especially when dealing with large or complex datasets.



*/