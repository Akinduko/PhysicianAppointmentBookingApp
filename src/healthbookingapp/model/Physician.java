/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public class Physician {
    
     public Physician (HashMap<PhysicianLookup, String> physicianObj){       
        this.id = physicianObj.get(PhysicianLookup.id);
        this.name = physicianObj.get(PhysicianLookup.name); 
    };  
     
    public enum PhysicianLookup {
        id,
        name,
        expertise
    }
    
    public String id;
    public String name;
    public ArrayList<Expertise>  expertise = new ArrayList<>();
   
}
