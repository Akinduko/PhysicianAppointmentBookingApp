/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.helper.TableLogger;
import healthbookingapp.model.Appointment;
import healthbookingapp.model.Appointment.AppointmentStatus;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Expertise;
import healthbookingapp.model.Patient;
import healthbookingapp.model.Physician;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author olugbengaakinduko
 */

public class AppointmentService  {
        private final   TreatmentService treatmentService = new TreatmentService();
        private final   RoomService roomService = new RoomService();
        private final   PatientService patientService = new PatientService();
        private final   ExpertiseService expertiseService = new ExpertiseService();
        private final   PhysicianService physicianService = new PhysicianService();
        private final   ConsultationService consultationService = new ConsultationService();
        private final TableLogger tableLogger = new TableLogger();  
        private Patient currentUser = null; 
        private Appointment appointment = null;
        private final String line = "\n".concat(new String(new char[150]).replace('\0', '-'));
        ArrayList<Physician> physicians = null;
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        


    
    //ENTERING AND VALIDATING CUSTOMER DETAILS
  
    public void setupDataCollections(){
        roomService.initialiseRooms();
        expertiseService.initialiseExpertise();
        treatmentService.initialiseTreatments();
        physicianService.initialisePhysicians(expertiseService.getExpertiseCollection());
        patientService.initialisePatients();   
        consultationService.initialiseConsultation(roomService.rooms(), physicianService.physicians(), treatmentService.treatments());  
    }
    
    private  void handleGuest(){
        String fullName = "";  
        String address = "";
        String phoneNumber = ""; 
        Boolean isFirstRun = true;
        char willRegisterInput = '0'; 
        
       HashMap<Patient.PatientLookup, String> patientObj = new HashMap<>();

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
            System.out.println("\nWelcome, " +currentUser.getFullName() + ", your unique user id is: " + currentUser.getId());
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
        System.out.println("\nWelcome, " + currentUser.getFullName());
        System.out.println(line); 
           
       }
    
    }
   
    private  void handlePatient(){
     
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
    
    private  void handleAppointment(){
        
       int appointmentOptionInput = 0; 

       do{
     
            displayPhysicianSlots();
         
            System.out.print("\nEnter a Slot ID to book an appointment:  ");
            appointmentOptionInput = input.nextInt();
            
            Consultation consultationObj = consultationService.getConsultationById(String.valueOf(appointmentOptionInput));
            
            appointment =  bookAppointment(consultationObj,currentUser);
             
            if(appointment != null){  
                System.out.println(line);  
                System.out.println("\n\n Appointment Booked Successfully!\n");
                System.out.println(line); 
                
                break;
            }

       }
       while (appointmentOptionInput > 0 && appointmentOptionInput <= physicians.size()); 
      
    }
    
    private  void displayPatientReport(ArrayList<Appointment> appointmentsRecord){
           final ArrayList<String>[] table = new ArrayList[appointmentsRecord.size()];
            
           for(int i= 0 ; i<(appointmentsRecord.size()); i++){
               
               ArrayList localAppointment = new ArrayList();  
               localAppointment.add(appointmentsRecord.get(i).getId());
               localAppointment.add(appointmentsRecord.get(i).getPatient().getFullName());
               localAppointment.add(appointmentsRecord.get(i).getConsultation().getPhysician().getName());
               localAppointment.add(appointmentsRecord.get(i).getConsultation().getRoom().getName());
               localAppointment.add(appointmentsRecord.get(i).getConsultation().getTreatment().getName());
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).getDate()));
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).getStatus()));
               
              table[i] = localAppointment;
            }
      
           tableLogger.printPatientAppointments(table); 
    }
    
    private  void displayGuestReport(ArrayList<Appointment> appointmentsRecord){
           final ArrayList<String>[] table = new ArrayList[appointmentsRecord.size()];
            
           for(int i= 0 ; i<(appointmentsRecord.size()); i++){
               
               ArrayList localAppointment = new ArrayList();  
               localAppointment.add(appointmentsRecord.get(i).getId());
               localAppointment.add(appointmentsRecord.get(i).getConsultation().getPhysician().getName());
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).getDate()));
               localAppointment.add(appointmentsRecord.get(i).getNotes());
               localAppointment.add(String.valueOf(appointmentsRecord.get(i).getStatus()));
               
              table[i] = localAppointment;
            }
      
           tableLogger.printGuestAppointments(table); 
    }
    
    private  void displayAppointmentReportByPatients(HashMap<String, ArrayList<Appointment>> groupedAppointments){
       
           for(String key: groupedAppointments.keySet()){
                System.out.println(line);   
                 System.out.println("Report for " + patientService.getPatientById(key).getFullName());
                System.out.println(line);    
               displayPatientReport(groupedAppointments.get(key));
            }
      
    }
    
    private  void displayPhysicianSlots(){
   
        
           
           for(int i= 0 ; i<physicians.size(); i++){
             

               // Fetch Guest Consultations if current user is guest.
               ArrayList<Consultation> consultations = new ArrayList();
                               
               if(currentUser.getIsGuest()){
                   consultations = 
                        consultationService
                        .availableGuestConsultationsByPhysicianId(physicians.get(i).getId(),
                        appointmentList, currentUser); 
 
               }else {
                consultations =  consultationService
                        .availablePatientConsultationsByPhysicianId(physicians.get(i).getId(),
                        appointmentList);
               }
     
               if(consultations.size()>0){

               ArrayList<String>[] table = new ArrayList[consultations.size()]; 
               
                    for(int j= 0 ; j<consultations.size(); j++){
                       ArrayList localAppointment = new ArrayList();  
                       localAppointment.add(physicians.get(i).getName()); 
                       localAppointment.add(consultations.get(j).getId());
                       localAppointment.add(consultations.get(j).getRoom().getName());
                       localAppointment.add(consultations.get(j).getTreatment().getName());
                       localAppointment.add(String.valueOf(consultations.get(j).getDate()));
                       table[j] = localAppointment; 
                     }
                
       
                 
                 tableLogger.printConsultationSlots(table, i<(physicians.size()-1)); 
                }
             
         
            }
      

    }
            
    private  void handleChangeAppointmentStatus(){
       int appointmentOptionInput = 0; 
       int appointmentStatusInput = 0; 
       Boolean appointmentSelected = false; 
       ArrayList<Appointment> currentUserAppointments = 
               getAppointmentsByUser(currentUser.getId());
            
       do{
            // Show the patients appointments
            
            displayPatientReport(currentUserAppointments);
            
            System.out.println("\n");
         
            System.out.print("\nEnter an ID to change an appointment status:  ");
            appointmentOptionInput = input.nextInt();
            
            for(Appointment each:currentUserAppointments){
                if(each.getId().equals(String.valueOf(appointmentOptionInput))) appointmentSelected = true; 
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
       
        if(appointmentStatusInput == 1) changeAppointmentStatus(String.valueOf(appointmentStatusInput),
                Appointment.AppointmentStatus.ATTENDED);
        if(appointmentStatusInput == 2) changeAppointmentStatus(String.valueOf(appointmentStatusInput),
                Appointment.AppointmentStatus.MISSED);
        if(appointmentStatusInput == 3) changeAppointmentStatus(String.valueOf(appointmentStatusInput),
                Appointment.AppointmentStatus.CANCELED);
        
            System.out.println(line); 
            System.out.println("Appointment status successfully changed");
            System.out.println(line); 
    }
    
    private  void handlePhysician(){
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
                        System.out.println((i+1) + ". " + expertise.get(i).getName());  
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
            
            if(!currentUser.getIsGuest()){
              handleChangeAppointmentStatus();
            }
   
       } 

    }
    
    public  void handleBooking() {
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
    
    public  void handleAppReport() {
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
                    displayPatientReport(getPatientAppointments());
                }
                
                if(userReportChoice == 2){
                    // Show the guests appointments report
                    displayGuestReport(getGuestAppointments());  
                }
                
                if(userReportChoice == 3){
                    // Show appointments report grouped by patients
                    displayAppointmentReportByPatients(getAppointmentsGroupByPatients());
                }
         }
  
    public Appointment getAppointmentById(String id) {
      Appointment result = null;
        for (Appointment appointment: appointmentList){
            if(id.equals(appointment.getId()) ){
                result = appointment;
            }
        }
        
        return result;
    }  
    
    public ArrayList<Appointment> getPatientAppointments() {
      ArrayList<Appointment> result = new ArrayList();
      appointmentList.stream().filter((appointmentObj) -> (!appointmentObj.getPatient().getIsGuest())).forEachOrdered((appointmentResult) -> {
          result.add(appointmentResult);
        });   
       return result;
    } 
 
    public ArrayList<Appointment> getGuestAppointments() {
      ArrayList<Appointment> result = new ArrayList();
      appointmentList.stream().filter((appointmentObj) -> (appointmentObj.getPatient().getIsGuest())).forEachOrdered((appointmentObj) -> {
          result.add(appointmentObj);
        });   
        return result;
    } 

    public HashMap<String, ArrayList<Appointment>> getAppointmentsGroupByPatients(){

        HashMap<String, ArrayList<Appointment>> patientsAppointments = new HashMap<>();
        
        appointmentList.stream().filter((appointmentObj) -> (!appointmentObj.getPatient().getIsGuest())).forEachOrdered((Appointment appointmentObj) -> {
            ArrayList<Appointment> patientAppointments;
            patientAppointments = patientsAppointments.get(appointmentObj.getPatient().getId());
            
            if(patientAppointments != null ){
                patientAppointments.add(appointmentObj);
            }else{
                patientAppointments = new ArrayList();
                patientAppointments.add(appointmentObj);
                patientsAppointments.put(appointmentObj.getPatient().getId(), patientAppointments);
            }
        });   
        
        return patientsAppointments;
    }
    
    public void changeAppointmentStatus(String id, AppointmentStatus status) {

        ArrayList newAppointments = new ArrayList();
                
        for (Appointment appointmentObject: appointmentList ){
            if(id.equals(appointmentObject.getId())){
             appointmentObject.setStatus(status);
             newAppointments.add(appointmentObject);
            }
            else newAppointments.add(appointmentObject);
        }
           
        appointmentList = newAppointments;
    } 
 
    public Appointment getAppointmentByConsultation(String id) {
      Appointment result = null;
        for (Appointment appointmentObj : appointmentList) {
            if(id.equals(appointmentObj.getConsultation().getId()) ){
                result = appointmentObj;
            }
        }   
        return result;
    }
    
    public ArrayList<Appointment> getAppointmentsByUser(String id) {
      ArrayList<Appointment> result = new ArrayList();
      appointmentList.forEach((Appointment appointmentObj) -> {
          if(id.equals(appointmentObj.getPatient().getId()) ){
              result.add(appointmentObj);
          }
      });   
        return result;
    }
    
    public Appointment bookAppointment(Consultation consultation, Patient patient){
        Appointment appointmentObj = new Appointment();
        appointmentObj.setNotes(patient.getFullName());
        appointmentObj.setDate(consultation.getDate());
        appointmentObj.setStatus(patient.getIsGuest() ?
                AppointmentStatus.ATTENDED: AppointmentStatus.BOOKED);
        appointmentObj.setPatient(patient);
        appointmentObj.setConsultation(consultation);
        appointmentObj.setId(String.valueOf(appointmentList.size() + 1));
        
        appointmentList.add(appointmentObj);

        return appointmentObj;   
    }
    
    public ArrayList<Appointment>  appointments(){
     return appointmentList;
    }
    
    public void resetAppointment(){
        appointmentList = new ArrayList();
    } 
}
