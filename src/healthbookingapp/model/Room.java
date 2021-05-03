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
public class Room {

    private String id;
    private String name;
    
    public enum RoomLookup {
        id,
        name
    }

    public Room() {
    }
    
    public Room(HashMap<RoomLookup, String> roomObj) {
        this.id = roomObj.get(RoomLookup.id);
        this.name = roomObj.get(RoomLookup.name);
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
    
}
