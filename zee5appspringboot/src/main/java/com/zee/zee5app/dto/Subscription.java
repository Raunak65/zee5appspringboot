package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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
@Entity
//For customizing table
@Table(name="subscription")
public class Subscription implements Comparable<Subscription>{
	@NotBlank
	private String regId;
	
	
	@NotNull
	private String dateOfPurchase;
	
	
	@NotNull
	private String status;
	
	
	@NotBlank
	private String type;
	
	
	private String paymentMode;
	
	
	@NotBlank
	private String autoRenewal;
	
	
	@NotNull
	private String expiryDate;
	
	
	@Id
	@Column(name="subscriptionId")
	@NotBlank
	private String id;
	
	
	@NotNull
	private float amount;
	
	@Override
	public int compareTo(Subscription o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
}
