package onlinecateringsystem;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mok Chun Kit Calvin
 */

public class Register {
    private String name;
    private String phoneNumber;
    private String icNumber;
    private String emailAddress;
    private String username;
    private String password;
  
    public Register() 
    {
        
    }
    
    public Register(String name, String phoneNumber, String icNumber, String emailAddress, String username, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.icNumber = icNumber;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIcNumber() {
        return icNumber;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
   
    
    private Scanner y;
    public int readRegisterFile(Register[] registerArr){
     try{                 //open file
          y = new Scanner(new File("CustomerDetails.txt"));
         
              
    }
    catch(Exception e){
          System.out.println("Error ! Could not find the file.");
    }
 
     
    int k = 0;
    y.useDelimiter("[|]");
       
    while(y.hasNext()) {      //do while loop - read file content
           String name = y.next();
           String phoneNumber = y.next();
           String icNumber = y.next();
           String emailAddress = y.next();
           String username = y.next();
           String password = y.next();

           registerArr[k] = new Register(name, phoneNumber, icNumber, emailAddress, username, password);
           
           y.nextLine();
           
           k++;

       }
    
       y.close();       //close file
       
       return k;

    }

 
    public static void appendRegisterFile(String name, String phoneNumber, String icNumber, String emailAddress, String username, String password) throws IOException{
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
                
             fw = new FileWriter("CustomerDetails.txt", true);
             bw = new BufferedWriter(fw);
             pw = new PrintWriter(bw);
             
             pw.printf("%s|%s|%s|%s|%s|%s|\n", name, phoneNumber, icNumber, emailAddress, username, password);
             System.out.print("\n");
             System.out.println("Data Added Into Text File Successfully.");
             pw.flush();
             pw.close();
             bw.close();
             fw.close();
                 
   
    
    }
    
    
    public static boolean checkRegisterName(String name, Register[] registerArr, int numOfRecords){
        boolean condition = true;
       
        
        for(int e = 0; e < numOfRecords; e++)
        {
            if(name.compareTo(registerArr[e].getName()) == 0) {          
               condition = true;
               break;
               
            }
                
            else 
               condition = false;
                  
        }
        
        return condition;
        
    }
    
    public static boolean isValidateName(String name) {
        boolean condition = true;
        
        Pattern patternName = Pattern.compile("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
        Matcher matcherName = patternName.matcher(name);

        
        if(matcherName.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean checkRegisterPhoneNumber(String phoneNumber, Register[] registerArr, int numOfRecords){
        boolean condition = true;
        
        for(int e = 0; e < numOfRecords; e++)
        {
           if(phoneNumber.compareTo(registerArr[e].getPhoneNumber()) == 0)
           {           
              condition = true;
              break;
           
           }
           else {
               condition = false;
               
           }     
        }
        
        return condition;
        
    }
    
    public static boolean isValidatePhoneNumber(String phoneNumber) {
        boolean condition = true;
        
        Pattern patternPhoneNumber1 = Pattern.compile("\\d{3}-\\d{7}");
        Pattern patternPhoneNumber2 = Pattern.compile("\\d{3}-\\d{8}");
        Matcher matcherPhoneNumber1 = patternPhoneNumber1.matcher(phoneNumber);
        Matcher matcherPhoneNumber2 = patternPhoneNumber2.matcher(phoneNumber);
        
        if((matcherPhoneNumber1.matches())||(matcherPhoneNumber2.matches())) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean checkRegisterICNo(String icNumber, Register[] registerArr, int numOfRecords){
        boolean condition = true;
        
        for(int e = 0; e < numOfRecords; e++)
        {
           if(icNumber.compareTo(registerArr[e].getIcNumber()) == 0)
           {           
              condition = true;
              break;
           
           }
           else {
               condition = false;
               
           }     
        }
        
        return condition;
        
    }
    
    public static boolean isValidateICNo(String icNumber) {
        boolean condition = true;
        
        Pattern patternICNo = Pattern.compile("\\d{6}-\\d{2}-\\d{4}");
        Matcher matcherICNo = patternICNo.matcher(icNumber);

        
        if(matcherICNo.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean checkRegisterEmailAddress(String emailAddress, Register[] registerArr, int numOfRecords){
        boolean condition = true;
        
        for(int e = 0; e < numOfRecords; e++)
        {
           if(emailAddress.compareTo(registerArr[e].getEmailAddress()) == 0)
           {           
              condition = true;
              break;
           
           }
           else {
               condition = false;
               
           }     
        }
        
        return condition;
        
    }
    
    public static boolean isValidateEmailAddress(String emailAddress) {
        boolean condition = true;
        
        Pattern patternUsername = Pattern.compile("^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$");
        Matcher matcherUsername = patternUsername.matcher(emailAddress);

        
        if(matcherUsername.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean checkRegisterUsername(String username, Register[] registerArr, int numOfRecords){
        boolean condition = true;
        
        for(int e = 0; e < numOfRecords; e++)
        {
           if(username.compareTo(registerArr[e].getUsername()) == 0)
           {           
              condition = true;
              break;
           
           }
           else {
               condition = false;
               
           }     
        }
        
        return condition;
        
    }
    
    public static boolean isValidateUsername(String username) {
        boolean condition = true;
        
        Pattern patternUsername = Pattern.compile("^[a-zA-Z0-9_-]{6,14}$");
        Matcher matcherUsername = patternUsername.matcher(username);

        
        if(matcherUsername.matches()) {
            condition = false;
            
        }
        else
        {
            condition = true;
        }
        
        return condition;
    }
    
    public static boolean checkRegisterPassword(String password, Register[] registerArr, int numOfRecords){
        boolean condition = true;
        
        for(int e = 0; e < numOfRecords; e++)
        {
           if(password.compareTo(registerArr[e].getPassword()) == 0)
           {           
              condition = true;
              break;
           
           }
           else {
               condition = false;
               
           }     
        }
        
        return condition;
        
    }
    
        
    public static boolean isValidatePassword(String password) {
        boolean condition = false;

        if(password.length() < 8 || password.length() > 16) {
            System.out.println("Password length should between 8 and 16.");
            condition = true;
        }

        String uppercaseCharacter = "(.*[A-Z].*)";
        if(!password.matches(uppercaseCharacter)) {
            System.out.println("Password must have at least one uppercase character.");
            condition = true;
            
        }
        
        String lowercaseCharacter = "(.*[a-z].*)";
        if(!password.matches(lowercaseCharacter)) {
            System.out.println("Password must have at least one lowercase character.");
            condition = true;
   
        }
        
        String number = "(.*[0-9].*)";
        if(!password.matches(number)) {
            System.out.println("Password must have at least one number.");
            condition = true;
   
        }
        
        String specialCharacter = "(.*[@,#,$,%,!,*,&,?].*$)";
        if(!password.matches(specialCharacter)) {
            System.out.println("Password must have at least one special character such as @,#,$,%,!,*,&, ?");
            condition = true;
   
        }
       
        
        return condition;
    }
    

    
    public static void editRegisterPasswordFile(String emailAddress, String newPassword, Register[] registerArr, int numOfRecordsTextFile) throws IOException{
        
        for(int e = 0; e < numOfRecordsTextFile; e++)
        {
            if(emailAddress.compareTo(registerArr[e].getEmailAddress()) == 0)
            {           
                registerArr[e].password = newPassword;
                    
            } 
        }

         
    }
    
    public static void updatedVersion(Register[] registerArr, int numOfRecordsTextFile) throws IOException {

        File oldFile = new File("CustomerDetails.txt");
        oldFile.delete();
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
                         
             fw = new FileWriter("CustomerDetails.txt", true);
             bw = new BufferedWriter(fw);
             pw = new PrintWriter(bw);
             
             for(int i = 0; i < numOfRecordsTextFile; i++)
             {
                pw.printf("%s|%s|%s|%s|%s|%s|\n", registerArr[i].name, registerArr[i].phoneNumber, registerArr[i].icNumber, registerArr[i].emailAddress, registerArr[i].username, registerArr[i].password);
 
             }
             
             pw.flush();
             pw.close();
             bw.close();
             fw.close();
                 
 
        
    }
    
         
}
