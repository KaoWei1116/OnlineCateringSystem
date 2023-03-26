package onlinecateringsystem;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Login {
	private int checkValid = 5;
	private String username, password;
	
	private int check(String userName, String pw) throws FileNotFoundException, IOException {
		String[] words=null;
		int count1 = 0, count2 = 0, count3 = 0, ucount = 0, pcount = 0;
		//File reader
		File file = new File("CustomerDetails.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
                
		String data;
		try {
			while ((data=br.readLine()) != null) {
				words=data.split("[|]");
				count3++;
				for (String word : words) {
					if (word.equals(userName)) {
						count1++;
						ucount = count3;
					} 
					
				}
				for (String word : words) {
					if (word.equals(pw)) {
						count2++;
						pcount = count3;
					} 
											
				}
			}
		}finally {
                    try{
                           br.close();
                           fr.close();
                          
                           
                    }catch (IOException e) {
				e.printStackTrace();
                                
                    }
                }
                //both username and password is correct
		if(count1 > 0 && count2 > 0 && ucount == pcount)
                {
			return 1;
                }
                //username is wrong but password is correct
                else if( ucount == 0 && pcount != 0 )
                {
			return 2;
                }
                //username is correct but password is wrong
                else if (ucount != 0 && pcount == 0)
                {
                        return 3;
                }
                //both username and password is correct but not belong to same user
                else if (ucount != 0 && pcount != 0 && ucount != pcount)
                {
                    return 4;
                }
                //both username and password is wrong
                else
                {
                    return 5;
                }
                
             
           
		
	}
	
	public String loginPage() throws FileNotFoundException, IOException, InterruptedException {
            int tryNumber = 0;
            String finalUsername = "exit";
            
		do {
			System.out.printf("\nEnter your username  : ");
			username = getUserInputLogin();
			System.out.printf("\nEnter your password  : ");
			password = getUserInputLogin();
			checkValid = check(username, password);
				if(checkValid == 1) {
					System.out.println("\nLogin successfully!");
                                        finalUsername = username;
                                        tryNumber = 0;
                                        break;
					
					
				} else if (checkValid == 2){
                                    System.out.println("Error! Incorrect username, please try again!");
                                    tryNumber++;
                                    
                                } else if (checkValid == 3){
                                    System.out.println("Error! Incorrect password, please try again!");
                                    tryNumber++;
                                    
                                } else if (checkValid == 4){
                                    System.out.println("Error! Incorrect username or password, please try again!");
                                    tryNumber++;
                                    
                                }else{
                                    System.out.println("Error! Incorrect username and password, please try again!");
                                    tryNumber++;
                                    
                                }
                                
                            if(tryNumber > 2)
                            {
                                System.out.println("You incorrectly logged in 3 times.");
                                System.out.println("You are now suspended for 10 seconds...");
                                TimeUnit.SECONDS.sleep(10);
                            }
                                
				
		
		}while(tryNumber <= 2);
		
                return finalUsername;

	}
        
        private static String getUserInputLogin() {
            String outputString;
            Scanner user = new Scanner(System.in);
            outputString = user.nextLine();
            return outputString;
    }

}
