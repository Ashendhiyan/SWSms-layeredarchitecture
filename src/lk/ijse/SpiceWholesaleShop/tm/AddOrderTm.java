package lk.ijse.SpiceWholesaleShop.tm;


import javafx.scene.control.Button;

public class AddOrderTm {
    private String itemCode;
    private String description;
    private int qty;
    private double PurchasePrice;

    private Double unitPrice;
    private Double total;
    private Button btnDelete;


    public AddOrderTm() {
    }

    public AddOrderTm( String itemCode, String description, int qty,double purchasePrice, Double unitPrice, Double total, Button btnDelete) {
        this.itemCode = itemCode;
        this.description = description;
        this.qty = qty;
        PurchasePrice = purchasePrice;
        this.unitPrice = unitPrice;
        this.total = total;
        this.btnDelete = btnDelete;
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

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public double getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        PurchasePrice = purchasePrice;
    }
}
