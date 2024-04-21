package kw.kng.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import kw.kng.entity.Doctor;

public interface DoctorJpaRepo extends JpaRepository<Doctor, Integer> 
{

}
