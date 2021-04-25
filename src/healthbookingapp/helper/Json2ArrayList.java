/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

import healthbookingapp.model.seeders.ConsultationObj;
import healthbookingapp.model.seeders.ExpertiseObj;
import healthbookingapp.model.seeders.PatientObj;
import healthbookingapp.model.seeders.PhysicianObj;
import healthbookingapp.model.seeders.RoomObj;
import healthbookingapp.model.seeders.TreatmentObj;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

         patients  = mapper.readValue(new File(currentWorkingDir+"/src/healthbookingapp/resources/patients.json"), PatientObj[].class);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
       return patients;

    }
       
       public  ExpertiseObj[] importExpertise () {
               
         ExpertiseObj[] expertise = null;        
            try {

             expertise  = mapper.readValue(new File(currentWorkingDir+"/src/healthbookingapp/resources/expertise.json"), ExpertiseObj[].class);

            } catch (IOException e) {
                e.printStackTrace();
            }

           return expertise;      

      }
       
       public  ConsultationObj[] importConsultation () {

         ConsultationObj[] consultations = null;        
            
           try {

             consultations  = mapper.readValue(new File(currentWorkingDir+"/src/healthbookingapp/resources/consultations.json"), ConsultationObj[].class);

            } catch (IOException e) {
                e.printStackTrace();
            }

             return consultations;     
           }
       
       public  PhysicianObj[] importPhysicians ()  {

        PhysicianObj[] physicians = null;        
            
            try {

              physicians  = mapper.readValue(new File(currentWorkingDir+"/src/healthbookingapp/resources/physicians.json"), PhysicianObj[].class);

             } catch (IOException e) {
                 e.printStackTrace();
             }

            return physicians;    
       }
        
       public  RoomObj[] importRoom () {
               
        RoomObj[] rooms = null;        
            
            try {
                
           File json = new File(currentWorkingDir+"/src/healthbookingapp/resources/rooms.json");

           rooms =  mapper.readValue(json, RoomObj[].class);
           
             } catch (IOException e) {
                 e.printStackTrace();
             }

            return rooms;    
       
    }
        
       public  TreatmentObj[] importTreatment () {
               
        TreatmentObj[] treatments = null;        
            
            try {

              treatments  = mapper.readValue(new File(currentWorkingDir+"/src/healthbookingapp/resources/treatments.json"), TreatmentObj[].class);

             } catch (IOException e) {
                 e.printStackTrace();
             }

            return treatments;  
           }

}
