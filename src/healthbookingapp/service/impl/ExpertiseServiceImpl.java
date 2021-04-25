/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.HealthBookingApp;
import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Expertise;
import healthbookingapp.model.seeders.ExpertiseObj;
import healthbookingapp.service.ExpertiseService;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class ExpertiseServiceImpl implements ExpertiseService {
    ArrayList<Expertise> expertiseList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList();
    
    @Override
    public Expertise getExpertiseById(String id) {
      Expertise result = null;
        for (Expertise expertise: expertiseList){
            if(id == null ? expertise.id == null : id.equals(expertise.id) ){
                result = expertise;
            }
        }
        
        return result;
    }   
  
    @Override
    public void initialiseExpertise() {
    
        ExpertiseObj[] expertises = importJson.importExpertise();
 
        for (ExpertiseObj expertise: expertises){
            
          HashMap<Expertise.ExpertiseLookup, String> expertiseObj = new HashMap<Expertise.ExpertiseLookup, String>();
          
          expertiseObj.put(Expertise.ExpertiseLookup.id, expertise.id);
          expertiseObj.put(Expertise.ExpertiseLookup.name, expertise.name);
          
          Expertise expertiseEntity = new Expertise(expertiseObj);
          
          expertiseList.add(expertiseEntity); 
          
        }
    } 
}
