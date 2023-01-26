package lk.ijse.SpiceWholesaleShop.to;

public class Spice {
    private String itemCode;
    private double purchasePrice;
    private double unitPrice;
    private int qtyOnHand;
    private String description;

    public Spice(String itemCode, double purchasePrice, double unitPrice, int qtyOnHand, String description) {
        this.itemCode = itemCode;
        this.purchasePrice = purchasePrice;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
        this.description = description;
    }

    public Spice(String orderId, String itemCode, Double unitPrice, int qty, String description) {
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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
