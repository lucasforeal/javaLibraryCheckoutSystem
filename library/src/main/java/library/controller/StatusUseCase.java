/*
 * StatusUseCase.java
 */

package library.controller;

import library.gui.GUI;
import library.model.Copy;
import library.model.Patron;
import library.model.LibraryDatabase;

/** This is the controller for the use case that reports the status of copies
 *
 * @author Russell C. Bjork
 *
 * MODIFIED BY: Ben Rogers and Lucas deAssis
 */
public class StatusUseCase {

  /** Accessor for the one and only object of this class (singleton
   *  pattern)
   *
   *  @return the one and only object of this class
   */
  public static StatusUseCase getInstance() {
    if (theStatusUseCase == null) {
      theStatusUseCase = new StatusUseCase();
    }
    return theStatusUseCase;
  }

  /** Gets the status of the specified copy.
   *
   *  @param copy the copy whose status is being requested
   *  @return a message specifying if the copy is currently on the shelf, or with a patron
   */
  public String getStatus(Copy copy) {
    Patron checkedOutTo = copy.getCheckedOutTo();
    if (checkedOutTo == null) {
      return "Copy is on the shelf";
    } else {
      return "Checked out to " + checkedOutTo.getFullName() + " due " + copy.getDateDue();
    }

  }

  /***************************************************************************
   * PRIVATE METHOD AND VARIABLES
   **************************************************************************/

  // Private constructor - other classes should access through the singleton
  // pattern
  private StatusUseCase() {}

  // Variable used for the singleton pattern
  private static StatusUseCase theStatusUseCase;
}
