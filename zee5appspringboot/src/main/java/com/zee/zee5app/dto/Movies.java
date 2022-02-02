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
/**
 * @param genre
 * @param releasedate
 * @param trailer
 * @param language
 * @param length
 * @param cast
 * @param agelimit
 * @param id
 * @param name
 */
@AllArgsConstructor
@Entity
//For customizing table
@Table(name="movies",uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Movies {
	@Id
	@Column(name="movieId")
	private String id;

	@NotBlank
	private String name;
	
	@NotBlank
	private String genre;
	
	@NotNull
	private String releasedate;
	
	@NotBlank
	private String trailer;
	
	@NotBlank
	private String language;
	
	@NotBlank
	private String cast;
	
	@Min(value=60)
	private int length;
	
	
	@Max(value=70)
	private int agelimit;
}
