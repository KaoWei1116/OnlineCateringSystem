/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author User
 */
public class OrderItem implements Comparable<OrderItem> {
    private String orderID;
    private String itemID;
    private String itemName;
    private int quantity;
    private double subtotal;
    
    public OrderItem(String orderID, String itemID, String itemName, int quantity, double subtotal) {
        this.orderID = orderID;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    @Override
    public int compareTo(OrderItem anotherOrderItem) {
        return this.itemID.compareTo(anotherOrderItem.itemID);
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

        final OrderItem other = (OrderItem) obj;

        if (orderID.equals(other.orderID) && itemID.equals(other.itemID)) {
            return true;
        }

        return false;
    }
    
    @Override
    public String toString() {
        return  String.format("%-20s\t%-10d\tRM%-8.2f", itemName, quantity, subtotal);
    }
    
}
