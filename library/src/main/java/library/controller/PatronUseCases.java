/*
 * PatronUseCases.java
 */

package library.controller;

import library.gui.GUI;
import library.model.LibraryDatabase;
import library.model.Patron;

/** This is the controller for the use cases for managing patrons in
 * the database
 *  • It handles adding patrons to the database.
 * 
 * @author Ben Rogers and Lucas DeAssis
 */
public class PatronUseCases {
  
  /** Returns the singleton instance of the Patron use cases
   * creates a new instance if none exists.
   * 
   * @return the patron use cases instance
   */
  public static PatronUseCases getInstance() {
    if (thePatronUseCases == null) {
      thePatronUseCases = new PatronUseCases();
    }
    return thePatronUseCases;
  }
  
  
  /** Add patron use case - adds a new patron to the database
   * 
   * @param firstName - first name of new patron
   * @param lastName - last name of new patron
   * @param address - address of new patron
   * @param phoneNumber - phone number of new patron
   * @throws IllegalArgumentException if a patron with this phone number is
   *			   already in the database
   */
  public void addPatron(String firstName,
                        String lastName, 
                        String address,
                        String phoneNumber) throws IllegalArgumentException {
    Patron patron = new Patron(firstName, lastName, address, phoneNumber);
    LibraryDatabase.getInstance().add(patron);
  }
  
  /** Cancel use case - deletes current instance
   * 
   */
  public void cancel() {
    thePatronUseCases = null;
  }
  
  private PatronUseCases() {
  }
  
  private static PatronUseCases thePatronUseCases;
}
