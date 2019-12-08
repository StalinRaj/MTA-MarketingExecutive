package com.encee.MTA.model.project;

import java.io.Serializable;

public class ProjectModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3362457554875702706L;
	
	private long id;
	
	private String projectName;
	
	private String vendorName;
	
	private String projectManager;
	
	private String status;
	
	private String projectDescription;
	
	private long estimatedHours;
	
	private long targetcomplitionDate;
	
	private boolean isActive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public long getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(long estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public long getTargetcomplitionDate() {
		return targetcomplitionDate;
	}

	public void setTargetcomplitionDate(long targetcomplitionDate) {
		this.targetcomplitionDate = targetcomplitionDate;
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
