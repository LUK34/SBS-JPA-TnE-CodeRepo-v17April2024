package kw.kng.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kw.kng.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> 
{
	

}
