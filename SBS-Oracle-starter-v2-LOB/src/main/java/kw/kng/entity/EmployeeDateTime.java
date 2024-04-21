package kw.kng.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_EMPLOYEE_DATE_TIME")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeDateTime 
{
	@Column(name="EDT_ID")
	@Id
	@SequenceGenerator(name="edt_seq_gen", sequenceName="edt_seq", allocationSize=1)
	@GeneratedValue(generator="edt_seq_gen", strategy=GenerationType.SEQUENCE)
	private Integer eno;
	
	@NonNull
	private String ename;
	
	@NonNull
	private String desg;
	
	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	private LocalTime toj;
	
	@NonNull
	private LocalDate doj;


}


/*
  
CREATE SEQUENCE edt_seq
   START WITH 300
   INCREMENT BY 1
   NOMAXVALUE; 

 */
















