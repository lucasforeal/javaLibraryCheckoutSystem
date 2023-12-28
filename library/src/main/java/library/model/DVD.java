/*
 *  DVD.java
 */

package library.model;

/** Representation for a DVD
 *
 * @author  Russell C. Bjork
 *
 * MODIFIED BY: Ben Rogers, Lucas DeAssis
 */
public class DVD extends Item {
  
  // Immutable DVD attributes
  private final String title, leadActor, rating;

  /** Constructor
   *
   *  @param callNumber the call number of this DVD
   *  @param title the title of this DVD
   *  @param leadActor the lead actor of this DVD
   *	@param rating the rating of this DVD
   */
  public DVD(String callNumber, String title, String leadActor, String rating)  {
    super(callNumber);
    this.title = title;
    this.leadActor = leadActor;
    this.rating = rating;
  }

  // Implementation of abstract methods of base class

  public String getDescription() {
    return title + " featuring " + leadActor + ", rated " + rating;
  }

  public int getCheckoutPeriod() {
    return 7;
  }

  public int getAllowedNumberOfRenewals() {
    return 0;
  }
}
