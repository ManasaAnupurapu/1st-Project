package com.ApartmentManagementSystem.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ApartmentManagementSystem.entity.Apartment;
import com.ApartmentManagementSystem.service.ApartmentService;

public class ApartmentServiceImpl implements ApartmentService {
	Scanner sc = new Scanner(System.in);
	Session s;
	Transaction t;

	@Override
	public void insertApartment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		Apartment apartment = new Apartment();
		System.out.println("Enter apartment address ");
		apartment.setAddress(sc.nextLine());
		System.out.println("Enter Number of Flats");
		apartment.setNumberOfFlats(sc.nextInt());
		System.out.println("Enter rent");
		apartment.setRent(sc.nextDouble());

		s.save(apartment);
		t.commit();
		System.out.println("Apartment added successfully");

	}

	@Override
	public void updateApartment(SessionFactory sf) {

		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter Apartment ID to update: ");
		int apartmentId = sc.nextInt();
		Apartment apartment = s.get(Apartment.class, apartmentId);

		if (apartment != null) {
			System.out.println("What you want to update...?\n1.address\n2.No.of Flats\n3.rent");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter new Address: ");
				apartment.setAddress(sc.nextLine());
				break;
			case 2:
				System.out.println("Enter new Number of Flats: ");
				apartment.setNumberOfFlats(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter new Rent: ");
				apartment.setRent(sc.nextDouble());
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

			s.update(apartment);
			t.commit();
			System.out.println("Apartment updated successfully!");
		} else {
			System.out.println("No Apartment found with Id:" + apartmentId);
		}

	}

	@Override
	public void deleteApartment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter Apartment Id to delete: ");
		int apartmentId = sc.nextInt();
		Apartment apartment = s.get(Apartment.class, apartmentId);
		if (apartment != null) {
			s.delete(apartment);
			t.commit();
			System.out.println("Apartment deleted successfully!");
		} else {
			System.out.println("No Apartment found with ID: " + apartmentId);
		}
	}

	@Override
	public void getApartment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter apartment Id to get details");
		int apartmentId = sc.nextInt();
		Apartment apartment = s.get(Apartment.class, apartmentId);
		if (apartment != null) {
			System.out.println("Apartment Details are\n---------------------------");
			System.out.println("ID: " + apartment.getApartmentId() + ", Address: " + apartment.getAddress()
					+ ", Flats: " + apartment.getNumberOfFlats() + ", Rent: " + apartment.getRent());
		} else {
			System.out.println("No Apartment found with ID: " + apartmentId);
		}

	}

	@Override
	public void getAllApartment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		List<Apartment> apartments = s.createQuery("from Apartment", Apartment.class).list();

		if (apartments.isEmpty()) {
			System.out.println("No apartments found");
		} else {
			System.out.println("All Apartments:");
			for (Apartment apartment : apartments) {
				System.out.println("ID: " + apartment.getApartmentId() + ", Address: " + apartment.getAddress()
						+ ", Flats: " + apartment.getNumberOfFlats() + ", Rent: " + apartment.getRent());
			}

		}

	}
}