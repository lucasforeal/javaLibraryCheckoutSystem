/*
 *  Book.java
 */

package library.model;

/** Representation for a book
 *
 * @author  Russell C. Bjork
 *
 * MODIFIED BY: Ben Rogers, Lucas DeAssis
 */
public class Book extends Item {
  
  // Immutable book attributes
  private final String title, author;

  /** Constructor
   *
   *  @param callNumber the call number of this book
   *  @param title the title of this book
   *  @param author the principal author of this book
   */
  public Book(String callNumber, String title, String author) {
    super(callNumber);
    this.title = title;
    this.author = author;
  }

  // Implementation of abstract methods of base class

  public String getDescription() {
    return title + " by " + author;
  }

  public int getCheckoutPeriod() {
    return 28;
  }

  public int getAllowedNumberOfRenewals() {
    return 1;
  }
}
