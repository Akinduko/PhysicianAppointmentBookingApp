/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;

import static healthbookingapp.HealthBookingApp.initialExpertise;

import java.util.HashMap; 

/**
 *
 * @author olugbengaakinduko
 */
public class Expertise {
    
    private String id;
    private String name;
    private enum ExpertiseLookUpKey { id, name };
    private Expertise[] expertiseList;

    
    public Expertise (HashMap<ExpertiseLookUpKey, String> props){
        this.setExpertiseId(props.get(ExpertiseLookUpKey.id));
        this.setExpertiseName(props.get(ExpertiseLookUpKey.name));
    }
    
    public Expertise (){
        this.seedExpertise(initialExpertise);
    }
    
    private void setExpertiseName(String name){
        this.name = name;
    }
    
    private void setExpertiseId(String id){
        this.id = id;
    }
    
    private void seedExpertise(String[] initialExpertise){
       
        for (int i = 0; i <= initialExpertise.length; i++) {   
          
          HashMap<Expertise.ExpertiseLookUpKey, String> props = new HashMap<>();
          
          props.put(Expertise.ExpertiseLookUpKey.id,String.valueOf(i));
          
          props.put(Expertise.ExpertiseLookUpKey.name, initialExpertise[i]);
          
          Expertise params = new Expertise(props);
         
          expertiseList[i] = params;
        }
    }
      
    
}
