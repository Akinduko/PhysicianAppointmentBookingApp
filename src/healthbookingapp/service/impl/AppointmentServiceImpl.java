/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service.impl;

import healthbookingapp.HealthBookingApp;
import healthbookingapp.model.Appointment;
import healthbookingapp.service.AppointmentService;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author olugbengaakinduko
 */
public class AppointmentServiceImpl implements AppointmentService {
    ArrayList<Appointment> appointmentList = new ArrayList<>();
    
    @Override
    public Appointment getAppointmentById(String id) {
      Appointment result = null;
        for (Appointment appointment: appointmentList){
            if(id == null ? appointment.id == null : id.equals(appointment.id) ){
                result = appointment;
            }
        }
        
        return result;
    }   
   
}
