
package onlinecateringsystem;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Mok Chun Kit Calvin
 */
public class InventoryUI {
     public static void inventoryModule(Inventory[] inventoryArr) throws IOException, ParseException{
        
        String itemNameInput;
        String itemTypeInput;
        String itemMinimumQuantityInput;
        String itemQuantityOnHandInput;
        String itemUnitPriceInput;
        String itemAddedDateInput;
        String itemExpiryDateInput;
        String supplierNameInput;
        String supplierEmailAddressInput;
        char confirmAddInventory = 'n';
        int numRecordInventory;
        Inventory inventory = new Inventory();
        
        numRecordInventory = inventory.readInventoryFile(inventoryArr);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter item name : ");
                itemNameInput = getUserInputInventory();
                
                if(Inventory.isValidateItemName(itemNameInput) == true){
                    System.out.println(itemNameInput + " is not a valid name."); 
                    System.out.println("The item name should not contain digits.");
                    System.out.println("Please enter again.");
                    
                }
                else {
                    System.out.println(itemNameInput + " is a valid name."); 
                    
                }
                
        }while(Inventory.isValidateItemName(itemNameInput) == true);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter item type : ");
                itemTypeInput = getUserInputInventory();
                
                if(Inventory.isValidateItemType(itemTypeInput) == true){
                    System.out.println(itemTypeInput + " is not a valid item type."); 
                    System.out.println("The item type should not contain digits.");
                    System.out.println("Please enter again.");
                    
                }
                else {
                    System.out.println(itemTypeInput + " is a valid item type."); 
                    
                }
                
        }while(Inventory.isValidateItemType(itemTypeInput) == true);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter item minimum quantity : ");
                itemMinimumQuantityInput = getUserInputInventory();
                
                
                if(Inventory.isValidateitemMinimumQuantity(itemMinimumQuantityInput) == 1){
                    System.out.println(itemMinimumQuantityInput + " is not a valid item minimum quantity.");
                    System.out.println("The item minimum quantity should be more than 0.");
                    System.out.println("Please enter again.");
                    
                }
                else if(Inventory.isValidateitemMinimumQuantity(itemMinimumQuantityInput) == 2){
                    System.out.println(itemMinimumQuantityInput + " is not a valid item minimum quantity.");
                    System.out.println("The item minimum quantity should contain digits with more than 0.");
                    System.out.println("Please enter again.");
                    
                }
                else
                {
                    System.out.println(itemMinimumQuantityInput + " is a valid item minimum quantity.");
                }
                
        }while(Inventory.isValidateitemMinimumQuantity(itemMinimumQuantityInput)!= 0);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter item quantity on hand : ");
                itemQuantityOnHandInput = getUserInputInventory();
                
                if(Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) == 1){
                    System.out.println("The item quantity on hand should be more than the item minimum quantity.");
                    System.out.println("Please enter again.");
                    
                }
                else if(Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) == 2){
                    System.out.println(itemQuantityOnHandInput + " is not a valid item quantity on hand.");
                    System.out.println("The item quantity on hand should be more than 0.");
                    System.out.println("Please enter again.");
                
                }
                else if(Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) == 3) {
                    System.out.println(itemQuantityOnHandInput + " is not a valid item quantity on hand.");
                    System.out.println("The item quantity on hand should contain digits with more than 0.");
                    System.out.println("Please enter again.");
                    
                }
                else
                {
                    System.out.println(itemQuantityOnHandInput + " is a valid item quantity on hand.");
                }
                
        }while(Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) != 0);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s%s", "Enter item unit price :", "$");
                itemUnitPriceInput = getUserInputInventory();
                
                if(Inventory.isValidateItemUnitPrice(itemUnitPriceInput) == true){
                    System.out.println(itemUnitPriceInput + " is not a valid item unit price.");
                    System.out.println("The item unit price should be more than 0.");
                    System.out.println("The item unit price must be in this format (.XX) which is a number with only 2 decimal places.");
                    System.out.println("Please enter again.");
                    
                }
                else
                {
                    System.out.println(itemUnitPriceInput + " is a valid item unit price.");
                    
                }
                             
        }while(Inventory.isValidateItemUnitPrice(itemUnitPriceInput) == true);
        
        do
        {
                System.out.printf("\n");
                System.out.printf("%-61s", "Enter item added date (EX: yyyy/MM/dd) : ");
                itemAddedDateInput = getUserInputInventory();
                               
                if(Inventory.isValidateItemAddedDate(itemAddedDateInput) == false)
                {
                    System.out.println(itemAddedDateInput + " is not a valid item added date.");
                    System.out.println("The item added date must be in this format (yyyy/MM/dd).");
                    System.out.println("The item added date must be after today.");
                    System.out.println("Please enter again.");
                    
                }
                else
                {
                    System.out.println(itemAddedDateInput + " is a valid item added date.");
                    
                }
                
        }while(Inventory.isValidateItemAddedDate(itemAddedDateInput) == false);
        
        do
        {
                System.out.printf("\n");
                System.out.printf("%-61s", "Enter item expiry date (EX: YYYY/MM/DD) : ");
                itemExpiryDateInput = getUserInputInventory();
                
                if(Inventory.isValidateItemExpiryDate(itemExpiryDateInput, itemAddedDateInput) == false)
                {
                    System.out.println(itemExpiryDateInput + " is not a valid item expiry date.");
                    System.out.println("The item expiry date must be in this format (yyyy/MM/dd).");
                    System.out.println("The item expiry date must be after the item added date.");
                    System.out.println("Please enter again.");
                    
                }
                else
                {
                    System.out.println(itemExpiryDateInput + " is a valid item expiry date.");
                    
                }
                
        }while(Inventory.isValidateItemExpiryDate(itemExpiryDateInput, itemAddedDateInput) == false);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter supplier name : ");
                supplierNameInput = getUserInputInventory();
                
                if(Inventory.isValidateSupplierName(supplierNameInput) == true){
                    System.out.println(supplierNameInput + " is not a valid name."); 
                    System.out.println("The supplier name should not contain digits.");
                    System.out.println("Please enter again.");
                    
                }
                else {
                    System.out.println(supplierNameInput + " is a valid name."); 
                    
                }
                
        }while(Inventory.isValidateSupplierName(supplierNameInput) == true);
        
        do
        {
                System.out.printf("\n"); 
                System.out.printf("%-61s", "Enter email address (EX: 2004jingsheng@gmail.com) : ");
                supplierEmailAddressInput = getUserInputInventory();
                
                if(Inventory.isValidateSupplierEmailAddress(supplierEmailAddressInput) == true){
                    System.out.println(supplierEmailAddressInput + " is not a valid email address."); 
                    System.out.println("The email address must contain @ and end with .com");
                    System.out.println("Please enter again.");
                    
                }
                else {
                    System.out.println(supplierEmailAddressInput + " is a valid email address."); 
                    
                }
                
        }while(Inventory.isValidateSupplierEmailAddress(supplierEmailAddressInput) == true);
        
        System.out.printf("\n");
        System.out.printf("%-30s", "Confirm Add Inventory ? [y or n]");
        confirmAddInventory = getUserInputInventory().charAt(0);
           
        if(Character.toUpperCase(confirmAddInventory) == 'Y'){  
            Inventory.appendInventoryFile(itemNameInput, itemTypeInput, itemMinimumQuantityInput, itemQuantityOnHandInput, itemUnitPriceInput, itemAddedDateInput, itemExpiryDateInput, supplierNameInput, supplierEmailAddressInput);
            System.out.println("Added Successfully");
            
                
        }else {
                System.out.printf("\n");
                System.out.println("Cancelled Successfully.");
                
                
        }
        
    }
    
    private static String getUserInputInventory() {
        String outputString;
        Scanner user = new Scanner(System.in);
        outputString = user.nextLine();
        return outputString;
    }
}
