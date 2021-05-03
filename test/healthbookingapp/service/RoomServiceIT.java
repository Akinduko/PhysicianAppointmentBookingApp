/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Room;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author olugbengaakinduko
 */
public class RoomServiceIT {
    RoomService instance = new RoomService();
    ArrayList<Room> result = new ArrayList();
    
   @Before
   public void setUp() {
        System.out.println("initialiseTreatments");
        instance.initialiseRooms();     
        result = instance.rooms();
   }
    
    public RoomServiceIT() {
    }
  

    /**
     * Test of getRoomById method, of class RoomService.
     */
    @Test
    public void testGetRoomById() {
        System.out.println("getRoomById");
        String id = "2";
        Room room = instance.getRoomById(id);
        assertEquals(room.getName(), "B");
    }

    /**
     * Test of rooms method, of class RoomService.
     */
    @Test
    public void testRooms() {
        System.out.println("rooms");
        ArrayList<Room> rooms = instance.rooms();
        assertEquals(result.size(), rooms.size());
    }
    
}
