/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import adt.LinkedList;
import entity.MenuItem;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Ooi Chin Hui
 */
public class Ordering {

    LinkedList<MenuItem> menuItemList = new LinkedList<MenuItem>();

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
        System.out.println("============================================================");
        System.out.println("||                          Menu                          ||");
        System.out.println("============================================================");
        for (int i = 1; i < menuItemList.getNumberOfEntries() + 1; i++) {
            System.out.printf("%2d    %20s       %10s         RM%2.2f \n", i, menuItemList.getEntry(i).getItemName(), menuItemList.getEntry(i).getCategory(), menuItemList.getEntry(i).getPrice());
        }
    }

}
