/*
 * Patron.java
 */

package library.model;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.ArrayList;

/** Representation for a library patron
 *
 * @author  Russell C. Bjork
 *
 * MODIFIED BY: Ben Rogers, Lucas deAssis
 */
public class Patron implements java.io.Serializable {
  
  private static final long serialVersionUID = -6039077147916873719L;

  // Mutable information about the patron, because clerk/patron input typos are common
  private String firstName, lastName, address, phoneNumber;

  // All the current checkouts for this patron
  private TreeMap<String, CheckOut> checkOutMap;

  /** Constructor
   *
   *  @param firstName the first name of the patron
   *  @param lastName the last name of the patron
   *  @param address the address of the patron
   */
  public Patron(String firstName,
                String lastName,
                String address,
                String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    checkOutMap = new TreeMap<String, CheckOut>();
  }

  /** Accessor for the full name of this patron
   *
   *	@return the full name (first and last)
   */
  public String getFullName() {
    return firstName + " " + lastName;
  }

  /** Accessor for the address of this patron.
   * 
   * @return the address of this patron
   */
  public String getAddress() {
    return address;
  }

  /** Accessor for the phone number of this patron
   *
   *  @return the phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /** Accessor for the number of copies currently checked out to this patron
   *
   *  @return the number of copies currently out
   */
  public int getCurrentCopiesOut() {
    return checkOutMap.size();
  }

  /** Get the number of copies currently checked out that are overdue
   *
   *  @return the number overdue
   */
  public int getNumberOverdue() {
    int totalOverdue = 0;
    Iterator<CheckOut> i = checkOutMap.values().iterator();
    
    while (i.hasNext()) {
      if (i.next().isOverdue()) {
        totalOverdue++;
      }
    }
    return totalOverdue;
  }

  /** Check out a copy to this patron
   *
   *  @param copy the copy being checked out
   */
  public void checkOut(Copy copy) {
    checkOutMap.put(copy.getCopyId(), new CheckOut(this, copy));
  }

  /** Return a copy that was checked out to this patron
   *
   *  @param copy the copy to return
   */
  public void returnCopy(Copy copy) {
    checkOutMap.remove(copy.getCopyId());
  }

  /** Get an iterator over all the copies this patron has checked out
   *
   *  @return an iterator
   */
  public Iterator<Copy> getCopiesCheckedOut() {
    ArrayList<Copy> copies = new ArrayList<Copy>();
    Iterator<CheckOut> i = checkOutMap.values().iterator();
    
    while (i.hasNext()) {
      Copy copy = i.next().getCopy();
      copies.add(copy);
    }
    return copies.iterator();
  }
}
