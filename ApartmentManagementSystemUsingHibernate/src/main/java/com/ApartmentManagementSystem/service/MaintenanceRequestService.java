package com.ApartmentManagementSystem.service;

import org.hibernate.SessionFactory;

public interface MaintenanceRequestService {

	void insertMaintenance(SessionFactory sf);

	void updateMaintenance(SessionFactory sf);

	void deleteMaintenance(SessionFactory sf);

	void getAllMaintenance(SessionFactory sf);

	void getMaintenance(SessionFactory sf);

}