/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author d1P4N
 */
public class ManifestTest {
    
      // test data
    Product testProduct1 = new Product("Hammer", 3, false, false);
    Product testProduct2 = new Product("Mug Set", 8, false, true);
    Product testProduct3 = new Product("Monitor", 5, false, true);
    Product testProduct4 = new Product("Cpu", 8, false, true);
    
    Manifest testManifest1 = new Manifest();
    Manifest testManifest2 = new Manifest();
    Manifest testManifest3 = new Manifest();
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalweight");
       
        testManifest1.addProduct(testProduct3,2);
        testManifest2.addProduct(testProduct4,2);
        
        assertEquals(10, testManifest1.getTotalWeight(), 2);
        assertEquals(16, testManifest2.getTotalWeight(), 1);
    }

  

    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        testManifest1.addProduct(testProduct1);
        testManifest2.addProduct(testProduct2);
        assertEquals(false, testManifest1.isEmpty());
        assertEquals(false, testManifest2.isEmpty() );
        assertEquals(true, testManifest3.isEmpty() ); //Manifest 3 has no product added to it, hence TRUE
    }

    /**
    * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        testManifest1.addProduct(testProduct1);
        testManifest2.addProduct(testProduct2);
        assertEquals(false, testManifest1.hasFragileItems());
        assertEquals(true, testManifest2.hasFragileItems());
    }
    
}
