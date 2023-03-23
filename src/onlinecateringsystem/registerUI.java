package onlinecateringsystem;

import entity.Email;
import java.io.IOException;
import java.util.Scanner;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Mok Chun Kit Calvin
 */
public class registerUI {

    public static void registerModule(Register[] registerArr) throws IOException {

        Scanner scannerRegister = new Scanner(System.in);
        String userNameInput;
        String userPhoneNumberInput;
        String userICNoInput;
        String userEmailAddressInput;
        String usernameInput;
        String passwordInput;
        int numRecordRegister;
        char confirmRegister = 'y';
        Register register = new Register();

        numRecordRegister = register.readRegisterFile(registerArr);

        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter name (EX: Tan Wei Sheng) : ");
            userNameInput = scannerRegister.nextLine();

            if (Register.isValidateName(userNameInput) == true && (Register.checkRegisterName(userNameInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userNameInput + " is not a valid name.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateName(userNameInput) == false && (Register.checkRegisterName(userNameInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userNameInput + " is not a valid name.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateName(userNameInput) == true && (Register.checkRegisterName(userNameInput, registerArr, numRecordRegister) == false)) {
                System.out.println(userNameInput + " is not a valid name.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(userNameInput + " is a valid name.");

            }

        } while ((Register.isValidateName(userNameInput) == true) || (Register.checkRegisterName(userNameInput, registerArr, numRecordRegister) == true));

        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter phone number (EX: 011-1234567) or (EX: 011-12345678) : ");
            userPhoneNumberInput = getUserInputRegister();

            if (Register.isValidatePhoneNumber(userPhoneNumberInput) == true && (Register.checkRegisterPhoneNumber(userPhoneNumberInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userPhoneNumberInput + " is not a valid phone number.");
                System.out.println("The phone number must be in this format (XXX-XXXXXXX) or (XXX-XXXXXXXX) ");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidatePhoneNumber(userPhoneNumberInput) == false && (Register.checkRegisterPhoneNumber(userPhoneNumberInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userPhoneNumberInput + " is not a valid phone number.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidatePhoneNumber(userPhoneNumberInput) == true && Register.checkRegisterPhoneNumber(userPhoneNumberInput, registerArr, numRecordRegister) == false) {
                System.out.println(userPhoneNumberInput + " is not a valid phone number.");
                System.out.println("The phone number must be in this format (XXX-XXXXXXX) or (XXX-XXXXXXXX) ");
                System.out.println("Please enter again.");

            } else {
                System.out.println(userPhoneNumberInput + " is a valid phone number.");

            }

        } while ((Register.isValidatePhoneNumber(userPhoneNumberInput) == true) || (Register.checkRegisterPhoneNumber(userPhoneNumberInput, registerArr, numRecordRegister) == true));

        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter IC Number (EX: 001010-10-0101) : ");
            userICNoInput = getUserInputRegister();

            if (Register.isValidateICNo(userICNoInput) == true && (Register.checkRegisterICNo(userICNoInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userICNoInput + " is not a valid IC number.");
                System.out.println("The IC number must be in this format (XXXXXX-XX-XXXX) ");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateICNo(userICNoInput) == false && (Register.checkRegisterICNo(userICNoInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userICNoInput + " is not a valid IC number.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateICNo(userICNoInput) == true && (Register.checkRegisterICNo(userICNoInput, registerArr, numRecordRegister) == false)) {
                System.out.println(userICNoInput + " is not a valid IC number.");
                System.out.println("The IC number must be in this format (XXXXXX-XX-XXXX) ");
                System.out.println("Please enter again.");

            } else {
                System.out.println(userICNoInput + " is a valid IC number.");

            }

        } while ((Register.isValidateICNo(userICNoInput) == true) || (Register.checkRegisterICNo(userICNoInput, registerArr, numRecordRegister) == true));

        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter email address (EX: 2004jingsheng@gmail.com) : ");
            userEmailAddressInput = scannerRegister.nextLine();

            if (Register.isValidateEmailAddress(userEmailAddressInput) == true && (Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userEmailAddressInput + " is not a valid email address.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateEmailAddress(userEmailAddressInput) == false && (Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordRegister) == true)) {
                System.out.println(userEmailAddressInput + " is not a valid email address.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateEmailAddress(userEmailAddressInput) == true && (Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordRegister) == false)) {
                System.out.println(userEmailAddressInput + " is not a valid email address.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(userEmailAddressInput + " is a valid email address.");

            }

        } while ((Register.isValidateEmailAddress(userEmailAddressInput) == true) || (Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordRegister) == true));

        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter username (length between 6 and 14) with only contain alphabet and digit(optional) : ");
            usernameInput = getUserInputRegister();

            if (Register.isValidateUsername(usernameInput) == true && Register.checkRegisterUsername(usernameInput, registerArr, numRecordRegister) == true) {
                System.out.println(usernameInput + " is not a valid username.");
                System.out.println("The username length must between 6 and 14 with only contain alphabet and digit(optional).");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateUsername(usernameInput) == false && Register.checkRegisterUsername(usernameInput, registerArr, numRecordRegister) == true) {
                System.out.println(usernameInput + " is not a valid username.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (Register.isValidateUsername(usernameInput) == true && Register.checkRegisterUsername(usernameInput, registerArr, numRecordRegister) == false) {
                System.out.println(usernameInput + " is not a valid username.");
                System.out.println("The username length must between 6 and 14 with only contain alphabet and digit(optional).");
                System.out.println("Please enter again.");

            } else {
                System.out.println(usernameInput + " is a valid username.");

            }

        } while ((Register.isValidateUsername(usernameInput) == true) || Register.checkRegisterUsername(usernameInput, registerArr, numRecordRegister) == true);

        System.out.printf("\n");
        System.out.println("Password must have at least one numerical character, one lowercase character and one uppercase character.");
        System.out.println("Password must also have at least one special symbol such as @,#,$,%,!,*,& and password length should be between 8 and 16.");
        boolean validPassword;
        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter password (length between 8 and 16) : ");
            passwordInput = getUserInputRegister();

            validPassword = Register.isValidatePassword(passwordInput);

            if (validPassword == true && Register.checkRegisterPassword(passwordInput, registerArr, numRecordRegister) == true) {
                System.out.println(passwordInput + " is not a valid password.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (validPassword == false && Register.checkRegisterPassword(passwordInput, registerArr, numRecordRegister) == true) {
                System.out.println(passwordInput + " is not a valid password.");
                System.out.println("Got people used before already.");
                System.out.println("Please enter again.");

            } else if (validPassword == true && Register.checkRegisterPassword(passwordInput, registerArr, numRecordRegister) == false) {
                System.out.println(passwordInput + " is not a valid password.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(passwordInput + " is a valid password.");

            }

        } while ((validPassword == true) || Register.checkRegisterPassword(passwordInput, registerArr, numRecordRegister) == true);

        System.out.printf("\n");
        System.out.println(" Preview :");
        System.out.println("+----------------------+-----------------+-----------------+---------------------------+-----------------+----------------------+");
        System.out.printf("| %-20s | %-15s | %-15s | %-25s | %-15s | %-20s |\n", "Name", "Phone Number", "IC Number", "Email Address", "Username", "Password");
        System.out.println("+----------------------+-----------------+-----------------+---------------------------+-----------------+----------------------+");
        System.out.printf("| %-20s | %-15s | %-15s | %-25s | %-15s | %-20s |\n", userNameInput, userPhoneNumberInput, userICNoInput, userEmailAddressInput, usernameInput, passwordInput);
        System.out.println("+----------------------+-----------------+-----------------+---------------------------+-----------------+----------------------+");
        System.out.printf("\n");
        System.out.printf("%-30s", "Confirm Register ? [yes or no]");
        confirmRegister = getUserInputRegister().charAt(0);

        if (Character.toUpperCase(confirmRegister) == 'Y') {
            register.appendRegisterFile(userNameInput, userPhoneNumberInput, userICNoInput, userEmailAddressInput, usernameInput, passwordInput);

        } else {
            System.out.printf("\n");
            System.out.println("Cancelled Successfully");

        }
    }

    private static String getUserInputRegister() {
        String outputString;
        Scanner user = new Scanner(System.in);
        outputString = user.nextLine();
        return outputString;
    }

    public static void forgetPassword(Register[] registerArr) throws IOException {
        Scanner scannerRegister = new Scanner(System.in);
        String userEmailAddressInput;
        String newUserPasswordInput;
        int numRecordsTextFile;
        Register register = new Register();

        numRecordsTextFile = register.readRegisterFile(registerArr);

        ForgetPassword forgetProcess = new ForgetPassword();

        do {
            System.out.printf("\n");
            System.out.printf("%-61s", "Enter email address (EX: 2004jingsheng@gmail.com) : ");
            userEmailAddressInput = scannerRegister.nextLine();

            if (Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordsTextFile) == false) {
                System.out.println("This email address is not found in the text file.");
                System.out.println("Please enter again.");
            } //if the email address is found in the text file
            else {

                Email email = new Email(registerArr[numRecordsTextFile-1].getName(), userEmailAddressInput, forgetProcess.getRandom());

                boolean verifyEmail = forgetProcess.sendEmail(email);

                if (verifyEmail) {
                    System.out.printf("\n");
                    System.out.println("New password must have at least one numerical character, one lowercase character and one uppercase character.");
                    System.out.println("New password must also have at least one special symbol such as @,#,$,%,!,*,& and password length should be between 8 and 16.");
                    boolean validPassword;
                    do {
                        System.out.println("\n");
                        System.out.printf("%-61s", "Enter new password (length between 8 and 16) : ");
                        newUserPasswordInput = getUserInputRegister();

                        validPassword = Register.isValidatePassword(newUserPasswordInput);

                        if (validPassword == true && Register.checkRegisterPassword(newUserPasswordInput, registerArr, numRecordsTextFile) == true) {
                            System.out.println(newUserPasswordInput + " is not a valid password.");
                            System.out.println("Got people used before already.");
                            System.out.println("Please enter again.");

                        } else if (validPassword == false && Register.checkRegisterPassword(newUserPasswordInput, registerArr, numRecordsTextFile) == true) {
                            System.out.println(newUserPasswordInput + " is not a valid password.");
                            System.out.println("Got people used before already.");
                            System.out.println("Please enter again.");

                        } else if (validPassword == true && Register.checkRegisterPassword(newUserPasswordInput, registerArr, numRecordsTextFile) == false) {
                            System.out.println(newUserPasswordInput + " is not a valid password.");
                            System.out.println("Please enter again.");

                        } else {
                            System.out.println(newUserPasswordInput + " is a valid password.");
                            register.editRegisterPasswordFile(userEmailAddressInput, newUserPasswordInput, registerArr, numRecordsTextFile);
                            register.updatedVersion(registerArr, numRecordsTextFile);
                            System.out.println("Change Successfully. You can login to the system with your new password.");
                            break;
                        }

                    } while ((validPassword == true) || Register.checkRegisterPassword(newUserPasswordInput, registerArr, numRecordsTextFile) == true);
                }

            }

        } while (Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordsTextFile) == false);

    }

    /*public static void resetPassword(Register[] registerArr) throws IOException {
        Scanner scannerRegister = new Scanner(System.in);
        String userEmailAddressInput;
        String newUserPasswordInput;
        int numRecordsTextFile;         
        Register register = new Register();
           
        numRecordsTextFile = register.readRegisterFile(registerArr);   
        
        do
           {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter email address (EX: 2004jingsheng@gmail.com) : ");
                userEmailAddressInput = scannerRegister.nextLine();
               
                if(Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordsTextFile) == false)
                {
                    System.out.println("This email address is not found in the text file.");
                    System.out.println("Please enter again.");
                }
                //if the email address is found in the text file
                else {
                    
                    System.out.printf("\n");
                    System.out.println("New password must have at least one numerical character, one lowercase character and one uppercase character.");
                    System.out.println("New password must also have at least one special symbol such as @,#,$,%,!,*,& and password length should be between 8 and 16.");
                    boolean validPassword; 
                    do
                    {
                        System.out.println("\n");
                        System.out.printf("%-61s", "Enter new password (length between 8 and 16) : ");
                        newUserPasswordInput = getUserInputRegister();

                        validPassword = Register.isValidatePassword(newUserPasswordInput);

                        if(validPassword == true && Register.checkRegisterPassword(newUserPasswordInput , registerArr, numRecordsTextFile) == true){
                            System.out.println(newUserPasswordInput  + " is not a valid password.");
                            System.out.println("Got people used before already.");
                            System.out.println("Please enter again.");

                        }
                        else if(validPassword == false && Register.checkRegisterPassword(newUserPasswordInput , registerArr, numRecordsTextFile) == true){
                            System.out.println(newUserPasswordInput  + " is not a valid password.");
                            System.out.println("Got people used before already.");
                            System.out.println("Please enter again.");

                        }
                        else if(validPassword == true && Register.checkRegisterPassword(newUserPasswordInput , registerArr, numRecordsTextFile) == false){
                            System.out.println(newUserPasswordInput  + " is not a valid password.");
                            System.out.println("Please enter again.");

                        }
                        else{
                            System.out.println(newUserPasswordInput  + " is a valid password.");
                            register.editRegisterPasswordFile(userEmailAddressInput, newUserPasswordInput, registerArr, numRecordsTextFile);
                            register.updatedVersion(registerArr, numRecordsTextFile);
                            System.out.println("Change Successfully. You can login to the system with your new password.");
                            break;  
                        }

                    }while((validPassword == true) || Register.checkRegisterPassword(newUserPasswordInput, registerArr, numRecordsTextFile) == true);
                }
                
        }while(Register.checkRegisterEmailAddress(userEmailAddressInput, registerArr, numRecordsTextFile) == false);
  
        
     
    } */
}
