/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import packer.Address;
import packer.Coordinates;
import packer.Customer;
import packer.Depot;

/**
 *
 * @author d1P4N
 */
public class PackerTest {
    
    public PackerTest() {
}
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing PACKER class.....");
    }
    
    

    /**
     * Test of packProducts method, of class Packer.
     */
    @Test
    public void testPackProducts() {
        System.out.println("packProducts");
        Customer c = null;
        Depot d = null;
        Manifest m = null;
        List<Box> expResult = null;
        List<Box> result = Packer.packProducts(c, d, m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
