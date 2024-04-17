package kw.kng.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="JPA_MOVIES_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer mId;
	
	@Column(name="MOVIE_NAME", length=200)
	private String movieName;
	
	@Column(name="RELEASE_YEAR", length=10)
	private String year;
	
	//@Transient
	@Column(name="RATINGS", precision=5, scale=2)
	private Double ratings;

	public Movies(String movieName, String year, Double ratings) {
		super();
		this.movieName = movieName;
		this.year = year;
		this.ratings = ratings;
	}
	
	
	
	

}
