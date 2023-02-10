package lk.ijse.SpiceWholesaleShop.to;

import java.util.ArrayList;

public class PlaceOrder {
    private String customerId;
    private String orderId;
    private String description;


    private ArrayList<CartDetail> orderDetails = new ArrayList<>();

    public PlaceOrder(String customerId, String orderId,String description, ArrayList<CartDetail> orderDetails) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.description = description;
        this.orderDetails = orderDetails;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ArrayList<CartDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<CartDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "customerId='" + customerId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
