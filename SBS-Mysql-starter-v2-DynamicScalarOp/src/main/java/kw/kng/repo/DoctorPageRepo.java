package kw.kng.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import kw.kng.entity.Doctor;

public interface DoctorPageRepo extends PagingAndSortingRepository<Doctor,Integer> 
{

}
