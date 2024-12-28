package com.apjfsatest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ApartmentManagementSystem.entity.Apartment;
import com.ApartmentManagementSystem.service.ApartmentService;
import com.ApartmentManagementSystem.serviceImpl.ApartmentServiceImpl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

public class ApartmentServiceImplTest {

    @Mock private SessionFactory sessionFactory;
    @Mock private Session session;
    @Mock private Transaction transaction;

    private ApartmentServiceImpl apartmentService;

    @BeforeEach
    public void setup() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
       

        
        // Mocking the sessionFactory to return a mock session
        when(sessionFactory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);
        
        // Initialize the ApartmentServiceImpl with mocked sessionFactory
        apartmentService = new ApartmentServiceImpl();
    }

    @Test
    public void testInsertApartment() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setAddress("123 Main St");
        apartment.setNumberOfFlats(3);
        apartment.setRent(1200.0);

        // Act
        apartmentService.insertApartment(sessionFactory);

        // Verify that session.save() is called once with the correct apartment object
        verify(session).save(any(Apartment.class));  // any(Apartment.class) is a wildcard matcher
        verify(transaction).commit(); // Verify that transaction.commit() is called
    }

    @Test
    public void testUpdateApartment() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setApartmentId(1);
        apartment.setAddress("123 Main St");
        apartment.setNumberOfFlats(3);
        apartment.setRent(1200.0);
        
        when(session.get(Apartment.class, 1)).thenReturn(apartment);

        // Act
        apartmentService.updateApartment(sessionFactory);

        // Verify that session.update() was called with the updated apartment object
        verify(session).update(apartment);
        verify(transaction).commit();
    }

    @Test
    public void testDeleteApartment() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setApartmentId(1);
        when(session.get(Apartment.class, 1)).thenReturn(apartment);

        // Act
        apartmentService.deleteApartment(sessionFactory);

        // Verify that session.delete() was called with the correct apartment object
        verify(session).delete(apartment);
        verify(transaction).commit();
    }

    @Test
    public void testGetApartment() {
        // Arrange
        Apartment apartment = new Apartment();
        apartment.setApartmentId(1);
        apartment.setAddress("123 Main St");
        when(session.get(Apartment.class, 1)).thenReturn(apartment);

        // Act
        apartmentService.getApartment(sessionFactory);

        // Verify that session.get() was called to retrieve the apartment by ID
        verify(session).get(Apartment.class, 1);
    }

    @Test
    public void testGetAllApartment() {
        // Arrange
        Apartment apartment1 = new Apartment();
        apartment1.setApartmentId(1);
        apartment1.setAddress("123 Main St");

        Apartment apartment2 = new Apartment();
        apartment2.setApartmentId(2);
        apartment2.setAddress("456 Oak St");

        List<Apartment> apartments = Arrays.asList(apartment1, apartment2);
        when(session.createQuery("from Apartment", Apartment.class).list()).thenReturn(apartments);

        // Act
        apartmentService.getAllApartment(sessionFactory);

        // Verify that the query to get all apartments was executed
        verify(session).createQuery("from Apartment", Apartment.class);
    }

    @Test
    public void testInsertApartmentFailure() {
        // Arrange: Test behavior when insert fails (mocking exception)
        Apartment apartment = new Apartment();
        apartment.setAddress("Invalid Address");

        // Simulating an exception on save
        doThrow(new RuntimeException("Database error")).when(session).save(any(Apartment.class));

        // Act and Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            apartmentService.insertApartment(sessionFactory);
        });

        assertEquals("Database error", exception.getMessage());
    }
}
