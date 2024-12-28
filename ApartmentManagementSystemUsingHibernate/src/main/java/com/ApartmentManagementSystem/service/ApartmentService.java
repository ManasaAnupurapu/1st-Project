package com.ApartmentManagementSystem.service;

import org.hibernate.SessionFactory;

public interface ApartmentService {

	void insertApartment(SessionFactory sf);

	void updateApartment(SessionFactory sf);

	void deleteApartment(SessionFactory sf);

	void getAllApartment(SessionFactory sf);

	void getApartment(SessionFactory sf);
}