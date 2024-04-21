package kw.kng.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_MARRIAGE_SEEKER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MarriageSeeker implements Serializable
{
	@Column(name="ms_ID")
	@Id
	@SequenceGenerator(name="ms_seq_gen", sequenceName="ms_seq", allocationSize=1)
	@GeneratedValue(generator="ms_seq_gen", strategy=GenerationType.SEQUENCE)
	private Long msid;
	
	@NonNull
	@Column(length=20)
	private String name;
	
	@NonNull
	@Column(length=20)
	private String addrs;
	
	@NonNull
	@Lob
	private byte[] photo;
	
	@NonNull
	private LocalDateTime dob;
	
	@NonNull
	@Lob
	private char[] biodata;
	
	@NonNull
	private boolean indian;

}


/*
 
 CREATE SEQUENCE ms_seq
   START WITH 400
   INCREMENT BY 1
   NOMAXVALUE; 
 
 
 */









