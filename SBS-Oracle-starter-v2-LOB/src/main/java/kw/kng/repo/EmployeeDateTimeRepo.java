package kw.kng.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kw.kng.entity.EmployeeDateTime;

public interface EmployeeDateTimeRepo extends JpaRepository<EmployeeDateTime, Integer> 
{

	@Query(value="SELECT TRUNC(MONTHS_BETWEEN(CURRENT_DATE, DOB) / 12) as AGE \r\n"
			+ " FROM JPA_EMPLOYEE_DATE_TIME\r\n"
			+ "	WHERE DESG = :job", nativeQuery=true)
	public List<Integer> getEmployeeAgesByDesh(String job);
	
}
