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

    private String id;
    private String name;
    private Physician physician;

    public enum TreatmentLookup {
        id,
        name
    }

    public Treatment() {
    }
   
    public Treatment (HashMap<TreatmentLookup, String> treatmentObj){        
        this.id = treatmentObj.get(TreatmentLookup.id);
        this.name = treatmentObj.get(TreatmentLookup.name);
    };    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }
     

      
}
