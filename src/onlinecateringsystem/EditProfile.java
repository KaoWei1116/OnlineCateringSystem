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
public class EditProfile {

    public Scanner scanner = new Scanner(System.in);
    public ArrayList<Register> customerList = readCustomerList();
    private String username;

    public ArrayList<Register> readCustomerList() {
        ArrayList<Register> userList = new ArrayList<>();
        try {                 //open file
            scanner = new Scanner(new File("CustomerDetails.txt"));

        } catch (Exception e) {
            System.out.println("Error ! Could not find the file.");
        }

        scanner.useDelimiter("[|]");

        while (scanner.hasNext()) {      //do while loop - read file content
            String name = scanner.next();
            String phoneNumber = scanner.next();
            String icNumber = scanner.next();
            String emailAddress = scanner.next();
            String username = scanner.next();
            String password = scanner.next();

            Register user = new Register(name, phoneNumber, icNumber, emailAddress, username, password);
            userList.add(user);
            scanner.nextLine();
        }
        return userList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Register currentSession(String username) {
        setUsername(username);
        Register user = new Register();
        for (int index = 0; index < customerList.size(); index++) {
            if (username.equals(customerList.get(index).getUsername()) == true) {
                user = customerList.get(index);
            }
        }

        return user;
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

    
    public boolean rewriteFile(ArrayList<Register> customerList) {
        boolean rewrite = false;
        try {
            FileWriter myWriter = new FileWriter("CustomerDetails.txt");
            for (int index = 0; index < customerList.size(); index++) {
                myWriter.write(customerList.get(index).toString());
            }
            myWriter.close();
            rewrite = true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return rewrite;
    }

    public void editMenu() {
        Scanner inputScan = new Scanner(System.in);
        int choose = 0;
        do {
            System.out.println("\n\n\n\n=====================================");
            System.out.println("|   1. NAME                         |");
            System.out.println("|   2. IC NUMBER                    |");
            System.out.println("|   3. PHONE NUMBER                 |");
            System.out.println("|   4. EMAIL ADDRESS                |");
            System.out.println("|   5. PASSWORD                     |");
            System.out.println("|   6. EXIT                         |");
            System.out.println("=====================================");
            System.out.println("Which Information Want to Modify >");
            choose = inputScan.nextInt();
            editProcess(choose);
        } while (choose < 0 || choose > 6);
    }

    public void editProcess(int index) {
        Scanner inputScan = new Scanner(System.in);
        switch (index) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                char confirm = 'n';
                do {
                    String oldPassword;
                    System.out.println("\n\nEnter Old Password > ");
                    oldPassword = inputScan.nextLine();
                    if (oldPassword.isEmpty()) {
                        System.out.println("Please Enter Old Password");
                        confirm = 'y';
                    } else {
                        if (oldPassword.equals(currentSession(getUsername()).getPassword()) == true) {
                            String newPassword;
                            do {

                                System.out.println("\n\nPassword must have at least one numerical character, one lowercase character and one uppercase character.");
                                System.out.println("Password must also have at least one special symbol such as @,#,$,%,!,*,& and password length should be between 8 and 16.");
                                System.out.println("Enter Your new password >");
                                newPassword = inputScan.nextLine();

                                if (newPassword.isEmpty()) {
                                    System.out.println("Please Enter New Password");
                                } else {

                                    if (newPasswordValidation(newPassword) == true) {
                                        String confirmPassword;
                                        do {
                                            System.out.println("\n\nEnter Confirm Password >");
                                            confirmPassword = inputScan.nextLine();

                                            if (confirmPassword.isEmpty()) {
                                                System.out.println("Please Enter Confirm Password");
                                            } else {

                                                if (confirmPassword.equals(newPassword) == true) {
                                                    currentSession(getUsername()).setPassword(newPassword);
                                                    for (int i = 0; i < customerList.size(); i++) {
                                                        if (customerList.get(i).getUsername().equals(currentSession(getUsername()).getUsername()) == true) {
                                                            customerList.get(i).setPassword(newPassword);
                                                        }

                                                    }
                                                    rewriteFile(customerList);
                                                    System.out.println("\n\nPASSWORD Change Successful !! >");
                                                } else {
                                                    System.out.println("Confirm Password not same with new password,Pls try again !!1");
                                                }
                                            }
                                        } while (confirmPassword.equals(newPassword) == false);

                                    } else {
                                        System.out.println("Password format WRONG XXX, Pls Try again>");
                                    }
                                }
                            } while (newPasswordValidation(newPassword) == false);

                        } else {
                            System.out.println("Password Wrong !!!1  ");
                            System.out.println("Want to rede?[Y=Yes/N=No]");
                            confirm = inputScan.nextLine().charAt(0);
                        }
                    }
                } while (confirm == 'y' || confirm == 'Y');
                break;
            case 6:
                return;
            default:
        }
    }
}
