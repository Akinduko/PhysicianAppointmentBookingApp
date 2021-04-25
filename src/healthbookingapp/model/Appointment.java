/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;

import healthbookingapp.model.Consultation;
import java.util.Date;

/**
 *
 * @author olugbengaakinduko
 */
public class Appointment {
    
    public String id;
    public String notes;
    public Date date;
    public Boolean isAttended;
    public Boolean isCancelled;
    public Boolean isRescheduled;
    public Patient patient;
    public Consultation consultation;
    
}
