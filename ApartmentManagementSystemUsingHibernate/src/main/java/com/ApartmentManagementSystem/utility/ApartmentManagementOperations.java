package com.ApartmentManagementSystem.utility;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.ApartmentManagementSystem.entity.Owner;
import com.ApartmentManagementSystem.service.ApartmentService;
import com.ApartmentManagementSystem.service.ComplaintsService;
import com.ApartmentManagementSystem.service.MaintenanceRequestService;
import com.ApartmentManagementSystem.service.OwnerService;
import com.ApartmentManagementSystem.service.PaymentService;
import com.ApartmentManagementSystem.service.ResidentService;
import com.ApartmentManagementSystem.serviceImpl.ApartmentServiceImpl;
import com.ApartmentManagementSystem.serviceImpl.ComplaintsServiceImpl;
import com.ApartmentManagementSystem.serviceImpl.MaintenanceRequestServiceImpl;
import com.ApartmentManagementSystem.serviceImpl.OwnerServiceImpl;
import com.ApartmentManagementSystem.serviceImpl.PaymentServiceImpl;
import com.ApartmentManagementSystem.serviceImpl.ResidentServiceImpl;

public class ApartmentManagementOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SessionFactory sf = ConfigurationUtility.getsFactory();

        ApartmentService apartmentService = new ApartmentServiceImpl();
        ResidentService residentService = new ResidentServiceImpl();
        PaymentService paymentService = new PaymentServiceImpl();
        MaintenanceRequestService maintenanceService = new MaintenanceRequestServiceImpl();
        OwnerService ownerService= new OwnerServiceImpl();
        ComplaintsService complaintsService= new ComplaintsServiceImpl();
        while (true) {
            System.out.println("\n--- Apartment Management System ---");
            System.out.println("1. Apartment Operations");
            System.out.println("2. Resident Operations");
            System.out.println("3. Payment Operations");
            System.out.println("4. Maintenance Request Operations");
            System.out.println("5. Owner Operations");
            System.out.println("6. Complaints Operations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: 
                    apartmentOperations(apartmentService, sf);
                    break;
                case 2: 
                    residentOperations(residentService, sf);
                    break;
                case 3: 
                    paymentOperations(paymentService, sf);
                    break;
                case 4: 
                    maintenanceOperations(maintenanceService, sf);
                    break;
                case 5:
                	ownerOperations(ownerService, sf);
                	break;
                case 6:
                	complaintsOperations(complaintsService,sf);
                	break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    return; 
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

  
    private static void apartmentOperations(ApartmentService apartmentService, SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Apartment Operations ---");
            System.out.println("1. Insert Apartment");
            System.out.println("2. Update Apartment");
            System.out.println("3. Delete Apartment");
            System.out.println("4. Get Apartment");
            System.out.println("5. Get All Apartments");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    apartmentService.insertApartment(sessionFactory);
                    break;
                case 2:
                    apartmentService.updateApartment(sessionFactory);
                    break;
                case 3:
                    apartmentService.deleteApartment(sessionFactory);
                    break;
                case 4:
                    apartmentService.getApartment(sessionFactory);
                    break;
                case 5:
                    apartmentService.getAllApartment(sessionFactory);
                    break;
                case 6:
                    return;  // Back to the Main Menu
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Resident Operations
    private static void residentOperations(ResidentService residentService, SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Resident Operations ---");
            System.out.println("1. Insert Resident");
            System.out.println("2. Update Resident");
            System.out.println("3. Delete Resident");
            System.out.println("4. Get Resident");
            System.out.println("5. Get All Residents");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    residentService.insertResident(sessionFactory);
                    break;
                case 2:
                    residentService.updateResident(sessionFactory);
                    break;
                case 3:
                    residentService.deleteResident(sessionFactory);
                    break;
                case 4:
                    residentService.getAllResident(sessionFactory);
                    break;
                case 5:
                    residentService.getResident(sessionFactory);
                    break;
                case 6:
                    return;  // Back to the Main Menu
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Payment Operations
    private static void paymentOperations(PaymentService paymentService, SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Payment Operations ---");
            System.out.println("1. Insert Payment");
            System.out.println("2. Update Payment");
            System.out.println("3. Delete Payment");
            System.out.println("4. Get Payment");
            System.out.println("5. Get All Payments");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    paymentService.insertPayment(sessionFactory);
                    break;
                case 2:
                    paymentService.updatePayment(sessionFactory);
                    break;
                case 3:
                    paymentService.deletePayment(sessionFactory);
                    break;
                case 4:
                    paymentService.getPayment(sessionFactory);
                    break;
                case 5:
                    paymentService.getAllPayment(sessionFactory);
                    break;
                case 6:
                    return;  // Back to the Main Menu
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    // Maintenance Request Operations
    private static void maintenanceOperations(MaintenanceRequestService maintenanceService,
                                              SessionFactory sessionFactory) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Maintenance Request Operations ---");
            System.out.println("1. Insert Maintenance Request");
            System.out.println("2. Update Maintenance Request");
            System.out.println("3. Delete Maintenance Request");
            System.out.println("4. Get Maintenance Request");
            System.out.println("5. Get All Maintenance Requests");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    maintenanceService.insertMaintenance(sessionFactory);
                    break;
                case 2:
                    maintenanceService.updateMaintenance(sessionFactory);
                    break;
                case 3:
                    maintenanceService.deleteMaintenance(sessionFactory);
                    break;
                case 4:
                    maintenanceService.getMaintenance(sessionFactory);
                    break;
                case 5:
                    maintenanceService.getAllMaintenance(sessionFactory);
                    break;
                case 6:
                    return;  
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
        private static void ownerOperations(OwnerService ownerService, SessionFactory sessionFactory) {
        	Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Owner Operations ---");
                System.out.println("1. Insert Owner");
                System.out.println("2. Update Owner");
                System.out.println("3. Delete Owner");
                System.out.println("4. Get Owner");
                System.out.println("5. Get All Owners");
                System.out.println("6. Back to Main Menu");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        ownerService.insertOwner(sessionFactory);
                        break;
                    case 2:
                        ownerService.updateOwner(sessionFactory);
                        break;
                    case 3:
                        ownerService.deleteOwner(sessionFactory);
                        break;
                    case 4:
                        System.out.print("Enter owner ID: ");
                        int ownerId = sc.nextInt();
                        Owner owner = ownerService.getOwner(sessionFactory, ownerId);
                        if (owner != null) {
                            System.out.println(owner);
                        }
                        break;
                    case 5:
                        ownerService.getAllOwners(sessionFactory);
                        break;
                    case 6:
                        return;  // Back to the Main Menu
                    default:
                        System.out.println("Invalid Choice! Please enter correct option");	
        }
    }
        }
            private static void complaintsOperations(ComplaintsService complaintsService, SessionFactory sessionFactory) {
                Scanner sc = new Scanner(System.in);

                while (true) {
                    System.out.println("\n--- Complaints Operations ---");
                    System.out.println("1. Insert Complaint");
                    System.out.println("2. Update Complaint");
                    System.out.println("3. Delete Complaint");
                    System.out.println("4. Get Complaint");
                    System.out.println("5. Get All Complaints");
                    System.out.println("6. Back to Main Menu");
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            complaintsService.insertComplaint(sessionFactory);
                            break;
                        case 2:
                            complaintsService.updateComplaint(sessionFactory);
                            break;
                        case 3:
                            complaintsService.deleteComplaint(sessionFactory);
                            break;
                        case 4:
                            complaintsService.getComplaint(sessionFactory);
                            break;
                        case 5:
                            complaintsService.getAllComplaints(sessionFactory);
                            break;
                        case 6:
                            return;  // Back to the Main Menu
                        default:
                            System.out.println("Invalid choice! Please enter a valid option.");
                    }
                }
            }
     
}
