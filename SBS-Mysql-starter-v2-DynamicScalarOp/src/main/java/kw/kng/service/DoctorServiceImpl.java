package kw.kng.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import kw.kng.entity.Doctor;
import kw.kng.repo.DoctorJpaRepo;
import kw.kng.repo.DoctorPageRepo;
import kw.kng.repo.DoctorRepo;
import kw.kng.views.IDoctorResultView;

@Service
public class DoctorServiceImpl implements DoctorService 
{

	@Autowired
	private DoctorRepo drepo;
	
	@Autowired
	private DoctorPageRepo dprepo;
	
	@Autowired
	private DoctorJpaRepo djrepo;
	
	
	@Override
	public String registerDoctor(Doctor doctor)
	{
		System.out.println("Doc id(before save::" + doctor.getDocId());
		Doctor doc=drepo.save(doctor);
		return "Doctor obj is saved with value: "+doc.getDocId();
	}


	@Override
	public long fetchDoctorsCount() {
		
		return drepo.count();
	}


	@Override
	public boolean checkDoctorAvailability(Integer id) 
	{	
		return drepo.existsById(id);
	}


	@Override
	public Iterable<Doctor> showAllDoctors() 
	{	
		return drepo.findAll();
	}


	@Override
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) 
	{	
		return drepo.findAllById(ids);
	}


	@Override
	public String registerGroupCustomers(List<Doctor> docList) 
	{
		
		Iterable<Doctor> savedDoctprList= drepo.saveAll(docList);
		return "no.of records inserted: " + docList.size();
	}


	@Override
	public Doctor showDoctorById(Integer id) 
	{
		/*
		Optional<Doctor> opt=drepo.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
		}
		else 
		{
			throw new IllegalArgumentException("Invalid Doctor Id");
		}
		*/

		//This is the BEST Version:
		Doctor doctor= drepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Doctor Id"));
		
		return doctor;
	}


	@Override
	public String registerOrUpdateDoctor(Doctor doctor) 
	{
		Optional<Doctor> opt= drepo.findById(doctor.getDocId());
		if(opt.isPresent())
		{
			drepo.save(doctor); //this step is for updation. If the Id exist.
			return "Id Value= " + doctor.getDocId() + " .Doctor details are found and updated";
		}
		else 
		{
			return "Doctor is saved with id value: " + drepo.save(doctor).getDocId();
		}
	}


	@Override
	public String deleteDocorById(Integer id) 
	{
		Optional<Doctor> opt=drepo.findById(id);
		if(opt.isPresent())
		{
			drepo.deleteById(id);
			return "doctor id = " + id + " is deleted";
		}
		else 
		{
			return "doctor id = " + id + " not found for deletion";
		}
	}


	@Override
	public String removeAllDoctors() 
	{
		long count=drepo.count();
		if(count>0)
		{
			drepo.deleteAll();
			return "The no. of records deleted are count="+count;
		}
		return "There are no records present in the databse for deletion";
	}


	@Override
	public String removeDoctorsByIds(Iterable<Integer> ids) {
		
		List<Doctor> doc=(List<Doctor>)drepo.findAllById(ids);
		if(doc.isEmpty())
		{
			return "Records with the specified ids -> " + ids + " are not found in Database. Hence not able to perform deletion.";
		}
		else 
		{
			drepo.deleteAllById(ids);
			return "No.of records deleted are: "+doc.size();
		}
	}


	@Override
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) 
	{
		Sort sort= Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		
		Iterable<Doctor> it=dprepo.findAll(sort);
		return it;
	}


	@Override
	public Page<Doctor> showDoctorsInfoByPageNo(int pageNo, int pageSize, boolean ascOrder, String... props) 
	{
		//Prepare the sort object
		Sort sort= Sort.by(ascOrder ? Direction.ASC: Direction.DESC, props);
		
		//prepare Pageable object
		Pageable pageable= PageRequest.of(pageNo, pageSize, sort);
		
		Page<Doctor> page= dprepo.findAll(pageable);
		
		return page;
	}


	@Override
	public String deleteDoctorsByIdsInBatch(List<Integer> ids) 
	{
		//load the entities
		List<Doctor> list= djrepo.findAllById(ids);
		
		//delete the entities
		djrepo.deleteAllByIdInBatch(ids);
		
		return list.size()+" records are deleted";
	}


	@Override
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange, double endRange)
	{
		return drepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(startRange, endRange);
	}


	@Override
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials, double start, double end) 
	{
		return drepo.findBySpecializationInOrIncomeBetween(specials, start, end);
	}


	@Override
	public Iterable<Doctor> findBySpecializationInAndIncomeBetween(List<String> specials, double start, double end) 
	{
		return drepo.findBySpecializationInAndIncomeBetween(specials, start, end);
	}


	@Override
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeDesc(double startRange,
			double endRange) 
	{
		
		return drepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeDesc(startRange, endRange);
	}


	@Override
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeAsc(double startRange,
			double endRange)
	{
		return drepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeAsc(startRange, endRange);
	}


	@Override
	public Iterable<Doctor> findBySpecializationInAndIncomeBetweenOrderByIncomeDescSpecializationAsc
	(List<String> specials, double start, double end) 
	{
		return drepo.findBySpecializationInAndIncomeBetweenOrderByIncomeDescSpecializationAsc(specials, start, end);
	}


	//DYNAMIC SCALAR PROJECTIONS using GENERICS
	@Override
	public <T extends IDoctorResultView> Iterable<T> findByIncomeBetween(double start, double end,Class<T> clazz)
	
	{
		return drepo.findByIncomeBetween(start, end, clazz);
	}


	
	
	

}
