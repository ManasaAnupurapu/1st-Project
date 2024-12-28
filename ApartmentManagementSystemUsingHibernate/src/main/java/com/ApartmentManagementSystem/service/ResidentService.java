package com.ApartmentManagementSystem.service;

import org.hibernate.SessionFactory;

public interface ResidentService {

	void insertResident(SessionFactory sf);

	void updateResident(SessionFactory sf);

	void deleteResident(SessionFactory sf);
	
	void getResident(SessionFactory sf);

	void getAllResident(SessionFactory sf);

	
	
}