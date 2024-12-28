package com.ApartmentManagementSystem.service;

import org.hibernate.SessionFactory;

public interface PaymentService {

	void insertPayment(SessionFactory sf);

	void updatePayment(SessionFactory sf);

	void deletePayment(SessionFactory sf);

	void getAllPayment(SessionFactory sf);

	void getPayment(SessionFactory sf);
	
}