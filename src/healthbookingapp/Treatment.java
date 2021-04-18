/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;

import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public class Treatment {
    private String id;
    private String name;
    public  enum TreatmentLookUpKey { id, name };
    private Treatment[] treatmentList;

    
    public Treatment (HashMap<TreatmentLookUpKey, String> props){
        this.setTreatmentId(props.get(TreatmentLookUpKey.id));
        this.setTreatmentName(props.get(TreatmentLookUpKey.name));
    }
    
    public Treatment (){
        this.seedTreatment();
    }
    
    private void setTreatmentName(String name){
        this.name = name;
    }
    
    private void setTreatmentId(String id){
        this.id = id;
    }
    
      private void seedTreatment (){
        
        for (int i = 0; i <= initialTreatments.length; i++) {   
          
          HashMap<Treatment.TreatmentLookUpKey, String> props = new HashMap<>();
          
          props.put(Treatment.TreatmentLookUpKey.id,String.valueOf(i));
          
          props.put(Treatment.TreatmentLookUpKey.name, initialTreatments[i]);
          
          Treatment params = new Treatment(props);
         
          treatmentList[i] = params;
        }
    }
}
