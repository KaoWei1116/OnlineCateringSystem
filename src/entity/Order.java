/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import adt.LinkedList;

/**
 *
 * @author User
 */
public class Order implements Comparable<Order> {
    private String orderID;
    private LinkedList<OrderItem> orderItemList = new LinkedList<OrderItem>();
    private double totalPrice;
    private String orderStatus;
    private static int currentOrderNo = 1000;

    public Order(){
        currentOrderNo++;
        this.orderID = "ORD" + currentOrderNo;
    }
    
    public Order(Order order){
        this.orderID = order.orderID;
        this.orderItemList = order.orderItemList;
        this.totalPrice = order.totalPrice;
        this.orderStatus = order.orderStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public LinkedList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setOrderItemList(OrderItem orderItem) {
        this.orderItemList.add(orderItem);
    }
    
    public void setOrderItemList(LinkedList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    @Override
    public int compareTo(Order anotherOrder) {
        return this.orderID.compareTo(anotherOrder.orderID);
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

        final Order other = (Order) obj;

        if (orderID.equals(other.orderID)) {
            return true;
        }

        return false;
    }
    
    @Override
    public String toString() {
        return  "===========================================" +
                "\nOrder ID: " + orderID +
                "\n===========================================" +
                String.format("\n%-2s\t%-20s\t%-10s\t%-10s", "No", "Item Name", "Quantity", "Subtotal") +
                "\n" + orderItemList.toString() +
                "\n-------------------------------------------" +
                String.format("\nTotal Price: RM%-8.2f", totalPrice) + 
                "\n===========================================";
    }
    
}
