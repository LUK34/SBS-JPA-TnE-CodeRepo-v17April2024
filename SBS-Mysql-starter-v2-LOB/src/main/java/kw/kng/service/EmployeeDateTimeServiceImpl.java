package kw.kng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.entity.EmployeeDateTime;
import kw.kng.repo.EmployeeDateTimeRepo;

@Service
public class EmployeeDateTimeServiceImpl implements EmployeeDateTimeService 
{
	@Autowired
	private EmployeeDateTimeRepo empRepo;

	@Override
	public String saveEmployeeDateTime(EmployeeDateTime dateTime) 
	{
		int idVal= empRepo.save(dateTime).getEno();
		return "Employee Object is saved with the id Valie :: " +idVal;
	}

	@Override
	public List<EmployeeDateTime> getAllEmployeeDateTime() 
	{
		return empRepo.findAll();
	}

	@Override
	public List<Integer> showEmployeeDateTimeAgesBydesg(String desg) 
	{
		
		return empRepo.getEmployeeAgesByDesh(desg);
	}
	

}
