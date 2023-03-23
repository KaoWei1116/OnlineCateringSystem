/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import java.io.File;
import java.io.IOException;
import java.lang.*;
import entity.Staff;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tzeha
 */
public class AdminOperation {
    // Create Staff txt
    public void createStaffFile() {
        try {
            File obj = new File("StaffDetails.txt");
            if (obj.createNewFile()) {
                System.out.println("File Created: " + obj.getName());
            } else {
                System.out.println("File already exist.");
            }
        } catch (IOException e) {
            System.out.println("An Error occured.");
            e.printStackTrace();
        }

    }
    
    //Read Staff txt
    private Scanner scanner;
    public ArrayList<Staff> readRStaffFile(){
        ArrayList<Staff> staffList = new ArrayList<>();
     try{                 //open file
          scanner = new Scanner(new File("StaffDetails.txt"));
         
              
    }
    catch(Exception e){
          System.out.println("Error ! Could not find the file.");
    }
 
    
    scanner.useDelimiter("[|]");
       
    while(scanner.hasNext()) {      //do while loop - read file content
           String staffID = scanner.next();
           String password = scanner.next();
           String staffName = scanner.next();
           char gender = scanner.next().charAt(0);
           String personalEmail = scanner.next();
           String phone = scanner.next();

           Staff staff= new Staff(staffID, password, staffName,gender ,personalEmail, phone);
           staffList.add(staff);
           scanner.nextLine();
           
           
       }
    
       scanner.close();       //close file
       
       return staffList;

    }

    public Staff addStaff() {
        // Create object
        Staff newStaff = new Staff();
        Scanner scan = new Scanner(System.in);
        ArrayList<Staff> staffList=readRStaffFile();
        
        //default auto staff ID/username sequence
        String staffID=staffList.get(staffList.size()-1).getStaffID();
       
        // ID auto checking and define
        boolean validID = false;
        do {
            int numberInFile = Integer.parseInt(staffID.substring(1,6));

            if (numberInFile > 0 && numberInFile < 10) {
                staffID = "S0000" + (numberInFile+1);
                newStaff.setStaffID(staffID);
            } else if (numberInFile >= 10 && numberInFile < 99) {
                newStaff.setStaffID(staffID);
                staffID = "S000" + (numberInFile+1);
            } else if (numberInFile >= 100 && numberInFile < 999) {
                newStaff.setStaffID(staffID);
                staffID = "S00" + (numberInFile+1);
            } else if (numberInFile >= 1000 && numberInFile < 9999) {
                newStaff.setStaffID(staffID);
                staffID = "S0" + (numberInFile+1);
            } else if (numberInFile >= 10000 && numberInFile < 99999) {
                newStaff.setStaffID(staffID);
                staffID = "S" + (numberInFile+1);
            } else {
                System.out.println("Invalid StaffID, Check SYSTEM");
                break;
            }
        } while (validID = false);
       System.out.println("Current Staff ID: "+newStaff.getStaffID()+"\n\n");
        
        
        //input and validation for password
        boolean validPassword = false;
        do {

            System.out.println("Password must have at least one numerical character, one lowercase character and one uppercase character.");
            System.out.println("Password must also have at least one special symbol such as @,#,$,%,!,*,& and password length should be between 8 and 16.");
            String password = scan.next();

            int upperCase = 0;
            int lowerCase = 0;
            int number = 0;
            int specialCase = 0;

            for (int index = 0; index < password.length(); index++) {
                if (Character.isUpperCase(password.charAt(index))) {
                    upperCase++;
                } else if (Character.isLowerCase(password.charAt(index))) {
                    lowerCase++;
                } else if (Character.isDigit(password.charAt(index))) {
                    number++;
                } else {
                    specialCase++;
                }
            }

            if (upperCase != 0 && lowerCase != 0 && number != 0 && specialCase != 0) {
                validPassword = true;
                newStaff.setPassword(password);
            } else {
                System.out.println("Invalid Password format, Pls Try Again");
            }

        } while (validPassword == false);

        //input for staff name
        System.out.println("\n\nEnter Staff Name >");
        String name = scan.next();
        newStaff.setStaffName(name);

        //input and validation for staff gender
        boolean validGender = false;

        do {
            System.out.println("\n\nEnter Staff Gender[M=Male/F=Female] >");
            char gender = scan.next().charAt(0);

            if (gender == 'F' || gender == 'f' || gender == 'm' || gender == 'M') {
                validGender = true;
                newStaff.setGender(gender);
            } else {
                System.out.println("Invalid Gender Pls Try Again >");
            }

        } while (validGender == false);

        // Input and validation for personal email
        boolean validEmail = false;

        do {
            System.out.println("\n\nEnter Staff Personal Email >");
            String email = scan.next();

            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches() == true) {
                validEmail = true;
                newStaff.setPersonalEmail(email);
            } else {
                System.out.println("Invalid Email Format, Pls try again");
            }

        } while (validEmail == false);

        // Input and validation for phone number
        boolean validPhone = false;
        do {
            System.out.println("\n\nEnter Phone Number[011-XXXXXXXX] >");
            String phone = scan.next();

            Pattern patternPhoneNumber1 = Pattern.compile("\\d{3}-\\d{7}");
            Pattern patternPhoneNumber2 = Pattern.compile("\\d{3}-\\d{8}");
            Matcher matcherPhoneNumber1 = patternPhoneNumber1.matcher(phone);
            Matcher matcherPhoneNumber2 = patternPhoneNumber2.matcher(phone);
            if (matcherPhoneNumber1.matches()==true || matcherPhoneNumber2.matches()==true) {
                validPhone = true;
                newStaff.setPhoneNumber(phone);
            }
            else{
                System.out.println("Invalid Phone Format, Please Try Again");
            }
        } while (validPhone == false);

        System.out.println("Below is the information");
        System.out.println("=======================================================================");
        System.out.printf("|    StaffID     |       %-33s            |\n", newStaff.getStaffID());
        System.out.println("=======================================================================");
        System.out.printf("|    Password    |       %-33s            |\n", newStaff.getPassword());
        System.out.println("=======================================================================");
        System.out.printf("|    Name        |       %-33s            |\n", newStaff.getStaffName());
        System.out.println("=======================================================================");
        System.out.printf("|    Gender      |       %-33s            |\n", newStaff.getGender());
        System.out.println("=======================================================================");
        System.out.printf("|    Email       |       %-33s            |\n", newStaff.getPersonalEmail());
        System.out.println("=======================================================================");
        System.out.printf("|    Phone       |       %-33s            |\n", newStaff.getPhoneNumber());
        System.out.println("=======================================================================\n\n\n");

        boolean saveConfirmation = false;

        do {
            System.out.println("Confirm want to SAVE STAFF[Y=YES/N=NO] >");
            char confirm = scan.next().charAt(0);

            //save to txt file
            if (confirm == 'Y' || confirm == 'y') {
                addStaffToFile(newStaff);
                saveConfirmation = true;
                System.out.println("Staff Save Successful");
            } else if (confirm == 'n' || confirm != 'N') {
                saveConfirmation = true;
            } else {
                System.out.println("Invalid Input, Pls Try Again");
                saveConfirmation = false;
            }
        } while (saveConfirmation == false);

        return newStaff;
    }

    public void addStaffToFile(Staff staff) {
        try {
            FileWriter writer = new FileWriter("StaffDetails.txt", true);
            writer.write(staff.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        AdminOperation adminOperat = new AdminOperation();
        adminOperat.addStaff();
       // adminOperat.createStaffFile();
    }
}
