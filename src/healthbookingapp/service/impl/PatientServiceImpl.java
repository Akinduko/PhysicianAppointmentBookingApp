/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.HealthBookingApp;
import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Patient;
import healthbookingapp.model.seeders.PatientObj;
import healthbookingapp.service.PatientService;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class PatientServiceImpl implements PatientService {
    ArrayList<Patient> patientList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList();
    
    @Override
    public Patient getPatientById(String id) {
      Patient result = null;
        for (Patient patient: patientList){
            if(id == null ? patient.id == null : id.equals(patient.id) ){
                result = patient;
            }
        }
        
        return result;
    }   

    @Override
    public void initialisePatients() {
    
        PatientObj[] patients = importJson.importPatients();
 
        for (PatientObj patient: patients){
            
          HashMap<Patient.PatientLookup, String> physicianObj = new HashMap<Patient.PatientLookup, String>();
          
          physicianObj.put(Patient.PatientLookup.id, patient.id);
          physicianObj.put(Patient.PatientLookup.fullName, patient.fullName);
          physicianObj.put(Patient.PatientLookup.address, patient.address);
          physicianObj.put(Patient.PatientLookup.phoneNumber, patient.phoneNumber);
          Patient patientEntity = new Patient(physicianObj);
          
          patientEntity.isGuest = new Boolean(patient.isGuest);
          patientList.add(patientEntity); 
          
        }
    }  
}
