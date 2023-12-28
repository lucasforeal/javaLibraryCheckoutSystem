/*
 *  Copy.java
 */

package library.model;

/** Representation for a single copy that can be checked out from the library
 *
 * @author  Russell C. Bjork
 *
 * MODIFIED BY: Ben Rogers, Lucas DeAssis
 */
public class Copy implements java.io.Serializable {
  
  private static long serializableVersionUID = 1;
  
  // Cannot change which item this is a copy of
  private final Item item;
  private int copyNumber;
  private String id;

  // An existing/non-existing (if null) checkout association to this copy
  private CheckOut checkOut;

  /** Constructor
   *
   *  @param item the item this is a copy of
   *  @param copyNumber the copy number of this copy of the item
   */
  public Copy(Item item, int copyNumber) {
    this.item = item;
    this.copyNumber = copyNumber;

    // The copy number in callNumber#copyNumber format
    // E.g. 1234#1 stands for the item 1234's first copy
    id = getCallNumber() + "#" + copyNumber;
  }
  
  /** Accessor for the call number of this copy
   *
   *  @return the call number
   */
  public String getCallNumber() {
    return item.getCallNumber();
  }

  /** Accessor for the copy number of this copy
   *
   *  @return the copy number
   */
  public int getCopyNumber() {
    return copyNumber;
  }
  
  /**
   * Accessor for the id number of this copy
   * 
   * @return this copy's id
   */
  public String getCopyId() {
    return id;
  }

  /** Accessor for a description of this copy
   *
   *  @return a description of this copy
   */
  public String getDescription() {
    return item.getDescription();
  }

  /** Calculate when this copy will be due if it is checked out today
   *
   *	@return the calculated due date
   */
  public SimpleDate calculateDateDue() {
    return SimpleDate.getToday().daysLater(item.getCheckoutPeriod());  
  }

  /** Check this copy out to a patron
   *
   *  @param patron the patron to check this book out to
   */
  public void checkOutTo(Patron patron) {
    checkOut = new CheckOut(patron, this);
  }

  /** Get the patron to whom this copy is checked out
   *
   *	Precondition: this copy is checked out
   *
   *  @return the patron, or null if not checked out
   *  @exception IllegalArgumentException if the precondition isn't met, as the copy isn't, in fact,
   *  checked out
   */
  public Patron getCheckedOutTo() throws IllegalArgumentException {
    if (checkOut == null) {
      throw new IllegalArgumentException("Copy is not checked out");
    }
    return checkOut.getPatron();
  }

  /** Get the date when this copy is due
   *
   *	Precondition: this copy is checked out
   *
   *  @return the date due, or date it will be due if not yet checked out
   */
  public SimpleDate getDateDue() {
    return checkOut.getDueDate();
  }

  /** Test to see whether this copy is checked out
   *
   *	@return true if this copy is checked out
   */
  public boolean isCheckedOut() {

    // If a checkout hasn't been made for this copy, or this copy was checked back in, the
    // checkOut object will be equal to null
    return checkOut != null;
  }

  /** Test to see whether this copy is overdue
   *
   *	Precondition: this copy is checked out
   *
   *	@return true if this copy is overdue
   */
  public boolean isOverdue() {
    return checkOut.isOverdue();
  }

  /** Renew this copy (to patron who currently has it out)
   *
   *	Precondition; this copy is checked out
   *
   *  @return the new due date
   *  @exception IllegalArgumentException if this copy cannot be renewed
   *             because it is a copy of a non-renewable item, or has been
   *             renewed as many times as allowed, or is overdue.  (The
   *             message in the exception will specify the reason.)
   */
  public SimpleDate renew() throws IllegalArgumentException {

    // Renew
    checkOut.renew();

    // Get the renewal's new due date
    return checkOut.getDueDate();
  }

  /** Record the return of this book
   *
   *	Precondition: this copy is checked out
   *
   *  @return if overdue, the number of days overdue; 0 if it is returned on time
   */
  public int recordReturn() {

    // If the copy is overdue, the amount of days overdue is calculated, otherwise the value is zero
    int daysOverDue = isOverdue()? SimpleDate.getToday().daysAfter(checkOut.getDueDate()): 0;

    // Delete the current checkout instance, because it is being returned
    checkOut = null;

    return daysOverDue;
  }

  public Item getItem() {
    return item;
  }
}
