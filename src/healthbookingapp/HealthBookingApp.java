/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;
import healthbookingapp.service.AppointmentService;
import java.util.Scanner;

/**
 *
 * @author olugbengaakinduko
 */
public class HealthBookingApp {
   static Scanner input = new Scanner(System.in);
   static AppointmentService appointmentService = new AppointmentService(); 
   static final String LINE = "\n".concat(new String(new char[150]).replace('\0', '-'));
    
    /**
     * @param args the command LINE arguments
     */
   
    private static void seedInitialData(){
          appointmentService.setupDataCollections();
    }
    
    private static void startApp() {
               int actionInput = 0;          
                // Checks if user is a patient or guest
               do{
                   
                    System.out.println(LINE);  
                    System.out.println("Welcome to Demo Health Booking APP?");
                    System.out.println(LINE);  
                    
                    System.out.println(LINE);   
                    System.out.println("1. Book an appointment.");
                    System.out.println("2. Generate report."); 
                    System.out.println(LINE);    
        
                    System.out.print("\nChoose one of the options above "
                            + "to proceed (Enter 1 or 2):  ");
                    
                   actionInput = input.nextInt();
                   
               }
               while (actionInput < 1 && actionInput > 2);
                
                if(actionInput == 1){
                     appointmentService.handleBooking();
                  } else{
                     appointmentService.handleAppReport();
                }
                   
    }
    
    private static void closeApp() {
         //Recursion for booking another appointment
        boolean bookingLoop = true;
        do {
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
                                startApp(); //Loops the program
                        }
                }

        }
        while(bookingLoop);
        System.exit(0);
    }
        
    public static void main(String[] args) {
        
        // Seed  initial app data
        seedInitialData();
        
        // Start application
        
        startApp();
 
        // Handle app exit
        closeApp();
}

}
