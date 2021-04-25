/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;
import healthbookingapp.helper.Json2ArrayList;
import healthbookingapp.model.Room;
import healthbookingapp.service.impl.AppointmentServiceImpl;
import healthbookingapp.service.impl.ConsultationServiceImpl;
import healthbookingapp.service.impl.ExpertiseServiceImpl;
import healthbookingapp.service.impl.PatientServiceImpl;
import healthbookingapp.service.impl.PhysicianServiceImpl;
import healthbookingapp.service.impl.RoomServiceImpl;
import healthbookingapp.service.impl.TreatmentServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author olugbengaakinduko
 */
public class HealthBookingApp {
    
   static Scanner input = new Scanner(System.in);
   static RoomServiceImpl roomService = new RoomServiceImpl(); 
   static TreatmentServiceImpl treatmentService = new TreatmentServiceImpl();
   static ConsultationServiceImpl consultationService = new ConsultationServiceImpl();
   static PatientServiceImpl patientService = new PatientServiceImpl();         
   static ExpertiseServiceImpl expertiseService = new ExpertiseServiceImpl(); 
   static PhysicianServiceImpl physicianService = new PhysicianServiceImpl();    
    
	//ENTERING AND VALIDATING CUSTOMER DETAILS
    private static void userInput() {
                char isGuestInput = '0';
                 
                
                // Checks if user is a patient or guest
		do{
			System.out.println("Are you a guest? (Type Y or N): ");
                        
			isGuestInput = Character.toLowerCase(input.next().charAt(0));
                        	
		}
		while (isGuestInput != 'y' && isGuestInput != 'n');
                
                if(isGuestInput == 'y'){
                   System.out.println( roomService.getRoomById("1").id);
                }
                if(isGuestInput == 'n'){
                   System.out.println(roomService.getRoomById("2").id);
                }
		
	}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Seed  initial app data
        roomService.initialiseRooms();
        expertiseService.initialiseExpertise();
        treatmentService.initialiseTreatments();
        physicianService.initialisePhysicians();
        patientService.initialisePatients();
        consultationService.initialiseConsultation();   
 
		//Recursion for booking another appointment
		boolean bookingLoop = true;
		do {
			userInput();
			char bookAgain = '0';
			while(bookAgain != 'Y' && bookAgain != 'N') {
				System.out.println("Would you like to book another appointment? (Y / N)");
				bookAgain = input.next().charAt(0);
				bookAgain = Character.toUpperCase(bookAgain);
				if(bookAgain == 'N') {
					System.out.println("Goodbye!");
					bookingLoop = false; //Closes the loop and the program.
				}	
				else if(bookAgain == 'Y') {
					continue; //Loops the program
				}
			}

		}
		while(bookingLoop);
		System.exit(0);
    }
    
}
