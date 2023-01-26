package lk.ijse.SpiceWholesaleShop.to;

public class PurchaseCartDetail {
      private String purchaseId;
      private String itemCode;
      private String description;
      private int qty;
      private Double unitPrice;
      private Double total;

    public PurchaseCartDetail(String purchaseId, String itemCode, String description, int qty, Double unitPrice, Double total, Double purchasePrice) {
        this.purchaseId = purchaseId;
        this.itemCode = itemCode;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
        PurchasePrice = purchasePrice;
    }

    private Double PurchasePrice;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }


    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        PurchasePrice = purchasePrice;
    }
}
