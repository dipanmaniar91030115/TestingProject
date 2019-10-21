/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;


import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author d1P4N
 */
public class BoxTest {
    
    
        //test data
        Product a1 = new Product("Printer", 8, false, true);
        Product a2 = new Product("Desktop", 5, false, true);
        Product a3 = new Product("Hammer", 2, false, true);
        Product a4 = new Product("Cups", 4, false, false);
        Product a5 = new Product("LPG Can", 9, true, true);
        
        Address depotAddress1 = new Address("333 Camp St", "Mt High", "Sydney", "Z6657", new Coordinates(1778, 895));
        Address depotAddress2 = new Address("67 Hataitai Rd.", "Hataitai", "Wellington", "6012", new Coordinates(1001, 8550));
        
        Address customerAddress1 = new Address("67 Torch Rd", "Treeline", "Mt High", "T799", new Coordinates(1102, 87));
        Address customerAddress2 = new Address("88 Camp Mine St", "Ridgeway", "Lowe Valley", "I998", new Coordinates(100, 34));
        
        Customer customer1 = new Customer("Andy Bravo", customerAddress1);
        Customer customer2 = new Customer("Johnny Bravo", customerAddress2);
        
        Depot depot1 = new Depot("Main Depot", depotAddress1);
        Depot depot2 = new Depot("Local Depot", depotAddress2);
        
        Box box1 = new Box(customer1, depot1);
        Box box2 = new Box(customer1, depot2);
        Box box3 = new Box(customer2, depot1);
        Box box4 = new Box(customer2, depot2);
        
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing BOX class.....");
    }
 
    /**
     * Test of getTotalWeight method, of class Box.
     */
    @Test
    public void testGetTotalWeight() {
        box1.addProduct(a1);
        box2.addProduct(a2);
        box3.addProduct(a5);
        box4.addProduct(a4);
        assertEquals(8, box1.getTotalWeight(),0);
        assertEquals(5, box2.getTotalWeight(), 0);
        assertEquals(9, box3.getTotalWeight(),0);
        assertEquals(4, box4.getTotalWeight(), 0);
    }

    /**
     * Test of canFit method, of class Box.
     */
    @Test
    public void testCanFit_Product() {
        box1.addProduct(a1,2);
        box2.addProduct(a2, 20);
        box3.addProduct(a5,2);
        box4.addProduct(a4,5);
        assertEquals(true, box1.canFit(a1,2));
        assertEquals(false, box2.canFit(a2,20));
        assertEquals(true, box3.canFit(a5,2));
        assertEquals(false, box4.canFit(a4,5));
    }

 

    /**
     * Test of remainingCapacity method, of class Box.
     */
    @Test
    public void testRemainingCapacity() {
        box1.addProduct(a3);
        box2.addProduct(a4);
        box3.addProduct(a5);
        box4.addProduct(a2);
        assertEquals(18, box1.remainingCapacity(), 0);
        assertEquals(16, box2.remainingCapacity(), 0);
        assertEquals(11, box3.remainingCapacity(), 0);
        assertEquals(15, box4.remainingCapacity(), 0);
    }

    
}

