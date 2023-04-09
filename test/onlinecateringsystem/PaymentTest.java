/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import entity.Order;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ooi Chin Hui
 */
public class PaymentTest {

    public PaymentTest() {
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
     * Test of generatePayment method, of class Payment.
     */
    @Test
    public void testGeneratePayment() {
        System.out.println("generatePayment");
        Order currentOrder = null;
        Payment instance = new Payment();
        instance.generatePayment(currentOrder);
    }

    /**
     * Test of makePayment method, of class Payment.
     */
    @Test
    public void testMakePayment() {
        System.out.println("makePayment");
        Order currentOrder = null;
        Payment instance = new Payment();
        boolean expResult = false;
        boolean result = instance.makePayment(currentOrder);
        assertEquals(expResult, result);
    }

    /**
     * Test of printReceiptMenu method, of class Payment.
     */
    @Test
    public void testPrintReceiptMenu() throws Exception {
        System.out.println("printReceiptMenu");
        String userName = "";
        Order currentOrder = null;
        Payment instance = new Payment();
        instance.printReceiptMenu(userName, currentOrder);
    }

    /**
     * Test of formatReceipt method, of class Payment.
     */
    @Test
    public void testFormatReceipt() {
        System.out.println("formatReceipt");
        String userName = "";
        Order currentOrder = null;
        Payment instance = new Payment();
        String expResult = "";
        String result = instance.formatReceipt(userName, currentOrder);
        assertEquals(expResult, result);
    }

    /**
     * Test of printReceipt method, of class Payment.
     */
    @Test
    public void testPrintReceipt() throws Exception {
        System.out.println("printReceipt");
        String userName = "";
        Order currentOrder = null;
        Payment instance = new Payment();
        instance.printReceipt(userName, currentOrder);
    }

}
