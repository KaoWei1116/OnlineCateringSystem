/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Timer implements Runnable {
    
    private Scanner scanner;
    private StringBuilder buffer;
    private boolean reading;
    private Thread t;
    private static long timeLeft;
    
    public Timer() {
        scanner = new Scanner(System.in);
        buffer = new StringBuilder();
        reading = false;
        t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Timer scanner = new Timer();
        char cancel = ' ';
        long startTime = System.currentTimeMillis();
        String orderStatus = "Processing";

        clsScreen();

        do {
            System.out.printf("\nEnter \"Y\" to cancel the order. ");
            
            cancel = scanner.next(orderStatus).charAt(0);

            if(System.currentTimeMillis() - startTime > 1000)
                orderStatus = "Preparing";
            
            if(System.currentTimeMillis() - startTime > 1000)
                orderStatus = "Ready";
            
            if(System.currentTimeMillis() - startTime > 1000)
                orderStatus = "Completed";
            
            if (cancel == ' ') {
                clsScreen();
                
                if(orderStatus.equals("Preparing"))
                    System.out.println("\nYour order is preparing...");
                if(orderStatus.equals("Ready"))
                    System.out.println("\nYour order is ready for pick up.");
                if(orderStatus.equals("Completed"))
                    System.out.println("\nYou have pick up your order. Enjoy your meal~");
            } else if (cancel == 'Y' || cancel == 'y') {
                System.out.println("You have canceled the order. ");
                orderStatus = "Canceled";
            } else {
                System.out.println("Please don't enter other things. ");
            }
        } while (cancel != ' ' && cancel != 'Y' && cancel != 'y');

        System.exit(0);
    }
    
    public String next(String orderStatus) {
        reading = true;
        buffer.delete(0, buffer.length());
        String result = " ";
        while (orderStatus.equals("Processing") && result == " ") {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
            }
            synchronized (buffer) {
                if (buffer.length() > 0) {
                    Scanner temp = new Scanner(buffer.toString());
                    result = temp.nextLine();
                }
            }
        }
        reading = false;
        return result;
    }
    
    @Override
    public void run() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            synchronized (buffer) {
                if (reading) {

                    buffer.append(line);
                    buffer.append("\n");

                } else {
                    // flush the buffer
                    if (buffer.length() != 0) {
                        buffer.delete(0, buffer.length());
                    }
                }
            }
        }
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
            Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
