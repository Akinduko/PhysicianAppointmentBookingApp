/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;

import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class Treatment {
    
     public Treatment (HashMap<TreatmentLookup, String> treatmentObj){
         
        this.id = treatmentObj.get(TreatmentLookup.id);
        this.name = treatmentObj.get(TreatmentLookup.name);
        
    };    
     
   public enum TreatmentLookup {
        id,
        name
    }
    
    
    public String id;
    public String name;
    public Physician physician;
      
}
