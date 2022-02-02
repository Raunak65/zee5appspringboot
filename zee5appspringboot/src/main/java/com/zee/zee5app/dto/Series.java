package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
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
@Table(name="series",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})

public class Series {
	
	@Id
	@Column(name="seriesId")
	private String id;
	
	@NotBlank
	private String genre;
	
	@NotBlank
	private String name;
	
	@NotNull
	private String releaseDate;
	
	@NotBlank
	private String trailer;
	
	@NotBlank
	private String language;
	@NotBlank
	private String cast;
	
	@Min(value=1)
	private int noOfEpisodes;
	
	@Max(value=70)
	private int ageLimit;
	
	
//	public Series(String id,String genre, String movieName, String trailer,float length,String location,String language,String cast,String releasedate,int noofepisodes) 
//			throws IdInvalidLengthException, InvalidNameException,LocationNotFoundException {
//				super();
//				this.setId(id);
//				this.setSeriesName(movieName);
//				this.genre = genre;
//				this.releasedate = releasedate;
//				this.language = language;
//				this.length = length;
//				this.trailer = trailer;
//				this.cast = cast;
//				this.noofepisodes = noofepisodes;
//				this.agelimit = agelimit;
//				
//				
//		}
	
}
