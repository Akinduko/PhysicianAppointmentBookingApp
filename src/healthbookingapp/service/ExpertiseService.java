/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Expertise;

/**
 *
 * @author olugbengaakinduko
 */
public interface ExpertiseService {
    Expertise getExpertiseById (String id);  
    void  initialiseExpertise(); 
}
