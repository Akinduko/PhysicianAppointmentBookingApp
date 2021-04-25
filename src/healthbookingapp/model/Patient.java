/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;

import healthbookingapp.model.Appointment;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public class Patient {

     public Patient (HashMap<PatientLookup, String> patientObj){
         
        this.id = patientObj.get(PatientLookup.id);
        this.fullName = patientObj.get(PatientLookup.fullName);
        this.address = patientObj.get(PatientLookup.address);
        this.phoneNumber = patientObj.get(PatientLookup.phoneNumber);
        this.isGuest = new Boolean(patientObj.get(PatientLookup.isGuest));
        
    };   
     
    public enum PatientLookup {
        id,
        fullName,
        address,
        phoneNumber,
        isGuest
    }
    
    public String id;
    public String fullName;
    public String address;
    public String phoneNumber;
    public Boolean isGuest;
    public ArrayList<Appointment> appointments = new ArrayList<>();
 
}
