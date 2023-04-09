/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author tzeha
 */
public class Staff {
     private String staffID;
     private String password;
     private String staffIC;
     private String staffName;
     private String personalEmail;
     private String phoneNumber;
     private char gender;

    public Staff() {
    }

    public Staff(String staffID, String password,String staffIC ,String staffName, char gender, String personalEmail, String phoneNumber) {
        this.staffID = staffID;
        this.password = password;
        this.staffIC = staffIC;
        this.staffName = staffName;
        this.personalEmail = personalEmail;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

  

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffIC() {
        return staffIC;
    }

    public void setStaffIC(String staffIC) {
        this.staffIC = staffIC;
    }
    
    
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }


    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.staffID);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.staffIC);
        hash = 59 * hash + Objects.hashCode(this.staffName);
        hash = 59 * hash + Objects.hashCode(this.personalEmail);
        hash = 59 * hash + Objects.hashCode(this.phoneNumber);
        hash = 59 * hash + this.gender;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Staff other = (Staff) obj;
        return true;
    }

    @Override
    public String toString() {
        return  staffID +"|"+password +"|"+staffIC+"|"+staffName+"|"+gender+"|"+personalEmail+"|"+phoneNumber+"|\n";
    }

   
     
     
     
     
}
