/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public class Patient {

    private String id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Boolean isGuest;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    
    public enum PatientLookup {
        id,
        fullName,
        address,
        phoneNumber,
        isGuest
    }

    public Patient() {
    }
    
    public Patient (HashMap<PatientLookup, String> patientObj){
         
        this.id = patientObj.get(PatientLookup.id);
        this.fullName = patientObj.get(PatientLookup.fullName);
        this.address = patientObj.get(PatientLookup.address);
        this.phoneNumber = patientObj.get(PatientLookup.phoneNumber);
        this.isGuest = Boolean.valueOf(patientObj.get(PatientLookup.isGuest));      
    };  
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
 
}
