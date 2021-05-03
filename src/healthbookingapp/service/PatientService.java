/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Patient;
import healthbookingapp.model.dto.PatientObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class PatientService  {
    ArrayList<Patient> patientList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList();
    
    public Patient getPatientById(String id) {
        
      Patient result = null;
        for (Patient patient: patientList){
            if(id.equals(patient.getId()) && !patient.getIsGuest()){
                result = patient;
            }
        }
        
        return result;
    }   
    

  public Patient creatPatient(HashMap<Patient.PatientLookup, String> patientObj) {

    Patient result = new Patient(patientObj);
    
    result.setIsGuest(false);
    
    result.setId(String.valueOf(patientList.size() + 1));
    
    patientList.add(result);
    
    return result;
    } 
    
    public Patient creatGuest(HashMap<Patient.PatientLookup, String> patientObj) {

        Patient result = new Patient(patientObj);
        
        result.setIsGuest(true);
    
        result.setId(String.valueOf(patientList.size() + 1));
    
        patientList.add(result);

        return result;
    } 
    

    public void initialisePatients() {
    
        PatientObj[] patients = importJson.importPatients();
 
        for (PatientObj patient: patients){
            
          HashMap<Patient.PatientLookup, String> patientObj = new HashMap<Patient.PatientLookup, String>();
          
          patientObj.put(Patient.PatientLookup.id, patient.getId());
          patientObj.put(Patient.PatientLookup.fullName, patient.getFullName());
          patientObj.put(Patient.PatientLookup.address, patient.getAddress());
          patientObj.put(Patient.PatientLookup.phoneNumber, patient.getPhoneNumber());
          
          Patient patientEntity = new Patient(patientObj);
          
          patientEntity.setIsGuest(patient.getIsGuest());
          
          patientList.add(patientEntity); 
          
        }
    }  
    
    public ArrayList<Patient>  patients(){
        return patientList;
    }
    
    public void resetPatient(){
        patientList = new ArrayList();
    }
}
