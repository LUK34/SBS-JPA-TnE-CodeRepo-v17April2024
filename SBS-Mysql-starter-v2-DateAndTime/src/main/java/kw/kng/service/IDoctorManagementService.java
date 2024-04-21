package kw.kng.service;

import java.util.List;

import kw.kng.entity.Doctor;

public interface IDoctorManagementService 
{
	public List<Doctor> showDoctorsByIncomeRange(double start, double end);

}
