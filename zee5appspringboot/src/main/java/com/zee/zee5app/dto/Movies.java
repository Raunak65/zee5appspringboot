package com.zee.zee5app.dto;

import javax.naming.InvalidNameException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFoundException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
//For customizing table
@Table(name="movies",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Movies {
	
	@NotBlank
	private String genre;
	
	@NotNull
	private String releasedate;
	
	@NotBlank
	private String trailer;
	
	@NotBlank
	private String language;
	
	@Min(value=60)
	private int length;
	
	@NotBlank
	private String cast;
	
	@Max(value=70)
	private int agelimit;
	
	@Id
	@Column(name="movieId")
	private String id;
	
	@NotBlank
	private String name;
	
//	public Movies(String id,String movieName,String trailer,float length,String releasedate,int agelimit,String genre,String language,String cast) 
//			throws IdInvalidLengthException, InvalidNameException,LocationNotFoundException {
//				super();
//				this.setId(id);
//				this.setMovieName(movieName);
//				this.genre = genre;
//				this.releasedate = releasedate;
//				this.language = language;
//				this.length = length;
//				this.trailer = trailer;
//				this.cast = cast;
//				this.agelimit = agelimit;
//				
//				
//		}
//	
//	public Movies() {
//		
//	}
//	public void setMovieName(String movieName) throws InvalidNameException {
//		if(movieName == null || movieName=="" || movieName.length()<2) {
//			throw new InvalidNameException("First Name is not valid");
//		}
//		this.movieName = movieName;
//	}
//	
//	public void setId(String id) throws IdInvalidLengthException {
//		if(id.length()<=6) {
//			
//			throw new IdInvalidLengthException("Id length is less than or equal to 6");
//			
//		}
//			
//		this.id = id;
//	}
	
}
