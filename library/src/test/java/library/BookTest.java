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

import library.model.Book;
import library.model.Copy;
import library.model.Patron;

import static org.junit.Assert.*;

/**
 *
 * @author jroge
 */
public class BookTest {
  
  public BookTest() {
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
   * Test of getDescription method, of class Book.
   */
  @Test
  public void testGetDescription() {
    System.out.println("getDescription");
    String callNumber = "1";
    String title = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book instance = new Book(callNumber, title, author);
    String expResult = "The Hobbit by T.L.L Tolkien.";
    String result = instance.getDescription();
    assertEquals(expResult, result);
  }

  /**
   * Test of getCheckoutPeriod method, of class Book.
   */
  @Test
  public void testGetCheckoutPeriod() {
    System.out.println("getCheckoutPeriod");
    String callNumber = "1";
    String title = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book instance = new Book(callNumber, title, author);
    int expResult = 28;
    int result = instance.getCheckoutPeriod();
    assertEquals(expResult, result);
  }

  /**
   * Test of getAllowedNumberOfRenewals method, of class Book.
   */
  @Test
  public void testGetAllowedNumberOfRenewals() {
    System.out.println("getAllowedNumberOfRenewals");
    String callNumber = "1";
    String title = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book instance = new Book(callNumber, title, author);
    Copy copy = instance.makeCopy();
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    copy.checkOutTo(patron);
    patron.checkOut(copy);
    int result = instance.getAllowedNumberOfRenewals();
    assertEquals(1, result);
  }

}
