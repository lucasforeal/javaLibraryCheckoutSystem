/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import library.model.Book;
import library.model.Copy;
import library.model.Item;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 *
 * @author bjork
 */
public class ItemTest {
    
    public ItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeCopy method, of class Item.
     */
    @Test
    public void testMakeCopy() {
        System.out.println("makeCopy");
        Item instance = new Book("QA", "LISP", "Winston");
        String expResult1 = "QA";
        int expResult2 = 2;
        Copy copy1 = instance.makeCopy();
        Copy result = instance.makeCopy();
        assertEquals(expResult1, result.getCallNumber());
        assertEquals(expResult2, result.getCopyNumber());
     }
    
    /**
     * Test of getCopy method, of class Item
     */
    @Test
    public void testGetCopy() {
        System.out.println("getCopy");
        Item instance = new Book("QA", "LISP", "Winston");
        Copy copy1 = instance.makeCopy();
        Copy copy2 = instance.makeCopy();
        assertEquals(copy1, instance.getCopy(1));
        assertEquals(copy2, instance.getCopy(2));
    }

    /**
     * Test of getCopies method, of class Item
     */
    @Test
    public void testGetCopies() {
        System.out.println("getCopy");
        Item instance = new Book("QA", "LISP", "Winston");
        Copy copy1 = instance.makeCopy();
        Copy copy2 = instance.makeCopy();

        // Create a map with the copies above
        TreeMap<Integer, Copy> copies = new TreeMap<Integer, Copy>();
        copies.put(1, copy1);
        copies.put(2, copy2);

        assertEquals(copies, instance.getCopies());
    }

    /**
     * Test of getCallNumber method, of class Item.
     */
    @Test
    public void testGetCallNumber() {
        System.out.println("getCallNumber");
        Item instance = new Book("QA", "LISP", "Winston");
        String expResult = "QA";
        String result = instance.getCallNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Item.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription is an abstract method tested for each concrete subclass");
    }

    /**
     * Test of getCheckoutPeriod method, of class Item.
     */
    @Test
    public void testGetCheckoutPeriod() {
        System.out.println("getCheckoutPeriod  is an abstract method tested for each concrete subclass");
    }

    /**
     * Test of getAllowedNumberOfRenewals method, of class Item.
     */
    @Test
    public void testGetAllowedNumberOfRenewals() {
        System.out.println("getAllowedNumberOfRenewals is an abstract method tested for each concrete subclass");
    }
}
