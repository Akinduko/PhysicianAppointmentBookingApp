/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Appointment;

/**
 *
 * @author olugbengaakinduko
 */
public interface AppointmentService {
     Appointment getAppointmentById (String id);     
}
