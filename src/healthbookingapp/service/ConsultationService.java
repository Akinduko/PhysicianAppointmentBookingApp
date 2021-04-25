/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Appointment;
import healthbookingapp.model.Consultation;
import healthbookingapp.model.Room;
import healthbookingapp.model.Treatment;

/**
 *
 * @author olugbengaakinduko
 */
public interface ConsultationService {
      Consultation getConsultationById (String id);       
      public void initialiseConsultation();
}
