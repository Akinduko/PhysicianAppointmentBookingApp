/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.HealthBookingApp;
import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Physician;
import healthbookingapp.model.Physician.PhysicianLookup;
import healthbookingapp.model.seeders.PhysicianObj;
import healthbookingapp.service.PhysicianService;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class PhysicianServiceImpl implements PhysicianService {
     
    ArrayList<Physician> physicianList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList();
    ExpertiseServiceImpl expertiseService = new ExpertiseServiceImpl();
    
    @Override
    public Physician getPhysicianById(String id) {
      Physician result = null;
        for (Physician physician: physicianList){
            if(id == null ? physician.id == null : id.equals(physician.id) ){
                result = physician;
            }
        }
        
        return result;
    }   

    @Override
    public void initialisePhysicians() {
    
        PhysicianObj[] physicians = importJson.importPhysicians();
 
        for (PhysicianObj physician: physicians){
            
          HashMap<Physician.PhysicianLookup, String> physicianObj = new HashMap<Physician.PhysicianLookup, String>();
          
          physicianObj.put(Physician.PhysicianLookup.id, physician.id);
          physicianObj.put(Physician.PhysicianLookup.name, physician.name);
          
          Physician physicianEntity = new Physician(physicianObj);
          
          physicianEntity.expertise.add(expertiseService.getExpertiseById(physician.expertise));
                  
          physicianList.add(physicianEntity); 
          
        }
    }
}
