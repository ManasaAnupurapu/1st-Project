package com.ApartmentManagementSystem.service;

import org.hibernate.SessionFactory;

import com.ApartmentManagementSystem.entity.Owner;

public interface OwnerService {
	
	    void insertOwner(SessionFactory sessionFactory);
	    void updateOwner(SessionFactory sessionFactory);
	    void deleteOwner(SessionFactory sessionFactory);
	    Owner getOwner(SessionFactory sessionFactory, int ownerId);
	    void getAllOwners(SessionFactory sessionFactory);
	}



