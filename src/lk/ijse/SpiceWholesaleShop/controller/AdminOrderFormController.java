package lk.ijse.SpiceWholesaleShop.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.SpiceWholesaleShop.entity.Spice;
import lk.ijse.SpiceWholesaleShop.entity.Customer;
import lk.ijse.SpiceWholesaleShop.service.cutom.OrderService;
import lk.ijse.SpiceWholesaleShop.service.cutom.impl.OrderFormServiceImpl;
import lk.ijse.SpiceWholesaleShop.util.Navigation;
import lk.ijse.SpiceWholesaleShop.util.Routes;
import lk.ijse.SpiceWholesaleShop.tm.AddOrderTm;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class AdminOrderFormController {
    public AnchorPane Order;
    public Label lblOrderId;
    public Label lblDescription;
    public Label lblOrderDate;
    public Label lblUnitPrice;
    public TextField txtDiscount;
    public TextField txtQty;
    public Label lblCustomerName;
    public Label lblQtyOnHand;
    public Label lblPurchasePrice;
    public ComboBox cmbCustomerId;
    public ComboBox cmbItemCode;
    public ComboBox cmbItemCode1;
    public JFXDatePicker OrderDate;
    public TableView<AddOrderTm> tblAddOrder;
    public TableColumn colOrderId;
    public TableColumn colProductCode;
    public TableColumn colDescription;
    public TableColumn colQty;
    public TableColumn colUnitPrice;
    public TableColumn colDiscount;
    public TableColumn colTotal;
    public TableColumn colAction;
    public TableColumn colPurchasePrice;

    OrderService orderService=new OrderFormServiceImpl();
    private ObservableList<AddOrderTm> obList = FXCollections.observableArrayList();

    public void initialize(){
        loadOrderDate();
        LoadProductCode();
        loadNextOrderId();
        loadCustomerIds();
        setCellValueFactory();
    }

    public void btnDashboard(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.DASHBOARD,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnProduct(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPRODUCT,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public void btnCustomers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.CUSTOMER,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnEmployees(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.EMPLOYEES,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPurchase(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINPURCHASE,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnReports(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINREPORT,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnLogout(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.LOGIN,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnUsers(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.USER,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOrderDetails(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDERDETAILS,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnOders(ActionEvent actionEvent) {
        try {
            Navigation.navigate(Routes.ADMINORDER,Order);
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
    }
    private void loadOrderDate() {
        lblOrderDate.setText(String.valueOf(LocalDate.now()));
    }

    public void cmbItemOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbItemCode.getValue());
        try {
            Optional<Spice> item = orderService.SearchSpice(code);
            if (item.isPresent()){
                item.get();
            }

            fillItemFields(item.get());
            txtQty.requestFocus();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void LoadProductCode(){
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> itemList = orderService.LoadItem();

            for (String code : itemList) {
                observableList.add(code);
            }
            cmbItemCode.setItems(observableList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadNextOrderId() {
        try {
            String orderId = orderService.generateOrderId();
            lblOrderId.setText(orderId);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadCustomerIds() {
        try {
            ObservableList<String> observableList = FXCollections.observableArrayList();
            ArrayList<String> idList = orderService.loadCustomer();

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

    public void btnDelete(ActionEvent actionEvent) {
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void cmbICustomerOnAction(ActionEvent actionEvent) {
        String code = String.valueOf(cmbCustomerId.getValue());
        try {
            OrderFormServiceImpl orderFormService = new OrderFormServiceImpl();
            Optional<Customer> customer = orderFormService.SearchCustomer(code);
            if (customer.isPresent()){
                customer.get();
            }
            fillCustomerFields(customer.get());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(ActionEvent actionEvent) {
        String OrderId = lblOrderId.getText();
        String itemCode = String.valueOf(cmbItemCode.getValue());
        String desc = lblDescription.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double PurchasePrice = Double.parseDouble(lblPurchasePrice.getText());
        double unitPrice = Double.parseDouble(lblUnitPrice.getText());
        double total = unitPrice * qty;
        Button btnDelete = new Button("Delete");

        txtQty.setText("");

        if (!obList.isEmpty()) {
            L1:
            /* check same item has been in table. If so, update that row instead of adding new row to the table */
            for (int i = 0; i < tblAddOrder.getItems().size(); i++) {
                if (colProductCode.getCellData(i).equals(itemCode)) {
                    qty += (int) colQty.getCellData(i);
                    total = unitPrice * qty;

                    obList.get(i).setQty(qty);
                    obList.get(i).setTotal(total);
                    tblAddOrder.refresh();
                    return;
                }
            }
        }

        /* set delete button to some action before it put on obList */
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
        obList.add(new AddOrderTm(itemCode, desc, qty,PurchasePrice, unitPrice, total, btnDelete));
        tblAddOrder.setItems(obList);
    }
}
