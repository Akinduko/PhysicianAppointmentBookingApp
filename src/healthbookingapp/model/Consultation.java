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

 public  enum ConsultationLookup {
        id,
        date,
        room,
        treatment,
        appointment
    }
    
    public Consultation (HashMap<ConsultationLookup, String> consultationObj){
        this.id = consultationObj.get(ConsultationLookup.id);
        this.date = new Date(consultationObj.get(ConsultationLookup.date));
    };
    
    public String id;
    public Date date;
    public Room room;
    public Treatment treatment;
    public Physician physician;
        
}
