/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.model.Book;
import library.model.Copy;
import library.model.DVD;
import library.model.Patron;
import library.model.SimpleDate;

import static org.junit.Assert.*;

/**
 *
 * @author jroge
 */
public class PatronTest {
  
  public PatronTest() {
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
   * Test of getFullName method, of class Patron.
   */
  @Test
  public void testGetFullName() {
    System.out.println("getFullName");
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);
    String expResult = "Ben Rogers";
    String result = instance.getFullName();
    assertEquals(expResult, result);
  }

  /**
   * Test of getPhoneNumber method, of class Patron.
   */
  @Test
  public void testGetPhoneNumber() {
    System.out.println("getPhoneNumber");
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);
    String expResult = phoneNumber;
    String result = instance.getPhoneNumber();
    assertEquals(expResult, result);
  }

  /**
   * Test of getCurrentCopiesOut method, of class Patron.
   */
  @Test
  public void testGetCurrentCopiesOut() {
    System.out.println("getCurrentCopiesOut");
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);
    assertEquals(0, instance.getCurrentCopiesOut());
    
    String callNumberBook = "1";
    String titleBook = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book book = new Book(callNumberBook, titleBook, author);
    String callNumberDvd = "2";
    String titleDvd = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD dvd = new DVD(callNumberDvd, titleDvd, leadActor, rating);
    Copy bookCopy = new Copy(book, 3);
    Copy dvdCopy = new Copy(dvd, 4);
    
    bookCopy.checkOutTo(instance);
    instance.checkOut(bookCopy);
    assertEquals(1, instance.getCurrentCopiesOut());
    dvdCopy.checkOutTo(instance);
    instance.checkOut(dvdCopy);
    assertEquals(2, instance.getCurrentCopiesOut());
  }

  /**
   * Test of getNumberOverdue method, of class Patron.
   */
  @Test
  public void testGetNumberOverdue() {
    System.out.println("getNumberOverdue");
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);
    
    String callNumberBook = "1";
    String titleBook = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book book = new Book(callNumberBook, titleBook, author);
    
    String callNumberDvd = "2";
    String titleDvd = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD dvd = new DVD(callNumberDvd, titleDvd, leadActor, rating);
    
    Copy bookCopy = new Copy(book, 3);
    Copy dvdCopy = new Copy(dvd, 4);
    
    instance.checkOut(bookCopy);
    instance.checkOut(dvdCopy);
    assertEquals(0, instance.getNumberOverdue());
    
    SimpleDate today = SimpleDate.getToday();
    SimpleDate.setToday(today.daysLater(8).toDate());
    assertEquals(1, instance.getNumberOverdue());
    SimpleDate.setToday(today.daysLater(30).toDate());
    assertEquals(2, instance.getNumberOverdue());
  }

  /**
   * Test of checkOut method, of class Patron.
   */
  @Test
  public void testCheckOut() {
    System.out.println("checkOut");
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);
    
    String callNumberBook = "1";
    String titleBook = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book book = new Book(callNumberBook, titleBook, author);
    
    String callNumberDvd = "2";
    String titleDvd = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD dvd = new DVD(callNumberDvd, titleDvd, leadActor, rating);
    
    Copy bookCopy = new Copy(book, 3);
    Copy dvdCopy = new Copy(dvd, 4);
    
    assertEquals(false, bookCopy.isCheckedOut());
    assertEquals(false, dvdCopy.isCheckedOut());
    assertEquals(0, instance.getCurrentCopiesOut());
    
    instance.checkOut(bookCopy);
    assertEquals(1, instance.getCurrentCopiesOut());
    instance.checkOut(dvdCopy);
    assertEquals(2, instance.getCurrentCopiesOut());
  }

  /**
   * Test of returnCopy method, of class Patron.
   */
  @Test
  public void testReturnCopy() {
    System.out.println("returnCopy");
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);
    
    String callNumberBook = "1";
    String titleBook = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book book = new Book(callNumberBook, titleBook, author);
    
    String callNumberDvd = "2";
    String titleDvd = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "2.5";
    DVD dvd = new DVD(callNumberDvd, titleDvd, leadActor, rating);
    
    Copy bookCopy = new Copy(book, 3);
    Copy dvdCopy = new Copy(dvd, 4);
    
    assertEquals(false, bookCopy.isCheckedOut());
    assertEquals(false, dvdCopy.isCheckedOut());
    assertEquals(0, instance.getCurrentCopiesOut());
    
    instance.checkOut(bookCopy);
    instance.checkOut(dvdCopy);
    
    instance.returnCopy(bookCopy);
    assertEquals(false, bookCopy.isCheckedOut());
    assertEquals(1, instance.getCurrentCopiesOut());
    instance.returnCopy(dvdCopy);
    assertEquals(false, dvdCopy.isCheckedOut());
    assertEquals(0, instance.getCurrentCopiesOut());
  }

  /**
   * Test of getCopiesCheckedOut method, of class Patron.
   */
  @Test
  public void testGetCopiesCheckedOut() {
    System.out.println("getCopiesCheckedOut");
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron instance = new Patron(firstName, lastName, address, phoneNumber);

    String callNumberBook = "QA";
    String titleBook = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book book = new Book(callNumberBook, titleBook, author);

    String callNumberDvd = "PN";
    String titleDvd = "DOOM";
    String leadActor = "Dwayne Johnson";
    String rating = "R";
    DVD dvd = new DVD(callNumberDvd, titleDvd, leadActor, rating);

    Copy bookCopy = book.makeCopy();
    Copy dvdCopy = dvd.makeCopy();
    Copy bookCopy2 = book.makeCopy();

    // Checkout copies to patron
    instance.checkOut(bookCopy);
    instance.checkOut(dvdCopy);
    instance.checkOut(bookCopy2);
    instance.returnCopy(bookCopy);

    // Get iterator from patron
    Iterator<Copy> result = instance.getCopiesCheckedOut();
    Copy copy1 = result.next();
    Copy copy2 = result.next();
    System.out.println(copy1.getDescription());
    System.out.println(copy2.getDescription());

    // Test iterator, should be book then DVD (order of checkout)
    assertEquals(dvdCopy, copy1);
    assertEquals(bookCopy2, copy2);
  }
}
