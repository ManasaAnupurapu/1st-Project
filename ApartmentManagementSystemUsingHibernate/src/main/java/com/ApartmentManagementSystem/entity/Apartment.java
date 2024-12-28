package com.ApartmentManagementSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Apartment")
public class Apartment {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Ensure this is present
	    @Column(name = "a_id")  // Ensure column name matches the database schema
	    private int apartmentId;

	private String address;
	private int numberOfFlats;
	private double rent;

	// One-to-many relationship with Resident
	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
	private List<Resident> residents;

	// One-to-many relationship with MaintenanceRequest
	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
	private List<MaintenanceRequest> maintenanceRequests;

	// Getters and setters
	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumberOfFlats() {
		return numberOfFlats;
	}

	public void setNumberOfFlats(int numberOfFlats) {
		this.numberOfFlats = numberOfFlats;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public List<Resident> getResidents() {
		return residents;
	}

	public void setResidents(List<Resident> residents) {
		this.residents = residents;
	}

	public List<MaintenanceRequest> getMaintenanceRequests() {
		return maintenanceRequests;
	}

	public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
		this.maintenanceRequests = maintenanceRequests;
	}
}
