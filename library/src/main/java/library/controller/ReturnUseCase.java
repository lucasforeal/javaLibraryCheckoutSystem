/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import library.model.Copy;
import library.model.Patron;

/** This is the controller for the use case that manages returning copies
 *  • It provides a method to return the copy given.
 * 
 * @author Ben Rogers
 */
public class ReturnUseCase {
  
  /** Accessor for the one and only object of this class (singleton
   *  pattern)
   *
   *  @return the one and only object of this class
   */
  public static ReturnUseCase getInstance() {
    if (theReturnUseCase == null) {
      theReturnUseCase = new ReturnUseCase();
    }
    return theReturnUseCase;
  }

  /** Start the use case
   *
   *  @param patron the patron to check out to
   *  @exception IllegalArgumentException if the copy isn't yet checked out
   */
  public void perform(Copy copy) throws IllegalArgumentException {
    Patron checkedOutTo = copy.getCheckedOutTo();
    checkedOutTo.returnCopy(copy);
    copy.recordReturn();
  }
  
  // Private constructor - other classes should access through the singleton
  // pattern
  private ReturnUseCase() {}
    
  // Variable used for the singleton pattern
  private static ReturnUseCase theReturnUseCase;
}
