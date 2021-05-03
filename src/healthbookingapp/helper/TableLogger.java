/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.helper;

import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;


/**
 *
 * @author olugbengaakinduko
 */

public class TableLogger {
   

    public  void printConsultationSlots (ArrayList<String>[] slots, Boolean header ) {
        String nameFormat = "|%s|";
        String endFormat = "|%s%n";
        String format = nameFormat.concat(nameFormat).concat(nameFormat).concat(nameFormat).concat(endFormat);
        String line = "\n".concat(new String(new char[150]).replace('\0', '-'));

    
        
        if(header){
            System.out.println(line);
            System.out.printf("|%s|%s|%s|%s|%s%n",
            StringUtils.center("Slot ID", 22),
            StringUtils.center("Physian Name", 22),
            StringUtils.center("Room", 22),
            StringUtils.center("Treatment", 35),
            StringUtils.center("Time Slot", 25));
       
           System.out.println(line);

        }

        for (ArrayList<String> slot : slots) {
            System.out.printf(format, 
                    StringUtils.center(slot.get(1),22), 
                    StringUtils.center(slot.get(0),22), 
                    StringUtils.center(slot.get(2),20), 
                    StringUtils.center(slot.get(3),35), 
                    StringUtils.center(slot.get(4),25));
        }

        System.out.println(line);
    }
    
           
    public  void printGuestAppointments (ArrayList<String>[] appointments ) {
        String nameFormat = "|%s|";
        String endFormat = "|%s%n";
        String format = nameFormat.concat(nameFormat).concat(nameFormat)
                .concat(nameFormat).concat(endFormat);
        String line = "\n".concat(new String(new char[150]).replace('\0', '-'));

        System.out.println(line);
        System.out.printf("|%s|%s|%s|%s|%s%n",
            StringUtils.center("ID", 22),
            StringUtils.center("Physian Name", 22),
            StringUtils.center("Time Slot", 25),
            StringUtils.center("Note", 22),
            StringUtils.center("Status", 25));
       
        System.out.println(line);

        for (ArrayList<String> appointment : appointments) {
            System.out.printf(format, 
                    StringUtils.center(appointment.get(0),22), 
                    StringUtils.center(appointment.get(1),22), 
                    StringUtils.center(appointment.get(2),20), 
                    StringUtils.center(appointment.get(3),22), 
                    StringUtils.center(appointment.get(4),25));
        }

        System.out.println(line);
    }
          
    public  void printPatientAppointments (ArrayList<String>[] appointments ) {
        String nameFormat = "|%s|";
        String endFormat = "|%s%n";
        String format = nameFormat.concat(nameFormat).concat(nameFormat)
                .concat(nameFormat).concat(nameFormat).concat(nameFormat).concat(endFormat);
        String line = "\n".concat(new String(new char[150]).replace('\0', '-'));

        System.out.println(line);
        System.out.printf("|%s|%s|%s|%s|%s|%s|%s%n",
            StringUtils.center("ID", 22),
            StringUtils.center("Patient Name", 22),
            StringUtils.center("Physian Name", 22),
            StringUtils.center("Room", 22),
            StringUtils.center("Treatment", 22),
            StringUtils.center("Time Slot", 25),
            StringUtils.center("Status", 25));
       
        System.out.println(line);

        for (ArrayList<String> appointment : appointments) {
            System.out.printf(format, 
                    StringUtils.center(appointment.get(0),22), 
                    StringUtils.center(appointment.get(1),22), 
                    StringUtils.center(appointment.get(2),20), 
                    StringUtils.center(appointment.get(3),22), 
                    StringUtils.center(appointment.get(4),25),
                    StringUtils.center(appointment.get(5),25),
                    StringUtils.center(appointment.get(6),25));
        }

        System.out.println(line);
    }
}