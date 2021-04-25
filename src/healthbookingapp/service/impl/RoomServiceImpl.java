/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Room;
import healthbookingapp.model.seeders.RoomObj;
import healthbookingapp.service.RoomService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author olugbengaakinduko
 */
public class RoomServiceImpl implements RoomService {
    
    static Json2ArrayList importJson = new Json2ArrayList();
    static ArrayList<Room> roomList = new ArrayList<>();
    
    @Override
    public Room getRoomById(String id) {

      Room result = null;
         
        for (Room room: roomList){
            if(id == null ? room.id == null : id.equals(room.id)){
                result = room;
            }
        }
        
        return result;
    }  
    
    @Override
    public void initialiseRooms() {
       RoomObj[] rooms = importJson.importRoom();
 
        for (RoomObj room: rooms){
            
          HashMap<Room.RoomLookup, String> roomObj = new HashMap<Room.RoomLookup, String>();
          
          roomObj.put(Room.RoomLookup.id, room.id);
          roomObj.put(Room.RoomLookup.name, room.name);
          
          Room roomEntity = new Room(roomObj);
          
          roomList.add(roomEntity); 
        }
        
        
    } 
   
}
