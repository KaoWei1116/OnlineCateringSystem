
package onlinecateringsystem;

import java.io.BufferedWriter;
import java.io.File;
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
    private String itemName;
    private static String itemType;
    private String itemMinimumQuantity;
    private String itemQuantityOnHand;
    private String itemUnitPrice;
    private String itemAddedDate;
    private String supplierName;
    private String supplierEmailAddress;
    
    public Inventory() 
    {
        
    }

    public Inventory(String itemName, String itemType, String itemMinimumQuantity, String itemQuantityOnHand, String itemUnitPrice, String itemAddedDate, String supplierName, String supplierEmailAddress) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.itemMinimumQuantity = itemMinimumQuantity;
        this.itemQuantityOnHand = itemQuantityOnHand;
        this.itemUnitPrice = itemUnitPrice;   
        this.supplierName = supplierName;
        this.supplierEmailAddress = supplierEmailAddress;
    }

    public String getItemName() {
        return itemName;
    }

    public static String getItemType() {
        return itemType;
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
    
    //refer to systemProcess.java, newReservationUI.java
    
    private Scanner y;
    public int readInventoryFile(Inventory[] inventoryArr){
     try{                 //open file
          y = new Scanner(new File("InventoryDetails.txt"));
         
              
    }
    catch(Exception e){
          System.out.println("Error ! Could not find the file.");
    }
 
     
    int k = 0;
    y.useDelimiter("[|]");
       
    while(y.hasNext()) {      //do while loop - read file content
           String itemName = y.next();
           String itemType = y.next();
           String itemMinimumQuantity = y.next();
           String itemQuantityOnHand = y.next();
           String itemUnitPrice = y.next();
           String itemAddedDate = y.next();
           String supplierName = y.next();
           String supplierEmailAddress = y.next();
           

           inventoryArr[k] = new Inventory(itemName, itemType, itemMinimumQuantity, itemQuantityOnHand, itemUnitPrice, itemAddedDate, supplierName, supplierEmailAddress);
           y.nextLine();
           
           k++;

       }
    
       y.close();       //close file
       
       return k;

    }
    
     public static void appendInventoryFile(String itemName, String itemTypeInput, String itemMinimumQuantity, String itemQuantityOnHand, String itemUnitPrice, String supplierName, String supplierEmailAddress) throws IOException{
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
                
             fw = new FileWriter("InventoryDetails.txt", true);
             bw = new BufferedWriter(fw);
             pw = new PrintWriter(bw);
             
             LocalDateTime oldFormatDateTime = LocalDateTime.now();
             DateTimeFormatter newFormatDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
             String itemAddedDate = oldFormatDateTime.format(newFormatDate); 
             
             if(Integer.parseInt(itemTypeInput) == 1)
             {
                 itemType = "Dessert";
                 
             }
             if(Integer.parseInt(itemTypeInput) == 2)
             {
                 itemType = "Main Dish";
                 
             }
             if(Integer.parseInt(itemTypeInput) == 3)
             {
                 itemType = "Appetizer";
                 
             }
             
             pw.printf("%s|%s|%s|%s|%s|%s|%s|%s|\n", itemName, itemType, itemMinimumQuantity, itemQuantityOnHand, itemUnitPrice, itemAddedDate, supplierName, supplierEmailAddress);
             System.out.print("\n");
             System.out.println("Data Added Into Text File Successfully.");
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
    
    public static int isValidateItemType(String itemType) {
       int condition = 0;
        
       try
       {
           if(Integer.parseInt(itemType) >= 1 && Integer.parseInt(itemType) <= 3)
           {
               condition = 0;
               
           }
           if(Integer.parseInt(itemType) <= 0)
           {
               condition = 1;
               
           }
           if(Integer.parseInt(itemType) > 3)
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
    
}
