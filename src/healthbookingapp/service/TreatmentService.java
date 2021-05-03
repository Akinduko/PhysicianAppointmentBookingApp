/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Treatment;
import healthbookingapp.model.dto.TreatmentObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class TreatmentService {


    ArrayList<Treatment> treatmentList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList(); 
 
    public TreatmentService() {
    }
        
    public Treatment getTreatmentById(String id) {
      Treatment result = null;
        for (Treatment treatment: treatmentList){
            if(id.equals(treatment.getId()) ){
                result = treatment;
            }
        }    
        return result;
    }  
    
     
    public void  initialiseTreatments() {
        
       TreatmentObj[] treatments = importJson.importTreatment();
 
        for (TreatmentObj treatment: treatments){
            
          HashMap<Treatment.TreatmentLookup, String> treatmentObj = new HashMap<>();
          
          treatmentObj.put(Treatment.TreatmentLookup.id, treatment.getId());
          treatmentObj.put(Treatment.TreatmentLookup.name, treatment.getName());
          
          Treatment treatmentEntity = new Treatment(treatmentObj);
          
          treatmentList.add(treatmentEntity); 
        }        
    }
    
    public ArrayList<Treatment>  treatments(){
        return treatmentList;
    }
    
    public void resetTreatment(){
        treatmentList = new ArrayList();
    }
}
