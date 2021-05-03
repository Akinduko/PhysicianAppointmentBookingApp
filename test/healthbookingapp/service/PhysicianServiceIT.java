/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp.service;

import healthbookingapp.model.Physician;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olugbengaakinduko
 */
public class PhysicianServiceIT {
    PhysicianService physicianInstance = new PhysicianService();
    ExpertiseService expertiseInstance = new ExpertiseService();
    
    public PhysicianServiceIT() {
    }
    
    @Before
    public void setUp() {
        expertiseInstance.initialiseExpertise();
        physicianInstance.initialisePhysicians(expertiseInstance.expertiseList);
    }
    

    /**
     * Test of getPhysicianById method, of class PhysicianService.
     */
    @Test
    public void testGetPhysicianById() {
        System.out.println("getPhysicianById");
        String id = "5";
        Physician result = physicianInstance.getPhysicianById(id);
        assertEquals(result.getExpertise().get("1").getId(), "1");
    }

    /**
     * Test of getPhysiciansByName method, of class PhysicianService.
     */
    @Test
    public void testGetPhysiciansByName() {
        System.out.println("getPhysiciansByName");
        String name = "Rebekah Boone";
        ArrayList<Physician> result = physicianInstance.getPhysiciansByName(name);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getId(), "5");
    }

    /**
     * Test of getPhysiciansByExpertise method, of class PhysicianService.
     */
    @Test
    public void testGetPhysiciansByExpertise() {
        System.out.println("getPhysiciansByExpertise");
        String id = "1";
        ArrayList<Physician> result = physicianInstance.getPhysiciansByExpertise(id);
        assertEquals(result.size(), 2);
    }
    
    /**
     * Test of physicians method, of class PhysicianService.
     */
    @Test
    public void testPhysicians() {
        System.out.println("physicians");
        ArrayList<Physician> result = physicianInstance.physicians();
        assertEquals(result.size(), 6);
    }
    
}
