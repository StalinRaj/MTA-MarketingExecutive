package com.encee.MTA.model.market_executive;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



public class MarketExecutiveModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7213651419451541339L;

	
	private long executiveId;
	
	private String executiveName;
	
	private String AssignedProject;
	
	private long Registration;
	
	private String State;
	
	private String City;
	
	private String EmailId;
	
	private long MobileNumber;
	
	private long DateOfBirth;
	
	private String Address;
	
	private String Gender;
	
	private long PinCode;
	
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
