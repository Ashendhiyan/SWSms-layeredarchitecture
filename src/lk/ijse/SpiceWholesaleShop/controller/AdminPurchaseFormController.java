package lk.ijse.SpiceWholesaleShop.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.service.cutom.PurchaseService;
import lk.ijse.SpiceWholesaleShop.service.cutom.impl.PurchaseFormServiceImpl;
import lk.ijse.SpiceWholesaleShop.tm.AddPurchaseTm;
import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class AdminPurchaseFormController {
    public AnchorPane Purchase;
    public ComboBox cmbProductId;
    public Label lblDescription;
    public Label lblPurchasePrice;
    public Label lblUnitPrice;
    public Label lblQtyOnHand;
    public TextField txtQty;
    public TextField txtTotalPurchasePrice;
    public Label lblPurchaseId;
    public Label lblCustomerName;
    public ComboBox cmbCustomerId;
    public JFXDatePicker PurchaseDate;
    public ComboBox cmbItemCode;
    public Label lblOrderDate;
    public TableView<AddPurchaseTm> tblAddOrder;
    public TableColumn colProductCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colPurchasePrice;
    public TableColumn colUnitPrice;
    public TableColumn colTotal;
    public TableColumn colAction;
    public TableView<AddPurchaseTm> tblAddPurchase;
    private ObservableList<AddPurchaseTm> obList = FXCollections.observableArrayList();
    PurchaseService purchaseService=new PurchaseFormServiceImpl();

    public void initialize(){
        loadOrderDate();
        LoadProductCode();
        loadNextPurchaseId();
        loadCustomerIds();
        setCellValueFactory();
    }

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOrders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchaseDetails(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASEDETAILS,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchaseOnAction(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASEDETAILS,Purchase);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    private void loadOrderDate() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
    }
    public void LoadProductCode(){
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = purchaseService.loadItem();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadNextPurchaseId() {
        try {
            String purchaseId = purchaseService.generatePurchaseId();
            lblPurchaseId.setText(purchaseId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = purchaseService.loadCustomer();

            for (String id : idList) {
                observableList.add(id);
            }
            cmbCustomerId.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillItemFields(Spice item) {
        lblDescription.setText(item.getDescription());
        lblPurchasePrice.setText(String.valueOf(item.getPurchasePrice()));
        lblUnitPrice.setText(String.valueOf(item.getUnitPrice()));
        lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
    }
    private void fillCustomerFields(Customer customer) {
        lblCustomerName.setText(customer.getName());
    }
    private void setCellValueFactory() {
        colProductCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory("description"));
        colQty.setCellValueFactory(new PropertyValueFactory("qty"));
        colPurchasePrice.setCellValueFactory(new PropertyValueFactory("PurchasePrice"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory("unitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory("total"));
        colAction.setCellValueFactory(new PropertyValueFactory("btnDelete"));
    }
    public void cmbICustomerOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbCustomerId.getValue());
        try {
            Optional<Customer> customer = purchaseService.SearchCustomer(code);
            if (customer.isPresent()){
                customer.get();
            }
            fillCustomerFields(customer.get());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void cmbItemOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbItemCode.getValue());
        try {
            Optional<Spice> item = purchaseService.SearchSpice(code);

            if (item.isPresent()){
                item.get();
            }
            fillItemFields(item.get());
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void cmbIProductIdOnAction(ActionEvent actionEvent) {
    }

    public void cmbCustomerIdOnAction(ActionEvent actionEvent) {
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }

    public void btnAddToCart(ActionEvent actionEvent) {
        String purchaseId = lblPurchaseId.getText();
        String itemCode = String.valueOf(cmbItemCode.getValue());
        String desc = lblDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double PurchasePrice = Double.parseDouble(lblPurchasePrice.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = PurchasePrice * qty;
        Button btnDelete = new Button("Delete");
        txtQty.setText("");


        if (!obList.isEmpty()) {
            L1:
            /* check same item has been in table. If so, update that row instead of adding new row to the table */
            for (int i = 0; i < tblAddPurchase.getItems().size(); i++) {
                if (colProductCode.getCellData(i).equals(itemCode)) {
                    qty += (int) colQty.getCellData(i);
                    total = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblAddPurchase.refresh();
                    return;
                }
            }
        }
        btnDelete.setOnAction((e) -> {
            ButtonType ok = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure ?", ok, no);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.orElse(no) == ok) {
//                AddOrderTm lk.ijse.SpiceWholesaleShop.tm = tblAddOrder.getSelectionModel().getSelectedItem();
//                tblAddOrder.getItems().removeAll(tblAddOrder.getSelectionModel().getSelectedItem());
            }
        });
        obList.add(new AddPurchaseTm(itemCode, desc, qty,PurchasePrice, unitPrice, total, btnDelete));
        tblAddPurchase.setItems(obList);
    }
}
