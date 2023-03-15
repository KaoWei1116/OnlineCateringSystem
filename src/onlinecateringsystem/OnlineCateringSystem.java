package onlinecateringsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
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
                    registerUI.registerModule(registerArr);
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
                    break;
                default:
                    System.out.println("Please insert an integer between 1 to 4. Thank you.");
                    break;
            }
        } while (choice < 1 || choice > 4);
        
        //return username
        return usernameInputCheck;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {
        finalUsername = startingInterfaceMenu();
        while (finalUsername.equals("12312313") == false) {
            if (finalUsername.equals("1") == false || finalUsername.equals("exit") == false) {
                customerMenu();
            }
        }
    }

    private static void customerMenu() throws IOException, FileNotFoundException, InterruptedException {
        int choice = 0;
        String word = "";
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
                    break;
                case 2:
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
}
