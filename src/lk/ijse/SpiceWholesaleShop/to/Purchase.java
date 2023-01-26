package lk.ijse.SpiceWholesaleShop.to;

import java.time.LocalDate;

public class Purchase {
    private String RepairId;
    private String purchaseId;
    private String customerId;
    private String date;
    private double totalPurchasePrice;
    private String description;

    public Purchase(String repairId, String purchaseId, String customerId, String date, double totalPurchasePrice, String description) {
        RepairId = repairId;
        this.purchaseId = purchaseId;
        this.customerId = customerId;
        this.date = date;
        this.totalPurchasePrice = totalPurchasePrice;
        this.description = description;
    }

    public Purchase(String purchaseID, String customerId, LocalDate now, String description, Double total) {
    }

    public String getRepairId() {
        return RepairId;
    }

    public void setRepairId(String repairId) {
        RepairId = repairId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
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

    public double getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public void setTotalPurchasePrice(double totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
