/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Treatment;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

    

/**
 *
 * @author olugbengaakinduko
 */
public class TreatmentServiceIT {
   
    TreatmentService instance = new TreatmentService();

    @Before
    public void setUp() {
       System.out.println("initialiseTreatments");
       instance.initialiseTreatments();            
    }
    
    public TreatmentServiceIT() {
  
    }
     
    /**
     * Test of getTreatmentById method, of class TreatmentService.
     */
    @Test
    public void testGetTreatmentById() {
        System.out.println("getTreatmentById");
        String id = "5";
        Treatment result = instance.getTreatmentById(id);
        assertEquals(result.getName(), "Pool rehabilitation");
    }


    /**
     * Test of treatments method, of class TreatmentService.
     */
    @Test
    public void testTreatments() {
        System.out.println("treatments");
        ArrayList<Treatment> result = instance.treatments();
        assertEquals(result.size(), 5);

    }
    
}
