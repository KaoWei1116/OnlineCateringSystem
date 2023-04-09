
package onlinecateringsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mok Chun Kit Calvin
 */
public class Inventory {
    
    private String inventoryID = "I0";
    private static int inventoryNumber = 1;
    private static String latestInventoryID;
    private String itemName;
    private String itemCategory;
    private String itemMinimumQuantity;
    private String itemQuantityOnHand;
    private String itemUnitPrice;
    private String itemAddedDate;
    private String supplierName;
    private String supplierEmailAddress;
    private String inventoryStatus;
            
    
    public Inventory() 
    {
        
    }
    
    public Inventory(String inventoryID, String itemName, String itemCategory, String itemMinimumQuantity, String itemQuantityOnHand, String itemUnitPrice, String itemAddedDate, String supplierName, String supplierEmailAddress, String inventoryStatus) {
        this.inventoryID = inventoryID;
        Inventory.inventoryNumber++;
        inventoryID = inventoryID + inventoryNumber;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemMinimumQuantity = itemMinimumQuantity;
        this.itemQuantityOnHand = itemQuantityOnHand;
        this.itemUnitPrice = itemUnitPrice;   
        this.itemAddedDate = itemAddedDate;
        this.supplierName = supplierName;
        this.supplierEmailAddress = supplierEmailAddress;
        this.inventoryStatus = inventoryStatus;
    }
    
    public Inventory(String itemName, String itemCategory, String itemMinimumQuantity, String itemQuantityOnHand, String itemUnitPrice, String itemAddedDate, String supplierName, String supplierEmailAddress, String inventoryStatus) {
        char firstDigit = latestInventoryID.charAt(2);
        int firstDigitValue = Character.getNumericValue(firstDigit);
        char secondDigit = latestInventoryID.charAt(3);
        int secondDigitValue = Character.getNumericValue(secondDigit);
        int sequence = (firstDigitValue * 10) + (secondDigitValue * 1);
        sequence++;
        Inventory.inventoryNumber = sequence;
        inventoryID = inventoryID + inventoryNumber;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemMinimumQuantity = itemMinimumQuantity;
        this.itemQuantityOnHand = itemQuantityOnHand;
        this.itemUnitPrice = itemUnitPrice;   
        this.itemAddedDate = itemAddedDate;
        this.supplierName = supplierName;
        this.supplierEmailAddress = supplierEmailAddress;
        this.inventoryStatus = inventoryStatus;
    }

    public String getInventoryID() {
        return inventoryID;
    }
    
    public String getItemName() {
        return itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemAddedDate(String itemAddedDate) {
        this.itemAddedDate = itemAddedDate;
    }
   

    public String getItemMinimumQuantity() {
        return itemMinimumQuantity;
    }
    
    public String getItemQuantityOnHand() {
        return itemQuantityOnHand;
    }

    public String getItemUnitPrice() {
        return itemUnitPrice;
    }

    public String getItemAddedDate() {
        return itemAddedDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierEmailAddress() {
        return supplierEmailAddress;
    }
    
    public String getInventoryStatus() {
        return inventoryStatus;
    }
    
    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }
    
    private Scanner y;
    public int readInventoryFile(Inventory[] inventoryArr){    
    
    inventoryNumber = 1;    
        
    try{                 //open file
        File a = new File("InventoryDetails.txt");
        if(a.createNewFile()) {
            System.out.println("File created: " + a.getName());
            
        }

        y = new Scanner(new File("InventoryDetails.txt"));
        
    }
    catch(Exception e){
          System.out.println("Error ! Could not find the file.");
    }
 
     
    int k = 0;
    y.useDelimiter("[|]");
       
    while(y.hasNext()) {      //do while loop - read file content
           String inventoryID = y.next();
           String itemName = y.next();
           String itemCategory = y.next();
           String itemMinimumQuantity = y.next();
           String itemQuantityOnHand = y.next();
           String itemUnitPrice = y.next();
           String itemAddedDate = y.next();
           String supplierName = y.next();
           String supplierEmailAddress = y.next();
           String inventoryStatus = y.next();
           

           inventoryArr[k] = new Inventory(inventoryID, itemName, itemCategory, itemMinimumQuantity, itemQuantityOnHand, itemUnitPrice, itemAddedDate, supplierName, supplierEmailAddress, inventoryStatus);          
           y.nextLine();
           
           k++;
           latestInventoryID = inventoryID;
       }
    
    
       y.close();       //close file
       
       return k;

    }
    
    public static void appendInventoryFile(Inventory inventory) throws IOException{
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
                
             fw = new FileWriter("InventoryDetails.txt", true);
             bw = new BufferedWriter(fw);
             pw = new PrintWriter(bw);
               
             LocalDateTime oldFormatDateTime = LocalDateTime.now();
             DateTimeFormatter newFormatDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
             String itemAddedDate = oldFormatDateTime.format(newFormatDate); 
             inventory.setItemAddedDate(itemAddedDate);
             
             if(Integer.parseInt(inventory.itemQuantityOnHand) > 0){
                String inventoryStatus = "In Stock";
                inventory.setInventoryStatus(inventoryStatus);
                 
             }
             else
             {
                String inventoryStatus = "Out Of Stock";
                inventory.setInventoryStatus(inventoryStatus);
             }
             
             pw.printf("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n", inventory.inventoryID, inventory.itemName, inventory.getItemCategory(), inventory.itemMinimumQuantity, inventory.itemQuantityOnHand, inventory.itemUnitPrice, itemAddedDate, inventory.supplierName, inventory.supplierEmailAddress, inventory.inventoryStatus);
             System.out.print("\n");
             System.out.println("Data Added Into Text File Successfully.");
             pw.flush();
             pw.close();
             bw.close();
             fw.close();
                 
   
    }
     
    public static void deleteInventoryFromFile(Inventory[] inventoryArr, int numOfRecords) throws IOException {
       
        File oldFile = new File("InventoryDetails.txt");
        oldFile.delete();
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        
        fw = new FileWriter("InventoryDetails.txt", true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);

        for (int i = 0; i < numOfRecords; i++) {
            pw.printf("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n", inventoryArr[i].getInventoryID(), inventoryArr[i].getItemName(), inventoryArr[i].getItemCategory(), inventoryArr[i].getItemMinimumQuantity(), inventoryArr[i].getItemQuantityOnHand(), inventoryArr[i].getItemUnitPrice(), inventoryArr[i].getItemAddedDate(), inventoryArr[i].getSupplierName(), inventoryArr[i].getSupplierEmailAddress(), inventoryArr[i].getInventoryStatus());

        }


        pw.flush();
        pw.close();
        bw.close();
        fw.close();

        
    }
    
    public static boolean isValidateItemName(String itemName) {
        boolean condition = true;
        
        Pattern patternItemName = Pattern.compile("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
        Matcher matcherItemName = patternItemName.matcher(itemName);

        
        if(matcherItemName.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static int isValidateItemCategory(String itemCategory) {
       int condition = 0;
        
       try
       {
           if(Integer.parseInt(itemCategory) >= 1 && Integer.parseInt(itemCategory) <= 3)
           {
               condition = 0;
               
           }
           if(Integer.parseInt(itemCategory) <= 0)
           {
               condition = 1;
               
           }
           if(Integer.parseInt(itemCategory) > 3)
           {
               condition = 2;
               
           }
           
       }
       catch (NumberFormatException e)
       {
           condition = 3;
       }
        
       return condition;
        
    }
    
    public static int isValidateitemMinimumQuantity(String itemMinimumQuantity) {
        int condition = 0;
        
        try 
        {
            if(Integer.parseInt(itemMinimumQuantity) > 0)
            {
                condition = 0;
                
            }
            if(Integer.parseInt(itemMinimumQuantity) <= 0)
            {
                condition = 1;
                
            }
            
        }
        catch (NumberFormatException e)
        {
            condition = 2;
            
        }
        
        return condition;
    }
        
    public static int isValidateItemQuantityOnHand(String itemMinimumQuantity, String itemQuantityOnHand) {
        int condition = 0;

        try
        {
            if(Integer.parseInt(itemQuantityOnHand)> 0)
            {
                condition = 0;
                
            }
            if(Integer.parseInt(itemQuantityOnHand) < Integer.parseInt(itemMinimumQuantity))
            {
                condition = 1;
                
            }
            if(Integer.parseInt(itemQuantityOnHand) <= 0)
            {
                condition = 2;
                
            }

            
        }
        catch (NumberFormatException e)
        {
            condition = 3;
            
        }
        
        return condition;
    }
    
    public static boolean isValidateItemUnitPrice(String itemUnitPrice) {

        boolean condition = false;
        
        Pattern patternItemUnitPrice = Pattern.compile("\\d{0,}.\\d{2}");
        Matcher matcherItemUnitPrice = patternItemUnitPrice.matcher(itemUnitPrice);
        
        try
        {
            if(Double.parseDouble(itemUnitPrice) > 0.0 && matcherItemUnitPrice.matches()) {
                condition = false;
            
            }
            if(Double.parseDouble(itemUnitPrice) <= 0.00) {
                condition = true;
                
            }
            if(!matcherItemUnitPrice.matches()) {
                condition = true;
                
            }
            
        }
        catch (NumberFormatException e)
        {
            condition = true;
        }
       
        
        return condition;
    }
    
    public static boolean isValidateSupplierName(String supplierName) {
        boolean condition = true;
        
        Pattern patternSupplierName = Pattern.compile("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
        Matcher matcherSupplierName = patternSupplierName.matcher(supplierName);

        
        if(matcherSupplierName.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean isValidateSupplierEmailAddress(String supplierEmailAddress) {
        boolean condition = true;
        
        Pattern patternSupplierEmailAddress = Pattern.compile("^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$");
        Matcher matcherSupplierEmailAddress = patternSupplierEmailAddress.matcher(supplierEmailAddress);

        
        if(matcherSupplierEmailAddress.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean checkInventoryID(String inventoryID, Inventory[] inventory, int numOfRecords) {
        boolean condition = true;
        
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0) {
                condition = true;
                break;
                
            }
            else
            {
                condition = false;
                
            }
        }
        
        return condition;
        
    }
    
    public static void getOldCategory(String inventoryID, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                System.out.printf("Before : " + inventory[i].itemCategory);
                break;
            }
        }
    }
    
    public static void editInventoryCategoryFile(String inventoryID, String newCategory, Inventory[] inventory, int numOfRecords) {
        if(newCategory.equals("1") == true)
        {
            newCategory = "Dessert";
            
        }
        else if(newCategory.equals("2") == true)
        {
            newCategory = "Main Dish";
            
        }
        else
        {
            newCategory = "Appetizer";
            
        }
        
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                inventory[i].itemCategory = newCategory;
            }
        }
        
    }
    
    public static void getOldMinimumQuantity(String inventoryID, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                System.out.printf("Before : " + inventory[i].itemMinimumQuantity);
                break;
            }
        }
    }
    
    public static void editInventoryMinimumQuantityFile(String inventoryID, String newMinimumQuantity, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                inventory[i].itemMinimumQuantity = newMinimumQuantity;
            }
        }
    }
    
    public static String getOldQuantityOnHand(String inventoryID, Inventory[] inventory, int numOfRecords) {
        String oldInput = "";
        for(int i = 0; i < numOfRecords; i++) 
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                System.out.printf("Before : " + inventory[i].getItemQuantityOnHand());
                oldInput = inventory[i].getItemQuantityOnHand();
                break;
            }
        }
        return oldInput;
    }
    
    public static void editInventoryQuantityOnHandFile(String inventoryID, String newQuantityOnHand, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                inventory[i].itemQuantityOnHand = newQuantityOnHand;
            }
        }
    }
    
    public static void getOldUnitPrice(String inventoryID, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                System.out.printf("Before : " + inventory[i].getItemUnitPrice());
                break;
            }
        }
    }
    
    public static void editInventoryUnitPriceFile(String inventoryID, String newUnitPrice, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                inventory[i].itemUnitPrice = newUnitPrice;
            }
        }
    }
    
    public static void getOldSupplierName(String inventoryID, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                System.out.printf("Before : " + inventory[i].getSupplierName());
                break;
            }
        }
    }
    
    public static void editInventorySupplierNameFile(String inventoryID, String newSupplierName, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                inventory[i].supplierName = newSupplierName;
            }
        }
    }
    
    public static void getOldSupplierEmailAddress(String inventoryID, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                System.out.printf("Before : " + inventory[i].getSupplierEmailAddress());
                break;
            }
        }
    }
    
    public static void editInventorySupplierEmailAddressFile(String inventoryID, String newSupplierEmailAddress, Inventory[] inventory, int numOfRecords) {
        for(int i = 0; i < numOfRecords; i++)
        {
            if(inventoryID.compareTo(inventory[i].getInventoryID()) == 0)
            {
                inventory[i].supplierEmailAddress = newSupplierEmailAddress;
            }
        }
    }
    
    public static int validateUpdatedRestockItemQuantityOnHand(String itemQuantityRestock) {
        int condition = 0;
        
        try 
        {
            if(Integer.parseInt(itemQuantityRestock) > 0)
            {
                condition = 0;
            }
            if(Integer.parseInt(itemQuantityRestock) <= 0)
            {
                condition = 1;
            }
        }
        catch (NumberFormatException e)
        {
            condition = 2;
            
        }
        
        return condition;
    }
    
    public static int validateUpdatedUsedItemQuantityOnHand(String itemQuantityRestock) {
        int condition = 0;
        
        try 
        {
            if(Integer.parseInt(itemQuantityRestock) > 0)
            {
                condition = 0;
            }
            if(Integer.parseInt(itemQuantityRestock) <= 0)
            {
                condition = 1;
            }
        }
        catch (NumberFormatException e)
        {
            condition = 2;
            
        }
        
        return condition;
    }
    
    public static void updatedVersion(Inventory[] inventoryArr, int numOfRecords) throws IOException {
        File oldFile = new File("InventoryDetails.txt");
        oldFile.delete();
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        
        fw = new FileWriter("InventoryDetails.txt", true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);

        for (int i = 0; i < numOfRecords; i++) {
            pw.printf("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|\n", inventoryArr[i].getInventoryID(), inventoryArr[i].getItemName(), inventoryArr[i].getItemCategory(), inventoryArr[i].getItemMinimumQuantity(), inventoryArr[i].getItemQuantityOnHand(), inventoryArr[i].getItemUnitPrice(), inventoryArr[i].getItemAddedDate(), inventoryArr[i].getSupplierName(), inventoryArr[i].getSupplierEmailAddress(), inventoryArr[i].getInventoryStatus());

        }


        pw.flush();
        pw.close();
        bw.close();
        fw.close();
    }
    
    
    
}
