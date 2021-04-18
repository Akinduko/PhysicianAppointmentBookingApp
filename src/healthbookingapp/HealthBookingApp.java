/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author olugbengaakinduko
 */
public class HealthBookingApp {

    static final String[] initialExpertise = {"Physiotherapy","Osteopathy", "Rehabilitation"};
    static final String[] initialRooms = {"A","B", "C","Swimming Pool","Gym"};
    static final String[] initialTreatments = {
                                                "Neura Mobilisation",
                                                "Acupunture", 
                                                "Massage",
                                                "Mobilisation of joints and spine",
                                                "Pool rehabilitation"
                                               };
    
    private Room[] roomList;
    
    
    static Scanner input = new Scanner(System.in);
//    private Consultation consultation = new Consultation();
//    private Expertise expertise = new Expertise();
//    private Room room = new Room();
//    private Treatment treatment = new Treatment();
    
      
    
    private void seedRooms (){
        
        for (int i = 0; i <= initialRooms.length; i++) {   
          
          HashMap<Room.RoomLookUpKey, String> props = new HashMap<>();
          
          props.put(Room.RoomLookUpKey.id,String.valueOf(i));
          
          props.put(Room.RoomLookUpKey.name, initialRooms[i]);
          
          Room params = new Room(props);
         
          roomList[i] = params;
        }
    }
       
    
    public HealthBookingApp (){
        this.seedRooms();
    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // this.consultation.initialiseConsultationCollection();
    }
    
}
