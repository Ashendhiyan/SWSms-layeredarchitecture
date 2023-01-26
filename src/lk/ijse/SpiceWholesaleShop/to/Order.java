package lk.ijse.SpiceWholesaleShop.to;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private String orderId;
    private String customerId;
    private String date;
    private String description;

    private ArrayList<OrderDetails>orderDetailsList;

    public Order(ArrayList<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    public Order(String orderId, String customerId, String date, String description) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.description = description;
    }



    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(ArrayList<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
