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

    private String id;
    private String name;  
    
    public Expertise (HashMap<ExpertiseLookup, String> expertiseObj){
        this.id = expertiseObj.get(ExpertiseLookup.id);
        this.name = expertiseObj.get(ExpertiseLookup.name);
    };
     
    public Expertise (){

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
     
    public enum ExpertiseLookup {
        id,
        name
    }
   
}
