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
public class PhysicianObj {
    
    private String id;
    private String name;
    private String expertise;

    public PhysicianObj() {
    }

    public PhysicianObj(String id, String name, String expertise) {
        this.id = id;
        this.name = name;
        this.expertise = expertise;
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

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
    
  
}
