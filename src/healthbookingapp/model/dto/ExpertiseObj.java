/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.model.dto;

/**
 *
 * @author olugbengaakinduko
 */
public class ExpertiseObj {
    
    private String id;
    private String name;
    private String[] physician; 
    
    public ExpertiseObj() {
    }

    public ExpertiseObj(String id, String name, String[] physician) {
        this.id = id;
        this.name = name;
        this.physician = physician;
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

    public String[] getPhysician() {
        return physician;
    }

    public void setPhysician(String[] physician) {
        this.physician = physician;
    }
    

}
