package com.ApartmentManagementSystem.serviceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ApartmentManagementSystem.entity.Complaints;
import com.ApartmentManagementSystem.entity.Resident;
import com.ApartmentManagementSystem.service.ComplaintsService;


public class ComplaintsServiceImpl implements ComplaintsService {

    @Override
    public void insertComplaint(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter resident ID: ");
        int residentId = sc.nextInt();
        sc.nextLine(); // consume newline

        Session session = sessionFactory.openSession();
        Resident resident = session.get(Resident.class, residentId);

        if (resident != null) {
            System.out.print("Enter complaint description: ");
            String description = sc.nextLine();

            Complaints complaint = new Complaints(resident, description);
            Transaction transaction = session.beginTransaction();
            session.save(complaint);
            transaction.commit();
            System.out.println("Complaint submitted successfully!");
        } else {
            System.out.println("Resident not found!");
        }
        session.close();
    }

    @Override
    public void updateComplaint(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complaint ID to update: ");
        int complaintId = sc.nextInt();
        sc.nextLine(); // consume newline

        Session session = sessionFactory.openSession();
        Complaints complaint = session.get(Complaints.class, complaintId);

        if (complaint != null) {
            System.out.print("Enter new complaint description: ");
            complaint.setComplaintDescription(sc.nextLine());
            
            Transaction transaction = session.beginTransaction();
            session.update(complaint);
            transaction.commit();
            System.out.println("Complaint updated successfully!");
        } else {
            System.out.println("Complaint not found!");
        }
        session.close();
    }

    @Override
    public void deleteComplaint(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complaint ID to delete: ");
        int complaintId = sc.nextInt();

        Session session = sessionFactory.openSession();
        Complaints complaint = session.get(Complaints.class, complaintId);

        if (complaint != null) {
            Transaction transaction = session.beginTransaction();
            session.delete(complaint);
            transaction.commit();
            System.out.println("Complaint deleted successfully!");
        } else {
            System.out.println("Complaint not found!");
        }
        session.close();
    }

    @Override
    public void getComplaint(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter complaint ID to view: ");
        int complaintId = sc.nextInt();

        Session session = sessionFactory.openSession();
        Complaints complaint = session.get(Complaints.class, complaintId);
        if (complaint != null) {
            System.out.println(complaint);
        } else {
            System.out.println("Complaint not found!");
        }
        session.close();
    }

    @Override
    public void getAllComplaints(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Complaints> complaints = session.createQuery("from Complaint", Complaints.class).getResultList();
        for (Complaints complaint : complaints) {
            System.out.println(complaint);
        }
        session.close();
    }
}
