/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import library.model.Copy;
import library.model.Patron;

/** This is the controller for the use case that manages renewing copies
 *  • It provides a method to renewing the copy given.
 * 
 * @author Ben Rogers
 */
public class RenewalUseCase {
  
  /** Accessor for the one and only object of this class (singleton
   *  pattern)
   *
   *  @return the one and only object of this class
   */
  public static RenewalUseCase getInstance() {
    if (theRenewalUseCase == null) {
      theRenewalUseCase = new RenewalUseCase();
    }
    return theRenewalUseCase;
  }

  /** Start the use case
   *
   *  @param patron the patron to check out to
   *  @exception IllegalArgumentException the copy isn't, in fact, checked out
   */
  public void perform(Copy copy) throws IllegalArgumentException {
    Patron checkedOutTo = copy.getCheckedOutTo();
    copy.renew();
  }
  
  // Private constructor - other classes should access through the singleton
  // pattern
  private RenewalUseCase() {}
    
  // Variable used for the singleton pattern
  private static RenewalUseCase theRenewalUseCase;
}
