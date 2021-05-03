/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;

import java.util.Date;

/**
 *
 * @author olugbengaakinduko
 */
public class Appointment {

    private String id;
    private String notes;
    private Date date;
    private AppointmentStatus status;
    private Patient patient;
    private Consultation consultation;

    public enum AppointmentLookup {
        PATIENT_NAME,VALUE
    }
   
    public enum AppointmentStatus {
        ATTENDED,BOOKED,CANCELED,MISSED
    } 
    
    public Appointment() {
        
    }

    public Appointment(String id, String notes, Date date, AppointmentStatus status, Patient patient, Consultation consultation) {
        this.id = id;
        this.notes = notes;
        this.date = date;
        this.status = status;
        this.patient = patient;
        this.consultation = consultation;
    }
       
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
    
    
}
