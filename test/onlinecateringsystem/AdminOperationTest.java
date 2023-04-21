/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import entity.Staff;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tzeha
 */
public class AdminOperationTest {

    public AdminOperationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* AddStaffTest: @BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("* AddStaffTest: @AfterClass method");

    }

    @Before
    public void setUp() {
        System.out.println("* AddStaffTest: @Before method");

    }

    @After
    public void tearDown() {
        System.out.println("* AddStaffTest: @After method");

    }

    /**
     * Test of createStaffFile method, of class AdminOperation.
     */
    @Test
    public void testCreateStaffFile() {
        System.out.println("createStaffFile");
        AdminOperation instance = new AdminOperation();
        instance.createStaffFile();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of readRStaffFile method, of class AdminOperation.
     */
    @Test
    public void testReadRStaffFile() {
        System.out.println("readRStaffFile");
        AdminOperation instance = new AdminOperation();
        Staff exp1 = new Staff("S00001", "Tzehao_0131", "020111101192", "Henry", 'M', "tzehaoheng@gmail.com", "011-11969296");
        Staff exp2 = new Staff("S00002", "12345Aa!", "020111101193", "HHHHH", 'F', "hahha@gmail.com", "011-11969296");
        //  ArrayList<Staff> expResult = new ArrayList<>();
        ArrayList<Staff> result = instance.readRStaffFile();
        int expResult = 2;
        if (result.size() == expResult) {
            System.out.println("testReadRegisterFile() passed SUCCESSFULLY");
        } else {
            System.out.println("testReadRegisterFile() FAIL");
        }
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addStaff method, of class AdminOperation.
     */
    @Test
    public void testAddStaff() {
        System.out.println("addStaff");
        AdminOperation instance = new AdminOperation();
        Staff expResult = new Staff("S00010", "020202101111", "020202101111", "Kenry", 'M', "kenru@gmail.com", "011-2233456");
        Staff result = new Staff("S00010", "020202101111", "020202101111", "Kenry", 'M', "kenru@gmail.com", "011-2233456");

        //Staff result = instance.addStaff();
        /*result.setStaffID("S00010");
        result.setStaffIC("020202101111");
        result.setPassword("020202101111");
        result.setStaffName("Kenry");
        result.setGender('M');
        result.setPersonalEmail("kenru@gmail.com");
        result.setPhoneNumber("011-2233456");
         */
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addStaffToFile method, of class AdminOperation.
     */
    @Test
    public void testAddStaffToFile() {
        System.out.println("addStaffToFile");
        Staff validStaff = new Staff("S00001", "020131101193", "020131101193", "Henry", 'm', "tzehaoheng@gmail.com", "011-11969296");
        AdminOperation instance = new AdminOperation();
        boolean findValid = false;
        boolean findInvalid = false;
        instance.addStaffToFile(validStaff);
        ArrayList<Staff> staffList = instance.readRStaffFile();
        for (int index = 0; index < staffList.size(); index++) {
            if (staffList.get(index).getStaffID().equals("S00001") == true) {
                findValid = true;
            }
        }

        for (int index = 0; index < staffList.size(); index++) {
            if (staffList.get(index).getStaffID().equals("S00010") == true) {
                findInvalid = true;
            }
        }
        System.out.println("Valid Staff ID :S00001 > " + findValid);
        System.out.println("Invalid Staff ID :S00010 > " + findInvalid);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSession method, of class AdminOperation.
     */
    @Test
    public void testGetSession() {
        System.out.println("getSession");
        Staff staff = null;
        AdminOperation instance = new AdminOperation();
        Staff expResult = null;
        Staff result = instance.getSession(staff);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of main method, of class AdminOperation.
     */
}
