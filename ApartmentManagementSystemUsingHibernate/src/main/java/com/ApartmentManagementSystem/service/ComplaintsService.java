package com.ApartmentManagementSystem.service;

import org.hibernate.SessionFactory;

public interface ComplaintsService {
	
	    void insertComplaint(SessionFactory sessionFactory);
	    void updateComplaint(SessionFactory sessionFactory);
	    void deleteComplaint(SessionFactory sessionFactory);
	    void getComplaint(SessionFactory sessionFactory);
	    void getAllComplaints(SessionFactory sessionFactory);
	}



