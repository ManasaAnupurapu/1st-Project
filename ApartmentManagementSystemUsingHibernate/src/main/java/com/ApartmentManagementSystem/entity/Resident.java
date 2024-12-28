package com.ApartmentManagementSystem.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class Resident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int r_Id;

	private String r_name;
	private String r_email;
	private Long r_phnNo;
	private LocalDate move_in;
	private LocalDate move_out;

	@ManyToOne
	@JoinColumn(name = "apartment_id")
	private Apartment apartment;
	
	 @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
	    private List<Payment> payments;

	 @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL)
	    private List<MaintenanceRequest> maintenanceRequests;

	// Getters and Setters

	public int getR_Id() {
		return r_Id;
	}

	public void setR_Id(int r_Id) {
		this.r_Id = r_Id;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_email() {
		return r_email;
	}

	public void setR_email(String r_email) {
		this.r_email = r_email;
	}

	public Long getR_phnNo() {
		return r_phnNo;
	}

	public void setR_phnNo(Long r_phnNo) {
		this.r_phnNo = r_phnNo;
	}

	public LocalDate getMove_in() {
		return move_in;
	}

	public void setMove_in(LocalDate move_in) {
		this.move_in = move_in;
	}

	public LocalDate getMove_out() {
		return move_out;
	}

	public void setMove_out(LocalDate move_out) {
		this.move_out = move_out;
	}
}