/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import library.model.LibraryDatabase;

/** Controller for printing item and patron reports
 *
 * @author Ben Rogers and Lucas DeAssis
 */
public class ReportsUseCases {
  
  /** Accessor for the one and only object of this class (singleton
   *  pattern)
   *
   *  @return the one and only object of this class
   */
  public static ReportsUseCases getInstance() {
    if (theReportsUseCases == null) {
      theReportsUseCases = new ReportsUseCases();
    }
    return theReportsUseCases;
  }
  
  /** Produce report on all items in the database
   *  Report includes:
   *    1. Call number and book/dvd specific information
   *    2. Total number of copies currently owned including...
   *       a. Number of copies currently on shelf
   *       b. Number of copies currently checked out
   *       c. Number of copies on hold for some patron
   *    3. Number of reservations pending for the item
   */
  public void produceItemReport(String itemType) {
    LibraryDatabase.getInstance().produceItemReport(itemType);
  }

  /** Produce report on all items in the database
   *  Report includes:
   *    1. The patron's full name, address, and phone number
   *    2. Total number of copies currently lent, and the number
   *    overdue
   *    3. If there are any copies overdue, their description and
   *    date overdue for this patron
   */
  public void producePatronReport(boolean justTheOnesOverdue) {
    LibraryDatabase.getInstance().producePatronReport(justTheOnesOverdue);
  }
  
  // Private constructor - other classes should access through the singleton
  // pattern
  private ReportsUseCases() {}
  
  // Variable used for the singleton pattern
  private static ReportsUseCases theReportsUseCases;
}
