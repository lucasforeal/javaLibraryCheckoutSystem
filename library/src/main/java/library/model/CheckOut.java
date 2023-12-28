/*
 *  CheckOut.java
 */

package library.model;

/**
 * Association class between Patron and Copy class that record their respective
 * checkouts.
 * 
 * @author Ben and Lucas deAssis
 */
public class CheckOut implements java.io.Serializable {

  private static long serializableVersionUID = 1;
  // Cannot change who is responsible for this checkout, which copy it relates to,
  // or the date at which it was checked out
  private final Patron patron;
  private final Copy copy;
  private final SimpleDate checkoutDate;

  // —but CAN change when it is due, based on the number of renewals left
  private SimpleDate dueDate;
  private int renewalsLeft;

  /**
   * Constructor
   * 
   * @param patron the Patron checking out
   * @param copy the Copy being checked out
   */
  public CheckOut(Patron patron, Copy copy) {
    this.patron = patron;
    this.copy = copy;
    checkoutDate = SimpleDate.getToday();
    dueDate = checkoutDate.daysLater(copy.getItem().getCheckoutPeriod());
    renewalsLeft = copy.getItem().getAllowedNumberOfRenewals();
  }

  /**
   * Informs if the copy's return deadline has passed.
   * 
   * @return true if it's overdue, false otherwise
   */
  public boolean isOverdue() {
    
    // Iff today's date is past the due date, return true
    if (SimpleDate.getToday().isAfter(dueDate)) {
      return true;
    }
    return false;
  }

  public Patron getPatron() {
    return patron;
  }
  public Copy getCopy() {
    return copy;
  }
  public SimpleDate getCheckoutDate() {
    return checkoutDate;
  }
  public SimpleDate getDueDate() {
    return dueDate;
  }


  /**
   * Renews the the copy, if it's a Book, it isn't overdue, and there are renewals left
   * 
   * @throws IllegalArgumentException if it's a DVD, it is overdue, or there aren't renewals
   * left
   */  
  public void renew() throws IllegalArgumentException {
    Item item = copy.getItem();
    
    // If it's a DVD, it cannot be renewed.
    if (item instanceof DVD) {
      throw new IllegalArgumentException("Cannot renew a DVD");

    // If it's overdue, it cannot be renewed.
    } if (isOverdue()) {
      throw new IllegalArgumentException("The copy is overdue");
    
    // If it is out of renewals left, it cannot be renewed.
    } else if (renewalsLeft == 0) {
      throw new IllegalArgumentException("There are no renewals for this copy left");

    // Otherwise, the book is renewed, as its due date is pushed by the checkout period!
    } else {
      dueDate = dueDate.daysLater(copy.getItem().getCheckoutPeriod());
      renewalsLeft--;
    }
  }
}
