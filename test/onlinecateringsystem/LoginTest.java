/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Chong Kao Wei
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* LoginTest: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("* LoginTest: @AfterClass method");
    }
    
    @Before
    public void setUp() {
         System.out.println("* LoginTest: @Before method");
    }
    
    @After
    public void tearDown() {
         System.out.println("* LoginTest: @After method");
    }

    /**
     * Test of loginPage method, of class Login.
     */
    @Test
    public void testLoginPage() throws Exception {
        int correct = 0;
        
        System.out.println("Test 1: Test loginPage() function...");
        System.out.println("Instance created ...");
        System.out.println("\nTest 1.1: Both username and password is correct");
        System.out.println("Tested Data : username = \"chaha123\", password = \"1234567Aa!\"");
        System.out.println("Expected Result : 1");
        Login result = new Login();
        assertEquals(1, result.check("chaha123", "1234567Aa!"));
        System.out.println("Actual Result : " + result.check("chaha123", "1234567Aa!"));
        if(result.check("chaha123", "1234567Aa!") == 1)
        {
            System.out.println("Test 1.1 passed SUCCESSFULLY");
            correct++;
        }
        else
            System.out.println("Test 1.1 FAIL");
        
        System.out.println("\nTest 1.2: Username is wrong but password is correct");
        System.out.println("Tested Data : username = \"123\", password = \"1234567Aa!\"");
        System.out.println("Expected Result : 2");
        assertEquals(2, result.check("123", "1234567Aa!"));
        System.out.println("Actual Result : " + result.check("123", "1234567Aa!"));
        if(result.check("123", "1234567Aa!") == 2)
        {
            System.out.println("Test 1.2 passed SUCCESSFULLY");
            correct++;
        }
        else
            System.out.println("Test 1.2 FAIL");
        
        System.out.println("\nTest 1.3: Username is correct but password is wrong");
        System.out.println("Tested Data : username = \"chaha123\", password = \"123\"");
        System.out.println("Expected Result : 3");
        assertEquals(3, result.check("chaha123", "123"));
        System.out.println("Actual Result : " + result.check("chaha123", "123"));
        if(result.check("chaha123", "123") == 3)
        {
            System.out.println("Test 1.3 passed SUCCESSFULLY");
            correct++;
        }
        else
            System.out.println("Test 1.3 FAIL");
        
        System.out.println("\nTest 1.4: Both username and password is correct but not belong to same user");
        System.out.println("Tested Data : username = \"chaha123\", password = \"Ts129394$5\"");
        System.out.println("Expected Result : 4");
        assertEquals(4, result.check("chaha123", "Ts129394$5"));
        System.out.println("Actual Result : " + result.check("chaha123", "Ts129394$5"));
        if(result.check("chaha123", "Ts129394$5") == 4)
        {
            System.out.println("Test 1.4 passed SUCCESSFULLY");
            correct++;
        }
        else
            System.out.println("Test 1.4 FAIL");
        
        System.out.println("\nTest 1.5: Both username and password is wrong");
        System.out.println("Tested Data : username = \"123\", password = \"123\"");
        System.out.println("Expected Result : 5");
        assertEquals(5, result.check("123", "123"));
        System.out.println("Actual Result : " + result.check("123", "123"));
        if(result.check("123", "123") == 5)
        {
            System.out.println("Test 1.5 passed SUCCESSFULLY");
            correct++;
        }
        else
            System.out.println("Test 1.5 FAIL");
        
        if(correct == 5)
            System.out.println("\ntestLoginPage() passed SUCCESSFULLY");
        else
            System.out.println("\ntestLoginPage() FAIL");
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
}
