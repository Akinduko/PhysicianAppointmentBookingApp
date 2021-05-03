/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Expertise;
import healthbookingapp.model.Physician;
import healthbookingapp.model.dto.PhysicianObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class PhysicianService   {
     
    ArrayList<Physician> physicianList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList();
    ExpertiseService expertiseService = new ExpertiseService();
    

    public Physician getPhysicianById(String id) {
      Physician result = null;
            
        for (Physician physician: physicianList){
            if(id.equals(physician.getId())){
                result = physician;
            }
        }
       
       System.out.println(physicianList);
       System.out.println(id);
        return result;
    } 
    

    public ArrayList<Physician> getPhysiciansByName(String name) {
      ArrayList<Physician> result = new ArrayList<>();
      physicianList.stream().filter((physician) -> (name == null ? physician.getName() == null : physician.getName().contains(name) )).forEachOrdered((physician) -> {
          result.add(physician);
        });
        
        return result;
    } 
  
    public ArrayList<Physician> getPhysiciansByExpertise(String id) {
      ArrayList<Physician> result = new ArrayList<>();
      physicianList.forEach((physician) -> {
          HashMap<String, Expertise> expertise = physician.getExpertise();
            if (expertise.containsKey(id)) {
                result.add(physician);
            }
        });   
        return result;
    }   

    public void initialisePhysicians(ArrayList<Expertise> expertise) {
    
        PhysicianObj[] physicians = importJson.importPhysicians();
 
        for (PhysicianObj physician: physicians){
            
          HashMap<Physician.PhysicianLookup, String> physicianObj = new HashMap<>();
          
          physicianObj.put(Physician.PhysicianLookup.id, physician.getId());
          physicianObj.put(Physician.PhysicianLookup.name, physician.getName());
          
          Physician physicianEntity = new Physician(physicianObj);
          
           expertise.stream().forEach((each) -> {
               if(each.getId().equals((physician.getExpertise()))){
                   physicianEntity.getExpertise().put(physician.getExpertise(), each);
               }     
           });
           physicianList.add(physicianEntity); 
        }
       
    }
    
    public ArrayList<Physician>  physicians(){
        return physicianList;
    }
    
    public void resetPhysician(){
        physicianList = new ArrayList();
    }
}
