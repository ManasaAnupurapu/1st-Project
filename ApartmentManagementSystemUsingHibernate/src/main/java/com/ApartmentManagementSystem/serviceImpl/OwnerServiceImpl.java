package com.ApartmentManagementSystem.serviceImpl;


import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ApartmentManagementSystem.entity.Owner;
import com.ApartmentManagementSystem.service.OwnerService;

public class OwnerServiceImpl implements OwnerService {
    @Override
    public void insertOwner(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter owner name: ");
        String name = sc.nextLine();
        System.out.print("Enter owner email: ");
        String email = sc.nextLine();
        System.out.print("Enter owner phone number: ");
        String phone = sc.nextLine();

        Owner owner = new Owner(name, email, phone);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(owner);
        transaction.commit();
        session.close();
        System.out.println("Owner added successfully!");
    }

    @Override
    public void updateOwner(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter owner ID to update: ");
        int ownerId = sc.nextInt();
        sc.nextLine(); // consume newline

        Session session = sessionFactory.openSession();
        Owner owner = session.get(Owner.class, ownerId);

        if (owner != null) {
            System.out.print("Enter new name: ");
            owner.setName(sc.nextLine());
            System.out.print("Enter new email: ");
            owner.setEmail(sc.nextLine());
            System.out.print("Enter new phone number: ");
            owner.setPhoneNumber(sc.nextLine());

            Transaction transaction = session.beginTransaction();
            session.update(owner);
            transaction.commit();
            System.out.println("Owner updated successfully!");
        } else {
            System.out.println("Owner not found!");
        }
        session.close();
    }

    @Override
    public void deleteOwner(SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter owner ID to delete: ");
        int ownerId = sc.nextInt();

        Session session = sessionFactory.openSession();
        Owner owner = session.get(Owner.class, ownerId);

        if (owner != null) {
            Transaction transaction = session.beginTransaction();
            session.delete(owner);
            transaction.commit();
            System.out.println("Owner deleted successfully!");
        } else {
            System.out.println("Owner not found!");
        }
        session.close();
    }

    @Override
    public Owner getOwner(SessionFactory sessionFactory, int ownerId) {
        Session session = sessionFactory.openSession();
        Owner owner = session.get(Owner.class, ownerId);
        session.close();
        return owner;
    }

    @Override
    public void getAllOwners(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Owner> owners = session.createQuery("from Owner", Owner.class).getResultList();
        for (Owner owner : owners) {
            System.out.println(owner);
        }
        session.close();
    }
}
