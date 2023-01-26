package lk.ijse.SpiceWholesaleShop.to;

import java.util.ArrayList;

public class PlacePurchase {
    private String customerId;
    private String purchaseID;
    private String description;
    private Double total;

    private ArrayList<PurchaseCartDetail> PurchaseDetails = new ArrayList<>();

    public PlacePurchase() {
    }

    public PlacePurchase(String customerId, String purchaseID, String description, Double total, ArrayList<PurchaseCartDetail> orderDetails) {
        this.customerId = customerId;
        this.purchaseID = purchaseID;
        this.description = description;
        this.total = total;
        this.PurchaseDetails = orderDetails;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(String purchaseID) {
        this.purchaseID = purchaseID;
    }

    public ArrayList<PurchaseCartDetail> getPurchaseDetails() {
        return PurchaseDetails;
    }

    public void setPurchaseDetails(ArrayList<PurchaseCartDetail> purchaseDetails) {
        this.PurchaseDetails = purchaseDetails;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "customerId='" + customerId + '\'' +
                ", orderId='" + purchaseID + '\'' +
                ", orderDetails=" + PurchaseDetails +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
