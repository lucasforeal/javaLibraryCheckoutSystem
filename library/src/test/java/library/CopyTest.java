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
import library.model.DVD;
import library.model.Patron;
import library.model.SimpleDate;

import static org.junit.Assert.*;

/**
 *
 * @author jroge
 */
public class CopyTest {
  
  public CopyTest() {
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
   * Test of getCallNumber method, of class Copy.
   */
  @Test
  public void testGetCallNumber() {
    System.out.println("getCallNumber");
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
    String expResultBook = callNumberBook;
    String expResultDvd = callNumberDvd;
    String resultBook = bookCopy.getCallNumber();
    String resultDvd = dvdCopy.getCallNumber();
    assertEquals(expResultBook, resultBook);
    assertEquals(expResultDvd, resultDvd);
  }

  /**
   * Test of getCopyNumber method, of class Copy.
   */
  @Test
  public void testGetCopyNumber() {
    System.out.println("getCopyNumber");
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
    int expResultBook = 3;
    int expResultDvd = 4;
    int resultBook = bookCopy.getCopyNumber();
    int resultDvd = dvdCopy.getCopyNumber();
    assertEquals(expResultBook, resultBook);
    assertEquals(expResultDvd, resultDvd);
  }

  /**
   * Test of getDescription method, of class Copy.
   */
  @Test
  public void testGetDescription() {
    System.out.println("getDescription");
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
    String expResultBook = book.getDescription();
    String expResultDvd = dvd.getDescription();
    String resultBook = bookCopy.getDescription();
    String resultDvd = dvdCopy.getDescription();
    assertEquals(expResultBook, resultBook);
    assertEquals(expResultDvd, resultDvd);
  }

  /**
   * Test of calculateDateDue method, of class Copy.
   */
  @Test
  public void testCalculateDateDue() {
    System.out.println("calculateDateDue");
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
    
    SimpleDate today = SimpleDate.getToday();
    SimpleDate expResultBook = today.daysLater(book.getCheckoutPeriod());
    SimpleDate expResultDvd = today.daysLater(dvd.getCheckoutPeriod());
    SimpleDate resultBook = bookCopy.calculateDateDue();
    SimpleDate resultDvd = dvdCopy.calculateDateDue();
    assertEquals(expResultBook, resultBook);
    assertEquals(expResultDvd, resultDvd);
  }

  /**
   * Test of checkOutTo method, of class Copy.
   */
  @Test
  public void testCheckOutTo() {
    System.out.println("checkOutTo");
    
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
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    assertEquals(false, bookCopy.isCheckedOut());
    assertEquals(false, dvdCopy.isCheckedOut());
    assertEquals(0, patron.getCurrentCopiesOut());
    
    bookCopy.checkOutTo(patron);
    assertEquals(true, bookCopy.isCheckedOut());
    dvdCopy.checkOutTo(patron);
    assertEquals(true, dvdCopy.isCheckedOut());
  }

  /**
   * Test of getCheckedOutTo method, of class Copy.
   */
  @Test
  public void testGetCheckedOutTo() {
    System.out.println("getCheckedOutTo");
    
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
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    bookCopy.checkOutTo(patron);
    assertEquals(patron, bookCopy.getCheckedOutTo());
    dvdCopy.checkOutTo(patron);
    assertEquals(patron, dvdCopy.getCheckedOutTo());
  }

  /**
   * Test of getDateDue method, of class Copy.
   */
  @Test
  public void testGetDateDue() {
    System.out.println("getDateDue");
    
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
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    bookCopy.checkOutTo(patron);
    assertEquals(SimpleDate.getToday().daysLater(book.getCheckoutPeriod())
            , bookCopy.getDateDue());
    dvdCopy.checkOutTo(patron);
    assertEquals(SimpleDate.getToday().daysLater(dvd.getCheckoutPeriod())
            , dvdCopy.getDateDue());
  }

  /**
   * Test of isCheckedOut method, of class Copy.
   */
  @Test
  public void testIsCheckedOut() {
    System.out.println("isCheckedOut");
    
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
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    
    assertEquals(false, bookCopy.isCheckedOut());
    assertEquals(false, dvdCopy.isCheckedOut());
    bookCopy.checkOutTo(patron);
    dvdCopy.checkOutTo(patron);
    assertEquals(true, bookCopy.isCheckedOut());
    assertEquals(true, dvdCopy.isCheckedOut());
  }

  /**
   * Test of isOverdue method, of class Copy.
   */
  @Test
  public void testIsOverdue() {
    System.out.println("isOverdue");
    
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
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    bookCopy.checkOutTo(patron);
    dvdCopy.checkOutTo(patron);
    assertEquals(false, bookCopy.isOverdue());
    assertEquals(false, dvdCopy.isOverdue());
    
    SimpleDate dvdDue = SimpleDate.getToday().daysLater(8);
    SimpleDate.setToday(dvdDue.toDate());
    assertEquals(false, bookCopy.isOverdue());
    assertEquals(true, dvdCopy.isOverdue());
    
    SimpleDate bookDue = SimpleDate.getToday().daysLater(25);
    SimpleDate.setToday(bookDue.toDate());
    assertEquals(true, bookCopy.isOverdue());
    assertEquals(true, dvdCopy.isOverdue());
  }

  /**
   * Test of renew method, of class Copy.
   */
  @Test
  public void testRenew() {
    System.out.println("renew");
    
    String callNumberBook = "1";
    String titleBook = "The Hobbit";
    String author = "T.L.L Tolkien";
    Book book = new Book(callNumberBook, titleBook, author);
    Copy bookCopy = new Copy(book, 3);
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    bookCopy.checkOutTo(patron);
    SimpleDate today = SimpleDate.getToday();
    SimpleDate due = today.daysLater(book.getCheckoutPeriod());
    SimpleDate resultBook = bookCopy.renew();
    assertEquals(due.daysLater(book.getCheckoutPeriod()), resultBook);
  }

  /**
   * Test of recordReturn method, of class Copy.
   */
  @Test
  public void testRecordReturn() {
    System.out.println("recordReturn");
    
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
    
    String firstName = "Ben";
    String lastName = "Rogers";
    String address = "255 Grapevine Road";
    String phoneNumber = "781-548-0927";
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    
    bookCopy.checkOutTo(patron);
    dvdCopy.checkOutTo(patron);
    SimpleDate date = SimpleDate.getToday().daysLater(9);
    SimpleDate.setToday(date.toDate());
    int bookReturn = bookCopy.recordReturn();
    int dvdReturn = dvdCopy.recordReturn();
    
    assertEquals(0, bookReturn);
    assertEquals(2, dvdReturn);
  }
  
}
