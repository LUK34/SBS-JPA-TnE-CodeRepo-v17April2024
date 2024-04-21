package kw.kng.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer docId;
	
	@Column(name="DOC_NAME", length=25)
	private String docName;
	
	@Column(name="SPECIALIZATION", length=20)
	private String specialization;
	
	//@Transient
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
*/








