/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;
import healthbookingapp.helper.TableLogger;
import healthbookingapp.model.Appointment;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Expertise;
import healthbookingapp.model.Patient;
import healthbookingapp.model.Physician;
import healthbookingapp.service.impl.AppointmentServiceImpl;
import healthbookingapp.service.impl.ConsultationServiceImpl;
import healthbookingapp.service.impl.ExpertiseServiceImpl;
import healthbookingapp.service.impl.PatientServiceImpl;
import healthbookingapp.service.impl.PhysicianServiceImpl;
import healthbookingapp.service.impl.RoomServiceImpl;
import healthbookingapp.service.impl.TreatmentServiceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author olugbengaakinduko
 */
public class HealthBookingApp {
    
   static Scanner input = new Scanner(System.in);
   static RoomServiceImpl roomService = new RoomServiceImpl(); 
   static TableLogger tableLogger = new TableLogger(); 
   static AppointmentServiceImpl appointmentService = new AppointmentServiceImpl(); 
   static TreatmentServiceImpl treatmentService = new TreatmentServiceImpl();
   static ConsultationServiceImpl consultationService = new ConsultationServiceImpl();
   static PatientServiceImpl patientService = new PatientServiceImpl();         
   static ExpertiseServiceImpl expertiseService = new ExpertiseServiceImpl(); 
   static PhysicianServiceImpl physicianService = new PhysicianServiceImpl();
   static Patient currentUser = null; 
   static Appointment appointment = null;
   static ArrayList<Physician> physicians = null;
   static String line = "\n".concat(new String(new char[150]).replace('\0', '-'));

    //ENTERING AND VALIDATING CUSTOMER DETAILS
  
    private static void handleGuest(){
        String fullName = "";  
        String address = "";
        String phoneNumber = ""; 
        Boolean isFirstRun = true;
        char willRegisterInput = '0'; 
        
       HashMap<Patient.PatientLookup, String> patientObj = new HashMap<Patient.PatientLookup, String>();

        // Checks if guest will like to register has a patient or login as guest
       do{
           
        System.out.println(line); 
        System.out.print("\n\nWill you a like to signup? (Type Y or N):  ");   
        willRegisterInput = Character.toLowerCase(input.next().charAt(0));
        
       }
       while (willRegisterInput != 'y' && willRegisterInput != 'n');
          
       if(willRegisterInput == 'y'){
           
        do{
            if(!isFirstRun){
             System.out.println(line); 
             System.out.print("Enter your Full Name:  ");
            }
           isFirstRun = false;
           fullName = input.nextLine(); 
        
        }
        while (fullName.isEmpty());
        
        do{
            System.out.println(line); 
            System.out.print("Enter your Address:  "); 
            address = input.nextLine();
         }
         while (address.isEmpty());

        do{
            System.out.println(line); 
            System.out.print("\nEnter your Phone number:  ");
            phoneNumber = input.nextLine();
         }
         while (phoneNumber.isEmpty()); 
       
            patientObj.put(Patient.PatientLookup.fullName, fullName);
            patientObj.put(Patient.PatientLookup.address, address);
            patientObj.put(Patient.PatientLookup.phoneNumber, phoneNumber);  
      
            currentUser  = patientService.creatPatient(patientObj); 
            
            System.out.println(line); 
            System.out.println("\nWelcome, " +currentUser.fullName + ", your unique user id is: " + currentUser.id);
            System.out.println(line); 
       } 
       else {
        do{
           if(!isFirstRun){
             System.out.println(line); 
             System.out.print("\nEnter your Full Name:  "); 
            }
           isFirstRun = false;
           fullName = input.nextLine(); 
         }
        while (fullName.isEmpty());  
        
        patientObj.put(Patient.PatientLookup.fullName, fullName);
        
        currentUser  = patientService.creatGuest(patientObj); 

        System.out.println(line); 
        System.out.println("\nWelcome, " +currentUser.fullName);
        System.out.println(line); 
           
       }
    
    }
   
    private static void handlePatient(){
     
        Boolean isFirstRun = true;   

        // login patient
       do{
    
        
            if(!isFirstRun){   
             System.out.println(line); 
             System.out.print("\nPlease enter your unique user id:  ");   
            }
        
           String userInput = input.nextLine();
           
           
            currentUser = patientService.getPatientById(userInput);

            if(currentUser == null && !isFirstRun){
                System.out.println(line); 
                System.out.println("\nPatient record not found!");
                System.out.println(line); 
            }           
            else if(currentUser == null && isFirstRun);  
            
            else if(currentUser != null)  break;
                
           isFirstRun = false;
       }
       while (true);
     

    }
    
    private static void handleAppointment(){
       int appointmentOptionInput = 0; 

       do{
     
            displayPhysicianSlots();
         
            System.out.print("\nEnter a Slot ID to book an appointment:  ");
            appointmentOptionInput = input.nextInt();
            
            Consultation consultationObj = consultationService.getConsultationById(String.valueOf(appointmentOptionInput));
            
            appointment =  appointmentService.bookAppointment(consultationObj,currentUser);
             
            if(appointment != null){  
                System.out.println(line);  
                System.out.println("\n\n Appointment Booked Successfully!\n");
                System.out.println(line); 
                
                break;
            }

       }
       while (appointmentOptionInput > 0 && appointmentOptionInput <= physicians.size()); 
      
    }
    
    private static void displayPatientReport(ArrayList<Appointment> appointmentsRecord){
           final ArrayList<String>[] table = new ArrayList[appointmentsRecord.size()];
            
           for(int i= 0 ; i<(appointmentsRecord.size()); i++){
               
               ArrayList localAppointment = new ArrayList();  
               localAppointment.add(appointmentsRecord.get(i).id);
               localAppointment.add(appointmentsRecord.get(i).patient.fullName);
               localAppointment.add(appointmentsRecord.get(i).consultation.physician.name);
               localAppointment.add(appointmentsRecord.get(i).consultation.room.name);
               localAppointment.add(appointmentsRecord.get(i).consultation.treatment.name);
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).date));
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).status));
               
              table[i] = localAppointment;
            }
      
           tableLogger.printPatientAppointments(table); 
    }
    
    private static void displayGuestReport(ArrayList<Appointment> appointmentsRecord){
           final ArrayList<String>[] table = new ArrayList[appointmentsRecord.size()];
            
           for(int i= 0 ; i<(appointmentsRecord.size()); i++){
               
               ArrayList localAppointment = new ArrayList();  
               localAppointment.add(appointmentsRecord.get(i).id);
               localAppointment.add(appointmentsRecord.get(i).consultation.physician.name);
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).date));
               localAppointment.add(appointmentsRecord.get(i).notes);
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).status));
               
              table[i] = localAppointment;
            }
      
           tableLogger.printGuestAppointments(table); 
    }
    
    private static void displayAppointmentReportByPatients(HashMap<String, ArrayList<Appointment>> groupedAppointments){
       
           for(String key: groupedAppointments.keySet()){
                System.out.println(line);   
                 System.out.println("Report for " + patientService.getPatientById(key).fullName);
                System.out.println(line);    
               displayPatientReport(groupedAppointments.get(key));
            }
      
    }
    
    private static void displayPhysicianSlots(){
           final ArrayList<String>[] table = new ArrayList[physicians.size()];
            
           for(int i= 0 ; i<(physicians.size()); i++){
               ArrayList localAppointment = new ArrayList();  
               localAppointment.add(physicians.get(i).name);
         
               // Fetch Guest Consultations if current user is guest.
                ArrayList<Consultation> consultations = currentUser.isGuest?
                        consultationService
                        .availableGuestConsultationsByPhysicianId(physicians.get(i).id,
                        appointmentService): 
                        consultationService
                        .availablePatientConsultationsByPhysicianId(physicians.get(i).id,
                        appointmentService);
            
                if(consultations.size()>0){
                    
                    for(int j= 0 ; j<consultations.size(); j++){
                       localAppointment.add(consultations.get(j).id);
                       localAppointment.add(consultations.get(j).room.name);
                       localAppointment.add(consultations.get(j).treatment.name);
                       localAppointment.add(String.valueOf(consultations.get(j).date));
                     }
                    table[i] = localAppointment;
                }
            }
      
           tableLogger.printConsultationSlots(table); 
    }
            
    private static void handleChangeAppointmentStatus(){
       int appointmentOptionInput = 0; 
       int appointmentStatusInput = 0; 
       Boolean appointmentSelected = false; 
       ArrayList<Appointment> currentUserAppointments = 
               appointmentService.getAppointmentsByUser(currentUser.id);
            
       do{
            // Show the patients appointments
            
            displayPatientReport(currentUserAppointments);
            
            System.out.println("\n");
         
            System.out.print("\nEnter an ID to change an appointment status:  ");
            appointmentOptionInput = input.nextInt();
            
            for(Appointment each:currentUserAppointments){
                if(each.id.equals(String.valueOf(appointmentOptionInput))) appointmentSelected = true; 
            }
  
       }
       while (!appointmentSelected); 
       
       do{
      
            System.out.println(line);   
                System.out.println("1. Attend");
                System.out.println("2. Missed"); 
                System.out.println("3. Cancel"); 
            System.out.println(line);    
        
         
            System.out.print("\nChoose an option to change appointment status:  ");
            appointmentStatusInput = input.nextInt();
  
       }
       while (appointmentStatusInput < 1 && appointmentStatusInput>3); 
       
        if(appointmentStatusInput == 1) appointmentService.changeAppointmentStatus(String.valueOf(appointmentStatusInput),
                Appointment.AppointmentStatus.ATTENDED);
        if(appointmentStatusInput == 2) appointmentService.changeAppointmentStatus(String.valueOf(appointmentStatusInput),
                Appointment.AppointmentStatus.CANCELED);
        if(appointmentStatusInput == 3) appointmentService.changeAppointmentStatus(String.valueOf(appointmentStatusInput),
                Appointment.AppointmentStatus.CANCELED);
        
            System.out.println(line); 
            System.out.println("Appointment status successfully changed");
            System.out.println(line); 
    }
    
    private static void handlePhysician(){
        int filterOptionInput = 0; 
        int expertiseOptionInput = 0; 
        Boolean searchEmpty = true;
        Boolean firstRun = true;
        String searchInput = ""; 
        ArrayList<Expertise> expertise = expertiseService.getExpertiseCollection();     
        
        do{
          
        System.out.println(line);   
            System.out.println("1. Filter physicians by expertise.");
            System.out.println("2. Search physicians by name."); 
        System.out.println(line);    
        
        System.out.print("\nChoose one of the options above to proceed (Enter 1 or 2):  ");
        filterOptionInput = input.nextInt();
       }
       while (filterOptionInput != 1 && filterOptionInput != 2);
       
       
       if(filterOptionInput == 1){
            do{ 
                System.out.println(line);                 
                    for(int i= 0; i < expertise.size(); i++){
                        System.out.println((i+1) + ". " + expertise.get(i).name);  
                    }
                System.out.println(line);  
                    
                System.out.print("\nChoose one of the expertise above to proceed:  ");
                expertiseOptionInput = input.nextInt();
                 
                 physicians = physicianService.getPhysiciansByExpertise(String.valueOf(expertiseOptionInput));
                 
                 if(physicians.size() > 0) break;
                 
                 else{
                     System.out.println(line);
                     System.out.println("\nNo Records Found:\n");
                     System.out.println(line); 
                 } 
            }
           while (expertiseOptionInput > 0 && expertiseOptionInput <= expertise.size() && searchEmpty); 
     
       }
       
       if(filterOptionInput == 2){
            do{
     
                if(!firstRun){
                    System.out.println(line);  
                    System.out.print("\nEnter your physician's name:  "); 
                }    
                 searchInput = input.nextLine();
                 
                 physicians = physicianService.getPhysiciansByName(searchInput);
                 if(physicians.size() > 0 && !firstRun){
                    break;
                 } else if(!(physicians.size() > 0) && !firstRun)  {
                     System.out.println(line);  
                     System.out.println("\nNo Records Found:\n");
                     System.out.println(line);  
                 }
                 firstRun = false;
           }
           while (searchInput.isEmpty() && searchEmpty); 
           
       }
      
       if(physicians.size() > 0){
            handleAppointment();
            
            if(!currentUser.isGuest){
              handleChangeAppointmentStatus();
            }
   
       } 

    }
    
    private static void handleActions() {
               int actionInput = 0;          
                // Checks if user is a patient or guest
               do{
                   
                    System.out.println(line);  
                    System.out.println("Welcome to Demo Health Booking APP?");
                    System.out.println(line);  
                    
                    System.out.println(line);   
                    System.out.println("1. Book an appointment.");
                    System.out.println("2. Generate report."); 
                    System.out.println(line);    
        
                    System.out.print("\nChoose one of the options above "
                            + "to proceed (Enter 1 or 2):  ");
                    
                   actionInput = input.nextInt();
                   
               }
               while (actionInput < 1 && actionInput > 2);
                
                if(actionInput == 1){
                     handleBooking();
                  } else{
                 handleAppReport();
                }
                   
    }
    
    private static void handleBooking() {
               char isPatientInput = '0';          
                // Checks if user is a patient or guest
               do{
 
                   System.out.print("\nAre you a registered patient?(Type Y or N):  ");
                   isPatientInput = Character.toLowerCase(input.next().charAt(0));
                   
               }
               while (isPatientInput != 'y' && isPatientInput != 'n');
                
                if(isPatientInput == 'y'){
                 handlePatient();
                }else{
                 handleGuest();
                }
                
                handlePhysician();     
    }
    
    private static void handleAppReport() {
               int userReportChoice = 0;          
                do{

                     System.out.println(line);   
                         System.out.println("1. Generate end of month, report for all treatment appointments.");
                         System.out.println("2. Generate end of month, report for all visitors appointments."); 
                         System.out.println("3. Generate end of month, report for all treatment appointments per patient."); 
                     System.out.println(line);    


                     System.out.print("\nChoose one of the options above to proceed:  ");
                     
                     userReportChoice = input.nextInt();

                }
                while (userReportChoice < 1 && userReportChoice>3); 
                
                if(userReportChoice == 1){
                    // Show the patients appointments report
                    displayPatientReport(appointmentService.getPatientAppointments());
                }
                
                if(userReportChoice == 2){
                    // Show the guests appointments report
                    displayGuestReport(appointmentService.getGuestAppointments());  
                }
                
                if(userReportChoice == 3){
                    // Show appointments report grouped by patients
                    displayAppointmentReportByPatients(appointmentService.getAppointmentsGroupByPatients());
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
        physicianService.initialisePhysicians(expertiseService.getExpertiseCollection());
        patientService.initialisePatients();   
        consultationService.initialiseConsultation(roomService.rooms(), physicianService.physicians(), treatmentService.treatments());   
 
		//Recursion for booking another appointment
		boolean bookingLoop = true;
		do {
			handleActions();
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
