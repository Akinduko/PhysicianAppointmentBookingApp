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
public class Expertise {
    
    public Expertise (HashMap<ExpertiseLookup, String> expertiseObj){
        this.id = expertiseObj.get(ExpertiseLookup.id);
        this.name = expertiseObj.get(ExpertiseLookup.name);
    };
     
    public enum ExpertiseLookup {
        id,
        name
    }
    
    public String id;
    public String name;   
    
}
