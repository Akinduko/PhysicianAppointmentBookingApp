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
public class Physician {

    private String id;
    private String name;
    private HashMap<String, Expertise>  expertise = new HashMap<>();
    public enum PhysicianLookup {
        id,
        name,
        expertise
    }

    public Physician() {
    }

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

    public HashMap<String, Expertise> getExpertise() {
        return expertise;
    }

    public void setExpertise(HashMap<String, Expertise> expertise) {
        this.expertise = expertise;
    }
    
    public Physician (HashMap<PhysicianLookup, String> physicianObj){       
        this.id = physicianObj.get(PhysicianLookup.id);
        this.name = physicianObj.get(PhysicianLookup.name); 
    };  
   
}
