/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.HealthBookingApp;
import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Room;
import healthbookingapp.model.seeders.ConsultationObj;
import healthbookingapp.service.ConsultationService;
import healthbookingapp.service.RoomService;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class ConsultationServiceImpl implements ConsultationService {
     ArrayList<Consultation> consultationList = new ArrayList<>();
     static Json2ArrayList importJson = new Json2ArrayList();
     
     RoomServiceImpl roomService = new RoomServiceImpl() ;
     TreatmentServiceImpl treatmentService = new TreatmentServiceImpl() ;
     AppointmentServiceImpl appointmentService = new AppointmentServiceImpl() ;
     PhysicianServiceImpl physicianService = new PhysicianServiceImpl() ;
        
    @Override
    public Consultation getConsultationById(String id) {
      Consultation result = null;
        for (Consultation consultation: consultationList){
            if(id == null ? consultation.id == null : id.equals(consultation.id) ){
                result = consultation;
            }
        }
        
        return result;
    };
    
    @Override
    public void initialiseConsultation() {
    
        ConsultationObj[] consultations = importJson.importConsultation();
 
        for (ConsultationObj consultation: consultations){
            
          HashMap<Consultation.ConsultationLookup, String> consultationObj = new HashMap<Consultation.ConsultationLookup, String>();
          
          consultationObj.put(Consultation.ConsultationLookup.id, consultation.id);
          
          consultationObj.put(Consultation.ConsultationLookup.date, consultation.date);
         
          Consultation consultationEntity = new Consultation(consultationObj);
          
          consultationEntity.room = roomService.getRoomById(consultation.room);
          consultationEntity.treatment = treatmentService.getTreatmentById(consultation.treatment);
          consultationEntity.physician = physicianService.getPhysicianById(consultation.physician);
          
          consultationList.add(consultationEntity); 
          
        }
    } 
}
