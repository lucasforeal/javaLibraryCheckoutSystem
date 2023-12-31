/* LibraryDatabaseTest.java
 */

package library;

import junit.framework.TestCase;
import library.model.LibraryDatabase;

/** Tester for the library.model.LibraryDatabase class - full implementation for iteration 1
 *
 *	@author: Russell C. Bjork
 *
 *	MODIFIED BY:
 */
public class LibraryDatabaseTest extends TestCase {
    
    public LibraryDatabaseTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getInstance method, of class LibraryDatabase.
     */
    public void testGetInstance() {
        System.out.println("getInstance");
        LibraryDatabase db1 = LibraryDatabase.getInstance();
        LibraryDatabase db2 = LibraryDatabase.getInstance();
        // Singleton pattern should yield same value both times
        assertEquals(db1, db2);
   }

    /**
     * Test of save method, of class LibraryDatabase.
     */
    public void testSave() throws Exception {
        System.out.println("save is not tested");
    }

    /**
     * Test of add method, of class LibraryDatabase.
     */
    public void testAdd_Patron() {
        System.out.println("add for patron will be tested wtih getPatron()");
    }

    /**
     * Test of add method, of class LibraryDatabase.
     */
    public void testAdd_Item() {
        System.out.println("add for item will be tested with getItem()");
    }

    /**
     * Test of getPatron method, of class LibraryDatabase.
     */
    public void testGetPatron() {
        System.out.println("getPatron");
        LibraryDatabase instance = LibraryDatabase.getInstance();
        // A oatron with phone number "1" and name "Anthony Aardvark" and
        // one with phone number "2" and name "Boris Buffalo" 
        // are added by createDummyData.  To make the tests continue to work 
        // during iteration 2, the comment out for the following two 
        // lines must be removed
        // instance.add(new Patron("Anthony", "Aardark", "Winn Subbasement", "1"));
        // instance.add(new Patron("Boris", "Buffalo", "Hamilton Common", "2"));
        assertEquals("Anthony Aardvark", instance.getPatron("1").getFullName());
        assertEquals("Boris Buffalo", instance.getPatron("2").getFullName());
        try
        {
            instance.getPatron("99");
            fail("Should have thrown an IllegalArgumentException");
        }
        catch(IllegalArgumentException e)
        { /* This is OK */ }
    }

    /**
     * Test of getItem method, of class LibraryDatabase.
     */
    public void testGetItem() {
        System.out.println("getItem");
        LibraryDatabase instance = LibraryDatabase.getInstance();
        // A book with call number "QA" and and a DVD with call number "PN"
        // are added by createDummyData.  To make the tests continue to work 
        // during iteration 2, the comment out for the following two 
        // lines must be removed
        // instance.add(new Book("QA", "Lisp", "Winston"));
        // instance.add(new DVD("PN", "Shrek", "Myers"));
        assertEquals("Lisp by Winston, Patrick.", instance.getItem("QA").getDescription());
        assertEquals("Shrek featuring Myers, Mike, rated PG.", instance.getItem("PN").getDescription());
        try
        {
            instance.getItem("ZZ");
            fail("Should have thrown an IllegalArgumentException");
        }
        catch(IllegalArgumentException e)
        { /* This is OK */ }
    }

    /**
     * Test of getCopy method, of class LibraryDatabase.
     */
    public void testGetCopy() {
        System.out.println("getCopy");
        LibraryDatabase instance = LibraryDatabase.getInstance();
        // A book with call number "QA" and and a DVD with call number "PN"
        // are added by createDummyData, as are two copies of each.
        // To make the tests continue to work during iteration 2, the comment 
        // out for the following lines must be removed
        // instance.add(new Book("QA", "Lisp", "Winston"));
        // instance.add(new DVD("PN", "Shrek", "Myers"));
        // Item book = instance.getItem("QA");
        // book.makeCopy();
        // book.makeCopy();
        // Item dvd = instance.getItem("PN");
        // dvd.makeCopy();
        // dvd.makeCopy();
        assertEquals("QA", instance.getCopy("QA", 1).getCallNumber());
        assertEquals(1, instance.getCopy("QA", 1).getCopyNumber());
        assertEquals("QA", instance.getCopy("QA", 2).getCallNumber());
        assertEquals(2, instance.getCopy("QA", 2).getCopyNumber());
        assertEquals("PN", instance.getCopy("PN", 1).getCallNumber());
        assertEquals(1, instance.getCopy("PN", 1).getCopyNumber());
        assertEquals("PN", instance.getCopy("PN", 2).getCallNumber());
        assertEquals(2, instance.getCopy("PN", 2).getCopyNumber());
        try
        {
            // If this part fails, it might be because our current library (which was
            // changed through the GUI) has a third copy, which was created outside this
            // test. I.e. because this test uses the same singleton LibraryDatabase, as
            // the GUI, if we created a third QA copy in the GUI, the copy would legitimately
            // be there, so this test would fail expectedly
            instance.getCopy("QA", 3);
            fail("Should have thrown an IllegalArgumentException");
        }
        catch(IllegalArgumentException e)
        { /* This is OK */ }
    }
    
}
