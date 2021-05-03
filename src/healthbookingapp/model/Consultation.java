/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public class Consultation {
    
    private String id;
    private Boolean isGuest;
    private Date date;
    private Room room;
    private Treatment treatment;
    private Physician physician;
    public enum ConsultationLookup {
           id,
           date,
           room,
           isGuest,
           treatment,
           appointment
    } 
    
    public Consultation (){

    };
    
    public Consultation (HashMap<ConsultationLookup, String> consultationObj){
        this.id = consultationObj.get(ConsultationLookup.id);
        this.date = new Date(consultationObj.get(ConsultationLookup.date));
    };
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsGuest() {
        return this.isGuest;
    }

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }
    

 
        
}
