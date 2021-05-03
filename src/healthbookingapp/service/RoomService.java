/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Room;
import healthbookingapp.model.dto.RoomObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class RoomService  {
    
    static Json2ArrayList importJson = new Json2ArrayList();
    static ArrayList<Room> roomList = new ArrayList<>();
    

    public Room getRoomById(String id) {

      Room result = null;
         
        for (Room room: roomList){
            if(id.equals(room.getId())){
                result = room;
            }
        }
        
        return result;
    }  
    

    public  ArrayList<Room> rooms () {
      return roomList;
    }  
    

    public void initialiseRooms() {
       RoomObj[] rooms = importJson.importRoom();
 
        for (RoomObj room: rooms){
            
          HashMap<Room.RoomLookup, String> roomObj = new HashMap<>();
          
          roomObj.put(Room.RoomLookup.id, room.getId());
          roomObj.put(Room.RoomLookup.name, room.getName());
          
          Room roomEntity = new Room(roomObj);
          
          roomList.add(roomEntity); 
        }
        
        
    } 
  
    public void resetRoom(){
        roomList = new ArrayList();
    }
}
