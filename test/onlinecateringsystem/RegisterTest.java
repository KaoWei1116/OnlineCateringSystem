/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mok Chun Kit Calvin
 */
public class RegisterTest {
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("* RegisterTest: @BeforeClass method");
    }
    
    @AfterClass
    public static void tearDownClass() {
         System.out.println("* RegisterTest: @AfterClass method");
    }
    
    @Before
    public void setUp() {
         System.out.println("* RegisterTest: @Before method");
    }
    
    @After
    public void tearDown() {
         System.out.println("* RegisterTest: @After method");
    }

    /**
     * Test of getName method, of class Register.
     */
    @Test
    public void testGetName() {
        System.out.printf("\n");
        System.out.println("Test 1: Test getName() function...");
        System.out.println("Instance created ...");
        System.out.println("Tested Name : Chong Kao Wei");
        System.out.println("Expected Result : Chong Kao Wei");
        Register instance = new Register("Chong Kao Wei", "010-8181818", "001212-12-1111", "kaowei@gmail.com", "kaowei02", "Kaowei!02@");
        String expResult = "Chong Kao Wei";
        String result = instance.getName();
        assertEquals(expResult, result);
        System.out.println("Actual Result : " + result);
        if(result.equals(expResult))
        {
            System.out.println("testGetName() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testGetName() FAIL");
        }
    }

    /**
     * Test of getPhoneNumber method, of class Register.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.printf("\n");
        System.out.println("Test 2: Test getPhoneNumber() function...");
        System.out.println("Instance created ...");
        System.out.println("Tested Name : 010-8181818");
        System.out.println("Expected Result : 010-8181818");
        Register instance = new Register("Chong Kao Wei", "010-8181818", "001212-12-1111", "kaowei@gmail.com", "kaowei02", "Kaowei!02@");
        String expResult = "010-8181818";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        System.out.println("Actual Result : " + result);
        if(result.equals(expResult))
        {
            System.out.println("testGetPhoneNumber() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testGetPhoneNumber() FAIL");
        }
    }

    /**
     * Test of getIcNumber method, of class Register.
     */
    @Test
    public void testGetIcNumber() {
        System.out.printf("\n");
        System.out.println("Test 3: Test getIcNumber() function...");
        System.out.println("Instance created ...");
        System.out.println("Tested Name : 001212-12-1111");
        System.out.println("Expected Result : 001212-12-1111");
        Register instance = new Register("Chong Kao Wei", "010-8181818", "001212-12-1111", "kaowei@gmail.com", "kaowei02", "Kaowei!02@");
        String expResult = "001212-12-1111";
        String result = instance.getIcNumber();
        assertEquals(expResult, result);
        System.out.println("Actual Result : " + result);
        if(result.equals(expResult))
        {
            System.out.println("testGetIcNumber() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testGetIcNumber() FAIL");
        }
    }

    /**
     * Test of getEmailAddress method, of class Register.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.printf("\n");
        System.out.println("Test 4: Test getEmailAddress() function...");
        System.out.println("Instance created ...");
        System.out.println("Tested Name : kaowei@gmail.com");
        System.out.println("Expected Result : kaowei@gmail.com");
        Register instance = new Register("Chong Kao Wei", "010-8181818", "001212-12-1111", "kaowei@gmail.com", "kaowei02", "Kaowei!02@");
        String expResult = "kaowei@gmail.com";
        String result = instance.getEmailAddress();
        System.out.println("Actual Result : " + result);
        assertEquals(expResult, result);
        if(result.equals(expResult))
        {
            System.out.println("testGetEmailAddress() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testGetEmailAddress() FAIL");
        }
        
    }

    /**
     * Test of getUsername method, of class Register.
     */
    @Test
    public void testGetUsername() {
        System.out.printf("\n");
        System.out.println("Test 5: Test getUsername() function...");
        System.out.println("Instance created ...");
        System.out.println("Tested Name : kaowei02");
        System.out.println("Expected Result : kaowei02");
        Register instance = new Register("Chong Kao Wei", "010-8181818", "001212-12-1111", "kaowei@gmail.com", "kaowei02", "Kaowei!02@");
        String expResult = "kaowei02";
        String result = instance.getUsername();
        System.out.println("Actual Result : " + result);
        assertEquals(expResult, result);
        if(result.equals(expResult))
        {
            System.out.println("testGetUsername() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testGetUsername() FAIL");
        }
    }

    /**
     * Test of getPassword method, of class Register.
     */
    @Test
    public void testGetPassword() {
        System.out.printf("\n");
        System.out.println("Test 6: Test getPassword() function...");
        System.out.println("Instance created ...");
        System.out.println("Tested Name : kaowei02");
        System.out.println("Expected Result : kaowei02");
        Register instance = new Register("Chong Kao Wei", "010-8181818", "001212-12-1111", "kaowei@gmail.com", "kaowei02", "Kaowei!02@");
        String expResult = "Kaowei!02@";
        String result = instance.getPassword();
        System.out.println("Actual Result : " + result);
        assertEquals(expResult, result);
        if(result.equals(expResult))
        {
            System.out.println("testGetPassword() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testGetPassword() FAIL");
        }
    }

    /**
     * Test of readRegisterFile method, of class Register.
     */
    @Test
    public void testReadRegisterFile() {
        System.out.printf("\n");
        System.out.println("Test 7: Test readRegisterFile() function...");
        System.out.println("Expected Result : 3");
        Register[] registerArr = new Register[20];
        Register instance = new Register();
        //since there are 3 customer inside text file
        int expResult = 3;
        int result = instance.readRegisterFile(registerArr);
        System.out.println("Actual Result : " + result);
        assertEquals(expResult, result);
        if(result == expResult)
        {
            System.out.println("testReadRegisterFile() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testReadRegisterFile() FAIL");
        }

    }

    /**
     * Test of appendRegisterFile method, of class Register.
     */
    @Test
    public void testAppendRegisterFile() throws Exception {
        System.out.printf("\n");
        System.out.println("Test 8: Test appendRegisterFile() function...");
        System.out.println("Expected Result : 4");
        Register.appendRegisterFile("Ng Ting Shen", "010-1092223", "011012-11-1212", "tingshen@gmail.com", "tingshen02", "TingShen02!");
        Register[] registerArr = new Register[20];
        Register instance = new Register();
        //since there are 3 customers inside text file
        //if append the customer into the file, should be 4 customers inside text file
        int expResult = 4;
        int result = instance.readRegisterFile(registerArr);
        System.out.println("Actual Result : " + result);
        assertEquals(expResult, result);
        if(result == expResult)
        {
            System.out.println("testAppendRegisterFile() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testAppendRegisterFile() FAIL");
        }

        
    }

    /**
     * Test of isValidateName method, of class Register.
     */
    @Test
    public void testIsValidateName() {
        System.out.printf("\n");
        System.out.println("Test 9: Test isValidateName() function...");
        
        String name1 = "chongwei02"; 
        System.out.println("\nTested Name 1 : chongwei02 (name contain digits)");
        System.out.println("Expected Result for chongwei02: true (invalid name)");
        boolean expResultName1 = true; 
        boolean resultName1 = Register.isValidateName(name1); 
        System.out.println("Actual Result for chongwei02 : " + resultName1);
        assertEquals(expResultName1, resultName1);
        
        String name2 = "Chong Wei";
        System.out.println("\nTested Name 2 : Chong Wei");
        System.out.println("Expected Result for Chong Wei: false (valid name)");
        boolean expResultName2 = false;
        boolean resultName2 = Register.isValidateName(name2);
        System.out.println("Actual Result for Chong Wei : " + resultName2);
        assertEquals(expResultName2, resultName2);
                
        if((resultName1 == expResultName1) && (resultName2 == expResultName2))
        {
            System.out.println("testIsValidateName() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testIsValidateName() FAIL");
        }

    }
    
    /**
     * Test of isValidatePhoneNumber method, of class Register.
     */
    @Test
    public void testIsValidatePhoneNumber() {
        System.out.printf("\n");
        System.out.println("Test 10: Test isValidatePhoneNumber() function...");
        
        String phoneNumber1 = "010-86129299999";
        System.out.println("\nTested Phone Number 1 : 010-86129299999 (more than 7 or 8 digits after '-')");
        System.out.println("Expected Result for 010-86129299999: true (invalid phone number)");
        boolean expResultPhoneNumber1 = true;
        boolean resultPhoneNumber1 = Register.isValidatePhoneNumber(phoneNumber1);
        System.out.println("Actual Result for 010-86129299999 : " + resultPhoneNumber1);
        assertEquals(expResultPhoneNumber1, resultPhoneNumber1);
        
        String phoneNumber2 = "010--1119292";
        System.out.println("\nTested Phone Number 2 : 010--1119292 (invalid IC Number format)");
        System.out.println("Expected Result for 010--1119292: true (invalid phone number)");
        boolean expResultPhoneNumber2 = true;
        boolean resultPhoneNumber2 = Register.isValidatePhoneNumber(phoneNumber2);
        System.out.println("Actual Result for 010--1119292 : " + resultPhoneNumber2);
        assertEquals(expResultPhoneNumber2, resultPhoneNumber2);
        
        String phoneNumber3 = "010-1119292";
        System.out.println("\nTested Phone Number 3 : 010-1119292");
        System.out.println("Expected Result for 010-1119292: false (valid phone number)");
        boolean expResultPhoneNumber3 = false;
        boolean resultPhoneNumber3 = Register.isValidatePhoneNumber(phoneNumber3);
        System.out.println("Actual Result for 010-1119292 : " + resultPhoneNumber3);
        assertEquals(expResultPhoneNumber3, resultPhoneNumber3); 
        
        if((resultPhoneNumber1 == expResultPhoneNumber1) && (resultPhoneNumber2 == expResultPhoneNumber2) && (resultPhoneNumber3 == expResultPhoneNumber3))
        {
            System.out.println("testIsValidatePhoneNumber() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testIsValidatePhoneNumber() FAIL");
        }

    }

    /**
     * Test of isValidateICNo method, of class Register.
     */
    @Test
    public void testIsValidateICNo() {
        System.out.printf("\n");
        System.out.println("Test 11: Test isValidateICNo() function...");
        
        String ICNumber1 = "021001-111-1111";
        System.out.println("\nTested IC Number 1 : 021001-111-1111 (");
        System.out.println("Expected Result for 021001-111-1111: true (invalid IC Number format)");
        boolean expResultICNumber1 = true;
        boolean resultICNumber1 = Register.isValidateICNo(ICNumber1);
        System.out.println("Actual Result for 021001-111-1111 : " + resultICNumber1);
        assertEquals(expResultICNumber1, resultICNumber1);
        
        String ICNumber2 = "021001-11-0128";
        System.out.println("\nTested IC Number 2 : 021001-11-0128");
        System.out.println("Expected Result for 021001-11-0128: false (valid IC Number)");
        boolean expResultICNumber2 = false;
        boolean resultICNumber2 = Register.isValidateICNo(ICNumber2);
        System.out.println("Actual Result for 021001-11-0128 : " + resultICNumber2);
        assertEquals(expResultICNumber2, resultICNumber2);
        
        if((resultICNumber1 == expResultICNumber1) && (resultICNumber2 == expResultICNumber2))
        {
            System.out.println("testIsValidateICNo() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testIsValidateICNo() FAIL");
        }
       
    }

    /**
     * Test of isValidateEmailAddress method, of class Register.
     */
    @Test
    public void testIsValidateEmailAddress() {
        System.out.printf("\n");
        System.out.println("Test 12: Test isValidateEmailAddress() function...");
        
        String emailAddress1 = "Chongwei@gmail.com";
        System.out.println("\nTested Email Address 1 : Chongwei@gmail.com (first character is capital alphabet)");
        System.out.println("Expected Result for Chongwei@gmail.com: true (invalid Email Address)");
        boolean expResultEmailAddress1 = true;
        boolean resultEmailAddress1 = Register.isValidateEmailAddress(emailAddress1);
        System.out.println("Actual Result for Chongwei@gmail.com : " + resultEmailAddress1);
        assertEquals(expResultEmailAddress1, resultEmailAddress1);
        
        String emailAddress2 = "Chongwei@.com";
        System.out.println("\nTested Email Address 2 : Chongwei@.com (does not follow valid email format)");
        System.out.println("Expected Result for Chongwei@.com: true (invalid Email Address)");
        boolean expResultEmailAddress2 = true;
        boolean resultEmailAddress2 = Register.isValidateEmailAddress(emailAddress2);
        System.out.println("Actual Result for Chongwei@.com : " + resultEmailAddress2);
        assertEquals(expResultEmailAddress2, resultEmailAddress2);
        
        String emailAddress3 = "chongwei@gmail.abc";
        System.out.println("\nTested Email Address 3 : chongwei@gmail.abc (does not follow valid email format)");
        System.out.println("Expected Result for chongwei@gmail.abc: true (invalid Email Address)");
        boolean expResultEmailAddress3 = true;
        boolean resultEmailAddress3 = Register.isValidateEmailAddress(emailAddress3);
        System.out.println("Actual Result for chongwei@gmail.abc : " + resultEmailAddress3);
        assertEquals(expResultEmailAddress3, resultEmailAddress3);
        
        String emailAddress4 = "chongwei02@gmail.com";
        System.out.println("\nTested Email Address 4 : chongwei02@gmail.com");
        System.out.println("Expected Result for chongwei02@gmail.com: false (valid Email Address)");
        boolean expResultEmailAddress4 = false;
        boolean resultEmailAddress4 = Register.isValidateEmailAddress(emailAddress4);
        System.out.println("Actual Result for chongwei02@gmail.com : " + resultEmailAddress4);
        assertEquals(expResultEmailAddress4, resultEmailAddress4);
        
        if((resultEmailAddress1 == expResultEmailAddress1) && (resultEmailAddress2 == expResultEmailAddress2) && (resultEmailAddress3 == expResultEmailAddress3) && (resultEmailAddress4 == expResultEmailAddress4))
        {
            System.out.println("testIsValidateICNo() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testIsValidateICNo() FAIL");
        }
    }

    /**
     * Test of checkRegisterUsername method, of class Register.
     */
    @Test
    public void testCheckRegisterUsername() {
        System.out.printf("\n");
        System.out.println("Test 13: Test checkRegisterUsername() function...");
        
        Register[] registerArr = new Register[20];
        Register instance = new Register();
        int numOfRecords = instance.readRegisterFile(registerArr);
        
        //existing username inside the text file
        String username1 = "chaha123";
        System.out.println("\nTested Username 1 : chaha123 (existing username inside the text file)");
        System.out.println("Expected Result for chaha123: true (username is already taken)");
        boolean expResultUsername1 = true;
        boolean resultUsername1 = Register.checkRegisterUsername(username1, registerArr, numOfRecords);
        System.out.println("Actual Result for Chongwei@gmail.com : " + resultUsername1);
        assertEquals(expResultUsername1, resultUsername1);
        
        String username2 = "kaowei07";
        System.out.println("\nTested Username 2 : kaowei07");
        System.out.println("Expected Result for kaowei07: false (valid username)");
        boolean expResultUsername2 = false;
        boolean resultUsername2 = Register.checkRegisterUsername(username2, registerArr, numOfRecords);
        System.out.println("Actual Result for Chongwei@gmail.com : " + resultUsername2);
        assertEquals(expResultUsername2, resultUsername2);
        
        if((resultUsername1 == expResultUsername1) && (resultUsername2 == expResultUsername2))
        {
            System.out.println("testCheckRegisterUsername() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testCheckRegisterUsername() FAIL");
        }
        
                
    }

    /**
     * Test of isValidateUsername method, of class Register.
     */
    @Test
    public void testIsValidateUsername() {
        System.out.printf("\n");
        System.out.println("Test 14: Test isValidateUsername() function...");
        
        String username1 = "ab123";
        System.out.println("\nTested username 1 : ab123 (length < 6)");
        System.out.println("Expected Result for ab123: true (invalid username)");
        boolean expResultUsername1 = true;
        boolean resultUsername1 = Register.isValidateUsername(username1);
        System.out.println("Actual Result for ab123 : " + resultUsername1);
        assertEquals(expResultUsername1, resultUsername1);
        
        String username2 = "ab1231111111111";
        System.out.println("\nTested username 2 : ab1231111111111 (length > 14)");
        System.out.println("Expected Result for ab1231111111111: true (invalid username)");
        boolean expResultUsername2 = true;
        boolean resultUsername2 = Register.isValidateUsername(username2);
        System.out.println("Actual Result for ab1231111111111 : " + resultUsername2);
        assertEquals(expResultUsername2, resultUsername2);
        
        String username3 = "ab123111";
        System.out.println("\nTested username 3 : ab123111");
        System.out.println("Expected Result for ab123111: false (valid username)");
        boolean expResultUsername3 = false;
        boolean resultUsername3 = Register.isValidateUsername(username3);
        System.out.println("Actual Result for ab123111 : " + resultUsername3);
        assertEquals(expResultUsername3, resultUsername3);
        
        if((resultUsername1 == expResultUsername1) && (resultUsername2 == expResultUsername2) && (resultUsername3 == expResultUsername3))
        {
            System.out.println("testIsValidateUsername() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testIsValidateUsername() FAIL");
        }
    }

    /**
     * Test of isValidatePassword method, of class Register.
     */
    @Test
    public void testIsValidatePassword() {
        System.out.printf("\n");
        System.out.println("Test 15: Test isValidatePassword() function...");
        
        String password1 = "ab123A!";
        System.out.println("\nTested password 1 : ab123A! (password < 8)");
        System.out.println("Expected Result for ab123A!: true (invalid password)");
        boolean expResultPassword1 = true;
        boolean resultPassword1 = Register.isValidatePassword(password1);
        System.out.println("Actual Result for ab123A! : " + resultPassword1);
        assertEquals(expResultPassword1, resultPassword1);
        
        String password2 = "ab123A!aaaaaaa123";
        System.out.println("\nTested password 2 : ab123A!aaaaaaa123 (password > 16)");
        System.out.println("Expected Result for ab123A!aaaaaaa123: true (invalid password)");
        boolean expResultPassword2 = true;
        boolean resultPassword2 = Register.isValidatePassword(password2);
        System.out.println("Actual Result for ab123A!aaaaaaa123 : " + resultPassword2);
        assertEquals(expResultPassword2, resultPassword2);
        
        String password3 = "abcdefgh";
        System.out.println("\nTested password 3 : abcdefgh (password does not contain at least one uppercase character, number as well as special character)");
        System.out.println("Expected Result for abcdefgh: true (invalid password)");
        boolean expResultPassword3 = true;
        boolean resultPassword3 = Register.isValidatePassword(password3);
        System.out.println("Actual Result for abcdefgh : " + resultPassword3);
        assertEquals(expResultPassword3, resultPassword3);
        
        String password4 = "12345678";
        System.out.println("\nTested password 4 : 12345678 (password does not contain at least one uppercase character, lowercase character as well as special character)");
        System.out.println("Expected Result for 12345678: true (invalid password)");
        boolean expResultPassword4 = true;
        boolean resultPassword4 = Register.isValidatePassword(password4);
        System.out.println("Actual Result for 12345678 : " + resultPassword4);
        assertEquals(expResultPassword4, resultPassword4);
        
        String password5 = "ABCDEFGH";
        System.out.println("\nTested password 5 : ABCDEFGH (password does not contain at least one lowercase character, number as well as special character)");
        System.out.println("Expected Result for ABCDEFGH: true (invalid password)");
        boolean expResultPassword5 = true;
        boolean resultPassword5 = Register.isValidatePassword(password5);
        System.out.println("Actual Result for ABCDEFGH : " + resultPassword5);
        assertEquals(expResultPassword5, resultPassword5);
        
        String password6 = "Ab123!kaowei@";
        System.out.println("\nTested password 6 : Ab123!kaowei@");
        System.out.println("Expected Result for Ab123!kaowei@: false (valid password)");
        boolean expResultPassword6 = false;
        boolean resultPassword6 = Register.isValidatePassword(password6);
        System.out.println("Actual Result for ABCDEFGH : " + resultPassword6);
        assertEquals(expResultPassword6, resultPassword6);
        
        if((resultPassword1 == expResultPassword1) && (resultPassword2 == expResultPassword2) &&
           (resultPassword3 == expResultPassword3) && (resultPassword4 == expResultPassword4) &&
           (resultPassword5 == expResultPassword5) && (resultPassword6 == expResultPassword6))
        {
            System.out.println("testIsValidatePassword() passed SUCCESSFULLY");
        }
        else
        {
            System.out.println("testIsValidatePassword() FAIL");
        }
        
    }

}
