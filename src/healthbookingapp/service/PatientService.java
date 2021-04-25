/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Patient;

/**
 *
 * @author olugbengaakinduko
 */
public interface PatientService {
    Patient getPatientById (String id); 
    void  initialisePatients(); 
}
