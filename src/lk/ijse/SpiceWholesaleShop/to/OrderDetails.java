package lk.ijse.SpiceWholesaleShop.to;

public class OrderDetails {
    private String orderId;
    private String itemCode;
    private int qty;
    private double unitPrice;
    private Double total;

    public OrderDetails(String orderId, String itemCode, int qty, double unitPrice, Double total) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    public OrderDetails() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
