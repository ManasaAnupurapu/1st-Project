package com.ApartmentManagementSystem.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "complaints")
public class Complaints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @ManyToOne
    @JoinColumn(name = "r_Id", referencedColumnName = "r_Id")
    private Resident resident;  // Assuming Resident entity is already defined.

    @Column(name = "complaint_date")
    private LocalDate complaintDate;

    @Column(name = "complaint_description")
    private String complaintDescription;

    
    // Constructors, Getters, Setters, toString
    public Complaints() {
    }
    

    public Complaints(Resident resident, String complaintDescription) {
        this.resident = resident;
        this.complaintDescription = complaintDescription;
        this.complaintDate = LocalDate.now();
       
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public LocalDate getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(LocalDate complaintDate) {
        this.complaintDate = complaintDate;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }



    @Override
    public String toString() {
        return "Complaint [complaintId=" + complaintId + ", resident=" + resident + ", complaintDate=" + complaintDate + 
                ", complaintDescription=" + complaintDescription +  "]";
    }
}
