/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Room;
import healthbookingapp.model.Treatment;
import healthbookingapp.model.seeders.RoomObj;
import java.util.HashMap;

/**
 *
 * @author olugbengaakinduko
 */
public interface RoomService {
    
    Room getRoomById (String id);
    void  initialiseRooms();  
    
}
