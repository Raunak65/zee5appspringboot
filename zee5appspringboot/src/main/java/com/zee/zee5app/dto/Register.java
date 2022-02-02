package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.naming.InvalidNameException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;

import lombok.AccessLevel;
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
	
//	public boolean isValid(String email)
//    {
//        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//                            "[a-zA-Z0-9_+&*-]+)*@" +
//                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
//                            "A-Z]{2,7}$";
//                              
//        Pattern pat = Pattern.compile(emailRegex);
//        if (email == null)
//            return false;
//        return pat.matcher(email).matches();
//    }
//	
//	public void setEmail(String email) throws InvalidEmailException {
//		if(!isValid(email)) {
//			throw new InvalidEmailException("Invalid Email");
//		}
//		this.email = email;
//			
//	}
//	
//	public void setPassword(String password) throws InvalidPasswordException {
//		if(password.length() <= 8) {
//			throw new InvalidPasswordException("Password length is less than or equal to 8");
//		}
//			
//		this.password = password;
//	}
//	public void setFirstName(String firstName) throws InvalidNameException {
//		if(firstName == null || firstName=="" || firstName.length()<2) {
//			throw new InvalidNameException("First Name is not valid");
//		}
//		this.firstName = firstName;
//	}
//	
//	public void setLastName(String lastName) throws InvalidNameException {
//		if(lastName == null || lastName=="" || lastName.length()<2) {
//			throw new InvalidNameException("Last Name is not valid");
//		}
//		this.lastName = lastName;
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
