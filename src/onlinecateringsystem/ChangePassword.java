/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import entity.Staff;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tzeha
 */
public class ChangePassword {

    String username;
    String password;
    String newPassword;
    String confirmPassword;
    ArrayList<Staff> staffList = new ArrayList<Staff>();
    Staff onSession;
    private Scanner scanner;

    public ChangePassword() {
    }

    public ArrayList<Staff> readStaffList() {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {                 //open file
            scanner = new Scanner(new File("StaffDetails.txt"));

        } catch (Exception e) {
            System.out.println("Error ! Could not find the file.");
        }

        scanner.useDelimiter("[|]");

        while (scanner.hasNext()) {      //do while loop - read file content
            String staffID = scanner.next();
            String password = scanner.next();
            String staffIC = scanner.next();
            String staffName = scanner.next();
            char gender = scanner.next().charAt(0);
            String personalEmail = scanner.next();
            String phone = scanner.next();

            Staff staff = new Staff(staffID, password, staffIC, staffName, gender, personalEmail, phone);
            staffList.add(staff);
            scanner.nextLine();
        }
        return staffList;
    }

    public void setSession(Staff staff) {
        this.onSession = staff;
    }

    public Staff getSession(String staffID) {
        ArrayList<Staff> staffList = readStaffList();
        Staff currentSession = null;
        for(int index=0;index<staffList.size();index++){
            if(staffID.equals(staffList.get(index).getStaffID())==true){
                currentSession=staffList.get(index);
            }
        }
        return currentSession;
    }

      public boolean newPasswordValidation(String newPassword) {
        int isDigit = 0, isLower = 0, isUpper = 0, isSpecial = 0;
        for (int index = 0; index < newPassword.length(); index++) {
            if (Character.isDigit(newPassword.charAt(index)) == true) {
                isDigit++;
            } else if (Character.isLowerCase(newPassword.charAt(index)) == true) {
                isLower++;
            } else if (Character.isUpperCase(newPassword.charAt(index)) == true) {
                isUpper++;
            } else {
                isSpecial++;
            }
        }
        if (isDigit > 0 && isLower > 0 && isUpper > 0 && isSpecial > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean Login() {
        boolean isLogin=false;
        Scanner inputScan = new Scanner(System.in);

        System.out.println("Enter Staff ID :");
        String username = inputScan.next();

        System.out.println("Enter Password :");
        String password = inputScan.next();

        boolean validLogin = false;
        staffList = readStaffList();
        int errorNumber = 0;

        for (int index = 0; index < staffList.size(); index++) {
            if (username.equals(staffList.get(index).getStaffID()) == true) {
                if (password.equals(staffList.get(index).getPassword()) == true) {
                    System.out.println("\nLogin Successful");
                    setSession(staffList.get(index));
                    isLogin = true; 
                }
            } else {
                errorNumber++;

            }
        }
        if (errorNumber == staffList.size()) {
            System.out.println("\nNot Username Found ");
            isLogin =false;
        }
        return isLogin;
    }

    public void rewriteFile(ArrayList<Staff> staffList) {
        try {
            FileWriter myWriter = new FileWriter("StaffDetails.txt");
            
            for(int index=0;index<staffList.size();index++){
                myWriter.write(staffList.get(index).toString());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ChangePassword process = new ChangePassword();
        boolean loginSuccessful=process.Login();

        Scanner inputScan = new Scanner(System.in);
        
        if(loginSuccessful){
        System.out.println("\n\n\n============================================");
        System.out.println("             PASSWORD CHANGE PROCESS");
        System.out.println("\nEnter Old Password >");
        String password = inputScan.next();

        do {
            System.out.println("\nEnter New Password > ");
            String newPassword = inputScan.next();

            System.out.println("\nConfirm Password");
            String confirmPassword = inputScan.next();

            if (newPassword.equals(confirmPassword) == true) {
                System.out.println("Confirm to change password[Y=Yes/N=No]");
                char confirm = inputScan.next().charAt(0);
                if (confirm == 'y' || confirm == 'Y') {
                    for (int index = 0; index < process.staffList.size(); index++) {
                        if (process.onSession.getStaffID().equals(process.staffList.get(index).getStaffID()) == true) {
                            process.staffList.get(index).setPassword(newPassword);
                            process.rewriteFile(process.staffList);
                        }
                    }
                } else {
                    return;
                }
            } else {
                System.out.println("The New Password not consist with Confirm Password");
            }

        } while (password.equals(process.onSession.getPassword()) == true);

    }
    }
}
