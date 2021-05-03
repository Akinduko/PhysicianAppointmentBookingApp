/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model.dto;

/**
 *
 * @author olugbengaakinduko
 */
public class ConsultationObj {

    private String id;
    private String date;
    private Boolean isGuest;
    private String room;
    private String treatment;
    private String physician;   

    public ConsultationObj() {
    }

    public ConsultationObj(String id, String date, Boolean isGuest, String room, String treatment, String physician) {
        this.id = id;
        this.date = date;
        this.isGuest = isGuest;
        this.room = room;
        this.treatment = treatment;
        this.physician = physician;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getIsGuest() {
        return isGuest;
    }

    public void setIsGuest(Boolean isGuest) {
        this.isGuest = isGuest;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getPhysician() {
        return physician;
    }

    public void setPhysician(String physician) {
        this.physician = physician;
    }
    
}
