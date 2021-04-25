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

    public String id;
    public String name;
    
    public Room(HashMap<RoomLookup, String> roomObj) {
        this.id = roomObj.get(RoomLookup.id);
        this.name = roomObj.get(RoomLookup.name);
    }
    
    public enum RoomLookup {
        id,
        name
    }
  
}
