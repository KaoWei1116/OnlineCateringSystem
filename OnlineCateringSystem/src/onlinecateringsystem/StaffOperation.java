/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecateringsystem;

import java.io.File;
import java.io.IOException;
import entity.Staff;
/**
 *
 * @author tzeha
 */
public class StaffOperation {
    
    
    public void createFile(){
        try{
            File obj = new File("StaffDetail.txt");
            if(obj.createNewFile()){
                System.out.println("File Created: "+obj.getName());
            }
            else{
                System.out.println("File already exist.");
            }
        }catch (IOException e){
            System.out.println("An Error occured.");
            e.printStackTrace();
        }

    }
}
