package com.zee.zee5app.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
//ORM mapping
@Entity
// For customizing table
@Table(name="register")
public class Register implements Comparable<Register>
{
	
//		public Register(String id, String firstName, String lastName, String email, String password) 
//		throws IdInvalidLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//			super();
//			this.setId(id);
//			this.setFirstName(firstName);
//			this.setLastName(lastName);
//			this.setEmail(email);
//			this.setPassword(password);
//	}
	

	@NotNull
	private BigDecimal contactnumber;

	@Id
	@Column(name="regId")
	private String id;
	
	@Size(max=50)
	@NotBlank
	private String firstName;

	@Size(max=50)
	@NotBlank
	private String lastName;
	
	@Size(max=50)
	@Email
	private String email;

	@Size(max=100)
	@NotBlank
	private String password;
	
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}	
}
