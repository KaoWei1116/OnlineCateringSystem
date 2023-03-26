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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        System.out.println("==============");
        System.out.println("|| Menu     ||");
        System.out.println("==============");

        for (int i = 1; i < menuItemList.getNumberOfEntries() + 1; i++) {
            System.out.printf("%2d %20s %10s RM%2.2f \n", i, menuItemList.getEntry(i).getItemName(), menuItemList.getEntry(i).getCategory(), menuItemList.getEntry(i).getPrice());

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
    
    private void writeOrderIntoFile() {
        try {
            FileWriter writer = new FileWriter("Order.txt");
            writer.write(formatWriteOrder());
            writer.close();
            System.out.println("Data successful save to text file");
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
            System.out.println("Get data successful");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void makeOrder() {
        
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
        orderList.add(new Order(currentOrder));
        writeOrderIntoFile();
    }

    private MenuItem displayOrderDetail(int currentOrder, int orderQuantity) {
        MenuItem tempItem = new MenuItem();
        for (int i = 1; i <= menuItemList.getNumberOfEntries(); i++) {
            if (currentOrder == i) {
                System.out.printf("%2s %-20s %-20s %-10s %-14s\n", "No", "Item Name", "Item Category", "Unit Price", "Order Quantity");
                System.out.printf("%2d %-20s %-20s RM%-8.2f %-14d\n", i, menuItemList.getEntry(i).getItemName(), menuItemList.getEntry(i).getCategory(), menuItemList.getEntry(i).getPrice(), orderQuantity);
                tempItem = menuItemList.getEntry(i);
            }
        }
        return tempItem;
    }

}
