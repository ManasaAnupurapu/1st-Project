package com.ApartmentManagementSystem.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ApartmentManagementSystem.entity.Resident;
import com.ApartmentManagementSystem.service.ResidentService;

public class ResidentServiceImpl implements ResidentService {
	Scanner sc = new Scanner(System.in);
	Session s;
	Transaction t;

	@Override
	public void insertResident(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		Resident resident = new Resident();
		System.out.println("Enter resident name");
		resident.setR_name(sc.next());
		System.out.println("Enter resident email");
		resident.setR_email(sc.next());
		System.out.println("Enter resident mobile number");
		resident.setR_phnNo(sc.nextLong());
		
		resident.setMove_in(LocalDate.now());
		

		s.save(resident);
		t.commit();
		System.out.println("Resident added Successfully....");

	}

	@Override
	public void updateResident(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter Resident ID to update: ");
		int rid = sc.nextInt();
		Resident resident = s.get(Resident.class, rid);

		if (resident != null) {
			System.out.println(
					"What do you want to update?\n1. Name\n2. Email\n3. Phone Number\n4. Move-in Date\n5. Move-out Date");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter new Name: ");
				resident.setR_name(sc.next());
				break;
			case 2:
				System.out.println("Enter new Email: ");
				resident.setR_email(sc.next());
				break;
			case 3:
				System.out.println("Enter new Phone Number: ");
				resident.setR_phnNo(sc.nextLong());
				break;
			case 4:
			System.out.println("move_in");
			resident.setMove_in(LocalDate.now());
				break;
		
			default:
				System.out.println("Invalid option.");
			}
			s.update(resident);
			t.commit();
			System.out.println("Resident updated successfully!");
		} else {
			System.out.println("Resident not found with ID: " + rid);
		}
	}

	@Override
	public void deleteResident(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter Resident ID to delete: ");
		int rid = sc.nextInt();
		Resident resident = s.get(Resident.class, rid);

		if (resident != null) {
			s.delete(resident);
			t.commit();
			System.out.println("Resident deleted successfully!");
		} else {
			System.out.println("Resident not found with ID: " + rid);
		}

	}

	@Override
	public void getAllResident(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter Resident ID to get details: ");
		int rid = sc.nextInt();
		Resident resident = s.get(Resident.class, rid);

		if (resident != null) {
			System.out.println("Resident Details:");
			System.out.println("ID: " + resident.getR_Id());
			System.out.println("Name: " + resident.getR_name());
			System.out.println("Email: " + resident.getR_email());
			System.out.println("Phone: " + resident.getR_phnNo());
			System.out.println("Move-in Date: " + resident.getMove_in());
			System.out.println("Move-out Date: " + resident.getMove_out());
		} else {
			System.out.println("Resident not found with ID: " + rid);
		}

	}

	@Override
	public void getResident(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		List<Resident> residents = s.createQuery("FROM Resident", Resident.class).list();

		if (residents.isEmpty()) {
			System.out.println("No residents found.");
		} else {
			System.out.println("All Resident Details:");
			for (Resident resident : residents) {
				System.out.println("ID: " + resident.getR_Id() + ", Name: " + resident.getR_name() + ", Email: "
						+ resident.getR_email());
			}
		}

	}
}
