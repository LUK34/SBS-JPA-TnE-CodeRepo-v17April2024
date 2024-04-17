package kw.kng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.entity.Doctor;
import kw.kng.repo.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService 
{

	@Autowired
	private DoctorRepo drepo;
	
	
	@Override
	public String registerDoctor(Doctor doctor)
	{
		System.out.println("Doc id(before save::" + doctor.getDocId());
		Doctor doc=drepo.save(doctor);
		return "Doctor obj is saved with value: "+doc.getDocId();
	}

}
