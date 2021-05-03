/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Expertise;
import healthbookingapp.model.dto.ExpertiseObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class ExpertiseService  {
    ArrayList<Expertise> expertiseList = new ArrayList<>();
    static Json2ArrayList importJson = new Json2ArrayList();
    
    public Expertise getExpertiseById(String id) {
      Expertise result = null;
        for (Expertise expertise: expertiseList){
            if(id.equals(expertise.getId()) ){
                result = expertise;
            }
        }
        
        return result;
    }   
  
    public void initialiseExpertise() {
    
        ExpertiseObj[] expertises = importJson.importExpertise();
 
        for (ExpertiseObj expertise: expertises){
            
          HashMap<Expertise.ExpertiseLookup, String> expertiseObj;
            
          expertiseObj = new HashMap<>();
          
          expertiseObj.put(Expertise.ExpertiseLookup.id, expertise.getId());
          expertiseObj.put(Expertise.ExpertiseLookup.name, expertise.getName());
          
          Expertise expertiseEntity = new Expertise(expertiseObj);
          
          expertiseList.add(expertiseEntity); 
          
        }
    } 
    
   public ArrayList<Expertise>  getExpertiseCollection() { 
       return expertiseList;
   }
   
    public void resetExpertise(){
        expertiseList = new ArrayList();
    } 
}
