package lk.ijse.SpiceWholesaleShop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.service.cutom.SpiceService;
import lk.ijse.SpiceWholesaleShop.service.cutom.impl.SpiceFormServiceImpl;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;
import lk.ijse.SpiceWholesaleShop.util.Service;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AdminSpiceFormController {
    public AnchorPane Product;
    public TextField IdSearch;
    public TextField txtId;
    public TextField txtDescription;
    public TextField txtQtyOnHand;
    public TextField txtUnitPrice;
    public TextField txtPurchasePrice;
    public TableView<Spice> tblProduct;
    public TableColumn<Spice, String> colProductid;
    public TableColumn<Spice, String> colDiscription;
    public TableColumn<Spice, Double> colPurchasePrice;
    public TableColumn<Spice, Integer> colQtyOnhand;
    public TableColumn<Spice, Double> colUnitPrice;
    public Button btnAddDisable;

    boolean isMatchDescription = false;
    boolean isMatchProductId = false;
    boolean isMatchQtyOnHand = false;
    boolean isMatchUnitPrice = false;
    boolean isMatchPurchasePrice = false;

    SpiceService spiceService=new SpiceFormServiceImpl();

    public void initialize() {
        loadTableData();
    }

    private void loadTableData() {
        refreshTableData();
        colProductid.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colPurchasePrice.setCellValueFactory(new PropertyValueFactory<>("purchasePrice"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQtyOnhand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colDiscription.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    private void refreshTableData() {
        try {
            List<Spice> product = spiceService.findSpice();
            ObservableList<Spice> productObservableList = FXCollections.observableArrayList();
            productObservableList.addAll(product);
            tblProduct.setItems(productObservableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOrders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER, Product);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void txtProductIdOnAction(KeyEvent keyEvent) {
        if (Service.isValidProductId(txtId.getText())) {
            txtId.setStyle("-fx-border-color: green");
            isMatchProductId = true;
        } else {
            txtId.setStyle("-fx-border-color: red");
            isMatchProductId = false;
        }
    }

    public void txtDescriptionOnAction(KeyEvent keyEvent) {
        if (Service.isValidName(txtDescription.getText())) {
            txtDescription.setStyle("-fx-border-color: green");
            isMatchDescription = true;
        } else {
            txtDescription.setStyle("-fx-border-color: red");
            isMatchDescription = false;
        }
    }

    public void txtQtyOnAction(KeyEvent keyEvent) {
        if (Service.QtyOnHand(txtQtyOnHand.getText())) {
            txtQtyOnHand.setStyle("-fx-border-color: green");
            isMatchQtyOnHand = true;
        } else {
            txtQtyOnHand.setStyle("-fx-border-color: red");
            isMatchQtyOnHand = false;
        }
    }

    public void txtUnitPriceOnAction(KeyEvent keyEvent) {
        if (Service.isValidPrice(txtUnitPrice.getText())) {
            txtUnitPrice.setStyle("-fx-border-color: green");
            isMatchUnitPrice = true;
        } else {
            txtUnitPrice.setStyle("-fx-border-color: red");
            isMatchUnitPrice = false;
        }
    }

    public void txtPurchasePrice(KeyEvent keyEvent) {
        if (Service.isValidPrice(txtPurchasePrice.getText())) {
            txtPurchasePrice.setStyle("-fx-border-color: green");
            isMatchPurchasePrice = true;
        } else {
            txtPurchasePrice.setStyle("-fx-border-color: red");
            isMatchPurchasePrice = false;
        }
    }

    public void btnAdd(ActionEvent actionEvent) {
        if (!isMatchProductId) {
        } else if (!isMatchDescription) {
        } else if (!isMatchQtyOnHand) {
        } else if (!isMatchUnitPrice) {
        } else if (!isMatchPurchasePrice) {
        }else{
            String productId = txtId.getText();
        String Description = txtDescription.getText();
        int QtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        Double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        Double purchasePrice = Double.parseDouble(txtPurchasePrice.getText());

        Spice spice = new Spice(productId, purchasePrice, unitPrice, QtyOnHand, Description);
        boolean isAdded = false;
        try {
             isAdded = spiceService.saveSpice(spice);
            refreshTableData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (isAdded) {
            JOptionPane.showMessageDialog(null, "Product Successfully Added..!");
        } else {
            JOptionPane.showMessageDialog(null, "Unsuccessful..!");
        }
    }

}

    public void btnUpdate(ActionEvent actionEvent) {
        if (!isMatchProductId) {
        } else if (!isMatchDescription) {
        } else if (!isMatchQtyOnHand) {
        } else if (!isMatchUnitPrice) {
        } else if (!isMatchPurchasePrice) {
        } else {
            String productId = txtId.getText();
            String Description = txtDescription.getText();
            int QtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
            Double unitPrice = Double.parseDouble(txtUnitPrice.getText());
            Double purchasePrice = Double.parseDouble(txtPurchasePrice.getText());

            Spice spice = new Spice(productId, purchasePrice, unitPrice, QtyOnHand, Description);
            boolean isUpdated = false;
            try {
                isUpdated = spiceService.updateSpice(spice);
                refreshTableData();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (isUpdated) {
                JOptionPane.showMessageDialog(null, "Product Successfully Updated..!");
            } else {
                JOptionPane.showMessageDialog(null, "Unsuccessful..!");
            }
        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        String productId = txtId.getText();
        try {
            boolean isDeleted = spiceService.deleteSpice(productId);;
            refreshTableData();
            if (isDeleted){
                JOptionPane.showMessageDialog(null,"Successfully Deleted..!");
            }else{
                JOptionPane.showMessageDialog(null,"Unsuccessful..!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtIdSearch(ActionEvent actionEvent) {
       btnSearch(actionEvent);
    }

    public void btnSearch(ActionEvent actionEvent) {
        String Search = IdSearch.getText();
        try {
            List<Spice> search = spiceService.searchSpice(Search);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void tblProductOnMouseClick(MouseEvent mouseEvent) {
        Spice spice=tblProduct.getSelectionModel().getSelectedItem();
        if (spice!=null){
            txtId.setText(spice.getItemCode());
            txtPurchasePrice.setText(spice.getPurchasePrice()+"");
            txtUnitPrice.setText(spice.getUnitPrice()+"");
            txtQtyOnHand.setText(spice.getQtyOnHand()+"");
            txtDescription.setText(spice.getDescription());
            btnAddDisable.setDisable(true);
        }
    }
}
