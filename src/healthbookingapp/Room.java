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
public class Room {
    private String id;
    private String name;
    public  enum RoomLookUpKey { id, name };

    
    public Room (HashMap<RoomLookUpKey, String> props){
        this.setRoomId(props.get(RoomLookUpKey.id));
        this.setRoomName(props.get(RoomLookUpKey.name));
    }
    
    private void setRoomName(String name){
        this.name = name;
    }
    
    private void setRoomId(String id){
        this.id = id;
    }
    
}
