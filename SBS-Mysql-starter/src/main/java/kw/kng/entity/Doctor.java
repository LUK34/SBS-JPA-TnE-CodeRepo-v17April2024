package kw.kng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
public class Doctor 
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer docId;
	
	@Column(name="DOC_NAME", length=25)
	private String docName;
	
	@Column(name="SPECIALIZATION", length=20)
	private String specialization;
	
	@Column(name="INCOME")
	private Double income;

}


/*
*/








