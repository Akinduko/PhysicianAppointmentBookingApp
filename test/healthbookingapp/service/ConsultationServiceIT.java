/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Appointment;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Patient;
import healthbookingapp.model.Physician;
import healthbookingapp.model.Room;
import healthbookingapp.model.Treatment;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olugbengaakinduko
 */
public class ConsultationServiceIT {

    RoomService roomInstance = new RoomService();
    TreatmentService treatmentInstance = new TreatmentService();
    PhysicianService physicianInstance = new PhysicianService();
    ExpertiseService expertiseInstance = new ExpertiseService();
    PatientService patientInstance = new PatientService();
    AppointmentService appointmentInstance = new AppointmentService();
    ConsultationService instance = new ConsultationService();  
    
    @Before
    public void setUp() {
        roomInstance.initialiseRooms();
        treatmentInstance.initialiseTreatments();
        expertiseInstance.initialiseExpertise();
        patientInstance.initialisePatients();
        physicianInstance.initialisePhysicians(expertiseInstance.expertiseList);
        instance.initialiseConsultation(roomInstance.rooms(), physicianInstance.physicians(), treatmentInstance.treatments());
    } 
    
    public ConsultationServiceIT() {

    }
    
    

    /**
     * Test of getConsultationById method, of class ConsultationService.
     */
    @Test
    public void testGetConsultationById() {
        System.out.println("getConsultationById");
        String id = "5";
        Consultation result = instance.getConsultationById(id);
        assertEquals(result.getIsGuest(), false);
    }

    /**
     * Test of availablePatientConsultationsByPhysicianId method, of class ConsultationService.
     */
    @Test
    public void testAvailablePatientConsultationsByPhysicianId() {
        System.out.println("availablePatientConsultationsByPhysicianId");
        String id = "11";
     
        Consultation consultation = instance.getConsultationById(id);
        Patient patient = patientInstance.getPatientById(id);
        appointmentInstance.bookAppointment(consultation, patient);
        
        id = "16";
        consultation = instance.getConsultationById(id);
        patient = patientInstance.getPatientById(id);
        appointmentInstance.bookAppointment(consultation, patient); 
        
        ArrayList<Consultation> availableConsultation = instance.availablePatientConsultationsByPhysicianId("1", appointmentInstance.appointments());
        
        assertEquals(availableConsultation.size(), 2);
    }

    /**
     * Test of availableGuestConsultationsByPhysicianId method, of class ConsultationService.
     */
    @Test
    public void testAvailableGuestConsultationsByPhysicianId() {
        System.out.println("availableGuestConsultationsByPhysicianId");
 
          
        HashMap<Patient.PatientLookup, String> patientObj = new HashMap();
        patientObj.put(Patient.PatientLookup.fullName, "Test Guest");
        patientObj.put(Patient.PatientLookup.address, "Test Address");
        patientObj.put(Patient.PatientLookup.phoneNumber, "123456789");  
        Patient patient = patientInstance.creatGuest(patientObj);
        
        Consultation consultation = instance.getConsultationById("40"); 
        appointmentInstance.bookAppointment(consultation, patient);
               
        Consultation consultation2 = instance.getConsultationById("39"); 
        appointmentInstance.bookAppointment(consultation2, patient);
        
        ArrayList<Consultation> availableConsultation = instance.availableGuestConsultationsByPhysicianId("5", appointmentInstance.appointments(), patient);
        
        assertEquals(availableConsultation.size(), 2);
    }

    /**
     * Test of isPatientConsultationBooked method, of class ConsultationService.
     */
    @Test
    public void testIsPatientConsultationBooked() {
        
        System.out.println("isConsultationBooked");
        String id = "6";
        Consultation consultation = instance.getConsultationById(id);
        Patient patient = patientInstance.getPatientById(id);
        appointmentInstance.bookAppointment(consultation, patient);
     
        Boolean availableConsultation = instance.isPatientConsultationBooked(id,appointmentInstance.appointmentList);
        
        assertEquals(availableConsultation, true);
    }
    
}
