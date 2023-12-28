/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controller;

import library.gui.GUI;
import library.model.Book;
import library.model.DVD;
import library.model.Item;
import library.model.LibraryDatabase;

/** This is the controller for managing items in the database
 * It manages adding copies and adding items, both
 * books and DVDs
 *
 * @author Ben Rogers and Lucas DeAssis
 */
public class ItemUseCases {
  
  /**
   * Add copy use case - add a copy of an item
   * to the database. If the item does not exist, an
   * Illegal Argument exception is thrown. A message
   * is displayed if the operation is successful otherwise.
   * 
   * @param callNumber call number of item to make a copy of
   */
  public void addCopy(String callNumber) {
    try {
      Item item = LibraryDatabase.getInstance().getItem(callNumber);
      item.makeCopy();
      GUI.getInstance().showMessage("Copy added successfully!");
    } catch (IllegalArgumentException e) {
      GUI.getInstance().showMessage(e.getMessage());
    }
  }
  
  /**
   * Add book use case - adds a book to the database.
   * 
   * @param callName the call number of the new book
   * @param title the new book's title
   * @param author the new book's author
   * @exception IllegalArgumentException if an item with this call number is
   * already in the database
   */
  public void addItem(String callNumber,
                      String title,
                      String author) throws IllegalArgumentException {
    LibraryDatabase.getInstance().add(new Book(callNumber, title, author));
  }
  /**
   * Add DVD use case - adds a DVD to the database.
   * 
   * @param callName the call number of the new DVD
   * @param title the new DVD's title
   * @param leadActor the new DVD's lead actor
   * @param rating the new DVD's rating
   * @exception IllegalArgumentException if an item with this call number is
   * already in the database
   */
  public void addItem(String callNumber,
                      String title,
                      String leadActor,
                      String rating) throws IllegalArgumentException {
    LibraryDatabase.getInstance().add(new DVD(callNumber, title, leadActor, rating));
  }
  
  /** Cancel use case - deletes current instance.
   */
  public void cancel() {
    theItemUseCases = null;
  }
  
  /** Returns the singleton instance or creates a new one if none exists.
   * 
   * @return - the item use cases instance
   */
  public static ItemUseCases getInstance() {
    if (theItemUseCases == null) {
      theItemUseCases = new ItemUseCases();
    }
    return theItemUseCases;
  }
  
  // Private constructor - other classes should access through the singleton pattern
  private ItemUseCases() {}
  
  // Variable used for the singleton pattern
  private static ItemUseCases theItemUseCases;
}
