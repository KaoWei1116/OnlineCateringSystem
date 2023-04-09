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

    public static void inventoryModule(Inventory[] inventoryArr) throws IOException, ParseException {

        String itemNameInput;
        String itemCategoryInput;
        String itemMinimumQuantityInput;
        String itemQuantityOnHandInput;
        String itemUnitPriceInput;
        String supplierNameInput;
        String supplierEmailAddressInput;
        char confirmAddInventory = 'n';
        int numRecordInventory;
        Inventory inventory = new Inventory();

        numRecordInventory = inventory.readInventoryFile(inventoryArr);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter item name : ");
            itemNameInput = getUserInputInventory();

            if (Inventory.isValidateItemName(itemNameInput) == true) {
                System.out.println(itemNameInput + " is not a valid name.");
                System.out.println("The item name should not contain digits.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(itemNameInput + " is a valid name.");

            }

        } while (Inventory.isValidateItemName(itemNameInput) == true);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter item Category (1- Dessert, 2- Main Dish, 3- Appetizer): ");
            itemCategoryInput = getUserInputInventory();

            if (Inventory.isValidateItemCategory(itemCategoryInput) == 1) {
                System.out.println(itemCategoryInput + " is not a valid item type.");
                System.out.println("The item category should be between 0 and 3.");
                System.out.println("Please enter again.");

            } else if (Inventory.isValidateItemCategory(itemCategoryInput) == 2) {
                System.out.println(itemCategoryInput + " is not a valid item type.");
                System.out.println("The item category should be between 0 and 3.");
                System.out.println("Please enter again.");

            } else if (Inventory.isValidateItemCategory(itemCategoryInput) == 3) {
                System.out.println(itemCategoryInput + " is not a valid item type.");
                System.out.println("The item category should contain digits which should be between 0 and 3.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(itemCategoryInput + " is a valid item type.");

            }

        } while (Inventory.isValidateItemCategory(itemCategoryInput) != 0);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter item minimum quantity : ");
            itemMinimumQuantityInput = getUserInputInventory();

            if (Inventory.isValidateitemMinimumQuantity(itemMinimumQuantityInput) == 1) {
                System.out.println(itemMinimumQuantityInput + " is not a valid item minimum quantity.");
                System.out.println("The item minimum quantity should be more than 0.");
                System.out.println("Please enter again.");

            } else if (Inventory.isValidateitemMinimumQuantity(itemMinimumQuantityInput) == 2) {
                System.out.println(itemMinimumQuantityInput + " is not a valid item minimum quantity.");
                System.out.println("The item minimum quantity should contain digits with more than 0.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(itemMinimumQuantityInput + " is a valid item minimum quantity.");
            }

        } while (Inventory.isValidateitemMinimumQuantity(itemMinimumQuantityInput) != 0);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter item quantity on hand : ");
            itemQuantityOnHandInput = getUserInputInventory();

            if (Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) == 1) {
                System.out.println("The item quantity on hand should be more than the item minimum quantity.");
                System.out.println("Please enter again.");

            } else if (Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) == 2) {
                System.out.println(itemQuantityOnHandInput + " is not a valid item quantity on hand.");
                System.out.println("The item quantity on hand should be more than 0.");
                System.out.println("Please enter again.");

            } else if (Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) == 3) {
                System.out.println(itemQuantityOnHandInput + " is not a valid item quantity on hand.");
                System.out.println("The item quantity on hand should contain digits with more than 0.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(itemQuantityOnHandInput + " is a valid item quantity on hand.");
            }

        } while (Inventory.isValidateItemQuantityOnHand(itemMinimumQuantityInput, itemQuantityOnHandInput) != 0);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s%s", "Enter item unit price :", "$");
            itemUnitPriceInput = getUserInputInventory();

            if (Inventory.isValidateItemUnitPrice(itemUnitPriceInput) == true) {
                System.out.println(itemUnitPriceInput + " is not a valid item unit price.");
                System.out.println("The item unit price should be more than 0.");
                System.out.println("The item unit price must be in this format (.XX) which is a number with only 2 decimal places.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(itemUnitPriceInput + " is a valid item unit price.");

            }

        } while (Inventory.isValidateItemUnitPrice(itemUnitPriceInput) == true);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter supplier name : ");
            supplierNameInput = getUserInputInventory();

            if (Inventory.isValidateSupplierName(supplierNameInput) == true) {
                System.out.println(supplierNameInput + " is not a valid name.");
                System.out.println("The supplier name should not contain digits.");
                System.out.println("Please enter again.");

            } else {
                System.out.println(supplierNameInput + " is a valid name.");

            }

        } while (Inventory.isValidateSupplierName(supplierNameInput) == true);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter email address (EX: 2004jingsheng@gmail.com) : ");
            supplierEmailAddressInput = getUserInputInventory();

            if (Inventory.isValidateSupplierEmailAddress(supplierEmailAddressInput) == true) {
                System.out.println(supplierEmailAddressInput + " is not a valid email address.");
                System.out.println("The email address must contain @ and end with .com");
                System.out.println("Please enter again.");

            } else {
                System.out.println(supplierEmailAddressInput + " is a valid email address.");

            }

        } while (Inventory.isValidateSupplierEmailAddress(supplierEmailAddressInput) == true);

        System.out.printf("\n");
        System.out.printf("%-30s", "Confirm Add Inventory ? [y or n]");
        confirmAddInventory = getUserInputInventory().charAt(0);

        if (itemCategoryInput.equals("1") == true) {
            itemCategoryInput = "Dessert";

        } else if (itemCategoryInput.equals("2") == true) {
            itemCategoryInput = "Main Dish";

        } else {
            itemCategoryInput = "Appetizer";

        }

        Inventory inventoryItem = new Inventory(itemNameInput, itemCategoryInput, itemMinimumQuantityInput, itemQuantityOnHandInput, itemUnitPriceInput, null, supplierNameInput, supplierEmailAddressInput, null);

        if (Character.toUpperCase(confirmAddInventory) == 'Y') {
            Inventory.appendInventoryFile(inventoryItem);
            System.out.println("Added Successfully");

        } else {
            System.out.printf("\n");
            System.out.println("Cancelled Successfully.");

        }

    }

    public static void displayAllInventoryDetails() {
        int numRecordInventory = 0;
        Inventory[] inventoryDetailsArr = new Inventory[30];
        Inventory inventory = new Inventory();

        numRecordInventory = inventory.readInventoryFile(inventoryDetailsArr);

        System.out.printf("\n");
        System.out.printf("Full Details Of Inventory : \n");
        System.out.println("+-----------------+---------------------------+-----------------+------------------+--------------------+--------------+-----------------+---------------------------+-----------------------------+-----------------+");
        System.out.printf("| %-15s | %-25s | %-15s | %-15s | %-18s | %-12s | %-15s | %-25s | %-27s | %-15s|\n", "Inventory ID", "Name", "Type", "Minimum Quantity", "Quantity On Hand", "Unit Price", "Added Date", "Supplier Name", "Supplier Email Address", "Inventory Status");
        System.out.println("+-----------------+---------------------------+-----------------+------------------+--------------------+--------------+-----------------+---------------------------+-----------------------------+-----------------+");

        for (int i = 0; i < numRecordInventory; i++) {
            System.out.printf("| %-15s | %-25s | %-15s | %-15s  | %-18s | RM%-10s | %-15s | %-25s | %-27s | %-15s |\n", inventoryDetailsArr[i].getInventoryID(), inventoryDetailsArr[i].getItemName(), inventoryDetailsArr[i].getItemCategory(), inventoryDetailsArr[i].getItemMinimumQuantity(), inventoryDetailsArr[i].getItemQuantityOnHand(), inventoryDetailsArr[i].getItemUnitPrice(), inventoryDetailsArr[i].getItemAddedDate(), inventoryDetailsArr[i].getSupplierName(), inventoryDetailsArr[i].getSupplierEmailAddress(), inventoryDetailsArr[i].getInventoryStatus());
            System.out.println("+-----------------+---------------------------+-----------------+------------------+--------------------+--------------+-----------------+---------------------------+-----------------------------+-----------------+");
        }

        System.out.println("Press enter to return");
        getUserInputInventory();
    }

    public static void deleteAnInventory() throws IOException {
        String inventoryIDInput;
        char confirmDeleteInventory = 'n';
        int numRecordInventory = 0;
        int existRecordDelete = 0;
        Inventory[] inventoryDetailsArr = new Inventory[30];
        Inventory inventory = new Inventory();

        numRecordInventory = inventory.readInventoryFile(inventoryDetailsArr);

        System.out.printf("\n");
        System.out.printf("%-30s", "Enter the inventory ID : ");
        inventoryIDInput = getUserInputInventory();

        for (int i = 0; i < numRecordInventory; i++) {
            if (inventoryIDInput.compareTo(inventoryDetailsArr[i].getInventoryID()) == 0) {
                System.out.printf("%-10s : %-25s\n", "Inventory Name", inventoryDetailsArr[i].getItemName());
                System.out.printf("%-10s : %-25s\n", "Inventory Status", inventoryDetailsArr[i].getInventoryStatus());
                System.out.printf("%-40s", "Confirm To Delete Inventory ? [y or n]");
                confirmDeleteInventory = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmDeleteInventory) == 'Y') {

                    for (int a = i; a < numRecordInventory - 1; a++) {
                        inventoryDetailsArr[a] = inventoryDetailsArr[a + 1];
                    }

                    existRecordDelete++;
                    numRecordInventory--;
                    break;

                } else {
                    System.out.println("\n");
                    System.out.println("Cancelled Successfully");
                    break;
                }

            }

        }

        if (existRecordDelete != 0) {
            Inventory.deleteInventoryFromFile(inventoryDetailsArr, numRecordInventory);
            System.out.println("Delete Successfully From Text File");

        }
        if (existRecordDelete == 0) {
            System.out.println(inventoryIDInput + " is not found inside the text file.");

        }

    }

    public static void updateInventory(Inventory[] inventoryArr) throws IOException {

        int numRecordsTextFile;
        int choiceUpdate;

        String inventoryIDInput;
        String newCategoryInput;
        char confirmChangeCategory = 'y';
        String newMinimumQuantityInput;
        char confirmChangeMinimumQuantity = 'y';
        int choiceForQuantityOnHand;
        String oldQuantityInput;
        String restockQuantityInput = "";
        String usedQuantityInput = "";
        int quantityOnHandInput;
        String latestQuantityOnHand = "";
        char confirmChangeQuantityOnHandAmount = 'y';
        String newUnitPriceInput;
        char confirmChangeUnitPrice = 'y';
        String newSupplierNameInput;
        char confirmChangeSupplierName = 'y';
        String newSupplierEmailAddressInput;
        char confirmChangeSupplierEmailAddress = 'y';
        char updateOtherInformation = 'y';

        Inventory inventory = new Inventory();
        numRecordsTextFile = inventory.readInventoryFile(inventoryArr);

        do {
            System.out.printf("\n");
            System.out.printf("%-62s", "Enter Inventory ID that you want to update : ");
            inventoryIDInput = getUserInputInventory();

            if (Inventory.checkInventoryID(inventoryIDInput, inventoryArr, numRecordsTextFile) == false) {
                System.out.println(inventoryIDInput + " is not found inside the text file.");
                System.out.println("Please enter again.");

            }

        } while (Inventory.checkInventoryID(inventoryIDInput, inventoryArr, numRecordsTextFile) == false);

        do {

            System.out.printf("\n");

            System.out.printf("  _____________________________________________\n");
            System.out.printf("/|    1.  Category                             |\n");
            System.out.printf("||    2.  Minimum Quantity                     |\n");
            System.out.printf("||    3.  Quantity On Hand                     |\n");
            System.out.printf("||    4.  Unit Price                           |\n");
            System.out.printf("||    5.  Supplier Name                        |\n");
            System.out.printf("||    6.  Supplier Email Address               |\n");
            System.out.printf("||_____________________________________________|\n");
            System.out.printf("|/____________________________________________/\n");

            do {
                System.out.printf("\n");
                System.out.printf("Which information would you like to update (1 - 6)? ");
                choiceUpdate = Integer.parseInt(getUserInputInventory());

                if (choiceUpdate < 1 || choiceUpdate > 6) {
                    System.out.println("Error ! Please insert an integer between 1 to 4. Thank you.");

                }

            } while (choiceUpdate < 1 || choiceUpdate > 6);

            if (choiceUpdate == 1) {
                Inventory.getOldCategory(inventoryIDInput, inventoryArr, numRecordsTextFile);

                do {
                    System.out.printf("\n");
                    System.out.printf("%-62s", "Enter item Category (1- Dessert, 2- Main Dish, 3- Appetizer): ");
                    newCategoryInput = getUserInputInventory();

                    if (Inventory.isValidateItemCategory(newCategoryInput) == 1) {
                        System.out.println(newCategoryInput + " is not a valid item type.");
                        System.out.println("The item category should be between 0 and 3.");
                        System.out.println("Please enter again.");

                    } else if (Inventory.isValidateItemCategory(newCategoryInput) == 2) {
                        System.out.println(newCategoryInput + " is not a valid item type.");
                        System.out.println("The item category should be between 0 and 3.");
                        System.out.println("Please enter again.");

                    } else if (Inventory.isValidateItemCategory(newCategoryInput) == 3) {
                        System.out.println(newCategoryInput + " is not a valid item type.");
                        System.out.println("The item category should contain digits which should be between 0 and 3.");
                        System.out.println("Please enter again.");

                    } else {
                        System.out.println(newCategoryInput + " is a valid item type.");

                    }

                } while (Inventory.isValidateItemCategory(newCategoryInput) != 0);

                System.out.printf("\n");
                if (newCategoryInput.equals("1") == true) {
                    System.out.printf("%-61s", "Confirm to change the item category to Dessert ?");

                } else if (newCategoryInput.equals("2") == true) {
                    System.out.printf("%-61s", "Confirm to change the item category to Main Dish ?");

                } else {
                    System.out.printf("%-61s", "Confirm to change the item category to Appetizer ?");

                }

                confirmChangeCategory = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmChangeCategory) == 'Y') {
                    Inventory.editInventoryCategoryFile(inventoryIDInput, newCategoryInput, inventoryArr, numRecordsTextFile);

                } else {
                    System.out.println("Cancelled Successfully");

                }

            }

            if (choiceUpdate == 2) {
                Inventory.getOldMinimumQuantity(inventoryIDInput, inventoryArr, numRecordsTextFile);

                do {
                    System.out.printf("\n");
                    System.out.printf("%-62s", "Enter item minimum quantity : ");
                    newMinimumQuantityInput = getUserInputInventory();

                    if (Inventory.isValidateitemMinimumQuantity(newMinimumQuantityInput) == 1) {
                        System.out.println(newMinimumQuantityInput + " is not a valid item minimum quantity.");
                        System.out.println("The item minimum quantity should be more than 0.");
                        System.out.println("Please enter again.");

                    } else if (Inventory.isValidateitemMinimumQuantity(newMinimumQuantityInput) == 2) {
                        System.out.println(newMinimumQuantityInput + " is not a valid item minimum quantity.");
                        System.out.println("The item minimum quantity should contain digits with more than 0.");
                        System.out.println("Please enter again.");

                    } else {
                        System.out.println(newMinimumQuantityInput + " is a valid item minimum quantity.");
                    }

                } while (Inventory.isValidateitemMinimumQuantity(newMinimumQuantityInput) != 0);

                System.out.printf("\n");
                System.out.printf("%-61s", "Confirm to change the item minimum quantity to " + newMinimumQuantityInput + "? ");
                confirmChangeMinimumQuantity = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmChangeMinimumQuantity) == 'Y') {
                    Inventory.editInventoryMinimumQuantityFile(inventoryIDInput, newMinimumQuantityInput, inventoryArr, numRecordsTextFile);

                } else {
                    System.out.println("Cancelled Successfully");

                }

            }

            if (choiceUpdate == 3) {
                oldQuantityInput = Inventory.getOldQuantityOnHand(inventoryIDInput, inventoryArr, numRecordsTextFile);

                do {
                    System.out.printf("\n");
                    System.out.printf("  _____________________________________________\n");
                    System.out.printf("/|    1.  Restock Inventory Quantity           |\n");
                    System.out.printf("||    2.  Used Inventory Quantity              |\n");
                    System.out.printf("||_____________________________________________|\n");
                    System.out.printf("|/____________________________________________/\n");

                    System.out.printf("\n");
                    System.out.printf("%-61s", "Which operations would you like to updated on quantity on hand (1 or 2) : ");
                    choiceForQuantityOnHand = Integer.parseInt(getUserInputInventory());

                    if (choiceForQuantityOnHand < 1 || choiceForQuantityOnHand > 2) {
                        System.out.println("Error ! Please insert an integer between 1 to 2. Thank you.");

                    }

                } while (choiceForQuantityOnHand < 1 || choiceForQuantityOnHand > 2);

                if (choiceForQuantityOnHand == 1) {
                    do {
                        System.out.printf("\n");
                        System.out.printf("%-62s", "Enter restock inventory quantity : ");
                        restockQuantityInput = getUserInputInventory();

                        if (Inventory.validateUpdatedRestockItemQuantityOnHand(restockQuantityInput) == 1) {
                            System.out.println(restockQuantityInput + " is not a valid integer.");
                            System.out.println("The restock inventory quantity should be more than 0.");
                            System.out.println("Please enter again.");

                        } else if (Inventory.validateUpdatedRestockItemQuantityOnHand(restockQuantityInput) == 2) {
                            System.out.println(restockQuantityInput + " is not a valid integer.");
                            System.out.println("The restock inventory quantity should contain digits with more than 0.");
                            System.out.println("Please enter again.");

                        } else {
                            System.out.println(restockQuantityInput + " is a valid restock inventory quantity.");
                            quantityOnHandInput = Integer.parseInt(oldQuantityInput) + Integer.parseInt(restockQuantityInput);
                            latestQuantityOnHand = Integer.toString(quantityOnHandInput);

                        }

                    } while (Inventory.validateUpdatedRestockItemQuantityOnHand(restockQuantityInput) != 0);
                } else {
                    do {
                        System.out.printf("\n");
                        System.out.printf("%-62s", "Enter used inventory quantity : ");
                        usedQuantityInput = getUserInputInventory();

                        if (Inventory.validateUpdatedUsedItemQuantityOnHand(usedQuantityInput) == 1) {
                            System.out.println(usedQuantityInput + " is not a valid integer.");
                            System.out.println("The used inventory quantity should be more than 0.");
                            System.out.println("Please enter again.");

                        } else if (Inventory.validateUpdatedUsedItemQuantityOnHand(usedQuantityInput) == 2) {
                            System.out.println(usedQuantityInput + " is not a valid integer.");
                            System.out.println("The used inventory quantity should contain digits with more than 0.");
                            System.out.println("Please enter again.");

                        } else {
                            System.out.println(usedQuantityInput + " is a valid used inventory quantity.");
                            quantityOnHandInput = Integer.parseInt(oldQuantityInput) - Integer.parseInt(usedQuantityInput);
                            latestQuantityOnHand = Integer.toString(quantityOnHandInput);

                        }

                    } while (Inventory.validateUpdatedUsedItemQuantityOnHand(usedQuantityInput) != 0);
                }

                System.out.printf("\n");
                System.out.printf("Latest Quantity On Hand : " + latestQuantityOnHand);
                System.out.printf("\n");
                System.out.printf("%-61s", "Confirm to change the quantity on hand to " + latestQuantityOnHand + "? ");
                confirmChangeQuantityOnHandAmount = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmChangeQuantityOnHandAmount) == 'Y') {
                    Inventory.editInventoryQuantityOnHandFile(inventoryIDInput, latestQuantityOnHand, inventoryArr, numRecordsTextFile);
                   
                } else {
                    System.out.println("Cancelled Successfully");

                }
            }

            if (choiceUpdate == 4) {
                Inventory.getOldUnitPrice(inventoryIDInput, inventoryArr, numRecordsTextFile);

                do {
                    System.out.printf("\n");
                    System.out.printf("%-62s%s", "Enter item unit price :", "$");
                    newUnitPriceInput = getUserInputInventory();

                    if (Inventory.isValidateItemUnitPrice(newUnitPriceInput) == true) {
                        System.out.println(newUnitPriceInput + " is not a valid item unit price.");
                        System.out.println("The item unit price should be more than 0.");
                        System.out.println("The item unit price must be in this format (.XX) which is a number with only 2 decimal places.");
                        System.out.println("Please enter again.");

                    } else {
                        System.out.println(newUnitPriceInput + " is a valid item unit price.");

                    }

                } while (Inventory.isValidateItemUnitPrice(newUnitPriceInput) == true);

                System.out.printf("\n");
                System.out.printf("%-61s", "Confirm to change the item unit price to " + newUnitPriceInput + "? ");
                confirmChangeUnitPrice = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmChangeUnitPrice) == 'Y') {
                    Inventory.editInventoryUnitPriceFile(inventoryIDInput, newUnitPriceInput, inventoryArr, numRecordsTextFile);
                } else {
                    System.out.println("Cancelled Successfully");
                }

            }

            if (choiceUpdate == 5) {
                Inventory.getOldSupplierName(inventoryIDInput, inventoryArr, numRecordsTextFile);

                do {
                    System.out.printf("\n");
                    System.out.printf("%-62s", "Enter supplier name : ");
                    newSupplierNameInput = getUserInputInventory();

                    if (Inventory.isValidateSupplierName(newSupplierNameInput) == true) {
                        System.out.println(newSupplierNameInput + " is not a valid name.");
                        System.out.println("The supplier name should not contain digits.");
                        System.out.println("Please enter again.");

                    } else {
                        System.out.println(newSupplierNameInput + " is a valid name.");

                    }

                } while (Inventory.isValidateSupplierName(newSupplierNameInput) == true);

                System.out.printf("\n");
                System.out.printf("%-61s", "Confirm to change the supplier name to " + newSupplierNameInput + "? ");
                confirmChangeSupplierName = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmChangeSupplierName) == 'Y') {
                    Inventory.editInventorySupplierNameFile(inventoryIDInput, newSupplierNameInput, inventoryArr, numRecordsTextFile);
                } else {
                    System.out.println("Cancelled Successfully");
                }
            }

            if (choiceUpdate == 6) {
                Inventory.getOldSupplierEmailAddress(inventoryIDInput, inventoryArr, numRecordsTextFile);

                do {
                    System.out.printf("\n");
                    System.out.printf("%-62s", "Enter email address (EX: 2004jingsheng@gmail.com) : ");
                    newSupplierEmailAddressInput = getUserInputInventory();

                    if (Inventory.isValidateSupplierEmailAddress(newSupplierEmailAddressInput) == true) {
                        System.out.println(newSupplierEmailAddressInput + " is not a valid email address.");
                        System.out.println("The email address must contain @ and end with .com");
                        System.out.println("Please enter again.");

                    } else {
                        System.out.println(newSupplierEmailAddressInput + " is a valid email address.");

                    }

                } while (Inventory.isValidateSupplierEmailAddress(newSupplierEmailAddressInput) == true);

                System.out.printf("\n");
                System.out.printf("%-61s", "Confirm to change the email address to " + newSupplierEmailAddressInput + "? ");
                confirmChangeSupplierEmailAddress = getUserInputInventory().charAt(0);

                if (Character.toUpperCase(confirmChangeSupplierEmailAddress) == 'Y') {
                    Inventory.editInventorySupplierEmailAddressFile(inventoryIDInput, newSupplierEmailAddressInput, inventoryArr, numRecordsTextFile);
                } else {
                    System.out.println("Cancelled Successfully");
                }

            }

            System.out.printf("\n");
            System.out.printf("%-61s", "Continue to update other informations ? ( Y/N ) ");
            updateOtherInformation = getUserInputInventory().charAt(0);

            if (Character.toUpperCase(updateOtherInformation) == 'N') {
                System.out.printf("\n");
               
            
                //check whether the item quantity on hand is out of stock or not
                for(int i = 0; i < numRecordsTextFile; i++)
                {
                    if(Integer.parseInt(inventoryArr[i].getItemQuantityOnHand()) == 0)
                    {
                         inventoryArr[i].setInventoryStatus("Out Of Stock");
                    }
                }    
                
                
                Inventory.updatedVersion(inventoryArr, numRecordsTextFile);
                System.out.println("Updated Successfully");
            }
            else if (Character.toUpperCase(updateOtherInformation) == 'Y'){
                System.out.printf("\n");
                System.out.println("You can update other information");
            }
            else
            {
                System.out.printf("\n");
                System.out.println("Failed to update the text file");
            }
               
                 
            

        } while (Character.toUpperCase(updateOtherInformation) == 'Y');
    }

    private static String getUserInputInventory() {
        String outputString;
        Scanner user = new Scanner(System.in);
        outputString = user.nextLine();
        return outputString;
    }
}
