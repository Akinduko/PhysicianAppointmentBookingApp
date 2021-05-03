/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Expertise;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olugbengaakinduko
 */
public class ExpertiseServiceIT {
    ExpertiseService instance = new ExpertiseService(); 
    
    public ExpertiseServiceIT() {
    }
    
    @Before
    public void setUp() {
        instance.initialiseExpertise();
    }
    /**
     * Test of getExpertiseById method, of class ExpertiseService.
     */
    @Test
    public void testGetExpertiseById() {
        System.out.println("getExpertiseById");
        String id = "3";
        Expertise result = instance.getExpertiseById(id);
        assertEquals(result.getName(), "Rehabilitation");

    }

    /**
     * Test of getExpertiseCollection method, of class ExpertiseService.
     */
    @Test
    public void testGetExpertiseCollection() {
        System.out.println("getExpertiseCollection");
        ArrayList<Expertise> result = instance.getExpertiseCollection();
        assertEquals(result.size(), 3);
    }
    
}
