package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
//For customizing table
@Table(name="login")
public class Login {

	@Id
	@Column(name="userName")
	private String username;
	
	@Size(max=100)
	@NotBlank
	private String password;
	
	@NotBlank
	private String regId;
	
	@NotNull
	private ROLE role;
}
