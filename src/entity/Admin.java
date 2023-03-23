/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author tzeha
 */
public class Admin {
    private String username ="admin";
    private String password = "admin";
    private String permissionLevel;
    private ArrayList<Staff> staffList;

    public Admin() {
    }

    public Admin(String permissionLevel, ArrayList<Staff> staffList) {
        this.permissionLevel = permissionLevel;
        this.staffList = staffList;
    }
    
    
}

