package com.paypal.bfs.test.employeeserv.dao;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter 
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EmployeeDao {
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public Date getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(Date dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//	public AddressDao getAddress() {
//		return address;
//	}
//	public void setAddress(AddressDao address) {
//		this.address = address;
//	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private Date dateOfBirth;
	@Embedded
	private AddressDao address;

}
