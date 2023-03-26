/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

/**
 *
 * @author tzeha
 */
import java.io.File;
import java.util.Scanner;


public class viewUserProfile {
    
    
    public static void viewUserProfile(String finalUsername) {
        Register[] registerArr = new Register[20];
        int numRecordsExist = 0;
        Register viewUserProfile = new Register();
        
        numRecordsExist = viewUserProfile.readRegisterFile(registerArr);

        for(int i = 0; i < numRecordsExist; i++)
        {
            if(finalUsername.compareTo(registerArr[i].getUsername()) == 0) {
                System.out.printf("\n+----------------------------------------------------------------------------------+");
                System.out.printf("\n%-50s : %-30s|", "| Name : " ,registerArr[i].getName());
                System.out.printf("\n+----------------------------------------------------------------------------------+");
                System.out.printf("\n%-50s : %-30s|", "| Phone Number : " ,registerArr[i].getPhoneNumber());
                System.out.printf("\n+----------------------------------------------------------------------------------+");
                System.out.printf("\n%-50s : %-30s|", "| IC Number : " ,registerArr[i].getIcNumber());
                System.out.printf("\n+----------------------------------------------------------------------------------+");
                System.out.printf("\n%-50s : %-30s|", "| Email Address : " ,registerArr[i].getEmailAddress());
                System.out.printf("\n+----------------------------------------------------------------------------------+");
                break;
                
            }
        }
        

        
            
            
    }
            
}