package kw.kng.service;

import java.util.List;

import org.springframework.data.domain.Page;

import kw.kng.entity.Doctor;
import kw.kng.views.IDoctorResultView;
import kw.kng.views.IDoctorResultView1;
import kw.kng.views.IDoctorResultView2;

public interface DoctorService
{
	public String registerDoctor(Doctor doctor);
	public long fetchDoctorsCount();
	public boolean checkDoctorAvailability(Integer id);
	public Iterable<Doctor> showAllDoctors();
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);
	public String registerGroupCustomers(List<Doctor> docList);
	public Doctor showDoctorById(Integer id);
	public String registerOrUpdateDoctor(Doctor doctor);
	public String deleteDocorById(Integer id);
	public String removeAllDoctors();
	public String removeDoctorsByIds(Iterable<Integer> ids);
	
	//Paging And Sorting
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String ...props);
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String... props);
	
	
	//Using JPA Repository
	public String deleteDoctorsByIdsInBatch(List<Integer> ids);
	
	
	//More Custom Finder Methods
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange, double endRange);
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeDesc(double startRange, double endRange);
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeAsc(double startRange, double endRange);
	
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials, double start, double end);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetween(List<String> specials, double start, double end);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetweenOrderByIncomeDescSpecializationAsc(List<String> specials, double start, double end);
	
	
	
	//DYNAMIC SCALAR PROJECTION:
	public <T extends IDoctorResultView> Iterable<T> findByIncomeBetween(double start, double end,Class<T> clazz);
	
	
	//Query method example->Refer the repo layer
	public List<Doctor> searchDoctorsByIncomeRange(double start, double end);
	
	
	public Doctor showDoctorInfoByName(String docName);
	public Object showDoctorDataByName(String docName);
	public String showSpecializationByName(String docName);
	
	
	public int showDoctorNamesCount();
	public Object showAggregateData();
	
		
}

/*
 
 long count():
 //-----------
 Returns the number of entities available. It gives the records count in the db table.
 
 
 existsById:
 //-----------
  Returns whether an entity with the given id exits.
 
 
 
 Iterable<T> findAll():
 //----------------------
 Returns all instance of the type. It give all the records of table in
 form of Iterable/List of entity class objcs.
 

Iterable<T> findAllById(Iterable<ID> ids):
//-----------------------------------------

Returns all instance of the type T with the given IDS. If some or all ids are not found,
no entires are returned for these IDS. Note that the order of elements in the result id not
guarenteed.

Parameters: ids - must not be null nor contain any null values;

Returns: guarenteed to be not null. The size can be equal or less than the numbe of given ids/

Throws: Illega;ArgumentException: in case the given ids or one of its items is null.


<S extends T> Iterable <S> saveAll(Iterable <S> entities)
//--------------------------------------------------------
 
 Save all given entities. Entities must not be null nor nust it contain null.
 The save entities will never be null. The returbed Iterable will have the same size as the 
 Iterable passes as an argument.
 
 Throws:
 IllegaArgumentException - in case the entities or one of its entities is null.
 
 OptimistocLockingFailureException=when at least on entity uses optimistic locking and has 
 a version attribute with a different value from the found in the persistence store. Also
 thrown if at least one entity is assumed to be present bit does not exist in the database.
 
 
 
 
 
 
 
 
 
 
 */


