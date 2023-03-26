/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Ooi Chin Hui
 */
public class MenuItem implements Comparable<MenuItem> {

    private String itemID;
    private String itemName;
    private String category;
    private String desc;
    private double price;

    public MenuItem() {
    
    }
    
    public MenuItem(String itemID, String itemName, String category, String desc, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.category = category;
        this.desc = desc;
        this.price = price;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int compareTo(MenuItem anotherMenuItem) {
        return this.itemID.compareTo(anotherMenuItem.itemID);
    }
}
