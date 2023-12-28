/*
 *  LibraryDatabase.java
 */

package library.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import java.io.FileNotFoundException;
import java.util.Iterator;

/** A singleton object of this class represents the library's database
 *
 * @author  Russell C. Bjork
 *
 * MODIFIED BY: Ben Rogers, Lucas DeAssis
 */
public class LibraryDatabase implements java.io.Serializable {
  // The one and only instance of this class
  private static LibraryDatabase theLibraryDatabase;

  // Name to use for saved database
  private static final String SAVED_DATABASE_NAME = "library.database";

  // Symbolic constant needed to prevent unnecessary ClassCastExceptions
  // when reading a serialized object created by an earlier version of this
  // class
  static final long serialVersionUID = 1;
  
  // The patrons and items in this database
  private TreeMap<String, Patron> patrons;
  private TreeMap<String, Item> items;

  /** Accessor for the one and only object of this class (singleton
   *  pattern)
   *
   *  @return the one and only object of this class
   */
  public static LibraryDatabase getInstance() {
    if (theLibraryDatabase == null) {
      try {
        ObjectInputStream stream = new ObjectInputStream(
          new FileInputStream(SAVED_DATABASE_NAME));
        theLibraryDatabase = (LibraryDatabase) stream.readObject();
        stream.close();
      } catch(FileNotFoundException e) {
        new LibraryDatabase();
      } catch(Throwable e) {
        System.err.println("Unexpected exception " + e);
        e.printStackTrace(System.err);
        System.exit(1);
      }
    }
    return theLibraryDatabase;
  }

  /** Save the library database
   *
   *  @exception Exception any Exception thrown during the save is propagated
   */
  public void save() throws Exception {
    ObjectOutputStream stream = new ObjectOutputStream(
    new FileOutputStream(SAVED_DATABASE_NAME));
    stream.writeObject(theLibraryDatabase);
    stream.close();
  }

  /** Add a patron to the list of patrons
   *
   *  @param patron the patron to add
   *	@exception IllegalArgumentException if a patron with this phone number is
   *			   already in the database
   */
  public void add(Patron patron) throws IllegalArgumentException {
    if (patrons.containsKey(patron.getPhoneNumber())) {
      throw new IllegalArgumentException("This patron already exists");
    }
    patrons.put(patron.getPhoneNumber(), patron);
  }

  /** Add an item to the list of items, but only keeps it in the database for reference;
   *  there isn't a copy available to the public yet
   *
   *  @param item the item to add
   *	@exception IllegalArgumentException if an item with this call number is
   *			   already in the database
   */
  public void add(Item item) throws IllegalArgumentException {
    if (items.containsKey(item.getCallNumber())) {
      throw new IllegalArgumentException("This item already exists");
    }
    items.put(item.getCallNumber(), item);
  }

  /** Get the patron having a given phone number
   *
   *  @param phoneNumber the phone number of the patron
   *  @return the patron having this phone number
   *  @exception IllegalArgumentException if this patron does not exist
   */
  public Patron getPatron(String phoneNumber) {
    if (!patrons.containsKey(phoneNumber)) {
      throw new IllegalArgumentException("This patron does not exist");
    }
    return patrons.get(phoneNumber);
  }

  /** Get the item having a given call number
   *
   *  @param callNumber the call number of the item
   *  @return the patron having this phone number
   *  @exception IllegalArgumentException if this item does not exist
   */
  public Item getItem(String callNumber) throws IllegalArgumentException {
    if (!items.containsKey(callNumber)) {
      throw new IllegalArgumentException("This item does not exist");
    }
    return items.get(callNumber);
  }
  
  /** Get an iterator over all items in the database
   * 
   * @return the iterator of items in the database
   */
  public Iterator<Item> getItemIterator() {
    return items.values().iterator();
  }
  
  /** Accessor for number of items in the database
   * 
   * @return number of items in the database
   */
  public int getNumberOfItems() {
    return items.size();
  }

  /** Get the copy having a given call number and copy number
   *
   *  @param callNumber the call number of the copy
   *  @param copyNumber the copy number of the copy
   *  @return the copy having this call number and copy number
   *  @exception IllegalArgumentException if this copy does not exist
   */
    public Copy getCopy(String callNumber, int copyNumber) throws IllegalArgumentException {
      return getItem(callNumber).getCopy(copyNumber);
  }
  
  /** Produce an item report by printing information on each item
   * 
   * @param itemType - type of item to make report for
   */
  public void produceItemReport(String itemType) {
    Iterator<Item> itemIterator = getItemIterator();
    
    System.out.println();
    if (itemType.equals("Books")) { // Report only books
      System.out.println("=============== REPORT BOOKS ===============");
      while (itemIterator.hasNext()) {
        Item currentItem = itemIterator.next();
        if (currentItem instanceof Book) {
          produceItemReportAux(currentItem);
        }
      }
    } else if (itemType.equals("DVDs")) { // Report only DVDs
      System.out.println("=============== REPORT DVDS ================");
      while (itemIterator.hasNext()) {
        Item currentItem = itemIterator.next();
        if (currentItem instanceof DVD) {
          produceItemReportAux(currentItem);
        }
      }
    } else { // Report everything
      System.out.println("============= REPORT ALL ITEMS =============");
      while (itemIterator.hasNext()) {
        Item currentItem = itemIterator.next();
        produceItemReportAux(currentItem);
      }
    }
    System.out.println("============================================");
  }
  
  /** Helper function for produceItemReport to avoid copying too much code
   * 
   * @param item - item to make a report for
   */
  private void produceItemReportAux(Item currentItem) {
    // Print item description
    System.out.println(currentItem.getDescription() + ": " 
        + currentItem.getCallNumber());
          
    // Print number of copies for this item
    TreeMap<Integer, Copy> copies = currentItem.getCopies();
    System.out.println("Copies for this item:         " + copies.size());
          
    // Print number of copies checked out
    Iterator<Copy> copyIterator = copies.values().iterator();
    int numCheckedOut = 0;
    while (copyIterator.hasNext()) {
      if (copyIterator.next().isCheckedOut()) {
        numCheckedOut++;
      }
    }
    System.out.println("Number of copies on shelf:    " + (copies.size() - numCheckedOut));
    System.out.println("Number of copies checked out: " + numCheckedOut);
          
    // Print copies on hold and item reservations.
    //////////// NOT IMPLEMENTED FOR THIS ITERATION /////////////
    System.out.println("Number of copies on hold:     0");
    System.out.println("Number of reservations:       0");
    System.out.println("--------------------------------------------");
  }

  /** Produces report for all patrons
   * 
   *  @param justTheOnes if true only report tardy patrons, otherwise report all patrons.
   */
  public void producePatronReport(boolean justTheOnesOverdue) {
    Iterator<Patron> patronIterator = patrons.values().iterator();

    // Print the appropriate header for the requested report, with new lines before and
    // after the header.
    System.out.printf(justTheOnesOverdue?
                      "%n=========== REPORT TARDY PATRONS ===========%n":
                      "%n============ REPORT ALL PATRONS ============%n");

    while (patronIterator.hasNext()) {
      Patron patron = patronIterator.next();
      boolean tardyPatron = patron.getNumberOverdue() > 0;

      // If we're reporting all patrons, or if we're only reporting tardy ones,
      if (!justTheOnesOverdue || tardyPatron) {

        // produce their personal information, and their check out summary. Optionally,
        // if the patron has copies overdue, then create a new line to start reporting
        // those.
        System.out.printf("Name:           %s%n" +
                          "Address:        %s%n" +
                          "Phone Number:   %s%n" +
                          "Copies out:     %d%n" +
                          "Copies overdue: %s%n" +
                          (tardyPatron? "%n": ""),
                          patron.getFullName(),
                          patron.getAddress(),
                          patron.getPhoneNumber(),
                          patron.getCurrentCopiesOut(),
                          patron.getNumberOverdue());

        // If there are any overdue copies, print their respective information out.
        Iterator<Copy> copyIterator = patron.getCopiesCheckedOut();
        while (copyIterator.hasNext()) {
          Copy copy = copyIterator.next();
          if (copy.isOverdue()) {
            System.out.println(copy.getDescription() + ". Due: " + copy.getDateDue());
          }
        }
        // Put this line between patrons if there's another patron to report,
        if (patronIterator.hasNext()) {
          System.out.println("--------------------------------------------");
        }
      }
    }

    // otherwise end with a dashed double-line.
    System.out.println("============================================");
  }

  // Private constructor.  Other classes should access through the singleton
  // pattern
  private LibraryDatabase() {
    theLibraryDatabase = this;

    // Constructors for collections
    patrons = new TreeMap<String, Patron>();
    items = new TreeMap<String, Item>();
    
    createDummyData();
  }

  // Populate the database with dummy data.  Needed only until code for
  // adding patrons, etc. has been written
  private void createDummyData()  {
    Patron aardvark = new Patron("Anthony",
                                 "Aardvark",
                                 "Winn Subbasement",
                                 "1");
    add(aardvark);
    Patron buffalo = new Patron("Boris",
                                "Buffalo",
                                "Hamilton Common",
                                "2");
    add(buffalo);
    Patron cat = new Patron("Charlene",
                            "Cat",
                            "Gordon College",
                            "3");
    add(cat);

    Book lisp = new Book("QA", "Lisp", "Winston, Patrick");
    add(lisp);
    Copy lisp1 = lisp.makeCopy();
    Copy lisp2 = lisp.makeCopy();

    DVD shrek = new DVD("PN", "Shrek", "Myers, Mike", "PG");
    add(shrek);
    Copy shrek1 = shrek.makeCopy();
    Copy shrek2 = shrek.makeCopy();
    
    Book f451 = new Book("FA", "Fahrenheit 451", "Bradbury, Ray");
    add(f451);
    Copy f451Copy1 = f451.makeCopy();
    Copy f451Copy2 = f451.makeCopy();
    
    Book maze = new Book("MR", "Maze Runner", "Dashner, James");
    add(maze);
    Copy maze1 = maze.makeCopy();
    Copy maze2 = maze.makeCopy();

    DVD starWars = new DVD("SW", "Star Wars", "Hamill, Mark", "PG");
    add(starWars);
    Copy starWars1 = starWars.makeCopy();
    Copy starWars2 = starWars.makeCopy();
  }
}
