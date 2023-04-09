package onlinecateringsystem;

import entity.Order;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Chong Kao Wei
 */
public class OnlineCateringSystem {

    public static String finalUsername = null;
    static Scanner scanner = new Scanner(System.in);

    private static String startingInterfaceMenu() throws IOException, FileNotFoundException, InterruptedException {
        String usernameInputCheck = "exit";
        String registerStatusCheck = "fail";
        int choice = 0;
        Login login = new Login();
        do {
            System.out.print("\n");
            System.out.printf(" _____________________________________________\n");
            System.out.printf("[       Welcome to FourFriends Catering!      ]\n");
            System.out.printf("]   Where customer satisfaction comes first   [\n");
            System.out.printf("[_____________________________________________]\n");
            System.out.println("=============================================");
            System.out.println("|   1. Login to an existing account         |");
            System.out.println("|   2. Register to create a new account     |");
            System.out.println("|   3. Exit program                         |");
            System.out.println("|   4. Enter 4 if you forget password       |");
            System.out.println("=============================================");
            System.out.print("\n");
            System.out.print("Enter an number : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|            Login Page             |");
                    System.out.println("=====================================");
                    usernameInputCheck = login.loginPage();
                    if (usernameInputCheck == "exit") {
                        usernameInputCheck = startingInterfaceMenu();
                    }
                    break;
                case 2:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|           Register Page           |");
                    System.out.println("=====================================");
                    Register[] registerArr = new Register[20];
                    registerStatusCheck = registerUI.registerModule(registerArr);
                    if (registerStatusCheck.compareTo("fail") == 0) {
                        registerStatusCheck = startingInterfaceMenu();
                    }
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|            Login Page             |");
                    System.out.println("=====================================");
                    usernameInputCheck = login.loginPage();
                    if (usernameInputCheck == "exit") {
                        usernameInputCheck = startingInterfaceMenu();
                    }

                    break;
                case 3:
                    System.exit(0);
                case 4:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|       Reset Password Page         |");
                    System.out.println("=====================================");
                    Register[] registerArrResetPassword = new Register[20];
                    registerUI.forgetPassword(registerArrResetPassword);
                    break;
                default:
                    System.out.println("Please insert an integer between 1 to 4. Thank you.");
                    break;
            }
        } while (choice < 1 || choice > 4);

        //return username
        return usernameInputCheck;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException, ParseException {
        finalUsername = startingInterfaceMenu();
        while (finalUsername.equals("12312313") == false) {
            //admin account
            if (finalUsername.equals("1") == true && finalUsername.equals("exit") == false) {
                adminMenu();

            } else {
                //if first character is S then staff account
                if (finalUsername.charAt(0) == 'S' && finalUsername.equals("exit") == false) {
                    staffMenu();

                } //otherwise customer account
                else {
                    customerMenu();

                }
            }

        }
    }

    private static void customerMenu() throws IOException, FileNotFoundException, InterruptedException {
        Ordering ordering = new Ordering();
        ordering.readMenuItem();
        // ordering.createOrderFile();
        ordering.createOrderTrackingFile();
        ordering.readOrderFromFile();
        ordering.readOrderTrackingFromFile();

        int choice = 0;
        String word = "";
        char startOrder;
        System.out.printf("\n");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("++   Welcome back " + finalUsername);
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        do {
            System.out.print("\n");
            System.out.println("Customer Menu :");
            System.out.println("=====================================");
            System.out.println("|   1. View Profile                 |");
            System.out.println("|   2. View Menu                    |");
            System.out.println("|   3. Logout                       |");
            System.out.println("=====================================");
            System.out.print("\n");
            System.out.print("Enter an number : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    viewUserProfile.viewUserProfile(finalUsername);
                    System.out.println("\nPress enter something to return to option menu...");
                    word = scanner.next();
                    if (!word.isEmpty()) {
                        customerMenu();
                    }
                    break;
                case 2:
                    ordering.printMenu();
                    System.out.println("\nDo you want to make order? (Y-yes)");
                    startOrder = scanner.next().charAt(0);
                    if (startOrder == 'Y' || startOrder == 'y') {
                        Order newOrder = new Order(ordering.makeOrder());
                        newOrder.setOrderStatus("Pending");
                        Payment payment = new Payment();
                        boolean paymentStatus = payment.makePayment(newOrder);
                        if (paymentStatus == true) {
                            newOrder.setOrderStatus("Processing");
                            ordering.orderList.add(new Order(newOrder));
                            ordering.writeOrderIntoFile();
                            ordering.writeOrderTrackingIntoFile();
                            ordering.viewOrderStatus(newOrder);
                        }
                    }
                    break;
                case 3:
                    finalUsername = startingInterfaceMenu();
                    break;
                default:
                    System.out.println("Please insert an integer between 1 to 3. Thank you.");
                    break;

            }
        } while (choice < 1 || choice > 3);
    }

    private static void adminMenu() throws IOException, FileNotFoundException, InterruptedException {
        int choice = 0;
        System.out.printf("\n");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("++   Welcome back admin             +");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        do {
            System.out.print("\n");
            System.out.println("Admin Menu :");
            System.out.println("=====================================");
            System.out.println("|   1. Create Staff Account         |");
            System.out.println("|   2. Logout                       |");
            System.out.println("=====================================");
            System.out.print("\n");
            System.out.print("Enter an number : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    AdminOperation adminOperat = new AdminOperation();
                    adminOperat.addStaff();
                    break;
                case 2:
                    finalUsername = startingInterfaceMenu();
                    break;
                default:
                    System.out.println("Please insert an integer between 1 to 2. Thank you.");
                    break;
            }

        } while (choice < 1 || choice > 2);
    }

    private static void staffMenu() throws IOException, ParseException, FileNotFoundException, InterruptedException {
        int choice = 0;
        System.out.printf("\n");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        System.out.println("++   Welcome back " + finalUsername);
        System.out.println("+++++++++++++++++++++++++++++++++++++");
        do {
            System.out.print("\n");
            System.out.println("Staff Menu :");
            System.out.println("=====================================");
            System.out.println("|   1. Add Inventory                |");
            System.out.println("|   2. View All Inventory           |");
            System.out.println("|   3. Delete An Inventory          |");
            System.out.println("|   4. Update Inventory             |");
            System.out.println("|   5. Update Order Status          |");
            System.out.println("|   6. Logout                       |");
            System.out.println("=====================================");
            System.out.print("\n");
            System.out.print("Enter an number : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|        Add Inventory Page         |");
                    System.out.println("=====================================");
                    Inventory[] inventoryArr = new Inventory[30];
                    InventoryUI.inventoryModule(inventoryArr);
                    break;
                case 2:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|      View All Inventory Page      |");
                    System.out.println("=====================================");
                    InventoryUI.displayAllInventoryDetails();
                    break;
                case 3:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|      Delete An Inventory Page     |");
                    System.out.println("=====================================");
                    InventoryUI.deleteAnInventory();
                    break;
                case 4:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|   Update Inventory Details Page   |");
                    System.out.println("=====================================");
                    Inventory[] updateInventoryArr = new Inventory[30];
                    InventoryUI.updateInventory(updateInventoryArr);
                    break;
                case 5:
                    System.out.print("\n");
                    System.out.println("=====================================");
                    System.out.println("|     Update Order Status Page      |");
                    System.out.println("=====================================");
                    Ordering ordering = new Ordering();
                    ordering.updateOrderStatus();
                    break;
                case 6:
                    finalUsername = startingInterfaceMenu();
                    break;
                default:
                    System.out.println("Please insert an integer between 1 to 5. Thank you.");
            }

        } while (choice < 1 || choice > 5);
    }
}
