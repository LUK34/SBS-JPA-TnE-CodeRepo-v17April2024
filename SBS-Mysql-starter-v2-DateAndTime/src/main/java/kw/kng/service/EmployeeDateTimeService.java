package kw.kng.service;

import java.util.List;

import kw.kng.entity.EmployeeDateTime;

public interface EmployeeDateTimeService 
{
	public String saveEmployeeDateTime(EmployeeDateTime dateTime);
	public List<EmployeeDateTime> getAllEmployeeDateTime();
	public List<Integer> showEmployeeDateTimeAgesBydesg(String desg);
	
}
