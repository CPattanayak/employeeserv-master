package com.paypal.bfs.test.employeeserv.dao;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddressDao {
	
//	public String getLine1() {
//		return line1;
//	}
//
//	public void setLine1(String line1) {
//		this.line1 = line1;
//	}
//
//	public String getLine2() {
//		return line2;
//	}
//
//	public void setLine2(String line2) {
//		this.line2 = line2;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public int getZipCode() {
//		return zipCode;
//	}
//
//	public void setZipCode(int zipCode) {
//		this.zipCode = zipCode;
//	}

	private String line1;
	
	private String line2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int zipCode;

}
