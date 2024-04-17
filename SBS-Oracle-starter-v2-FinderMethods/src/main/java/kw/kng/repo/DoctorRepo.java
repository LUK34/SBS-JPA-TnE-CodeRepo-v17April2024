package kw.kng.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kw.kng.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> 
{
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double startRange, double endRange);
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeDesc(double startRange, double endRange);
	public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqualOrderByIncomeAsc(double startRange, double endRange);
	
	
	
	public Iterable<Doctor> findBySpecializationInOrIncomeBetween(List<String> specials, double start, double end);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetween(List<String> specials, double start, double end);
	public Iterable<Doctor> findBySpecializationInAndIncomeBetweenOrderByIncomeDescSpecializationAsc(List<String> specials, double start, double end);
	
	
	
	

}
