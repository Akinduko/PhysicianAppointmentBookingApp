/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthbookingapp;

import healthbookingapp.service.AppointmentServiceIT;
import healthbookingapp.service.ConsultationServiceIT;
import healthbookingapp.service.ExpertiseServiceIT;
import healthbookingapp.service.PatientServiceIT;
import healthbookingapp.service.PhysicianServiceIT;
import healthbookingapp.service.RoomServiceIT;
import healthbookingapp.service.TreatmentServiceIT;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author olugbengaakinduko
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    AppointmentServiceIT.class, 
    ConsultationServiceIT.class,
    ExpertiseServiceIT.class,
    PatientServiceIT.class,        
    PhysicianServiceIT.class,
    RoomServiceIT.class,
    TreatmentServiceIT.class
})
public class HealthBookingAppTest {

    
}
