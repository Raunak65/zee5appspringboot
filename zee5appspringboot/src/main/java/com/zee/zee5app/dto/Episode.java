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
@Table(name = "episode")
public class Episode {

	@NotNull
	private String seriesId;

	@NotNull
	private String location;

	@NotNull
	private String trailer;

	@Max(value = 60)
	private int length;

	@Id
	@Column(name = "episodeId")
	private String id;

	@NotBlank
	private String name;
}
