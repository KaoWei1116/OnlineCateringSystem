/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import adt.LinkedList;
import entity.MenuItem;
import entity.Order;
import entity.OrderItem;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ooi Chin Hui
 */
public class Ordering {

    LinkedList<MenuItem> menuItemList = new LinkedList<MenuItem>();
    LinkedList<Order> orderList = new LinkedList<Order>();

    public void OrderingModule() {
        readMenuItem();
        printMenu();
    }

    private Scanner fileScanner;

    public void sortMenuItemAscending() {
        menuItemList.sortLinkedListAscending();
    }

    public void sortMenuItemDescending() {
        menuItemList.sortLinkedListDescending();
    }

    public LinkedList<MenuItem> filterByCategory(String filterSetting) {
        LinkedList<MenuItem> menuItemList = new LinkedList<MenuItem>();
        for (int i = 1; i < this.menuItemList.getNumberOfEntries() + 1; i++) {
            if (this.menuItemList.getEntry(i).getCategory().equals(filterSetting)) {
                menuItemList.add(this.menuItemList.getEntry(i));
            }
        }
        return menuItemList;
    }

    public int readMenuItem() {
        try {                 //open file
            fileScanner = new Scanner(new File("MenuItem.txt"));
        } catch (Exception e) {
            System.out.println("Error! The file is either missing or corrupted.");
        }
        int menuItemCounter = 0;
        fileScanner.useDelimiter("[|]");
        while (fileScanner.hasNext()) {      //do while loop - read file content
            String itemID = fileScanner.next();
            String itemName = fileScanner.next();
            String itemCategory = fileScanner.next();
            String itemDesc = fileScanner.next();
            String itemPrice = fileScanner.next();

            menuItemList.add(new MenuItem(itemID, itemName, itemCategory, itemDesc, Double.parseDouble(itemPrice)));
            fileScanner.nextLine();
            menuItemCounter++;
        }
        fileScanner.close();       //close file
        return menuItemCounter;
    }

    public void printMenu() {
        //Display menu
        System.out.println("================================================================================================");
        System.out.println("||                                            Menu                                            ||");
        System.out.println("================================================================================================");
        for (int i = 1; i < menuItemList.getNumberOfEntries() + 1; i++) {
            System.out.printf("%2d    %50s       %10s         RM%-8.2f \n", i, menuItemList.getEntry(i).getItemName(), menuItemList.getEntry(i).getCategory(), menuItemList.getEntry(i).getPrice());
        }
    }

    public void createOrderFile() {
        try {
            File file = new File("Order.txt");
            if (file.createNewFile()) {
                System.out.println("File Created");
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected void writeOrderIntoFile() throws InterruptedException {
        try {
            clsScreen();
            FileWriter writer = new FileWriter("Order.txt");
            writer.write(formatWriteOrder());
            writer.close();
            System.out.println("Transaction Successful.");
            TimeUnit.SECONDS.sleep(5);
            clsScreen();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String formatWriteOrder() {
        String orderString = "";
        for (int index = 1; index <= orderList.getNumberOfEntries(); index++) {
            orderString += orderList.getEntry(index).getOrderID() + "\n";
            for (int index2 = 1; index2 <= orderList.getEntry(index).getOrderItemList().getNumberOfEntries(); index2++) {
                orderString += "#" + orderList.getEntry(index).getOrderItemList().getEntry(index2).getItemID() + ", ";
                orderString += orderList.getEntry(index).getOrderItemList().getEntry(index2).getItemName() + ", ";
                orderString += orderList.getEntry(index).getOrderItemList().getEntry(index2).getQuantity() + ", ";
                orderString += orderList.getEntry(index).getOrderItemList().getEntry(index2).getSubtotal() + "\n";
            }
        }
        return orderString;
    }

    public void readOrderFromFile() {
        try {
            int index = 0;
            File obj = new File("Order.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (data.contains("#")) {
                    String string = data.replace("#", "");
                    String[] stringList = string.split(", ");
                    String itemID = stringList[0];
                    String itemName = stringList[1];
                    int quantity = Integer.parseInt(stringList[2]);
                    double subtotal = Double.parseDouble(stringList[3]);
                    orderList.getEntry(index).setOrderItemList(new OrderItem(orderList.getEntry(index).getOrderID(), itemID, itemName, quantity, subtotal));
                } else {
                    String[] stringList = data.split(", ");
                    orderList.add(new Order());
                    index++;
                }
            }
            reader.close();
            //System.out.println("Get data successful");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void createOrderTrackingFile() {
        try {
            File file = new File("OrderTracking.txt");
            if (file.createNewFile()) {
                System.out.println("File Created");
            } else {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected void writeOrderTrackingIntoFile() throws InterruptedException {
        try {
            clsScreen();
            FileWriter writer = new FileWriter("OrderTracking.txt");
            writer.write(formatWriteOrderTracking());
            writer.close();
            clsScreen();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String formatWriteOrderTracking() {
        String orderString = "";
        for (int index = 1; index <= orderList.getNumberOfEntries(); index++) {
            orderString += orderList.getEntry(index).getOrderID() + ", ";
            orderString += orderList.getEntry(index).getOrderStatus() + "\n";
        }
        return orderString;
    }

    public void readOrderTrackingFromFile() {
        try {
            File obj = new File("OrderTracking.txt");
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] stringList = data.split(", ");
                for (int index = 1; index <= orderList.getNumberOfEntries(); index++) {
                    if (orderList.getEntry(index).getOrderID().equals(stringList[0])) {
                        orderList.getEntry(index).setOrderStatus(stringList[1]);
                    }
                }
            }
            reader.close();
            //System.out.println("Get data successful");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Order makeOrder() {

        Scanner scanner = new Scanner(System.in);
        Order currentOrder = new Order();
        int currentOrderItemNo;
        int orderQuantity;
        double subtotal = 0.0;
        MenuItem currentItem = new MenuItem();
        char orderConfirmation;
        char modifyConfirmation;
        char repeatOrder;
        boolean replace;
        do {
//            orderConfirmation = 'N';
//            modifyConfirmation = 'N';
//            repeatOrder = 'N';
            replace = false;
            do {
                System.out.printf("Select the item you want to order(Enter number): ");
                currentOrderItemNo = scanner.nextInt();
                scanner.nextLine();
                if (currentOrderItemNo < 1 || currentOrderItemNo > menuItemList.getNumberOfEntries()) {
                    System.out.println("The number you enter is not inside the menu!!");
                }
            } while (currentOrderItemNo < 1 || currentOrderItemNo > menuItemList.getNumberOfEntries());
            do {
                System.out.printf("Quantity: ");
                orderQuantity = scanner.nextInt();
                scanner.nextLine();
                if (orderQuantity < 0) {
                    System.out.println("The order quantity cannot be negative number.");
                } else if (orderQuantity == 0) {
                    System.out.println("The order quantity cannot be zero.");
                }
            } while (orderQuantity <= 0);
            currentItem = displayOrderDetail(currentOrderItemNo, orderQuantity);
            for (int i = 1; i <= currentOrder.getOrderItemList().getNumberOfEntries(); i++) {
                if (currentItem.getItemID().equals(currentOrder.getOrderItemList().getEntry(i).getItemID())) {
                    replace = true;
                    System.out.println("You have order this item before. Do you want to modify the quantity? (Y-Yes)");
                    modifyConfirmation = scanner.next().charAt(0);
                    if (modifyConfirmation == 'Y' || modifyConfirmation == 'y') {
                        System.out.println("Old Quantity: " + currentOrder.getOrderItemList().getEntry(i).getQuantity());
                        System.out.printf("New Quantity: ");
                        orderQuantity = scanner.nextInt();
                        scanner.nextLine();
                        currentOrder.setTotalPrice(currentOrder.getTotalPrice() - currentOrder.getOrderItemList().getEntry(i).getSubtotal());
                        subtotal = currentItem.getPrice() * orderQuantity;
                        currentOrder.getOrderItemList().getEntry(i).setSubtotal(subtotal);
                        currentOrder.setTotalPrice(currentOrder.getTotalPrice() + subtotal);
                        currentOrder.getOrderItemList().getEntry(i).setQuantity(orderQuantity);
                        System.out.println("Modify successful.");
                    }
                }
            }
            if (!replace) {
                System.out.println("Please confirm your order(Y-yes): ");
                orderConfirmation = scanner.next().charAt(0);
                if (orderConfirmation == 'Y' || orderConfirmation == 'y') {
                    subtotal = currentItem.getPrice() * orderQuantity;
                    currentOrder.setTotalPrice(currentOrder.getTotalPrice() + subtotal);
                    currentOrder.setOrderItemList(new OrderItem(currentOrder.getOrderID(), currentItem.getItemID(), currentItem.getItemName(), orderQuantity, subtotal));
                }
            }
            System.out.println("Current Order Item: " + currentOrder.getOrderItemList().getNumberOfEntries());
            System.out.println(currentOrder.toString());
            System.out.println("Do you want to order another item? (Y-yes)");
            repeatOrder = scanner.next().charAt(0);
        } while (repeatOrder == 'Y' || repeatOrder == 'y');
        return currentOrder;
    }

    private MenuItem displayOrderDetail(int currentOrder, int orderQuantity) {
        MenuItem tempItem = new MenuItem();
        for (int i = 1; i <= menuItemList.getNumberOfEntries(); i++) {
            if (currentOrder == i) {
                System.out.printf("%2s  %50s   %20s    %-10s    %14s\n", "No", "Item Name", "Item Category", "Unit Price", "Order Quantity");
                System.out.println("==============================================================================================================");
                System.out.printf("%2d  %50s    %20s    RM%-8.2f    %14d\n", i, menuItemList.getEntry(i).getItemName(), menuItemList.getEntry(i).getCategory(), menuItemList.getEntry(i).getPrice(), orderQuantity);
                tempItem = menuItemList.getEntry(i);
            }
        }
        return tempItem;
    }

    public void updateOrderStatus() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String currentOrderID = "";
        char modifyOrderStatus;
        int errorCount = 0;

        readOrderFromFile();
        readOrderTrackingFromFile();

        clsScreen();

        do {
            currentOrderID = "";
            modifyOrderStatus = ' ';
            errorCount = 0;
            displayOrderTracking();

            System.out.printf("Enter the Order ID you want to update(-1 to stop): ");
            currentOrderID = scanner.nextLine();

            if (!currentOrderID.equals("-1")) {
                for (int index = 1; index <= orderList.getNumberOfEntries(); index++) {
                    if (orderList.getEntry(index).getOrderID().equals(currentOrderID)) {
                        if (orderList.getEntry(index).getOrderStatus().equals("Completed")) {
                            clsScreen();
                            System.out.println("This order is completed!");
                        } else if (orderList.getEntry(index).getOrderStatus().equals("Canceled")) {
                            clsScreen();
                            System.out.println("This order is canceled!");
                        } else if (orderList.getEntry(index).getOrderStatus().equals("Processing")) {
                            System.out.println("Do you want to change the order status?");
                            System.out.println("Processing --> Preparing");
                            System.out.printf("Y for yes > ");
                            modifyOrderStatus = scanner.next().charAt(0);
                            scanner.nextLine();
                            if (modifyOrderStatus == 'Y' || modifyOrderStatus == 'y') {
                                orderList.getEntry(index).setOrderStatus("Preparing");
                                writeOrderTrackingIntoFile();
                                clsScreen();
                                System.out.println("Order status updated.");
                            } else {
                                clsScreen();
                                System.out.println("The order status remain " + orderList.getEntry(index).getOrderStatus() + ".");
                            }
                        } else if (orderList.getEntry(index).getOrderStatus().equals("Preparing")) {
                            System.out.println("Do you want to change the order status?");
                            System.out.println("Preparing --> Ready");
                            System.out.printf("Y for yes > ");
                            modifyOrderStatus = scanner.next().charAt(0);
                            scanner.nextLine();
                            if (modifyOrderStatus == 'Y' || modifyOrderStatus == 'y') {
                                orderList.getEntry(index).setOrderStatus("Ready");
                                writeOrderTrackingIntoFile();
                                clsScreen();
                                System.out.println("Order status updated.");
                            } else {
                                clsScreen();
                                System.out.println("The order status remain " + orderList.getEntry(index).getOrderStatus() + ".");
                            }
                        } else if (orderList.getEntry(index).getOrderStatus().equals("Ready")) {
                            System.out.println("Do you want to change the order status?");
                            System.out.println("Ready --> Completed");
                            System.out.printf("Y for yes > ");
                            modifyOrderStatus = scanner.next().charAt(0);
                            scanner.nextLine();
                            if (modifyOrderStatus == 'Y' || modifyOrderStatus == 'y') {
                                orderList.getEntry(index).setOrderStatus("Completed");
                                writeOrderTrackingIntoFile();
                                clsScreen();
                                System.out.println("Order status updated.");
                            } else {
                                clsScreen();
                                System.out.println("The order status remain " + orderList.getEntry(index).getOrderStatus() + ".");
                            }
                        } else {
                            errorCount++;
                        }
                    }
                }
                if (errorCount == orderList.getNumberOfEntries()) {
                    clsScreen();
                    System.out.println("Please enter valid Order ID!");
                }
            }
        } while (!currentOrderID.equals("-1"));
        System.out.println("Exit order status page..");
        clsScreen();
    }

    private void displayOrderTracking() {
        System.out.printf("\n%-10s %-15s\n", "Order ID", "Order Status");
        System.out.println("===========================");
        for (int index = 1; index <= orderList.getNumberOfEntries(); index++) {
            System.out.printf("%-10s %-15s\n", orderList.getEntry(index).getOrderID(), orderList.getEntry(index).getOrderStatus());
        }
        System.out.println("===========================");
    }

    public void viewOrderStatus(Order currentOrder) {
        long startTime = System.currentTimeMillis();
        
        clsScreen();
        do {
            if ((System.currentTimeMillis() - startTime) % 10000 == 0) {
                readOrderTrackingFromFile();
                for (int index = 1; index <= orderList.getNumberOfEntries(); index++) {
                    if (orderList.getEntry(index).equals(currentOrder)) {
                        switch (orderList.getEntry(index).getOrderStatus()) {
                            case "Processing":
                                System.out.println("\nYour order is processing...");
                                currentOrder.setOrderStatus("Processing");
                                break;
                            case "Preparing":
                                System.out.println("\nYour order is preparing...");
                                currentOrder.setOrderStatus("Preparing");
                                break;
                            case "Ready":
                                System.out.println("\nYour order is ready for pick up.");
                                currentOrder.setOrderStatus("Ready");
                                break;
                            case "Completed":
                                System.out.println("\nYou have pick up your order. Enjoy your meal~");
                                currentOrder.setOrderStatus("Completed");
                        }
                    }
                }
            }
        } while (!currentOrder.getOrderStatus().equals("Completed"));
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
