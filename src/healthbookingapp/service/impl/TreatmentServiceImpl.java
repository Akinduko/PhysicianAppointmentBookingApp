/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.HealthBookingApp;
import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Room;
import healthbookingapp.model.Treatment;
import healthbookingapp.model.seeders.TreatmentObj;
import healthbookingapp.service.TreatmentService;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class TreatmentServiceImpl implements TreatmentService {
    ArrayList<Treatment> treatmentList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList(); 
    
    @Override
    public Treatment getTreatmentById(String id) {
      Treatment result = null;
        for (Treatment treatment: treatmentList){
            if(id == null ? treatment.id == null : id.equals(treatment.id) ){
                result = treatment;
            }
        }
        
        return result;
    }  
    
    @Override
    public void  initialiseTreatments() {
        
       TreatmentObj[] treatments = importJson.importTreatment();
 
        for (TreatmentObj treatment: treatments){
            
          HashMap<Treatment.TreatmentLookup, String> treatmentObj = new HashMap<Treatment.TreatmentLookup, String>();
          
          treatmentObj.put(Treatment.TreatmentLookup.id, treatment.id);
          treatmentObj.put(Treatment.TreatmentLookup.name, treatment.name);
          
          Treatment treatmentEntity = new Treatment(treatmentObj);
          
          treatmentList.add(treatmentEntity); 
        }        
    }

}
