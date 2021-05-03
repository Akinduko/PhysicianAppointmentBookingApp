/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Appointment;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Patient;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;

/**
 *
 * @author olugbengaakinduko
 */
public class AppointmentServiceIT {

    RoomService roomInstance = new RoomService();
    TreatmentService treatmentInstance = new TreatmentService();
    PhysicianService physicianInstance = new PhysicianService();
    ExpertiseService expertiseInstance = new ExpertiseService();
    PatientService patientInstance = new PatientService();
    ConsultationService consultationInstance = new ConsultationService();  
    
   /**
     *
     */
    @Before
    public  void setUp() {
        roomInstance.initialiseRooms();
        treatmentInstance.initialiseTreatments();
        expertiseInstance.initialiseExpertise();
        patientInstance.initialisePatients();
        physicianInstance.initialisePhysicians(expertiseInstance.expertiseList);
        consultationInstance.initialiseConsultation(roomInstance.rooms(), physicianInstance.physicians(), treatmentInstance.treatments());
    } 
    
    
    /**
     * Test of changeAppointmentStatus method, of class AppointmentService.
     */
    @Test
    public void testChangeAppointmentStatus() {
        AppointmentService instance = new AppointmentService();
        System.out.println("changeAppointmentStatus");
        String id = "12";
        Consultation consultation = consultationInstance.getConsultationById(id);
        Patient patient = patientInstance.getPatientById(id);
        instance.bookAppointment(consultation, patient);
       
        Appointment appointment = instance.getAppointmentByConsultation(id);
        
        instance.changeAppointmentStatus(appointment.getId(), Appointment.AppointmentStatus.ATTENDED);
        
        appointment = instance.getAppointmentById(appointment.getId());
        
         assertEquals(appointment.getStatus(), Appointment.AppointmentStatus.ATTENDED);
    }

    /**
     * Test of getAppointmentByConsultation method, of class AppointmentService.
     */
    @Test
    public void testGetAppointmentByConsultation() {
        AppointmentService instance = new AppointmentService();
        System.out.println("getAppointmentByConsultation");
        String id = "12";
        Consultation consultation = consultationInstance.getConsultationById(id);
        Patient patient = patientInstance.getPatientById(id);
        instance.bookAppointment(consultation, patient);
        Appointment appointment = instance.getAppointmentByConsultation(id);
        assertEquals(appointment.getConsultation().getId(), "12");
    }

    /**
     * Test of getAppointmentsByUser method, of class AppointmentService.
     */
    @Test
    public void testGetAppointmentsByUser() {
        System.out.println("getAppointmentsByUser");
        AppointmentService instance = new AppointmentService();
        String id = "12";
        Consultation consultation = consultationInstance.getConsultationById(id);
        Patient patient = patientInstance.getPatientById(id);
        instance.bookAppointment(consultation, patient);
        ArrayList<Appointment> appointments = instance.getAppointmentsByUser(id);
        assertEquals(appointments.size(), 1);
    }

    /**
     * Test of bookAppointment method, of class AppointmentService.
     */
    @Test
    public void testBookAppointment() {
        System.out.println("bookAppointment");
        String id = "16";
        AppointmentService instance = new AppointmentService();
        
        Consultation consultation1 = consultationInstance.getConsultationById(id);
        Patient patient1 = patientInstance.getPatientById(id);
        instance.bookAppointment(consultation1, patient1);
        
        String id2 = "12";
        Consultation consultation2 = consultationInstance.getConsultationById(id2);
        Patient patient2 = patientInstance.getPatientById(id2);
        instance.bookAppointment(consultation2, patient2);
        
        ArrayList<Appointment> finalAppointments = instance.appointments();
        
        assertEquals(finalAppointments.size(), 2);
    }

    /**
     * Test of appointments method, of class AppointmentService.
     */
    @Test
    public void testAppointments() {
        System.out.println("appointments");
        AppointmentService instance = new AppointmentService();
        ArrayList<Appointment> result = instance.appointments();
        assertEquals(result.size(), 0);
    }
    
}
