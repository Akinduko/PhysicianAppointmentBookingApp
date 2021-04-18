/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;

/**
 *
 * @author olugbengaakinduko
 */
public class Appointment {
    
    private String id;
    private String notes;
    private String date;
    private Boolean isAttended;
    private Boolean isCancelled;
    private Boolean isRescheduled;
    private Consultation consultation;
    
    public void setAppointMentParams(Appointment appointment){
        this.id = appointment.id;
        this.notes = appointment.notes;
        this.date = appointment.date;
        this.isAttended = appointment.isAttended;
        this.isCancelled = appointment.isCancelled;
        this.isRescheduled = appointment.isRescheduled;
        this.consultation = appointment.consultation;
    }
    
}
