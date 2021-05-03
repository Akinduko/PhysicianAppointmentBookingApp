/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Appointment;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Patient;
import healthbookingapp.model.Physician;
import healthbookingapp.model.Room;
import healthbookingapp.model.Treatment;
import healthbookingapp.model.dto.ConsultationObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class ConsultationService {
     ArrayList<Consultation> consultationList = new ArrayList<>();
     Json2ArrayList importJson = new Json2ArrayList();
        
    /**
     *
     * @param id
     * @return
     */
    public Consultation getConsultationById(String id) {
      Consultation result = null;
        for (Consultation consultation: consultationList){
            if(id.equals(consultation.getId())){
                result = consultation;
            }
        }
        
        return result;
    };
    
    public void resetConsultation(){
        consultationList = new ArrayList();
    }  
    
    public void initialiseConsultation(ArrayList<Room> rooms, ArrayList<Physician> physicians, ArrayList<Treatment> treatments) {
    
        ConsultationObj[] consultations = importJson.importConsultation();
 
        for (ConsultationObj consultation: consultations){
            
          HashMap<Consultation.ConsultationLookup, String> consultationObj = new HashMap<>();
          
          consultationObj.put(Consultation.ConsultationLookup.id, consultation.getId());
          
          consultationObj.put(Consultation.ConsultationLookup.date, consultation.getDate());
         
          Consultation consultationEntity = new Consultation(consultationObj);
          
          
          rooms.stream().forEach((room) -> {
               if(room.getId().equals(consultation.getRoom())){
                   consultationEntity.setRoom(room);
               }     
           });   
          
          treatments.stream().forEach((treatment) -> {
               if(treatment.getId().equals(consultation.getTreatment())){
                   consultationEntity.setTreatment(treatment);
               }     
           });   

          physicians.stream().forEach((physician) -> {
               if(physician.getId().equals(consultation.getPhysician())){
                  
                   consultationEntity.setPhysician(physician);
                   
               }     
           }); 
          consultationEntity.setIsGuest(consultation.getIsGuest());
          consultationList.add(consultationEntity); 
          
        }
       
    } 
    
    public  ArrayList<Consultation> availablePatientConsultationsByPhysicianId (String id, ArrayList<Appointment> appointments){
        
        ArrayList<Consultation>  result = new ArrayList<>();
        for (Consultation consultation: this.consultations()){
         Boolean booked = isPatientConsultationBooked(consultation.getId(), appointments);
         
            if (!booked  && id.equals(consultation.getPhysician().getId()) && !consultation.getIsGuest()) {
                result.add(consultation);
            }
        }
   
        return result;
    }
    
    public  ArrayList<Consultation> availableGuestConsultationsByPhysicianId (String id, ArrayList<Appointment> appointments, Patient currentUser){
        
        ArrayList<Consultation>  result = new ArrayList<>();
        for (Consultation consultation: this.consultations()){
         Boolean booked = isGuestConsultationBooked(consultation.getId(), appointments, currentUser);
             if (!booked && id.equals(consultation.getPhysician().getId()) && consultation.getIsGuest()) {
                result.add(consultation);
            }
        }
     
        return result;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Consultation> consultations(){
        return consultationList;
    }
    
    public  Boolean isPatientConsultationBooked (String id, ArrayList<Appointment> appointments){
      
        Boolean isBooked = false;
      
        for (Appointment appointment: appointments){
            if(id != null && id.equals(appointment.getConsultation().getId()) ){
                isBooked = true;
            }
        }   
        return isBooked;
    }
    
        
    public  Boolean isGuestConsultationBooked (String id, ArrayList<Appointment> appointments, Patient currentUser){
      
        // total slot is 120 mins, eaach guest is entitled to 30mins
        // total available guest slot is 120/30 = 4 slots
        int bookCount = 0;
        Boolean isBooked = false;
        
        for (Appointment appointment: appointments){
            if(id != null && id.equals(appointment.getConsultation().getId()) ){
               bookCount ++;
                           
            if( currentUser.getId().equals(appointment.getPatient().getId())) isBooked=true;
            };

        }   
        return bookCount > 4 || isBooked;
    }
}
