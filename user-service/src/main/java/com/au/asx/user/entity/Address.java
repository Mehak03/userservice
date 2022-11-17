package com.au.asx.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * /**
 * Entity class for ADDRESS
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

	private Long userId;
	private String street;
    private String city;
    private String state;
    private Integer postcode;
    
    public Address() {
    	
    }
    
	public Address(Long id, String street, String city, String state, Integer postcode, UserDetails userDetails) {
		super();
		this.userId = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	@Column(name = "STREET")
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "CITY")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "POSTCODE")
	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) { 
		this.postcode = postcode;
	}	
}
