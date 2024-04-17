package kw.kng.runner;

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
		Doctor doc= new Doctor();
		doc.setDocName("Savita");
		doc.setIncome(95000.0);
		doc.setSpecialization("GYNO");
		
		String msg= ds.registerDoctor(doc);
		System.out.println(msg);

	}

}
