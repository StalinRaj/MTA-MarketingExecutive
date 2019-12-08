package com.encee.MTA.domain.project;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Project")
public class ProjectDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9052407238127889343L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
    @Column
	private String projectName;
	
    @Column
	private String vendorName;
	
    @Column
	private String projectManager;
	
    @Column
	private String status;
	
    @Column
	private String projectDescription;
	
    @Column
	private long estimatedHours;
	
    @Column
	private long targetcomplitionDate;
	
    @Column
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
