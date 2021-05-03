/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import healthbookingapp.model.dto.ConsultationObj;
import healthbookingapp.model.dto.ExpertiseObj;
import healthbookingapp.model.dto.PatientObj;
import healthbookingapp.model.dto.PhysicianObj;
import healthbookingapp.model.dto.RoomObj;
import healthbookingapp.model.dto.TreatmentObj;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author olugbengaakinduko
 */
public class Json2ArrayList {
       static Path currentWorkingDir = Paths.get("").toAbsolutePath();
       ObjectMapper mapper = new ObjectMapper();
   
       
       public  PatientObj[] importPatients () {
        PatientObj[] patients = null;  
        
        try {

         patients  = mapper.readValue(new File(currentWorkingDir+"/resources/patients.json") , PatientObj[].class);
   
        } catch (IOException e) {
            e.printStackTrace();  
        }
        
       return patients;

    }
       
       public  ExpertiseObj[] importExpertise () {
               
         ExpertiseObj[] expertise = null;        
            try {

           expertise  = mapper.readValue(new File(currentWorkingDir+"/resources/expertise.json"), ExpertiseObj[].class);

            } catch (IOException e) {
                e.printStackTrace();
            }

           return expertise;      

      }
       
       public  ConsultationObj[] importConsultation () {

         ConsultationObj[] consultations = null;        
            
           try {

             consultations  = mapper.readValue(new File(currentWorkingDir+"/resources/consultations.json"), ConsultationObj[].class);

            } catch (IOException e) {
                e.printStackTrace();
            }

             return consultations;     
           }
       
       public  PhysicianObj[] importPhysicians ()  {

        PhysicianObj[] physicians = null;        
            
            try {

              physicians  = mapper.readValue(new File(currentWorkingDir+"/resources/physicians.json"), PhysicianObj[].class);

             } catch (IOException e) {
                 e.printStackTrace();
             }

            return physicians;    
       }
        
       public  RoomObj[] importRoom () {
               
        RoomObj[] rooms = null;        
            
            try {
                
           File json = new File(currentWorkingDir+"/resources/rooms.json");

           rooms =  mapper.readValue(json, RoomObj[].class);
           
             } catch (IOException e) {
                 e.printStackTrace();
             }

            return rooms;    
       
    }
        
       public  TreatmentObj[] importTreatment () {
               
        TreatmentObj[] treatments = null;        
            
            try {

              treatments  = mapper.readValue(new File(currentWorkingDir+"/resources/treatments.json"), TreatmentObj[].class);

             } catch (IOException e) {
                 e.printStackTrace();
             }

            return treatments;  
           }

}
