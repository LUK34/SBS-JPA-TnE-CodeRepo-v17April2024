package kw.kng.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kw.kng.entity.EmployeeDateTime;

public interface EmployeeDateTimeRepo extends JpaRepository<EmployeeDateTime, Integer> 
{

	@Query(value="SELECT YEAR(CURRENT_TIMESTAMP)-YEAR(DOB) FROM JPA_EMPLOYEE_DATE_TIME WHERE DESG=:job", nativeQuery=true)
	public List<Integer> getEmployeeAgesByDesh(String job);
	
}
