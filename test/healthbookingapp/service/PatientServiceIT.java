/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olugbengaakinduko
 */
public class PatientServiceIT {
    PatientService patientInstance = new PatientService();
    public PatientServiceIT() {
    }
    
    @Before
    public void setUp() {
        patientInstance.initialisePatients();
    }


    /**
     * Test of getPatientById method, of class PatientService.
     */
    @Test
    public void testGetPatientById() {
        System.out.println("getPatientById");
        String id = "10";
        Patient result = patientInstance.getPatientById(id);
        assertEquals(result, null);
        
        id = "11";
        result = patientInstance.getPatientById(id);
        assertEquals(result.getFullName(), "Harvey Berger");
    }

    /**
     * Test of creatPatient method, of class PatientService.
     */
    @Test
    public void testCreatPatient() {
        System.out.println("creatPatient");
        
        HashMap<Patient.PatientLookup, String> patientObj = new HashMap();
        patientObj.put(Patient.PatientLookup.fullName, "Test User");
        patientObj.put(Patient.PatientLookup.address, "Test Address"); 
        patientObj.put(Patient.PatientLookup.phoneNumber, "123456789");
          
        Patient result = patientInstance.creatPatient(patientObj);
     
        assertEquals(String.valueOf(patientInstance.patients().size()), result.getId());
        
        assertEquals(result.getIsGuest(), false);
        
    }

    /**
     * Test of creatGuest method, of class PatientService.
     */
    @Test
    public void testCreatGuest() {
        System.out.println("creatGuest");
        
        HashMap<Patient.PatientLookup, String> patientObj = new HashMap();
        patientObj.put(Patient.PatientLookup.fullName, "Test Guest");
        patientObj.put(Patient.PatientLookup.address, "Test Address");
        patientObj.put(Patient.PatientLookup.phoneNumber, "123456789");
          
        Patient result = patientInstance.creatGuest(patientObj);
     
        assertEquals(String.valueOf(patientInstance.patients().size()), result.getId());
        
        assertEquals(result.getIsGuest(), true);
    }

    /**
     * Test of patients method, of class PatientService.
     */
    @Test
    public void testPatients() {
        System.out.println("patients");
        ArrayList<Patient> result = patientInstance.patients();
        assertEquals(result.size(), 43);
    }
    
}
