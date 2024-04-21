package kw.kng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor 
{
	@Column(name="CID")
	@Id
	@SequenceGenerator(name="gen1", sequenceName="doctor_seq", allocationSize=1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private Integer docId;
	
	
	@Column(name="DOC_NAME", length=25)
	private String docName;
	
	@Column(name="SPECIALIZATION", length=20)
	private String specialization;
	
	@Column(name="INCOME")
	private Double income;
	
	public Doctor(String docName, String specialization, Double income) 
	{
		super();
		this.docName = docName;
		this.specialization = specialization;
		this.income = income;
	}

}


/*
1. Oracle does'nt have Auto increment. so we have to create the sequence manually in the database first.

2. Create a runner class and place `Component`. Run the application from kw.kng package.
This starter class will recognize the runner class and execute it because of `@Component`.

Package: kw.kng.runner
Runner Class: DoctorTestRunner.java


3. To execute the application use

Package:
Class:SbsOracleStarterApplication

Run this class and data will be inserted into database.


*/


//SEQUENCE SQL Script is as follows:

/*
 CREATE SEQUENCE doctor_seq
    START WITH 100
    INCREMENT BY 1
    NOMAXVALUE;
 */


/*

CREATE or REPLACE PROCEDURE P_GET_DOCTORS_BY_INCOME_RANGE
(
    STARTINCOME IN FLOAT,
    ENDINCOME IN FLOAT,
    DETAILS OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN DETAILS FOR
        SELECT * FROM jpa_doctor_info WHERE INCOME >= STARTINCOME AND INCOME <= ENDINCOME;
END P_GET_DOCTORS_BY_INCOME_RANGE;

*/







