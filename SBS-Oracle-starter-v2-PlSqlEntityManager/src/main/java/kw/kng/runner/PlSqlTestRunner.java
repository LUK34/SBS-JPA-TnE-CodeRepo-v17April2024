package kw.kng.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import kw.kng.service.IDoctorManagementService;

@Component
public class PlSqlTestRunner implements CommandLineRunner 
{

	@Autowired
	private IDoctorManagementService dms;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		dms.showDoctorsByIncomeRange(90000.0, 95000.0).forEach(System.out::println);

	}

}
