package lk.ijse.SpiceWholesaleShop.entity;

import java.sql.Date;

public class Bill implements SuperEntity{
    private String billId;
    private String orderId;
    private String customerId;
    private Date date;
    private double totalAmount;

    public Bill(String billId, String orderId, String customerId, Date date, double totalAmount) {
        this.billId = billId;
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    public Bill() {
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
