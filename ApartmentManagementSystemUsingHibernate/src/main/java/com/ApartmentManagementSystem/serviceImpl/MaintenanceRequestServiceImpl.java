package com.ApartmentManagementSystem.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ApartmentManagementSystem.entity.MaintenanceRequest;
import com.ApartmentManagementSystem.service.MaintenanceRequestService;

public class MaintenanceRequestServiceImpl implements MaintenanceRequestService {
	Scanner sc = new Scanner(System.in);
	Session s;
	Transaction t;

	@Override
	public void insertMaintenance(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		MaintenanceRequest request = new MaintenanceRequest();
		System.out.println("Enter your Description ");
		request.setDescription(sc.nextLine());
		System.out.println("Enter status");
		request.setStatus(sc.nextLine());

		s.save(request);
		t.commit();
		System.out.println("Maintenance request added successfully....");
	}

	@Override
	public void updateMaintenance(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		System.out.println("Enter Maintenance Request Id to update: ");
		int requestId = sc.nextInt();
		MaintenanceRequest request = s.get(MaintenanceRequest.class, requestId);

		if (request != null) {
			System.out.println("What you want to update...?\n1.Description\n2.Status");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter new Description: ");
				request.setDescription(sc.nextLine());
				break;
			case 2:
				System.out.println("Enter new Status: ");
				request.setStatus(sc.nextLine());
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
			s.update(request);
			t.commit();
			System.out.println("Maintenance Request updated Successfully");
		} else {
			System.out.println("No maintenance Request found with ID: " + requestId);
		}
	}

	@Override
	public void deleteMaintenance(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter request id to remove maintenance request ");
		int requestId = sc.nextInt();
		MaintenanceRequest request = s.get(MaintenanceRequest.class, requestId);

		if (request != null) {
			s.delete(request);
			t.commit();
			System.out.println("Maintenance request deleted successfully!");
		} else {
			System.out.println("No Maintenance request found with ID: " + requestId);
		}
	}

	@Override
	public void getMaintenance(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter request Id to get details");
		int requestId = sc.nextInt();
		MaintenanceRequest request = s.get(MaintenanceRequest.class, requestId);

		if (request != null) {
			System.out.println("Maintenance Request Details are\n---------------------------");
			System.out.println("ID: " + request.getRequestId() + ", Description: " + request.getDescription()
					+ ", Status: " + request.getStatus());
		} else {
			System.out.println("No Maintenance request found with Id:" + requestId);

		}

	}

	@Override
	public void getAllMaintenance(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		List<MaintenanceRequest> requests = s.createQuery("from MaintenanceRequest", MaintenanceRequest.class).list();
		if (requests.isEmpty()) {
			System.out.println("No maintenance requests found");
		} else {
			System.out.println("All Maintenance Requests:");
			for (MaintenanceRequest request : requests) {
				System.out.println("ID: " + request.getRequestId() + ", Description: " + request.getDescription()
						+ ", Status: " + request.getStatus());
			}

		}

	}
}