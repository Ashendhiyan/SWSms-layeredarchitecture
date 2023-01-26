package lk.ijse.SpiceWholesaleShop.to;

public class Bill {
    private String billId;
    private String orderId;
    private String customerId;
    private String date;
    private double totalAmount;

    public Bill(String billId, String orderId, String customerId, String date, double totalAmount) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
