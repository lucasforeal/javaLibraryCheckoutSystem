/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.model.DVD;

import static org.junit.Assert.*;

/**
 *
 * @author jroge
 */
public class DVDTest {
  
  public DVDTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getDescription method, of class DVD.
   */
  @Test
  public void testGetDescription() {
    System.out.println("getDescription");
    String callNumber = "1";
    String title = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD instance = new DVD(callNumber, title, leadActor, rating);
    String expResult = "DOOM featuring Dwayne Johnson, rated 2.5.";
    String result = instance.getDescription();
    assertEquals(expResult, result);
  }

  /**
   * Test of getCheckoutPeriod method, of class DVD.
   */
  @Test
  public void testGetCheckoutPeriod() {
    System.out.println("getCheckoutPeriod");
    String callNumber = "1";
    String title = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD instance = new DVD(callNumber, title, leadActor, rating);
    int expResult = 7;
    int result = instance.getCheckoutPeriod();
    assertEquals(expResult, result);
  }

  /**
   * Test of getAllowedNumberOfRenewals method, of class DVD.
   */
  @Test
  public void testGetAllowedNumberOfRenewals() {
    System.out.println("getAllowedNumberOfRenewals");
    String callNumber = "1";
    String title = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD instance = new DVD(callNumber, title, leadActor, rating);
    int expResult = 0;
    int result = instance.getAllowedNumberOfRenewals();
    assertEquals(expResult, result);
  }
  
}
