package library;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.model.Book;
import library.model.CheckOut;
import library.model.Copy;
import library.model.DVD;
import library.model.Patron;
import library.model.SimpleDate;

import static org.junit.Assert.*;

/**
 * Tests all methods of the CheckOut class. Draws this project's renewal rules as base
 * assumptions; assumes DVDs shouldn't be renewed, books can only be renewed once, also
 * assumes that books and DVDs have seven and twenty-eight days to return, respectfully.
 * 
 * @author Lucas deAssis
 */
public class CheckOutTest {

  // Immutable objects that are used accross tests—but cannot be changed, so these are
  // test-safe implementations
  private final CheckOut DVD_CHECKOUT, BOOK_CHECKOUT;
  private final Patron PATRON;
  private final Book BOOK;
  private final DVD DVD;
  private final String TODAYS_DATE;

  public CheckOutTest() {
    PATRON = new Patron("Russell", "Bjork", "255 Grapevine Road", "1234567890");
    DVD = new DVD("1", "Titanic", "Michael B Jordan", "10/10");
    BOOK = new Book("2", "The Prince", "Niccolò Machiavelli");
    DVD_CHECKOUT = new CheckOut(PATRON, new Copy(DVD, 0));
    BOOK_CHECKOUT = new CheckOut(PATRON, new Copy(BOOK, 0));

    // Today's date as a String
    TODAYS_DATE = SimpleDate.getToday().toStringYYMMDD();
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
   * Assumes DVDs and books have a checkout period less than 30 days long
   */
  @Test
  public void testIsOverdue() {
    
    // Test a case where the copies aren't overdue, so isOverdue() should return false.
    assertEquals(false, DVD_CHECKOUT.isOverdue());
    assertEquals(false, BOOK_CHECKOUT.isOverdue());

    // Similarly, test a case where the copies are overdue.
    // Just change today's date to 30 days later, as copies should be overdue by then
    SimpleDate.changeTodayBy(30);

    // and check if isOverdue() now returns true—as is should.
    assertEquals(true, DVD_CHECKOUT.isOverdue());
    assertEquals(true, BOOK_CHECKOUT.isOverdue());

    // Change today's date back to what it was before, so all checkout tests have the
    // same today's date as reference, for simplicity of testing
    SimpleDate.changeTodayBy(-30);
  }

  @Test
  public void testGetPatron() {

    // These calls should draw test-safe comparisons, because not only are the objects 
    // immutable, but the methods called (below) after each object are tested separately
    // as well.
    assertEquals(PATRON.getFullName(), DVD_CHECKOUT.getPatron().getFullName());
    assertEquals(PATRON.getFullName(), BOOK_CHECKOUT.getPatron().getFullName());
  }
  @Test
  public void getCopy() {

    // These calls should draw test-safe comparisons, because not only are the objects 
    // immutable, but the methods called (below) after each object are tested separately
    // as well.
    assertEquals(DVD.getCallNumber(), DVD_CHECKOUT.getCopy().getCallNumber());
    assertEquals(BOOK.getCallNumber(), BOOK_CHECKOUT.getCopy().getCallNumber());
  }
  @Test
  public void testGetCheckoutDate() {

    // These calls should draw test-safe comparisons, because not only are the objects 
    // immutable, but the methods called (below) after each object are tested separately
    // as well.
    // Both copies were checked out today, so this method's call should return today's date
    assertEquals(TODAYS_DATE, DVD_CHECKOUT.getCheckoutDate().toStringYYMMDD());
    assertEquals(TODAYS_DATE, BOOK_CHECKOUT.getCheckoutDate().toStringYYMMDD());
  }
  /**
   * Assumes books and DVDs have seven and twenty-eight days to return, respectfully.
   */
  @Test
  public void testGetDueDate() {

    // These calls should draw test-safe comparisons, because not only are the objects 
    // immutable, but the methods called (below) after each object are tested separately
    // as well.
    // Compares the YY/MM/DD String of the day it should be due, to the String the checkout
    // is actually due in
    assertEquals(SimpleDate.getToday().daysLater(7).toStringYYMMDD(),
                 DVD_CHECKOUT.getDueDate().toStringYYMMDD());
    assertEquals(SimpleDate.getToday().daysLater(28).toString(),
                 BOOK_CHECKOUT.getDueDate().toString());
  }

  /**
   * Draws this project's renewal rules as base assumptions; assumes DVDs shouldn't be renewed,
   * books can only be renewed once, also assumes that books and DVDs have seven and twenty-eight
   * days to return, respectfully.
   */
  @Test
  public void testRenew() {
    // Deep copy of BOOK_CHECKOUT
    CheckOut bookCheckout = new CheckOut(PATRON, new Copy(BOOK, 0));

    try {
      DVD_CHECKOUT.renew();
      fail("Should have thrown DVD IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // This is good.
    }

    try {
      // First renewal
      BOOK_CHECKOUT.renew();
    } catch (IllegalArgumentException e) {
      fail("Book should have renewed");
    }

    try {
      // Second renewal
      BOOK_CHECKOUT.renew();
      fail("Shouldn't be able to renew book twice, and should've throw an Exception accordingly");
    } catch (IllegalArgumentException e) {
      // This is good.
    }

    try {

      // Change today's date by a date it should be overdue by
      SimpleDate.changeTodayBy(30);

      // Use the unrenewed book-checkout and try to renew it past due date
      bookCheckout.renew();
      fail("Shouldn't be able to renew book after it's overdue, and should've throw an Exception" +
           "accordingly");
      
    } catch (IllegalArgumentException e) {
      // This is good.
    } finally {

      // Change date back, so all test methods use the same date, for simplicity
      SimpleDate.changeTodayBy(-30);
    }
  }
}
