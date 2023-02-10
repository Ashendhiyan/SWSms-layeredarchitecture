package lk.ijse.SpiceWholesaleShop.entity;

public class PurchaseDetails implements SuperEntity{
    private String purchaseId;
    private String itemCode;
    private double purchasePrice;
    private int qty;
    private String date;

    public PurchaseDetails(String purchaseId, String itemCode, double purchasePrice, int qty, String date) {
        this.purchaseId = purchaseId;
        this.itemCode = itemCode;
        this.purchasePrice = purchasePrice;
        this.qty = qty;
        this.date = date;
    }

    public PurchaseDetails() {
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
