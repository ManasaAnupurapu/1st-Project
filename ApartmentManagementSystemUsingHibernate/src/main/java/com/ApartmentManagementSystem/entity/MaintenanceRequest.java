package com.ApartmentManagementSystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MaintenanceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;

	private String description;
	private String status;

	// Many-to-one relationship with Apartment
	@ManyToOne
	@JoinColumn(name = "apartment_id")
	private Apartment apartment;
	
	@ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;

	// Getters and setters
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
}