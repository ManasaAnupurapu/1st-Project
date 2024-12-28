package com.ApartmentManagementSystem.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ApartmentManagementSystem.entity.Payment;
import com.ApartmentManagementSystem.entity.Resident;
import com.ApartmentManagementSystem.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
	Scanner sc = new Scanner(System.in);
	Session s;
	Transaction t;

	@Override
	public void insertPayment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		Payment payment = new Payment();
		System.out.println("Enter Amount");
		payment.setAmount(sc.nextDouble());

		payment.setPaymentDate(LocalDate.now());
		System.out.println("Enter Resident id ");
		int rid = sc.nextInt();
		Resident resident = s.get(Resident.class, rid);

		if (resident != null) {
			payment.setResident(resident);
			s.save(payment);
			t.commit();
			System.out.println("Payment added successfully!");
		} else {
			System.out.println("No resident found with Id:" + rid);
		}

	}

	@Override
	public void updatePayment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter Payment ID to update:");
		int pid = sc.nextInt();
		Payment payment = s.get(Payment.class, pid);

		if (payment != null) {
			System.out.println("What you want to update...?\n1.Amount\n2.Payment Date");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter new Amount:");
				payment.setAmount(sc.nextDouble());
				break;
			case 2:
				System.out.println("Enter new Payment Date (yyyy-MM-dd):");
				payment.setPaymentDate(LocalDate.now());
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}

			s.update(payment);
			t.commit();
			System.out.println("Payment updated successfully!");
		} else {
			System.out.println("No Payment found with Id:" + pid);
		}

	}

	@Override
	public void deletePayment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter payment Id to delete: ");
		int pid = sc.nextInt();
		Payment payment = s.get(Payment.class, pid);
		if (payment != null) {
			s.delete(payment);
			t.commit();
			System.out.println("Payment deleted successfully");
		}

		else {
			System.out.println("No payment found with Id: " + pid);
		}
	}

	@Override
	public void getPayment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		System.out.println("Enter payment Id to get details");
		int pid = sc.nextInt();

		Payment payment = s.get(Payment.class, pid);
		if (payment != null) {
			System.out.println("DETAILS ARE\n---------------------------");
			System.out.println("Payment Details:\n---------------------------");
			System.out.println("Payment ID: " + payment.getPaymentId());
			System.out.println("Amount: " + payment.getAmount());
			System.out.println("Payment Date: " + payment.getPaymentDate());
			System.out.println("Resident Id: " + payment.getResident().getR_Id());
		} else {
			System.out.println("No Payment found with ID: " + pid);
		}

	}

	@Override
	public void getAllPayment(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		List<Payment> payments = s.createQuery("from Payment", Payment.class).list();

		if (payments.isEmpty()) {
			System.out.println("No payments found.");
		} else {
			System.out.println("All Payments:");
			for (Payment payment : payments) {
				System.out.println("Payment ID: " + payment.getPaymentId() + ", Amount: " + payment.getAmount()
						+ ", Payment Date: " + payment.getPaymentDate() + ", Resident ID: "
						+ payment.getResident().getR_Id());
			}
		}

	}
}