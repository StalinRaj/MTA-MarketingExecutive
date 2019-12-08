package com.encee.MTA.domain.market_executive;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="marketing_executive")
public class MarketExecutiveDomain implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 8142300048378171246L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long executiveId;
	
    @Column
	private String executiveName;
	
    @Column
	private String AssignedProject;
	
    @Column
	private long Registration;
	
    @Column
	private String State;
	
    @Column
	private String City;
    
    @Column
	private String EmailId;
    
    @Column
	private long MobileNumber;
    
    @Column
	private long DateOfBirth;
    
    @Column
	private String Address;
    
    @Column
	private String Gender;
    
    @Column
	private long PinCode;
    
    @Column
	private boolean isActive;

	public long getExecutiveId() {
		return executiveId;
	}

	public void setExecutiveId(long executiveId) {
		this.executiveId = executiveId;
	}

	public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	public String getAssignedProject() {
		return AssignedProject;
	}

	public void setAssignedProject(String assignedProject) {
		AssignedProject = assignedProject;
	}

	public long getRegistration() {
		return Registration;
	}

	public void setRegistration(long registration) {
		Registration = registration;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public long getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public long getPinCode() {
		return PinCode;
	}

	public void setPinCode(long pinCode) {
		PinCode = pinCode;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
	
}
