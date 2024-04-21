package kw.kng.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kw.kng.entity.Doctor;

@Service
public class IDoctorManagementServiceImpl implements IDoctorManagementService 
{
	@Autowired
	private EntityManager manager;
	

	@Override
	public List<Doctor> showDoctorsByIncomeRange(double start, double end) 
	{
		 // Create StoredProcedureQuery object pointing to the SQL procedure
        StoredProcedureQuery query = manager.createStoredProcedureQuery("P_GET_DOCTORS_BY_INCOME_RANGE", Doctor.class);

        // Register both IN parameters by specifying their mode
        query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);

        // Set values to IN parameters
        query.setParameter(1, start);
        query.setParameter(2, end);

        // Execute the stored procedure and get the result list
        @SuppressWarnings("unchecked")
        List<Doctor> list = query.getResultList();
        return list;
	}

}
