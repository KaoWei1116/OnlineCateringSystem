/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Year;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ooi Chin Hui
 */
public class Payment {

    Scanner scan = new Scanner(System.in);
    String action;

    public void generatePayment() {
    }

    public boolean makePayment() {
        boolean cardTypeFlag = false, cardNumberFlag = false, expirationFlag = false, securityCodeFlag = false;
        String cardNumber, expiryDate, securityCode, confirmation;
        //Confirm order
        do {
            //Get order amount from ordering
            //Display order, confirm then proceed
            System.out.println("Below is your order details please confirm:");
            //print something, based on ordering's logic
            generatePayment();
            //confirmation
            System.out.println("1. Confirm and proceed to payment.");
            System.out.println("2. Cancel payment.");
            //Receive option
            System.out.print(">");
            action = scan.next();
            //Do nothing, escape from here
            if (action.equals("1")) {
            } //Quit, cancel
            else if (action.equals("2")) {
                return false;
            } //Clear, Display error message
            else {
                clsScreen();
                System.out.println(ConsoleColors.RED + "Please enter only 1 and 2 to indicate your action." + ConsoleColors.RESET);
            }
        } while (action.equals("1") == false && action.equals("2") == false);
        clsScreen();
        //Select payment method
        do {
            //Basically useless option, just putting here
            System.out.println("Please enter payment details:");
            System.out.println("Card type:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. Cancel");
            //Receive option
            System.out.print(">");
            action = scan.next();
            //Credit/Debit process same
            if (action.equals("1") || action.equals("2")) {
                cardTypeFlag = true;
                System.out.print("Card number(-1 to exit):");
                cardNumber = scan.next();
                if (cardNumber.equals("-1")) {
                    //Return nothing / false(cancel)
                    return false;
                }
                if (cardNumber.matches("\\d+") && cardNumber.length() == 16) {
                    cardNumberFlag = true;
                }
                System.out.print("Expiration date(MM/YY)(-1 to exit):");
                expiryDate = scan.next();
                if (expiryDate.equals("-1")) {
                    return false;
                }
                if (expiryDate.length() != 5) {
                    //Show error
                    expirationFlag = false;
                } else {
                    if (expiryDate.matches("\\d{2}/\\d{2}") && expiryDate.charAt(0) == '0' || expiryDate.charAt(0) == '1') {
                        if (expiryDate.charAt(0) == '1') {
                            if (expiryDate.charAt(1) == '0' || expiryDate.charAt(1) == '1' || expiryDate.charAt(1) == '2') {
                                expirationFlag = true;
                            }
                        } else {
                            expirationFlag = true;
                        }
                        if (Integer.parseInt(expiryDate.substring(3, 5)) < Year.now().getValue() - 2000) {
                            expirationFlag = false;
                        }
                    }
                }
                System.out.print("Security code(-1 to exit):");
                securityCode = scan.next();
                if (securityCode.equals("-1")) {
                    return false;
                }
                if (securityCode.matches("\\d+") && securityCode.length() == 3 || securityCode.length() == 4) {
                    securityCodeFlag = true;
                }
                if (cardTypeFlag == true && cardNumberFlag == true && expirationFlag == true && securityCodeFlag == true) {

                    System.out.print("Press 'Y' to confirm the payment (-1 to cancel):");
                    do {
                        confirmation = scan.next();
                        if (confirmation.equals("Y")) {
                            //CHECK RETURN WHAT
                            clsScreen();
                            return true;
                        } else if (confirmation.equals("-1")) {
                            clsScreen();
                            return false;
                        } else {
                            System.out.print(ConsoleColors.RED + "Please enter 'Y' to confirm and -1 to cancel:" + ConsoleColors.RESET);
                        }
                    } while (confirmation.equals("Y") == false && confirmation.equals("-1") == false);
                }
            } else if (action.equals("3")) {
                //Return nothing / false(cancel)
                return false;
            } else {
                cardTypeFlag = false;
            }
            clsScreen();
            System.out.println("Error log:");
            System.out.print(ConsoleColors.WHITE + ConsoleColors.RED_BACKGROUND);
            if (cardTypeFlag == false) {
                System.out.print(ConsoleColors.WHITE + ConsoleColors.RED_BACKGROUND);
                System.out.println("Please enter 1 to 3 to indicate your action.");
            } else {
                System.out.print(ConsoleColors.WHITE + ConsoleColors.RED_BACKGROUND);
                if (cardNumberFlag == false) {
                    System.out.println("Card number section should be a 16 digit numeric input. (exp. 1111111111111111)                          ");
                }
                System.out.print(ConsoleColors.WHITE + ConsoleColors.RED_BACKGROUND);
                if (expirationFlag == false) {
                    System.out.println("You might have entered an invalid expiration date or your card has expired, please try again. (exp.01/23)");
                }
                System.out.print(ConsoleColors.WHITE + ConsoleColors.RED_BACKGROUND);
                if (securityCodeFlag == false) {
                    System.out.println("Security code entered is invalid! Please try again, it should be a 3 digit numeric input (exp. 111)      ");
                }
            }
            System.out.print(ConsoleColors.RESET);
        } //If not 1 - 3 and flag error, repeat
        while (action.equals("1") == false || action.equals("2") == false || action.equals("3") == false && cardTypeFlag == false && cardNumberFlag == false && expirationFlag == false && securityCodeFlag == false);
        //Supposition no need this, wont reach here
        return false;
    }

    public static void clsScreen() {
        try {
            Robot pressbot = new Robot();
            pressbot.keyPress(17);
            pressbot.keyPress(76);
            pressbot.keyRelease(17);
            pressbot.keyRelease(76);
            pressbot.delay(100);
        } catch (AWTException ex) {
            Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
